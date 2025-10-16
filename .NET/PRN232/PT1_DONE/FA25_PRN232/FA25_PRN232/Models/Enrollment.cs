namespace FA25_PRN232.Models
{
    public class Enrollment
    {
        public int EnrollmentId { get; set; }
        public DateTime EnrollmentDate { get; set; }

        public int CourseId { get; set; }
        public virtual Course Course { get; set; }

        public int UserId { get; set; }
        public virtual User User { get; set; }
    }
}
