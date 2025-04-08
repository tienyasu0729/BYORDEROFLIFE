using DataAcessLayer;
using Microsoft.Extensions.Configuration;
using Repositories;
using System;
using System.Collections.Generic;
using System.IO;
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

namespace NgocHanWPF
{
    /// <summary>
    /// Interaction logic for LoginWindow.xaml
    /// </summary>
    public partial class LoginWindow : Window
    {
        private readonly ICustomerRepository customerRepository;
        public LoginWindow()
        {
            InitializeComponent();
            customerRepository = new CustomerRepository();
        }

        private void btnLogin_Click(object sender, RoutedEventArgs e)
        {
            var email = txtEmail.Text;
            var password = txtPass.Password;

            if (email == "admin@gmail.com" && password == "1234")
            {
                // Open Admin Dashboard
                var adminDashboard = new AdminDashboard();
                adminDashboard.Show();
                this.Close();
            }
            else 
            {
                var customer = CustomerDAO.GetCustomerByEmail(email);
                if (customer != null && customer.Password == password)
                {
                    // Open Customer Dashboard or other customer-related functionality
                    var myProfile = new MyProfile(customer);
                    myProfile.Show();
                    this.Close();
                }
                else
                {
                    MessageBox.Show("Invalid credentials!");
                }
            }

        }

        private void btnCancel_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.Shutdown();
        }
    }

  
}
    

