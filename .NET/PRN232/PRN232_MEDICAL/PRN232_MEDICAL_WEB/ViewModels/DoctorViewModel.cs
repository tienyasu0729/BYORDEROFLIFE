using System.Text.Json.Serialization;

namespace PRN232_MEDICAL_WEB.ViewModels
{
    // Cần model này để ánh xạ dữ liệu JSON từ API
    public class DoctorViewModel
    {
        // Sử dụng [JsonPropertyName] để khớp chính xác với JSON trả về từ API
        // (thường là chữ cái thường ở đầu)
        [JsonPropertyName("doctorId")]
        public int DoctorId { get; set; }

        [JsonPropertyName("name")]
        public string Name { get; set; }

        [JsonPropertyName("specialty")]
        public string Specialty { get; set; }

        [JsonPropertyName("fee")]
        public decimal Fee { get; set; }

        [JsonPropertyName("available")]
        public bool Available { get; set; }

        [JsonPropertyName("description")]
        public string? Description { get; set; }
    }
}
