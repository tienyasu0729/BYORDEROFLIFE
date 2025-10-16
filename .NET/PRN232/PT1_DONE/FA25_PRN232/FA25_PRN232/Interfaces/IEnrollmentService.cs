using FA25_PRN232.DTOs;
using FA25_PRN232.Models;

namespace FA25_PRN232.Interfaces
{
    public interface IEnrollmentService
    {
        Task<Enrollment?> CreateEnrollment(CreateEnrollmentDto enrollmentDto);
    }
}
