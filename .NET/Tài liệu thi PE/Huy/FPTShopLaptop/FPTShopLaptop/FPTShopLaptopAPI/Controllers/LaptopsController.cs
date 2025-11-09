using AutoMapper;
using FPTShopLaptopAPI.Data;
using FPTShopLaptopAPI.DTOs;
using FPTShopLaptopAPI.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.OData.Query;
using Microsoft.EntityFrameworkCore;

namespace FPTShopLaptopAPI.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class LaptopsController : ControllerBase
    {
        private readonly AppDbContext _context;
        private readonly IMapper _mapper;
        public LaptopsController(AppDbContext context, IMapper mapper)
        {
            _context = context;
            _mapper = mapper;
        }

        [EnableQuery]
        [HttpGet]
        public IActionResult GetAll()
        {
            var laptops = _context.Laptops.
                Include(l => l.User).ToList();
            var laptopDtos = _mapper.Map<List<LaptopDTO>>(laptops);
            return Ok(laptopDtos);
        }

        [HttpGet("{id}")]
        public IActionResult GetById(int id)
        {
            var laptop = _context.Laptops.Include(l => l.User).FirstOrDefault(l => l.LaptopId == id);
            if (laptop == null) return NotFound();

            var laptopDto = _mapper.Map<LaptopDTO>(laptop);
            return Ok(laptopDto);
        }


        [HttpPost]
        public IActionResult Create([FromBody] Laptop laptop)
        {
            _context.Laptops.Add(laptop);
            _context.SaveChanges();
            return Ok(laptop);
        }

        [HttpPut("{id}")]
        public IActionResult Update(int id, [FromBody] Laptop updated)
        {
            var laptop = _context.Laptops.Find(id);
            if (laptop == null) return NotFound();
            laptop.Name = updated.Name;
            laptop.Brand = updated.Brand;
            laptop.Price = updated.Price;
            laptop.StockQuantity = updated.StockQuantity;
            _context.SaveChanges();
            return Ok(laptop);
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            var laptop = _context.Laptops.Find(id);
            if (laptop == null) return NotFound();
            _context.Laptops.Remove(laptop);
            _context.SaveChanges();
            return Ok("Deleted");
        }
    }
}
