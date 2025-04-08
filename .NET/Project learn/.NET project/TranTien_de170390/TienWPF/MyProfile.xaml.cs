using Model;
using Repository;
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
using System.Windows.Shapes;

namespace TienWPF
{
    /// <summary>
    /// Interaction logic for MyProfile.xaml
    /// </summary>
    public partial class MyProfile : Window

    {
        private Customer _customer;
        private readonly ICustomerRepository customerRepository;
        private readonly IBookingRepository bookingRepository;
        public MyProfile(Customer customer)
        {
            InitializeComponent();
            _customer = customer;
            customerRepository = new CustomerRepository();
            bookingRepository = new BookingRepository();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            txtName.Text = _customer.CustomerFullName.ToString();
            txtEmail.Text = _customer.EmailAddress.ToString();
            txtPhone.Text = _customer.TelePhone.ToString();

            var bookingList = bookingRepository.GetBookingReservationByCutomerId(_customer.CustomerId);
            BookingHistoryDataGrid.ItemsSource = bookingList;

        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Customer customer = customerRepository.GetCustomerByEmail(_customer.EmailAddress);
            if (customer != null)
            {
                customer.TelePhone = txtPhone.Text;
                customer.CustomerFullName = txtName.Text;
                customerRepository.UpdateCustomer(customer);
            }
        }


    }
}
