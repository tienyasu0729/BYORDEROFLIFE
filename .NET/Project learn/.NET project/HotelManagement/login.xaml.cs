using Microsoft.Extensions.Configuration;
using System.IO;
using System.Windows;
using System.Windows.Input;

namespace HotelManagement
{
    public partial class login : Window
    {
        private string _email;
        private string _password;

        public string Email
        {
            get => _email;
            set
            {
                _email = value;
                OnPropertyChanged(nameof(Email));
            }
        }

        public string Password
        {
            get => _password;
            set
            {
                _password = value;
                OnPropertyChanged(nameof(Password));
            }
        }

        public ICommand LoginCommand { get; }

        public LoginViewModel()
        {
            LoginCommand = new RelayCommand(Login, CanLogin);
        }

        private bool CanLogin(object parameter)
        {
            return !string.IsNullOrEmpty(Email) && !string.IsNullOrEmpty(Password);
        }

        private void Login(object parameter)
        {
            try
            {
                // Load appsettings.json to get admin credentials
                var config = new ConfigurationBuilder()
                    .SetBasePath(Directory.GetCurrentDirectory())
                    .AddJsonFile("appsettings.json", optional: false, reloadOnChange: true)
                    .Build();

                string adminEmail = config["AdminAccount:Email"];
                string adminPassword = config["AdminAccount:Password"];

                // Check if entered credentials match admin credentials
                if (Email == adminEmail && Password == adminPassword)
                {
                    // Navigate to Main Window
                    var mainWindow = new MainWindow();
                    mainWindow.Show();

                    // Close Login Window
                    if (parameter is Window loginWindow)
                    {
                        loginWindow.Close();
                    }
                }
                else
                {
                    MessageBox.Show("Invalid email or password. Please try again.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error: {ex.Message}");
            }
        }
    }
}