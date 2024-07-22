using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Blocked_User
    {
        public DateTime BlockDateTime { get; set; }
        public int IdUser { get; set; }
        public User User { get; set; } 
        public int IdShop { get; set; }
        public Shop Shop { get; set; }
    }
}
