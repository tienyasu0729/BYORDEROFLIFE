using BusinessLogic.DTOs;
using BusinessLogic.Repositories.Interfaces;
using DataAccess.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using BusinessLogic.DTOs;
using BusinessLogic.Repositories.Interfaces;
using DataAccess.Models;

namespace API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [Authorize] // Yêu cầu xác thực cho tất cả các endpoint trong controller này
    public class BearProfilesController : ControllerBase
    {
        private readonly IBearProfileRepository _repository;

        public BearProfilesController(IBearProfileRepository repository)
        {
            _repository = repository;
        }

        // 1. Create: POST /api/BearProfiles
        // Phân quyền: Chỉ Manager (RoleId = 2)
        [HttpPost]
        [Authorize(Policy = "ManagerPolicy")]
        public async Task<IActionResult> CreateBearProfile([FromBody] BearProfileCreateDto createDto)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            var newProfile = await _repository.CreateAsync(createDto);
            return CreatedAtAction(nameof(GetBearProfileById), new { id = newProfile.BearProfileId }, newProfile);
        }

        // 2. Update: PUT /api/BearProfiles
        // Endpoint này theo đề bài KHÔNG có {id} trên URL
        // Phân quyền: Chỉ Manager (RoleId = 2)
        [HttpPut]
        [Authorize(Policy = "ManagerPolicy")]
        public async Task<IActionResult> UpdateBearProfile([FromBody] BearProfile profileUpdate)
        {
            // ID được gửi trong body
            var result = await _repository.UpdateAsync(profileUpdate);
            if (!result)
            {
                return NotFound($"Profile with ID {profileUpdate.BearProfileId} not found or update failed.");
            }
            return NoContent(); // Cập nhật thành công
        }

        // 3. Delete: DELETE /api/BearProfiles/{id}
        // Phân quyền: Chỉ Manager (RoleId = 2)
        [HttpDelete("{id}")]
        [Authorize(Policy = "ManagerPolicy")]
        public async Task<IActionResult> DeleteBearProfile(int id)
        {
            var result = await _repository.DeleteAsync(id);
            if (!result)
            {
                return NotFound();
            }
            return NoContent();
        }

        // 4. View list of items: GET /api/BearProfiles
        // Phân quyền: Chỉ Manager (RoleId = 2)
        [HttpGet]
        [Authorize(Policy = "ManagerPolicy")]
        public async Task<IActionResult> GetAllBearProfiles()
        {
            var profiles = await _repository.GetAllAsync();
            return Ok(profiles);
        }

        // 5. View detail of an item: GET /api/BearProfiles/{id}
        // Phân quyền: Chỉ Manager (RoleId = 2)
        [HttpGet("{id}")]
        [Authorize(Policy = "ManagerPolicy")]
        public async Task<IActionResult> GetBearProfileById(int id)
        {
            var profile = await _repository.GetByIdAsync(id);
            if (profile == null)
            {
                return NotFound();
            }
            return Ok(profile);
        }

        // 6. Search with paging: POST /api/BearProfiles/Search
        // Phân quyền: Manager (2), Staff (3), Member (4)
        [HttpPost("Search")]
        [Authorize(Policy = "SearchPolicy")]
        public async Task<IActionResult> SearchBearProfiles([FromBody] SearchRequestDto request)
        {
            var result = await _repository.SearchAsync(request);
            return Ok(result);
        }
    }
}