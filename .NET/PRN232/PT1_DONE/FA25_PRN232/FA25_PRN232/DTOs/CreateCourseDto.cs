namespace FA25_PRN232.DTOs
{
    public class CreateCourseDto
    {
        public string Title { get; set; }
        public string? Description { get; set; }
        public decimal Price { get; set; }
        public int CategoryId { get; set; }
        public int UserId { get; set; }
    }
}
