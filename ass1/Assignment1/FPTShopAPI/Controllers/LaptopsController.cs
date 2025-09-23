using BusinessObjects;
using BusinessObjects.Models;
using Microsoft.AspNetCore.Mvc;
using Services;
using System.Collections.Generic;

namespace FPTShopAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LaptopsController : ControllerBase
    {
        private readonly ILaptopService _laptopService = new LaptopService();

        // GET: api/laptops
        [HttpGet]
        public ActionResult<List<Laptop>> GetLaptops()
        {
            return Ok(_laptopService.GetLaptops());
        }

        // GET: api/laptops/5
        [HttpGet("{id}")]
        public ActionResult<Laptop> GetLaptop(int id)
        {
            var laptop = _laptopService.GetLaptopById(id);
            if (laptop == null)
            {
                return NotFound();
            }
            return Ok(laptop);
        }

        // POST: api/laptops
        [HttpPost]
        public IActionResult PostLaptop(Laptop laptop)
        {
            _laptopService.AddLaptop(laptop);
            return CreatedAtAction(nameof(GetLaptop), new { id = laptop.LaptopId }, laptop);
        }

        // PUT: api/laptops/5
        [HttpPut("{id}")]
        public IActionResult PutLaptop(int id, Laptop laptop)
        {
            if (id != laptop.LaptopId)
            {
                return BadRequest();
            }

            var existingLaptop = _laptopService.GetLaptopById(id);
            if (existingLaptop == null)
            {
                return NotFound();
            }

            _laptopService.UpdateLaptop(laptop);
            return NoContent();
        }

        // DELETE: api/laptops/5
        [HttpDelete("{id}")]
        public IActionResult DeleteLaptop(int id)
        {
            var laptop = _laptopService.GetLaptopById(id);
            if (laptop == null)
            {
                return NotFound();
            }
            _laptopService.DeleteLaptop(id);
            return NoContent();
        }
    }
}