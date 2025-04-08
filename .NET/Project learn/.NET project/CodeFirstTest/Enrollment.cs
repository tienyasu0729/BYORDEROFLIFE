using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeFirstTest
{
    public class Enrollment
    {
        public int EnrollmentId {get; set;}
        public int StudentId {get; set;}
        public int CourseId {get; set;}
        public DateTime EnrollmentDate {get; set;}
        public virtual Student Student {get; set;}
        public virtual Course Course {get; set;}
    }
}
