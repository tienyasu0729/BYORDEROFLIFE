namespace FA25_PRN232.Models
{
    public class Course
    {
        public int CourseId { get; set; } // Sửa lại tên cột cho đúng chuẩn C#
        public string Title { get; set; }
        public string? Description { get; set; }
        public decimal Price { get; set; }
        public DateTime CreatedAt { get; set; }

        public int CategoryId { get; set; }
        public virtual Category Category { get; set; }

        public int UserId { get; set; }
        public virtual User User { get; set; }

        public virtual ICollection<Enrollment> Enrollments { get; set; }
    }
}
