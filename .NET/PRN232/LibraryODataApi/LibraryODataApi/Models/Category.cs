using System.Collections.Generic;

namespace LibraryODataApi.Models
{
    public class Category
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public int DisplayOrder { get; set; }
        public bool IsActive { get; set; }
        public ICollection<Book> Books { get; set; } = new List<Book>();
    }
}