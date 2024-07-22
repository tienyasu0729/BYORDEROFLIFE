using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Category
    {
        public int IdCategory { get; set; }
        public string NameCategory { get; set; }
        public int ParentID { get; set; }
        public Category Parent { get; set; }
        public ICollection<Category> Categorys { get; set; }
    }
}
