using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class User_Spending
    {
        public int OrderNumber { get; set; }
        public string Spending { get; set; }
        public int IdUser { get; set; }
        public User User { get; set; }
    }
}
