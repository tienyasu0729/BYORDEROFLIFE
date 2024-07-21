using BusinessObject;
using Repositories;
using System;
using System.Collections.Generic;
using System.Configuration;
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

namespace WPFApp
{
    /// <summary>
    /// Interaction logic for LoginWindow.xaml
    /// </summary>
    public partial class LoginWindow : Window
    {
        private AccountRepository iAccount;
        public LoginWindow()
        {
            InitializeComponent();
            iAccount = new AccountRepository();
        }

        private void btnLogin_Click(object sender, RoutedEventArgs e)
        {
            Account account = iAccount.GetAccountByEmail(txtUser.Text);
            if (account != null && account.Password.Equals(txtPass.Password))
            {
                if (account.Role == 1)
                {
                    AdminWindow adminWindow = new AdminWindow();
                    adminWindow.Show();
                }
                else if(account.Role == 2)
                {
                    var id = account.AccountId;
                    UserWindow userWindow = new UserWindow(id);
                    userWindow.Show();
                }
                this.Close();
            }
            else
            {
                MessageBox.Show("You are not permission !");
            }
        }

        private void btnCancel_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
    }
}
