using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Identification_Shop
    {
        public string FormOfIdentification { get; set; }
        public string IdentificationNumber { get; set; }
        public string IdentificationName { get; set; }
        public string ImageIdentificationFront { get; set; }
        public string ImageIdentificationBack { get; set; }
        public int IdShop { get; set; }
        public Shop Shop { get; set; }
        public int Id_Form_Of_Dentification {  get; set; }
        public Form_Of_Dentification Form_Of_Dentification { get; set; }
    }
}
