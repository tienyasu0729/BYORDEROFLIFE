namespace FA25_PRN232.Models
{
    public class Category
    {
        public int CategoryId { get; set; }
        public string CategoryName { get; set; }
        public virtual ICollection<Course> Courses { get; set; }
    }
}
