using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Abstract
{
    abstract class FlyingObject
    {
        public string Name { get; set; }
        public abstract void Fly();
    }
}
