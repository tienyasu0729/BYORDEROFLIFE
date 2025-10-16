using AutoMapper;
using FA25_PRN232.Data;
using FA25_PRN232.DTOs;
using FA25_PRN232.Interfaces;
using FA25_PRN232.Models;
using Microsoft.EntityFrameworkCore;

namespace FA25_PRN232.Services
{
    public class EnrollmentService : IEnrollmentService
    {
        private readonly AppDbContext _context;
        private readonly IMapper _mapper;

        public EnrollmentService(AppDbContext context, IMapper mapper)
        {
            _context = context;
            _mapper = mapper;
        }

        public async Task<Enrollment?> CreateEnrollment(CreateEnrollmentDto enrollmentDto)
        {
            // Check if user is already enrolled
            var existingEnrollment = await _context.Enrollments
                .FirstOrDefaultAsync(e => e.UserId == enrollmentDto.UserId && e.CourseId == enrollmentDto.CourseId);

            if (existingEnrollment != null)
            {
                // Optionally handle this case, e.g., by throwing a custom exception
                return null;
            }

            var enrollment = _mapper.Map<Enrollment>(enrollmentDto);
            _context.Enrollments.Add(enrollment);
            await _context.SaveChangesAsync();
            return enrollment;
        }
    }
}
