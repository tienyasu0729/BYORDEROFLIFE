namespace CodeFirstTest
{
    public class Student
    {
        public int StudentId { get; set; }
        public string StudentName { get; set; }
        public string Address { get; set; }
        public virtual ICollection<Enrollment> Enrollments { get; set; }
    }
}
