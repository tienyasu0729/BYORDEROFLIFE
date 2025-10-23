using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services.DTOs
{
    public class LoginResponseDto
    {
        public int UserId { get; set; }
        public int Role { get; set; }
    }
}
