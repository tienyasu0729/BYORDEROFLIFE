using CodeFirstTest;
using Microsoft.EntityFrameworkCore;

namespace PartOne
{
    public class StudentDAO: SingletonBase<StudentDAO>
    {
        public async Task<IEnumerable<Student>> GetStudentAll()
        {
            return await _context.Students.ToListAsync();
        }

        public async Task<Student> GetStudentById(int id)
        {
            var student = await _context.Students.FirstOrDefaultAsync(c => c.StudentId == id);
            if (student == null)
            {
                return null;
            }
            return student;
        }

        public async Task Add(Student student)
        {
            _context.Students.Add(student);
            await _context.SaveChangesAsync();
        }

        public async Task Update(Student student)
        {
            var existingItem = await GetStudentById(student.StudentId);
            if (existingItem != null)
            {
                _context.Entry(existingItem).CurrentValues.SetValues(student);

            }
            await _context.SaveChangesAsync();
        }

        public async Task Delete(int id)
        {
            var existingItem = await GetStudentById(id);
            if (existingItem != null)
            {
                _context.Students.Remove(existingItem);
                await _context.SaveChangesAsync();
            }
        }
    }
}
