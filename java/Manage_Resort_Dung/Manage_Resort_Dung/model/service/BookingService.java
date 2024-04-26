package model.service;

import java.util.ArrayList;

import model.entity.Booking;
import model.repository.BookingRepository;

public class BookingService {
    BookingRepository bookingRepository=new BookingRepository();
    public ArrayList<Booking> getAllBookings()throws Exception{
        return bookingRepository.getAllBookings();
    }

    public void addBooking(Booking booking)throws Exception{
        bookingRepository.addBooking(booking);
    }
}
