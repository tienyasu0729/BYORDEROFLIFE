using CodeFirstTest;
using PartOne;

namespace PartTwo
{
    public class StudentRepository : IStudentRepository
    {
        public async Task AddStudent(Student student)
        {
            await StudentDAO.instance.Add(student);
        }

        public async Task DeleteStudent(int id)
        {
            await StudentDAO.instance.Delete(id);
        }

        public async Task<IEnumerable<Student>> GetAllStudent()
        {
            return await StudentDAO.instance.GetStudentAll();
        }

        public async Task<Student> GetStudentById(int id)
        {
            return await StudentDAO.instance.GetStudentById(id);
        }

        public async Task UpdateStudent(Student student)
        {
            await StudentDAO.instance.Update(student);
        }
    }
}
