using BusinessObjects;
using DataAcessLayer;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class BookingRepository: IBookingRepository
    {
       

        public void AddBookingReservation(BookingReservation bookingReservation)=> BookingReservationDAO.AddBookingReservation(bookingReservation);


        public void DeleteBookingReservation(int id) => BookingReservationDAO.DeleteBookingReservation(id);
    

        public List<BookingReservation> GetAllBookings()=> BookingReservationDAO.GetAllBookingReservations();


        public List<BookingReservation> GetBookingReservationByCutomerId(int cutomerId) => BookingReservationDAO.GetBookingReservationByCutomerId(cutomerId);


        public List<BookingReservation> GetBookingReservationsByPeriod(DateOnly startDate, DateOnly endDate)
         => BookingReservationDAO.GetBookingReservationsByPeriod(startDate, endDate);

        public void UpdateBookingReservation(BookingReservation bookingReservation) => BookingReservationDAO.UpdateBookingReservation(bookingReservation);
       
    }
}
