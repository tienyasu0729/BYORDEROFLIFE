using Microsoft.EntityFrameworkCore;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAcess
{
    public class BookingReservationDAO
    {
        public static List<BookingReservation> GetAllBookingReservations()
        {
            using (var context = new FuminiHotelSystemContext())
            {
                return context.BookingReservations.Include(x=>x.BookingDetail).Include(x=>x.Customer).ToList();
            }
        }

        public static List<BookingReservation> GetBookingReservationByCutomerId(int Id)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                return context.BookingReservations.Where(x=>x.CustomerId==Id).ToList();
            }
        }

        public static void AddBookingReservation(BookingReservation bookingReservation)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                context.BookingReservations.Add(bookingReservation);
                context.SaveChanges();
            }
        }

        public static void UpdateBookingReservation(BookingReservation bookingReservation)
        {
            using (var context = new FuminiHotelSystemContext())
        {
            var existingReservation = context.BookingReservations
                                             .Include(br => br.BookingDetail)
                                             .FirstOrDefault(br => br.BookingReservationId == bookingReservation.BookingReservationId);
            if (existingReservation != null)
            {
                existingReservation.BookingDate = bookingReservation.BookingDate;
                existingReservation.TotalPrice = bookingReservation.TotalPrice;
                existingReservation.CustomerId = bookingReservation.CustomerId;
                existingReservation.BooingStatus = bookingReservation.BooingStatus;

                if (bookingReservation.BookingDetail != null)
                {
                    existingReservation.BookingDetail.StartDate = bookingReservation.BookingDetail.StartDate;
                    existingReservation.BookingDetail.EndDate = bookingReservation.BookingDetail.EndDate;
                    existingReservation.BookingDetail.ActualPrice = bookingReservation.BookingDetail.ActualPrice;
                    existingReservation.BookingDetail.RoomId = bookingReservation.BookingDetail.RoomId;
                }

                context.SaveChanges();
            }
        }
        }

        public static void DeleteBookingReservation(int bookingReservationId)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                var reservation = context.BookingReservations
                                         .Include(br => br.BookingDetail)
                                         .FirstOrDefault(br => br.BookingReservationId == bookingReservationId);
                if (reservation != null)
                {
                    if (reservation.BookingDetail != null)
                    {
                        context.BookingDetails.Remove(reservation.BookingDetail);
                    }
                    context.BookingReservations.Remove(reservation);
                    context.SaveChanges();
                }
            }
        }

        public static List<BookingReservation> GetBookingReservationsByPeriod(DateOnly startDate, DateOnly endDate)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                return context.BookingReservations
                              .Where(r => r.BookingDate >= startDate && r.BookingDate <= endDate).Include(x=>x.BookingDetail).Include(x=>x.Customer)
                              .OrderByDescending(r => r.BookingDate)
                              .ToList();
            }
        }
    }
}
