using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Shop
    {
        public int IdShop { get; set; }
        public string PhoneNumber { get; set; }
        public string ShopName { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public String AvatarImage { get; set; } // Giả sử ảnh được lưu dưới dạng dữ liệu nhị phân
        public bool Status { get; set; }
        public int IdMainAccount { get; set; }
        public ICollection<List_Email_To_Receive_Electronic_Invoices> List_Email_To_Receive_Electronic_Invoices { get; set; }
        public Payment_Settings Payment_Setting { get; set; }
        public Chat_Settings Chat_Setting { get; set; }
        public Notification_Settings Notification_Setting { get; set; }
        public Business_Information Business_Information { get; set; }
        public ICollection<Blocked_User> BlockUserList { get; set; }




    }

}
