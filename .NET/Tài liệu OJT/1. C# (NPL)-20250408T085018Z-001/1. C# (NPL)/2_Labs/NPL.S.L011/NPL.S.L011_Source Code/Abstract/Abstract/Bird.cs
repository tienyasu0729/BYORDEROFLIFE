using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Abstract
{
    class Bird : FlyingObject
    {
        public override void Fly()
        {
            Console.WriteLine("Bird is flying!");
        }

        public void Eat()
        {
            Console.WriteLine("Bird is eating!");
        }
    }
}
