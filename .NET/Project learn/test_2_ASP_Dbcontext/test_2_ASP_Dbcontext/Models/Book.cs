﻿namespace test_2_ASP_Dbcontext.Models
{
    public class Book
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public int? Rate { get; set; }
        public string Genre { get; set; }
        public string Author { get; set; }
        public DateTime DateAdded { get; set; }
    }
}
