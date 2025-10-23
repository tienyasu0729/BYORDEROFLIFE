using Data.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.OData.Query;
using Microsoft.AspNetCore.OData.Routing.Controllers;
using Microsoft.EntityFrameworkCore;

namespace GarageSystem.API.Controllers
{
    // Controller này sẽ xử lý các request tới /odata/Vehicles
    public class VehiclesController : ODataController
    {
        private readonly SU25_PRN232_01Context _context;

        // OData thường làm việc hiệu quả nhất khi dùng trực tiếp DbContext
        // thay vì Repository, vì nó cần IQueryable để xây dựng câu lệnh SQL
        public VehiclesController(SU25_PRN232_01Context context)
        {
            _context = context;
        }

        // GET: /odata/Vehicles
        [EnableQuery] // <-- Bật OData (filter, sort...) cho phương thức này
        public IActionResult Get()
        {
            return Ok(_context.Vehicles);
        }

        // GET: /odata/Vehicles(5)
        [EnableQuery]
        public IActionResult Get(int key)
        {
            var vehicle = _context.Vehicles.FirstOrDefault(v => v.VehicleId == key);
            if (vehicle == null)
            {
                return NotFound();
            }
            return Ok(vehicle);
        }

        // POST: /odata/Vehicles
        public async Task<IActionResult> Post([FromBody] Vehicle vehicle)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            _context.Vehicles.Add(vehicle);
            await _context.SaveChangesAsync();
            return Created(vehicle);
        }

        // PUT: /odata/Vehicles(5)
        public async Task<IActionResult> Put(int key, [FromBody] Vehicle vehicle)
        {
            if (key != vehicle.VehicleId)
            {
                return BadRequest("Key in URL does not match key in body.");
            }
            _context.Entry(vehicle).State = EntityState.Modified;
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!_context.Vehicles.Any(v => v.VehicleId == key))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }
            return NoContent();
        }

        // DELETE: /odata/Vehicles(5)
        public async Task<IActionResult> Delete(int key)
        {
            var vehicle = await _context.Vehicles.FindAsync(key);
            if (vehicle == null)
            {
                return NotFound();
            }
            _context.Vehicles.Remove(vehicle);
            await _context.SaveChangesAsync();
            return NoContent();
        }
    }
}