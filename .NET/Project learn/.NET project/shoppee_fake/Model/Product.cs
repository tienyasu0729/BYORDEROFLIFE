using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Product
    {
        public int IdProduct { get; set; }
        public string NameProduct { get; set; }
        public string ProductDescription { get; set; }
        public bool PreOrder { get; set; }
        public string Condition { get; set; }
        public string SKUProduct { get; set; }
    }
}
