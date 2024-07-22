using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Area
    {
        public int IdArea { get; set; }
        public string NameArea { get; set; }
        public ICollection<Main_Account> Main_Accounts { get; set; }
    }
}
