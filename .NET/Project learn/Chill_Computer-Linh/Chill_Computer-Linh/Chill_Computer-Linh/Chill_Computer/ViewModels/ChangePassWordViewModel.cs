using System.ComponentModel.DataAnnotations;

namespace Chill_Computer.ViewModels
{
    public class ChangePasswordViewModel
    {
        public string OldPassword { get; set; }
        public string NewPassword { get; set; }
    }
}
