using CodeFirstTest;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PartTwo
{
    public interface IEnrollmentRepository
    {
        Task<IEnumerable<Enrollment>> GetAllEnrollment();
        Task<Enrollment> GetEnrollmentById(int id);

        Task AddEnrollment(Enrollment enrollment);

        Task UpdateEnrollment(Enrollment enrollment);
        Task DeleteEnrollment(int id);
    }
}
