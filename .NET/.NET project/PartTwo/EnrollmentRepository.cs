using CodeFirstTest;
using PartOne;

namespace PartTwo
{
    public class EnrollmentRepository : IEnrollmentRepository
    {
        public async Task AddEnrollment(Enrollment enrollment)
        {
            await EnrollmentDAO.instance.Add(enrollment);
        }

        public async Task DeleteEnrollment(int id)
        {
            await EnrollmentDAO.instance.Delete(id);
        }

        public async Task<IEnumerable<Enrollment>> GetAllEnrollment()
        {
            return await EnrollmentDAO.instance.GetEnrollmentAll();
        }

        public async Task<Enrollment> GetEnrollmentById(int id)
        {
            return await EnrollmentDAO.instance.GetEnrollmentById(id);
        }

        public async Task UpdateEnrollment(Enrollment enrollment)
        {
            await EnrollmentDAO.instance.Update(enrollment);
        }
    }
}
