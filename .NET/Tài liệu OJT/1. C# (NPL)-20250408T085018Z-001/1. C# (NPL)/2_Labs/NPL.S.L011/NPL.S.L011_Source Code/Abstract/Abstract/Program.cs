using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Abstract
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Cannot create object from abstract class
            //FlyingObject flyingObject = new FlyingObject();

            //// Create bird object
            Bird bird = new Bird();
            bird.Fly();
            bird.Eat();

            //// Create air craft object
            AirCraft airCraft = new AirCraft();
            airCraft.Fly();
            airCraft.PourFuel();

            Console.ReadKey();
        }
    }
}
