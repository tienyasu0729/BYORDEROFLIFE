package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.Booking;
import model.entity.Customer;

public class BookingRepository {
    private ArrayList<Booking> bookings=new ArrayList<>();
    CustomerRepository customerRepository=new CustomerRepository();
    public ArrayList<Booking> read()throws Exception{
        bookings.clear();
        FileReader fr=new FileReader("D://Hoc_them/resort/database/Booking.txt");
        BufferedReader br=new BufferedReader(fr);
        String result;
        while((result=br.readLine())!=null){
            int id=Integer.parseInt(result.split(",")[0]);
            Customer customer=customerRepository.getCustomerById(id);
            String service=result.split(",")[1];
            Booking booking=new Booking(customer, service);
            bookings.add(booking);
        }
        fr.close();
        br.close();
        return bookings;
    }

    public void write()throws Exception{
        FileWriter fw=new FileWriter("D://Hoc_them/resort/database/Booking.txt");
        String boString="";
        for (Booking booking : bookings) {
            boString+= booking.getCustomer().getId()+","+booking.getService()+"\n";
        }
        fw.write(boString);
        fw.close();
    }

    public ArrayList<Booking> getAllBookings()throws Exception{
        read();
        return bookings;
    }

    public void addBooking(Booking booking)throws Exception{
        read();
        bookings.add(booking);
        write();
    }
}
