using CodeFirstTest;
using Microsoft.EntityFrameworkCore;

namespace PartOne
{
    public class CourseDAO : SingletonBase<CourseDAO>
    {
        public async Task<IEnumerable<Course>> GetCourseAll()
        {
            return await _context.Courses.ToListAsync();
        }

        public async Task<Course> GetCourseById(int id)
        {
            var course = await _context.Courses.FirstOrDefaultAsync(c => c.CourseID == id);
            if (course == null)
            {
                return null;
            }
            return course;
        }

        public async Task Add(Course course)
        {
            _context.Courses.Add(course);
            await _context.SaveChangesAsync();
        }

        public async Task Update(Course course)
        {
            var existingItem = await GetCourseById(course.CourseID);
            if (existingItem != null)
            {
                _context.Entry(existingItem).CurrentValues.SetValues(course);

            }
            await _context.SaveChangesAsync();
        }

        public async Task Delete(int id)
        {
            var existingItem = await GetCourseById(id);
            if (existingItem != null)
            {
                _context.Courses.Remove(existingItem);
                await _context.SaveChangesAsync();
            }
        }
    }
}
