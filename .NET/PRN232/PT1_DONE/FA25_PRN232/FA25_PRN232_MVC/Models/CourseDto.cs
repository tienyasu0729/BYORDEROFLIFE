namespace FA25_PRN232_MVC.Models
{
    public class CourseDto
    {
        public int CourseId { get; set; }
        public string Title { get; set; }
        public string? Description { get; set; }
        public decimal Price { get; set; }
        public string CategoryName { get; set; }
        public string Author { get; set; }
        public DateTime CreatedAt { get; set; }
    }
}
