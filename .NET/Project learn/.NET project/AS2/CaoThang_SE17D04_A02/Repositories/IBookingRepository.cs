using BusinessObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public interface IBookingRepository
    {
        List<BookingReservation> GetAllBookings();
        List<BookingReservation> GetBookingReservationByCutomerId(int cutomerId);
        void AddBookingReservation(BookingReservation bookingReservation);
        void UpdateBookingReservation(BookingReservation bookingReservation);
        void DeleteBookingReservation(int id);
        List<BookingReservation> GetBookingReservationsByPeriod(DateOnly startDate, DateOnly endDate);
    }
}
