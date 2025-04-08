using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BusinessObject
{
    public class Booking
    {
        public Booking() { }
        public Booking(int boookingReservationID, int roomID, DateTime startDate, DateTime endDate, Decimal actualPrice, int customerID)
        {
            BookingReservationID = boookingReservationID;
            RoomID = roomID;
            StartDate = startDate;
            EndDate = endDate;
            ActualPrice = actualPrice;
            CustomerID = customerID;
        }
        public int BookingReservationID { get; set; }
        public int RoomID { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime EndDate { get; set; }
        public Decimal ActualPrice { get; set; }
        public int CustomerID { get; set; }
    }
}
