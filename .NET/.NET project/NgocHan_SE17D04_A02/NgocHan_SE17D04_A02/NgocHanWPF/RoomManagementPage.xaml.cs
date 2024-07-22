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

namespace NgocHanWPF
{
    /// <summary>
    /// Interaction logic for RoomManagementPage.xaml
    /// </summary>
    public partial class RoomManagementPage : Page
    {
        private readonly IRoomRepository roomRepository;
        public RoomManagementPage()
        {
            InitializeComponent();
            roomRepository = new RoomRepository();
            LoadRooms();
            
        }

        private void LoadRooms()
        {
            var listRoom = roomRepository.GetAllRooms();
            RoomDataGrid.ItemsSource = null;
            RoomDataGrid.ItemsSource = listRoom;
         }

        
        private void SearchButton_Click(object sender, RoutedEventArgs e)
        {
            string roomIdStr = SearchTextBox.Text;
            if (int.TryParse(roomIdStr, out int roomId))
            {
                var room = RoomDAO.GetRoomById(roomId);
                if (room != null)
                {
                    RoomDataGrid.ItemsSource = new List<RoomInfomation> { room };
                    
                }
                else
                {
                    MessageBox.Show("Room not found!");
                }
            }
            else
            {
                MessageBox.Show("Please enter a valid room ID!");
            }
        }

        private void AddRoomButton_Click(object sender, RoutedEventArgs e)
        {
            if (int.TryParse(txtRoomType.Text, out int roomTypeId))
            {
                var newRoom = new RoomInfomation
                {
                    RoomNumber = Int32.Parse(txtRoomNumber.Text),
                    RoomDetailDescription = txtDescription.Text,
                    RoomMaxCapacity = txtMaxCapacity.Text,
                    RoomTypeId = Int32.Parse(txtRoomType.Text), // Assign parsed roomTypeId directly
                    RoomStatus = Boolean.Parse(txtStatus.Text),
                    RoomPricePerDay = Decimal.Parse(txtPrice.Text),
                };
                roomRepository.AddRoom(newRoom);
                LoadRooms();
            }
            else
            {
                MessageBox.Show("Please enter a valid RoomTypeId (must be an integer).");
            }
        }

        private void UpdateRoomButton_Click(object sender, RoutedEventArgs e)
        {
            if (int.TryParse(txtRoomType.Text, out int roomTypeId))
            {
                var newRoom = new RoomInfomation
                {
                    RoomNumber = Int32.Parse(txtRoomNumber.Text),
                    RoomDetailDescription = txtDescription.Text,
                    RoomMaxCapacity = txtMaxCapacity.Text,
                    RoomTypeId = Int32.Parse(txtRoomType.Text), 
                    RoomStatus = Boolean.Parse(txtStatus.Text),
                    RoomPricePerDay = Decimal.Parse(txtPrice.Text),
                };
                roomRepository.UpdateRoom(newRoom);
                LoadRooms();
            }
            else
            {
                MessageBox.Show("Please enter a valid RoomTypeId (must be an integer).");
            }
        }

        private void DeleteRoomButton_Click(object sender, RoutedEventArgs e)
        {
            if (RoomDataGrid.SelectedItem is RoomInfomation selectedRoom)
            {
                RoomDAO.DeleteRoom(selectedRoom.RoomId);
                LoadRooms();
            }
        }

        
    }
}
