namespace BusinessLogic.DTOs
{
    public class SearchRequestDto
    {
        // Đặt giá trị mặc định theo yêu cầu của đề bài
        public int CurrentPage { get; set; } = 2;
        public int PageSize { get; set; } = 3;

        public string BearName { get; set; }
        public double? BearWeight { get; set; } // Dùng nullable để biết khi nào cần tìm
        public string BearTypeName { get; set; }
    }
}