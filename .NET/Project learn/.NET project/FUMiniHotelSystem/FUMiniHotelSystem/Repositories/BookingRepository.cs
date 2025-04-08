using BusinessObject;
using DataAccessObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class BookingRepository
    {
        BookingDAO dao = new BookingDAO();
        public List<Booking> GetBookingReservations() => dao.GetBookingReservations();
        public List<Booking> GetBookingReservationById(int id) => dao.GetBookingReservationById(id);
    }
}
