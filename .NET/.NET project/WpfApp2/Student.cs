namespace ClassLibrary1
{
    public class Student
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
        public virtual ICollection<Enrollment> Enrollments { get; set; }
    
    }
}
