using BusinessObjects;
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
    /// Interaction logic for CustomerManagementPage.xaml
    /// </summary>
    public partial class CustomerManagementPage : Page
    {
        private readonly ICustomerRepository customerRepository;
        public CustomerManagementPage()
        {
            InitializeComponent();
            customerRepository = new CustomerRepository();
        }



        private void Page_Loaded(object sender, RoutedEventArgs e)
        {
            LoadCustomerData();
        }

        private void LoadCustomerData()
        {
            var listCus = customerRepository.GetAllCustomers();
            CustomerData.ItemsSource = listCus;
        }
        private void SearchButton_Click(object sender, RoutedEventArgs e)
        {
            string name = SearchTextBox.Text;
            var customer = customerRepository.GetCusByName(name);
            if (customer != null)
            {
                CustomerData.ItemsSource = customer;
            }
            else
            {
                MessageBox.Show("Customer not found!");
            }
        }

        private void AddCustomerButton_Click(object sender, RoutedEventArgs e)
        {
            var newCustomer = new Customer
            {

                CustomerFullName = txtFullName.Text,
                EmailAddress = txtEmail.Text,
                TelePhone = !string.IsNullOrEmpty(txtTelephone.Text) ? txtTelephone.Text : null,
                CustomerStatus = bool.TryParse(txtStatus.Text, out var status) ? status : (bool?)null,
                CustomerBirthDay = DateOnly.Parse(txtBirthDay.Text),

            };
            customerRepository.AddCustomer(newCustomer);
            LoadCustomerData();
        }

        private void UpdateCustomerButton_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (txtCustomerId.Text.Length > 0)
                {
                    var customer = new Customer
                    {
                        CustomerId = int.Parse(txtCustomerId.Text),
                        CustomerFullName = txtFullName.Text,
                        EmailAddress = txtEmail.Text,
                        CustomerBirthDay = DateOnly.Parse(txtBirthDay.Text),
                        CustomerStatus = bool.TryParse(txtStatus.Text, out var status) ? status : (bool?)null,
                        TelePhone = !string.IsNullOrEmpty(txtTelephone.Text) ? txtTelephone.Text : null,
                    };

                    customerRepository.UpdateCustomer(customer);
                    LoadCustomerData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void DeleteCustomerButton_Click(object sender, RoutedEventArgs e)
        {
            if (CustomerData.SelectedItem is Customer selectedCustomer)
            {
                customerRepository.DeleteCustomer(selectedCustomer.CustomerId);
                LoadCustomerData();
            }
        }
    }
}
