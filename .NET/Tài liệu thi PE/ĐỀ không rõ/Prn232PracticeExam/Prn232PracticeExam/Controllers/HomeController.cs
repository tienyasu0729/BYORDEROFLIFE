using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.OData.Query;
using Microsoft.EntityFrameworkCore;
using Prn232PracticeExam.Data;
using Prn232PracticeExam.Models;

namespace Prn232PracticeExam.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [Authorize] // Bắt buộc TẤT CẢ các endpoint phải có token (theo Mục 2.4)
    public class LeopardProfileController : ControllerBase
    {
        private readonly PracticeExamContext _context;

        public LeopardProfileController(PracticeExamContext context)
        {
            _context = context;
        }

        // GET: api/LeopardProfile (OData)
        // Mục 2.2: ALL ROLES (Admin, Mod, Dev, Member)
        [HttpGet]
        [EnableQuery] // Kích hoạt OData
        [Authorize(Roles = "Administrator,Moderator,Developer,Member")]
        public IActionResult GetLeopardProfiles()
        {
            // Nhờ [EnableQuery], bạn chỉ cần return IQueryable là OData tự xử lý
            return Ok(_context.LeopardProfiles);
        }

        // GET: api/LeopardProfile/5
        // Mục 2.2: ALL ROLES
        [HttpGet("{id}")]
        [Authorize(Roles = "Administrator,Moderator,Developer,Member")]
        public async Task<ActionResult<LeopardProfile>> GetLeopardProfile(int id)
        {
            var profile = await _context.LeopardProfiles.FindAsync(id);

            if (profile == null)
            {
                // Trả về lỗi 404 với format yêu cầu (Mục 2.3)
                return NotFound(new { errorCode = "HB40401", errorMessage = "Resource not found" });
            }

            return Ok(profile);
        }

        // POST: api/LeopardProfile
        // Mục 2.2: Admin, Moderator
        [HttpPost]
        [Authorize(Roles = "Administrator,Moderator")]
        public async Task<ActionResult<LeopardProfile>> PostLeopardProfile(LeopardProfile profile)
        {
            // Validation (Regex) sẽ tự động được check bởi [ApiController]
            // và trả về lỗi 400 (HB40001) nhờ cấu hình ở Program.cs.

            _context.LeopardProfiles.Add(profile);
            await _context.SaveChangesAsync();

            return CreatedAtAction(nameof(GetLeopardProfile), new { id = profile.Id }, profile);
        }

        // PUT: api/LeopardProfile/5
        // Mục 2.2: Admin, Moderator
        [HttpPut("{id}")]
        [Authorize(Roles = "Administrator,Moderator")]
        public async Task<IActionResult> PutLeopardProfile(int id, LeopardProfile profile)
        {
            if (id != profile.Id)
            {
                // Trả về lỗi 400 với format (Mục 2.3)
                return BadRequest(new { errorCode = "HB40001", errorMessage = "ID mismatch" });
            }

            // Validation (Regex) cũng tự động check ở đây

            _context.Entry(profile).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!_context.LeopardProfiles.Any(e => e.Id == id))
                {
                    return NotFound(new { errorCode = "HB40401", errorMessage = "Resource not found" });
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // DELETE: api/LeopardProfile/5
        // Mục 2.2: CHỈ Admin
        [HttpDelete("{id}")]
        [Authorize(Roles = "Administrator")]
        public async Task<IActionResult> DeleteLeopardProfile(int id)
        {
            var profile = await _context.LeopardProfiles.FindAsync(id);
            if (profile == null)
            {
                return NotFound(new { errorCode = "HB40401", errorMessage = "Resource not found" });
            }

            _context.LeopardProfiles.Remove(profile);
            await _context.SaveChangesAsync();

            return NoContent();
        }
    }
}