using BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccessObjects
{
    public class BookingDAO
    {
        private static List<Booking> listBooked;
        public BookingDAO()
        {
            Booking book1 = new Booking(1, 1, new DateTime(2024, 6, 13), new DateTime(2024, 6, 14), 100, 2);
            Booking book2 = new Booking(2, 2, new DateTime(2024, 6, 15), new DateTime(2024, 6, 16), 150, 2);
            Booking book3 = new Booking(3, 3, new DateTime(2024, 6, 17), new DateTime(2024, 6, 18), 200, 2);
            Booking book4 = new Booking(4, 1, new DateTime(2024, 6, 19), new DateTime(2024, 6, 20), 100, 2);
            Booking book5 = new Booking(1, 1, new DateTime(2024, 6, 13), new DateTime(2024, 6, 14), 100, 3);
            Booking book6 = new Booking(2, 2, new DateTime(2024, 6, 15), new DateTime(2024, 6, 16), 150, 3);
            Booking book7 = new Booking(3, 3, new DateTime(2024, 6, 17), new DateTime(2024, 6, 18), 200, 3);
            listBooked = new List<Booking> { book1, book2, book3, book4, book5, book6, book7 };
        }
        public List<Booking> GetBookingReservations()
        {
            return listBooked;
        }
        //CRUD RoomInfomation
        public List<Booking> GetBookingReservationById(int id)
        {
            List<Booking> bookings = listBooked.Where(b => b.CustomerID == id).ToList();
            return bookings;
        }
    }
}
