namespace FA25_PRN232.Models
{
    public class User
    {
        public int UserId { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public virtual ICollection<Course> Courses { get; set; }
        public virtual ICollection<Enrollment> Enrollments { get; set; }
    }
}
