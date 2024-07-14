using CodeFirstTest;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PartTwo
{
    public interface IStudentRepository
    {
        Task<IEnumerable<Student>> GetAllStudent();
        Task<Student> GetStudentById(int id);

        Task AddStudent(Student student);

        Task UpdateStudent(Student student);
        Task DeleteStudent(int id);
    }
}
