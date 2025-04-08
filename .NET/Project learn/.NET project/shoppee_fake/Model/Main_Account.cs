using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Main_Account
    {
        public int IdMainAccount { get; set; }
        public string PhoneNumber { get; set; }
        public string Email { get; set; }
        public string BusinessID { get; set; } // Đại diện cho tài khoản đăng nhập
        public string Password { get; set; }
        public int AreaId { get; set; }
        public Area Area { get; set; }
        public ICollection<Shop> Shops { get; set; }

    }
}
