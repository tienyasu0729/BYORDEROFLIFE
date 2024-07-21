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
    /// Interaction logic for ManageCustomerWindow.xaml
    /// </summary>
    public partial class ManageCustomerWindow : Window
    {
        private CustomerRepository _customerRepository;
        public ManageCustomerWindow()
        {
            InitializeComponent();
            _customerRepository = new CustomerRepository();
            LoadCustomerList();
        }
        public void LoadCustomerList()
        {
            try
            {
                var customerList = _customerRepository.GetCustomers();
                dgData.ItemsSource = customerList;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error loading customer list");
            }
        }
        private void btnCreate_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                Customer newCustomer = new Customer
                {
                    CustomerFullName = txtFullName.Text,
                    Telephone = txtTelephone.Text,
                    EmailAddress = txtEmailAddress.Text,
                    CustomerBirthday = txtBirthday.SelectedDate.Value,
                    CustomerStatus = Int32.Parse(cmbStatus.Text),
                    Password = txtPassword.Text
                };

                //create new customer
                _customerRepository.AddCustomer(newCustomer);
                MessageBox.Show("Customer created successfully!");
                LoadCustomerList();
                ClearFields();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnUpdate_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (dgData.SelectedItem is Customer selectedCustomer)
                {
                    selectedCustomer.CustomerFullName = txtFullName.Text;
                    selectedCustomer.Telephone = txtTelephone.Text;
                    selectedCustomer.EmailAddress = txtEmailAddress.Text;
                    selectedCustomer.CustomerBirthday = txtBirthday.SelectedDate.Value;
                    selectedCustomer.CustomerStatus = Int32.Parse(cmbStatus.Text);
                    selectedCustomer.Password = txtPassword.Text;

                    //update customer
                    _customerRepository.UpdateCustomer(selectedCustomer);
                    MessageBox.Show("Customer updated successfully!");
                    LoadCustomerList();
                    ClearFields();
                }
                else
                {
                    MessageBox.Show("You must select a product !");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnDelete_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (dgData.SelectedItem is Customer selectedCustomer)
                {
                    //show confirmation
                    MessageBoxResult re = MessageBox.Show("Are you sure you want to delete this item?", "Delete Confirmation", 
                        MessageBoxButton.YesNo, MessageBoxImage.Warning);
                    if(re == MessageBoxResult.Yes)
                    {
                        _customerRepository.DeleteCustomer(selectedCustomer);
                        MessageBox.Show("Customer deleted successfully!");
                        LoadCustomerList();
                        ClearFields();
                    }
                }
                else
                {
                    MessageBox.Show("You must select a product !");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnClose_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void dgData_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (dgData.SelectedIndex >= 0)
            {
                if (dgData.SelectedItem is Customer selectedCustomer)
                {
                    txtCustomerID.Text = selectedCustomer.CustomerID.ToString();
                    txtFullName.Text = selectedCustomer.CustomerFullName;
                    txtTelephone.Text = selectedCustomer.Telephone;
                    txtEmailAddress.Text = selectedCustomer.EmailAddress;
                    txtBirthday.SelectedDate = selectedCustomer.CustomerBirthday;
                    cmbStatus.Text = selectedCustomer.CustomerStatus.ToString();
                    txtPassword.Text = selectedCustomer.Password;
                }
            }
        }
        private void ClearFields()
        {
            txtCustomerID.Clear();
            txtFullName.Clear();
            txtTelephone.Clear();
            txtEmailAddress.Clear();
            txtBirthday.SelectedDate = null;
            cmbStatus.SelectedIndex = -1;
            txtPassword.Clear();
        }

        private void btnBack_Click(object sender, RoutedEventArgs e)
        {
            AdminWindow adminWindow = new AdminWindow();
            adminWindow.Show();
            this.Close();
        }
    }
}
