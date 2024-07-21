using BusinessObject;
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
using System.Windows.Shapes;

namespace WPFApp
{
    /// <summary>
    /// Interaction logic for UserWindow.xaml
    /// </summary>
    public partial class UserWindow : Window
    {
        private BookingRepository _bookingRepository;
        private CustomerRepository _customerRepository;
        private int _customerID;
        public UserWindow(int customerID)
        {
            InitializeComponent();
            _bookingRepository = new BookingRepository();
            _customerRepository = new CustomerRepository();
            _customerID = customerID;
        }

        private void ManageProfile_Click(object sender, RoutedEventArgs e)
        {
            ProfileGrid.Visibility = Visibility.Visible;
            //BookGrid.Visibility = Visibility.Collapsed;
            dgData.Visibility = Visibility.Collapsed;
            LoadProfile();
        }
        public void LoadProfile()
        {
            try
            {
                var customer = _customerRepository.GetCustomerById( _customerID );
                txtId.Text = customer.CustomerID.ToString();
                txtName.Text = customer.CustomerFullName;
                txtEmail.Text = customer.EmailAddress;
                txtPhone.Text = customer.Telephone;
                dpBirthday.Text = customer.CustomerBirthday.ToString("yyyy-MM-dd");
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error loading profile");
            }
        }
        private void EditProfile_Click(object sender, RoutedEventArgs e)
        {
            txtName.IsEnabled = true;
            txtEmail.IsEnabled = true;
            txtPhone.IsEnabled = true;
            dpBirthday.IsEnabled = true;
        }
        private void SaveProfile_Click(object sender, RoutedEventArgs e)
        {
            Customer customer = new Customer();
            customer.CustomerFullName = txtName.Text;
            customer.EmailAddress = txtEmail.Text;
            customer.Telephone = txtPhone.Text;
            customer.CustomerBirthday = dpBirthday.SelectedDate.Value;

            _customerRepository.UpdateCustomer( customer );
            MessageBox.Show("Customer updated successfully!");

            txtName.IsEnabled = false;
            txtEmail.IsEnabled = false;
            txtPhone.IsEnabled = false;
            dpBirthday.IsEnabled = false;
        }
        private void ViewBookingHistory_Click(object sender, RoutedEventArgs e)
        {
            //BookGrid.Visibility = Visibility.Visible;
            dgData.Visibility = Visibility.Visible;
            ProfileGrid.Visibility = Visibility.Collapsed;
            LoadBookingReservation();
        }
        public void LoadBookingReservation()
        {
            try
            {
                var bookingReservation = _bookingRepository.GetBookingReservationById(_customerID);
                dgData.ItemsSource = bookingReservation;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error loading booking reservation");
            }
        }
        private void btnClose_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
    }
}
