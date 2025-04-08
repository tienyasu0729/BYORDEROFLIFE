using ClassLibrary1;
using ClassLibrary2;

namespace ClassLibrary3
{
    public class StudentRepository: IStudentRepository
    {
        public async Task<IEnumerable<Student>> GetAllStudent()
        {
            return await StudentDAO.Instance.GetStudentAll();
        }

        public async Task<Student> GetStudentById(int id) { 
        }
        public async Task Add(Student student);
        public async Task Update(Student student);
        public async Task Delete(int id);
    }
}
