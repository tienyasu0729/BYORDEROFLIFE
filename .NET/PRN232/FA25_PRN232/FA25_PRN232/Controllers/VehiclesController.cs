using FA25_PRN232.DTOs;
using FA25_PRN232.Services;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.OData.Formatter;
using Microsoft.AspNetCore.OData.Query;
using Microsoft.AspNetCore.OData.Routing.Controllers;

namespace FA25_PRN232.Controllers
{
    public class VehiclesController : ODataController
    {
        private readonly IVehicleService _vehicleService;

        // Chỉ tiêm Service, không tiêm DbContext hay Mapper
        public VehiclesController(IVehicleService vehicleService)
        {
            _vehicleService = vehicleService;
        }

        // GET: odata/Vehicles
        [EnableQuery]
        public IActionResult Get()
        {
            // Trả về IQueryable<VehicleDto> từ service
            return Ok(_vehicleService.GetVehicles());
        }

        // GET: odata/Vehicles(5)
        [EnableQuery]
        public async Task<IActionResult> Get([FromODataUri] int key)
        {
            var vehicle = await _vehicleService.GetVehicleByIdAsync(key);
            if (vehicle == null)
            {
                return NotFound();
            }
            return Ok(vehicle);
        }

        // POST: odata/Vehicles
        // Nhận vào DTO
        public async Task<IActionResult> Post([FromBody] VehicleCreateDto createDto)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            var createdVehicle = await _vehicleService.CreateVehicleAsync(createDto);
            return Created(createdVehicle);
        }

        // PUT: odata/Vehicles(5)
        // Nhận vào DTO
        public async Task<IActionResult> Put([FromODataUri] int key, [FromBody] VehicleCreateDto updateDto)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            var result = await _vehicleService.UpdateVehicleAsync(key, updateDto);
            if (!result)
            {
                return NotFound();
            }
            return NoContent();
        }

        // DELETE: odata/Vehicles(5)
        public async Task<IActionResult> Delete([FromODataUri] int key)
        {
            var result = await _vehicleService.DeleteVehicleAsync(key);
            if (!result)
            {
                return NotFound();
            }
            return NoContent();
        }
    }
}