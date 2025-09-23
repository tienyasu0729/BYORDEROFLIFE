using System;

namespace LibraryODataApi.Models
{
    public class BookLoan
    {
        public int Id { get; set; }
        public string MemberName { get; set; }
        public string MemberEmail { get; set; }
        public DateTime LoanDate { get; set; }
        public DateTime DueDate { get; set; }
        public DateTime? ReturnDate { get; set; }
        public bool IsReturned { get; set; }
        public decimal Fine { get; set; }

        public int BookId { get; set; }
        public Book Book { get; set; }
    }
}