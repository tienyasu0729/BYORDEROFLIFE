using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BusinessObject
{
    public class RoomInformation
    {
        public RoomInformation() { }
        public RoomInformation(int roomID, string roomNumber, string roomDescription, int roomMaxCapacity, int roomStatus, Decimal roomPricePerDate, int roomTypeID) 
        { 
            RoomID = roomID;
            RoomNumber = roomNumber;
            RoomDescription = roomDescription;
            RoomMaxCapacity = roomMaxCapacity;
            RoomStatus = roomStatus;
            RoomPricePerDate = roomPricePerDate;
            RoomTypeID = roomTypeID;
        }
        public int RoomID { get; set; }
        public string RoomNumber { get; set; }
        public string RoomDescription { get; set;}
        public int RoomMaxCapacity { get; set; }
        public int RoomStatus { get; set; }
        public Decimal RoomPricePerDate { get; set; }
        public int RoomTypeID { get; set; }
        public virtual RoomType RoomType { get; set; }
    }
}
