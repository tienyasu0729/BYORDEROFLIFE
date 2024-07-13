using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibrary1
{
    public class Course
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Credit { get; set; }
        public virtual ICollection<Enrollment> Enrollments { get; set; }

    }
}
