using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Animal
{
    public class Cat : Animal
    {
        public void Say()
        {
            Console.WriteLine("{0} says meow meow meow", this.Name);
        }
    }
}
