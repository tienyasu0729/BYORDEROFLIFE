using CodeFirstTest;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PartTwo
{
    public interface ICourseRepository
    {
        Task<IEnumerable<Course>> GetAllCourse();
        Task<Course> GetCourseById(int id);

        Task AddCourse(Course course);

        Task UpdateCourse(Course course);
        Task DeleteCourse(int id);
    }
}
