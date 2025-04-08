using CodeFirstTest;
using Microsoft.EntityFrameworkCore;

namespace PartOne
{
    public class EnrollmentDAO : SingletonBase<EnrollmentDAO>
    {
        public async Task<IEnumerable<Enrollment>> GetEnrollmentAll()
        {
            return await _context.Enrollments.ToListAsync();
        }

        public async Task<Enrollment> GetEnrollmentById(int id)
        {
            var enrollment = await _context.Enrollments.FirstOrDefaultAsync(c => c.EnrollmentId == id);
            if (enrollment == null)
            {
                return null;
            }
            return enrollment;
        }

        public async Task Add(Enrollment enrollment)
        {
            _context.Enrollments.Add(enrollment);
            await _context.SaveChangesAsync();
        }

        public async Task Update(Enrollment enrollment)
        {
            var existingItem = await GetEnrollmentById(enrollment.EnrollmentId);
            if (existingItem != null)
            {
                _context.Entry(existingItem).CurrentValues.SetValues(enrollment);

            }
            await _context.SaveChangesAsync();
        }

        public async Task Delete(int id)
        {
            var existingItem = await GetEnrollmentById(id);
            if (existingItem != null)
            {
                _context.Enrollments.Remove(existingItem);
                await _context.SaveChangesAsync();
            }
        }
    }
}
