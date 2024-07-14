using CodeFirstTest;
using PartOne;

namespace PartTwo
{
    public class CourseRepository : ICourseRepository
    {
        public async Task AddCourse(Course course)
        {
            await CourseDAO.instance.Add(course);
        }

        public async Task DeleteCourse(int id)
        {
            await CourseDAO.instance.Delete(id);
        }

        public async Task<IEnumerable<Course>> GetAllCourse()
        {
            return await CourseDAO.instance.GetCourseAll();
        }

        public async Task<Course> GetCourseById(int id)
        {
            return await CourseDAO.instance.GetCourseById(id);
        }

        public async Task UpdateCourse(Course course)
        {
            await CourseDAO.instance.Update(course);
        }
    }
}
