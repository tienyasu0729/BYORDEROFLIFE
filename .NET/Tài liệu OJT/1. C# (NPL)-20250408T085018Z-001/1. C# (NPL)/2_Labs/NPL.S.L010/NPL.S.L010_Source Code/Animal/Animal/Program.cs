using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Animal
{
    class Program
    {
        static void Main(string[] args)
        {
            Dog dog = new Dog(){};
            dog.Name = "Cooper";
            dog.Location = "England";

            //// dog object use method from supper class
            dog.Run();
            //// dog object use method from derived class
            dog.Say();
            
            Cat cat = new Cat(){};
            cat.Name = "Tom";
            cat.Location = "America";

            //// cat object use method from supper class
            cat.Run();
            //// cat object use method from derived class
            cat.Say();

            Console.ReadKey();
        }
    }
}
