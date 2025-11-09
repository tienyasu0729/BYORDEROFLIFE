using GarageSystem.BusinessLogic.Models;
using GarageSystem.Services;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.OData.Query;
using Microsoft.AspNetCore.OData.Routing.Controllers;
using System.Security.Claims;

namespace GarageSystem.WebAPI.Controllers
{

    [Authorize]
    public class VehiclesController : ODataController
    {

        private readonly IVehicleService _vehicleService;
        private readonly IUserService _userService;

        public VehiclesController(IVehicleService vehicleService, IUserService userService)
        {
            _vehicleService = vehicleService;
            _userService = userService;
        }

        [EnableQuery] // Hỗ trợ $filter=Brand eq 'Toyota' &$orderby=PlateNumber desc
        public IActionResult Get()
        {
            //var role = User.FindFirst("userId")?.Value;
            var userId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier).Value);
            var user = _userService.GetById(userId);
            var list = (user.Role == 1) ? _vehicleService.GetAll() : _vehicleService.GetByUserId(userId);
            return Ok(list.AsQueryable());
        }

        [EnableQuery]
        public IActionResult Get([FromRoute] int key)
        {
            var vehicle = _vehicleService.GetById(key);
            if (vehicle == null) return NotFound();

            var role = User.FindFirst("role")?.Value;
            var userId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier).Value);

            if (role != "1" && vehicle.UserId != userId)
                return Forbid();

            return Ok(vehicle);
        }

        // POST odata/Vehicles
        public IActionResult Post([FromBody] Vehicle vehicle)
        {
            var userId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier).Value);
            var user = _userService.GetById(userId);
            var role = user.Role.ToString();

            if (role != "1")
                vehicle.UserId = userId;

            _vehicleService.Add(vehicle);
            return Created(vehicle);
        }

        // PUT odata/Vehicles(1)
        public IActionResult Put([FromRoute] int key, [FromBody] Vehicle vehicle)
        {
            var existing = _vehicleService.GetById(key);
            if (existing == null) return NotFound();

            var userId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier).Value);
            var user = _userService.GetById(userId);
            var role = user.Role.ToString();

            if (role != "1" && existing.UserId != userId)
                return Forbid();

            vehicle.VehicleId = key;
            _vehicleService.Update(vehicle);
            return Updated(vehicle);
        }

        // DELETE /odata/Vehicles({key})
        [HttpDelete]
        public IActionResult Delete([FromRoute] int key)
        {
            var vehicle = _vehicleService.GetById(key);
            if (vehicle == null)
                return NotFound();

            // Lấy thông tin người dùng hiện tại từ JWT token
            var userId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier).Value);
            var user = _userService.GetById(userId);
            var role = user.Role.ToString();

            // Chỉ Admin (Role == "0") mới có quyền xoá
            if (role != "1")
                return Forbid("Chỉ Admin được phép xoá xe.");

            _vehicleService.Delete(vehicle);
            return NoContent();
        }
    }
}
