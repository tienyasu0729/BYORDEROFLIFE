using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.OData.Query;
using Microsoft.EntityFrameworkCore;
using PRN232_MEDICAL.Data;
using PRN232_MEDICAL.Models;

namespace PRN232_MEDICAL.Controllers
{
   
        [Route("api/doctors")]
        [ApiController]
        public class DoctorsController : ControllerBase
        {
            private readonly ApplicationDbContext _context;

            public DoctorsController(ApplicationDbContext context)
            {
                _context = context;
            }

            // GET: /api/doctors (Câu 1.3 - List all)
            // Hỗ trợ OData (Câu 1.5)
            [HttpGet]
            [EnableQuery] //
            [AllowAnonymous] // Theo yêu cầu là "All" (mọi người đều xem được) 
            public IQueryable<Doctor> GetDoctors()
            {
                // Trả về IQueryable để OData xử lý $filter, $orderby...
                return _context.Doctors;
            }

            // GET: /api/doctors/{id} (Câu 1.3 - Get details)
            [HttpGet("{id}")]
            [AllowAnonymous] // "All" 
            public async Task<ActionResult<Doctor>> GetDoctor(int id)
            {
                var doctor = await _context.Doctors.FindAsync(id);

                if (doctor == null)
                {
                    return NotFound();
                }

                return doctor;
            }

            // POST: /api/doctors (Câu 1.3 - Add new)
            [HttpPost]
            [Authorize(Policy = "Admin")] // Chỉ Admin 
            public async Task<ActionResult<Doctor>> PostDoctor(Doctor doctor)
            {
                if (!ModelState.IsValid)
                {
                    return BadRequest(ModelState);
                }

                _context.Doctors.Add(doctor);
                await _context.SaveChangesAsync();

                return CreatedAtAction(nameof(GetDoctor), new { id = doctor.DoctorId }, doctor);
            }

            // PUT: /api/doctors/{id} (Câu 1.3 - Update info)
            [HttpPut("{id}")]
            [Authorize(Policy = "Admin")] // Chỉ Admin 
            public async Task<IActionResult> PutDoctor(int id, Doctor doctor)
            {
                if (id != doctor.DoctorId)
                {
                    return BadRequest("Doctor ID mismatch");
                }

                if (!ModelState.IsValid)
                {
                    return BadRequest(ModelState);
                }

                _context.Entry(doctor).State = EntityState.Modified;

                try
                {
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!_context.Doctors.Any(e => e.DoctorId == id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }

                return NoContent(); //
            }

            // DELETE: /api/doctors/{id} (Câu 1.3 - Delete doctor)
            [HttpDelete("{id}")]
            [Authorize(Policy = "Admin")] // Chỉ Admin 
            public async Task<IActionResult> DeleteDoctor(int id)
            {
                var doctor = await _context.Doctors.FindAsync(id);
                if (doctor == null)
                {
                    return NotFound();
                }

                _context.Doctors.Remove(doctor);
                await _context.SaveChangesAsync();

                return NoContent();
            }
        }
    }
