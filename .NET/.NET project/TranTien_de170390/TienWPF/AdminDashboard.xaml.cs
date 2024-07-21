using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace TienWPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class AdminDashboard : Window
    {
        public AdminDashboard()
        {
            InitializeComponent();
        }

        private void ManageCustomersButton_Click(object sender, RoutedEventArgs e)
        {
            MainFrame.Navigate(new CustomerManagementPage());
        }

        private void ManageRoomsButton_Click(object sender, RoutedEventArgs e)
        {
            MainFrame.Navigate(new RoomManagementPage());
        }

        private void ManageBookingsButton_Click(object sender, RoutedEventArgs e)
        {
            MainFrame.Navigate(new BookingManagementPage());
        }
    }
}