using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Abstract
{
    class AirCraft: FlyingObject
    {
        public override void Fly()
        {
            Console.WriteLine("Air Craft is flying!");
        }

        public void PourFuel()
        {
            Console.WriteLine("Air Craft is pouring fuel!");
        }
    }
}
