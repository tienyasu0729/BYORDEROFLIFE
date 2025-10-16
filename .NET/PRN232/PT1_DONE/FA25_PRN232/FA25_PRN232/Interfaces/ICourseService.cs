using FA25_PRN232.DTOs;
using FA25_PRN232.Models;

namespace FA25_PRN232.Interfaces
{
    public interface ICourseService
    {
        IQueryable<CourseDto> GetAllCourses();
        Task<CourseDto> GetCourseById(int id);
        Task<Course> CreateCourse(CreateCourseDto courseDto);
        Task<bool> UpdateCourse(int id, CreateCourseDto courseDto);
        Task<bool> DeleteCourse(int id);
    }
}
