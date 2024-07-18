using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Room
    {
        public int RoomID { get; set; }
        public string RoomNumber { get; set; }
        public string RoomDescription { get; set; }
        public int RoomMaxCapacity { get; set; }
        public int RoomStatus { get; set; } // 1 Active, 2 Deleted
        [Column(TypeName = "decimal(18, 2)")]
        public decimal RoomPricePerDate { get; set; }
        public int RoomTypeID { get; set; }
    }
}
