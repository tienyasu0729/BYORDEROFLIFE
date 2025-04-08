using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Animal
{
    public class Animal
    {
        public string Name { get; set; }
        public string Location { get; set; }

        public void Run()
        {
            Console.WriteLine("{0} is running at {1}!", this.Name, this.Location);
        }
    }
}
