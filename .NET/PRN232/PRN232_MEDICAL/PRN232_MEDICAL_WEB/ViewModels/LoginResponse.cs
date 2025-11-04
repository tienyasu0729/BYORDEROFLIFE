using System.Text.Json.Serialization;

namespace PRN232_MEDICAL_WEB.ViewModels
{
    public class LoginResponse
    {
        // Tên thuộc tính phải khớp với API trả về ("token")
        [JsonPropertyName("token")]
        public string Token { get; set; }
    }
}
