namespace FPTBusiness
{
    public class Student
    {
        public int StudentId { get; set; }
        public int StudentCode { get; set; }
        public string StudentName { get; set; }
        public virtual ICollection<Grade> Grades { get; set; }
    }
}
