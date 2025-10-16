using AutoMapper;
using AutoMapper.QueryableExtensions;
using FA25_PRN232.Data;
using FA25_PRN232.DTOs;
using FA25_PRN232.Interfaces;
using FA25_PRN232.Models;
using Microsoft.EntityFrameworkCore;

namespace SP25_PRN231.Services
{
    public class CourseService : ICourseService
    {
        private readonly AppDbContext _context;
        private readonly IMapper _mapper;

        public CourseService(AppDbContext context, IMapper mapper)
        {
            _context = context;
            _mapper = mapper;
        }

        public IQueryable<CourseDto> GetAllCourses()
        {
            // ProjectTo is efficient as it translates the projection to SQL
            return _context.Courses
                           .Include(c => c.Category)
                           .Include(c => c.User)
                           .ProjectTo<CourseDto>(_mapper.ConfigurationProvider);
        }

        public async Task<CourseDto?> GetCourseById(int id)
        {
            return await _context.Courses
                                 .Where(c => c.CourseId == id)
                                 .ProjectTo<CourseDto>(_mapper.ConfigurationProvider)
                                 .FirstOrDefaultAsync();
        }

        public async Task<Course> CreateCourse(CreateCourseDto courseDto)
        {
            var course = _mapper.Map<Course>(courseDto);
            _context.Courses.Add(course);
            await _context.SaveChangesAsync();
            return course;
        }

        public async Task<bool> UpdateCourse(int id, CreateCourseDto courseDto)
        {
            var existingCourse = await _context.Courses.FindAsync(id);
            if (existingCourse == null) return false;

            _mapper.Map(courseDto, existingCourse);
            await _context.SaveChangesAsync();
            return true;
        }

        public async Task<bool> DeleteCourse(int id)
        {
            var course = await _context.Courses.FindAsync(id);
            if (course == null) return false;

            _context.Courses.Remove(course);
            await _context.SaveChangesAsync();
            return true;
        }
    }
}
