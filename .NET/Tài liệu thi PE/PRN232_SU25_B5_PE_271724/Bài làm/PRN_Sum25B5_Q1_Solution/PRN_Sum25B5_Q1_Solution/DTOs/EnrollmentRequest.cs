// Thay thế TOÀN BỘ file EnrollmentRequest.cs của bạn bằng code này

using System.ComponentModel.DataAnnotations;

namespace PRN_Sum25B5_Q1_Solution.Models.DTOs // <-- Đảm bảo namespace này đúng
{
    public class EnrollmentRequest
    {
        [Required(ErrorMessage = "studentId is required")]
        public int? StudentId { get; set; }

        [Required(ErrorMessage = "courseId is required")]
        public int? CourseId { get; set; }

        [Required(ErrorMessage = "enrollDate is required")]
        // SỬA Ở ĐÂY: Dùng DateOnly?
        public DateOnly? EnrollDate { get; set; }

        [Required(ErrorMessage = "grade is required")]
        public double? Grade { get; set; }
    }
}