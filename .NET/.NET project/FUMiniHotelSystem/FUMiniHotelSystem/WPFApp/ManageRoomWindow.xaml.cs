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
    /// Interaction logic for ManageRoomWindow.xaml
    /// </summary>
    public partial class ManageRoomWindow : Window
    {
        private RoomRepository _roomRepository;
        public ManageRoomWindow()
        {
            InitializeComponent();
            _roomRepository = new RoomRepository();
            LoadRoomList();
        }
        public void LoadRoomList()
        {
            try
            {
                var roomList = _roomRepository.GetRooms();
                dgData.ItemsSource = roomList;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error loading room list");
            }
        }
        private void btnCreate_Click(object sender, RoutedEventArgs e)
        {

            try
            {
                RoomInformation newRoom = new RoomInformation
                {
                    RoomNumber = txtRoomNumber.Text,
                    RoomDescription = txtDescription.Text,
                    RoomMaxCapacity = Int32.Parse(txtMaxCapacity.Text),
                    RoomStatus = Int32.Parse(cmbStatus.Text),
                    RoomPricePerDate = Decimal.Parse(txtPrice.Text),
                    RoomTypeID = Int32.Parse(txtRoomTypeID.Text)
                };

                //create new customer
                _roomRepository.AddRoom(newRoom);
                MessageBox.Show("Room created successfully!");
                LoadRoomList();
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
                if (dgData.SelectedItem is RoomInformation selectedRoom)
                {
                    selectedRoom.RoomNumber = txtRoomNumber.Text;
                    selectedRoom.RoomDescription = txtDescription.Text;
                    selectedRoom.RoomMaxCapacity = Int32.Parse(txtMaxCapacity.Text);
                    selectedRoom.RoomStatus = Int32.Parse(cmbStatus.Text);
                    selectedRoom.RoomPricePerDate = Decimal.Parse(txtPrice.Text);
                    selectedRoom.RoomTypeID = Int32.Parse(txtRoomTypeID.Text);

                    //update customer
                    _roomRepository.UpdateRoom(selectedRoom);
                    MessageBox.Show("Room updated successfully!");
                    LoadRoomList();
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
                if (dgData.SelectedItem is RoomInformation selectedRoom)
                {
                    //show confirmation
                    MessageBoxResult re = MessageBox.Show("Are you sure you want to delete this item?", "Delete Confirmation", 
                        MessageBoxButton.YesNo, MessageBoxImage.Warning);
                    if (re == MessageBoxResult.Yes)
                    {
                        _roomRepository.DeleteRoom(selectedRoom);
                        MessageBox.Show("Room deleted successfully!");
                        LoadRoomList();
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
                if (dgData.SelectedItem is RoomInformation selectedRoom)
                {
                    txtRoomID.Text = selectedRoom.RoomID.ToString();
                    txtRoomNumber.Text = selectedRoom.RoomNumber;
                    txtDescription.Text = selectedRoom.RoomDescription;
                    txtMaxCapacity.Text = selectedRoom.RoomMaxCapacity.ToString();
                    cmbStatus.Text = selectedRoom.RoomStatus.ToString();
                    txtPrice.Text = selectedRoom.RoomPricePerDate.ToString();
                    txtRoomTypeID.Text = selectedRoom.RoomTypeID.ToString();
                }
            }
        }
        private void ClearFields()
        {
            txtRoomID.Clear();
            txtRoomNumber.Clear();
            txtDescription.Clear();
            txtMaxCapacity.Clear();
            cmbStatus.SelectedIndex = -1;
            txtPrice.Clear();
            txtRoomTypeID.Clear();
        }

        private void btnBack_Click(object sender, RoutedEventArgs e)
        {
            AdminWindow adminWindow = new AdminWindow();
            adminWindow.Show();
            this.Close();
        }
    }
}
