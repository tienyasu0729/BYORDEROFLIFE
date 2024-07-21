using BusinessObjects;
using DataAcessLayer;
using Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace CaoThangWPF
{
    /// <summary>
    /// Interaction logic for BookingManagementPage.xaml
    /// </summary>
    public partial class BookingManagementPage : Page
    {
        private readonly IBookingRepository bookingRepository;

        public BookingManagementPage()
        {
            InitializeComponent();
            bookingRepository = new BookingRepository();
            LoadBookings();
        }

        private void LoadBookings()
        {
            var listBooking = bookingRepository.GetAllBookings();
            BookingDataGrid.ItemsSource = listBooking;

        }

        private void SearchButton_Click(object sender, RoutedEventArgs e)
        {
            if (DateOnly.TryParse(StartDatePicker.Text, out DateOnly startDate) && DateOnly.TryParse(EndDatePicker.Text, out DateOnly endDate))
            {
                BookingDataGrid.ItemsSource = BookingReservationDAO.GetBookingReservationsByPeriod(startDate, endDate);
            }
            else
            {
                MessageBox.Show("Please enter valid dates!");
            }
        }



        private void UpdateBookingButton_Click(object sender, RoutedEventArgs e)
        {
            if (txtDateStart.SelectedDate is DateTime startDate &&
       txtDateEnd.SelectedDate is DateTime endDate &&
       int.TryParse(txtCustomerId.Text, out int customerId) &&
       int.TryParse(RoomId.Text, out int roomId) &&
       decimal.TryParse(txtTotal.Text, out decimal totalPrice))
            {
                var newBooking = new BookingReservation
                {
                    BookingReservationId = Int32.Parse(txtBookingId.Text),
                    CustomerId = customerId,
                    BooingStatus = true,
                    BookingDate = DateOnly.FromDateTime(DateTime.Now),
                    TotalPrice = totalPrice,
                    BookingDetail = new BookingDetail
                    {
                        RoomId = roomId,
                        StartDate = DateOnly.FromDateTime(startDate),
                        EndDate = DateOnly.FromDateTime(endDate),
                    }
                };

                BookingReservationDAO.UpdateBookingReservation(newBooking);
                LoadBookings();
                MessageBox.Show("Booking update successfully.");
            }
            else
            {
                MessageBox.Show("Please ensure all fields are filled in correctly.");
            }

        }

        private void DeleteBookingButton_Click(object sender, RoutedEventArgs e)
        {
            if (BookingDataGrid.SelectedItem is BookingReservation selectedBooking)
            {
                BookingReservationDAO.DeleteBookingReservation(selectedBooking.BookingReservationId);
                LoadBookings();
            }
        }

        private void txtBookingId_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

        private void AddBookingButton_Click(object sender, RoutedEventArgs e)
        {
            if (txtDateStart.SelectedDate is DateTime startDate &&
        txtDateEnd.SelectedDate is DateTime endDate &&
        int.TryParse(txtCustomerId.Text, out int customerId) &&
        int.TryParse(RoomId.Text, out int roomId) &&
        decimal.TryParse(txtTotal.Text, out decimal totalPrice))
            {
                var newBooking = new BookingReservation
                {
                    CustomerId = customerId,
                    BooingStatus = true,
                    BookingDate = DateOnly.FromDateTime(DateTime.Now),
                    TotalPrice = totalPrice,
                    BookingDetail = new BookingDetail
                    {
                        RoomId = roomId,
                        StartDate = DateOnly.FromDateTime(startDate),
                        EndDate = DateOnly.FromDateTime(endDate),
                    }
                };

                BookingReservationDAO.AddBookingReservation(newBooking);
                LoadBookings();
                MessageBox.Show("Booking added successfully.");
            }
            else
            {
                MessageBox.Show("Please ensure all fields are filled in correctly.");
            }
        }
    }
}
