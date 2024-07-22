using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class User_Identification_information
    {
        public string Cccd { get; set; }
        public string ImageSelfie { get; set; }
        public string ImageCccdFront { get; set; }
        public string ImageCccdBack { get; set; }
        public int IdUser { get; set; }
        public User User { get; set; }

    }
}
