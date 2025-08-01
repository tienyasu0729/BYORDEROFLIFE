using System.ComponentModel.DataAnnotations;

namespace PawnShop.Models
{
    public class LoginViewModel
    {
        [Required(ErrorMessage = "Số điện thoại không được để trống")]
        public string PhoneNumber { get; set; }

        [Required(ErrorMessage = "Mật khẩu không được để trống")]
        [DataType(DataType.Password)]
        public string Password { get; set; }
    }
}
