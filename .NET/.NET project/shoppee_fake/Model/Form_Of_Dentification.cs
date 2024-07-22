using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Form_Of_Dentification
    {
        public int Id_Form_Of_Dentification { get; set; }
        public string NameForm { get; set; }
        public ICollection<Identification_Shop> Identification_Shops { get; set; }
    }
}
