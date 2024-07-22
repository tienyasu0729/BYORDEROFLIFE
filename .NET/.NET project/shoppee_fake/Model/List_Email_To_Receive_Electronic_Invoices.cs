using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class List_Email_To_Receive_Electronic_Invoices
    {
        public int Id_List_Email_To_Receive_Electronic_Invoices { get; set; }
        public string Email { get; set; }
        public int IdShop { get; set; }
        public Shop Shop { get; set; }
    }
}
