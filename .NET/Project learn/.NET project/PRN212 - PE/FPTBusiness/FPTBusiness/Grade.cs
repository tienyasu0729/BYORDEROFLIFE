using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FPTBusiness
{

    [PrimaryKey(nameof(SubjectId), nameof(StudentId))]
    public class Grade
    {
        public int GradeId { get; set; }
        public int SubjectId { get; set; }
        public int StudentId { get; set; }
        public int Point { get; set; }
        [DataType(DataType.Date)]
        public DateTime DataCreate { get; set; }
        public virtual Subject Subject { get; set; }
        public virtual Student Student { get; set; }
    }
}
