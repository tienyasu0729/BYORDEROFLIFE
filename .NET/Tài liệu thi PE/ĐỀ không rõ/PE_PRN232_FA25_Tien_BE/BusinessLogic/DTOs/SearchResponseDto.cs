using System.Collections.Generic;

namespace BusinessLogic.DTOs
{
    public class SearchResponseDto<T>
    {
        public long TotalItems { get; set; }
        public int TotalPages { get; set; }
        public int CurrentPage { get; set; }
        public int PageSize { get; set; }
        public List<T> Items { get; set; }
    }
}