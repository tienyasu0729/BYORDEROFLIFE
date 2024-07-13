using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibrary1
{
    public class Enrollment
    {
        public int id { get; set; }
        public string StudentId { get; set; }
        public string CourseId { get; set; }
        public DateTime EnrollmentDate { get; set; }
        public virtual Student Student { get; set; }
        public virtual Course Course { get; set; }

    }
}
