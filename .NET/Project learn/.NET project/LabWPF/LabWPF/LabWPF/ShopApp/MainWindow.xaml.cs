using BusinessObject;
using Repository;
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

namespace ShopApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private readonly IProductRepository productRepository;
        private readonly IOrderRepository orderRepository;
        private readonly IOrderDetailRepository orderDetailRepository;

        public MainWindow()
        {
            InitializeComponent();
            productRepository = new ProductRepository();
            orderRepository = new OrderRepository();
            orderDetailRepository = new OrderDetailRepository();
        }

        private async void Window_Loaded(object sender, RoutedEventArgs e)
        {
            await LoadProductList();
            await LoadOrderList();
            await LoadOrderDetailList();
        }

        private async Task LoadProductList()
        {
            try
            {
                var prdList = await productRepository.GetAllProduct();
                cboProduct.ItemsSource = prdList;
                cboProduct.DisplayMemberPath = "ProductName";
                cboProduct.SelectedValuePath = "ProductId";
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error on load list of products");
            }
        }

        private async Task LoadOrderList()
        {
            try
            {
                var orderList = await orderRepository.GetAllOrder();
                cboOrder.ItemsSource = orderList;
                cboOrder.DisplayMemberPath = "OrderId";
                cboOrder.SelectedValuePath = "OrderId";
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error on load list of orders");
            }
            finally
            {
                ResetInput();
            }
        }

        private async Task LoadOrderDetailList()
        {
            try
            {
                var orderDetailList = await orderDetailRepository.GetAllOrderDetail();
                dgData.ItemsSource = orderDetailList;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error on load list of order details");
            }
            finally
            {
                ResetInput();
            }
        }

        private async void btnCreate_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                OrderDetail orderDetail = new OrderDetail
                {
                    ProductId = Convert.ToInt32(cboProduct.SelectedValue),
                    UnitsInStock = Convert.ToInt32(txtStock.Text),
                    UnitPrice = Convert.ToInt32(txtPrice.Text),
                    OrderId = Convert.ToInt32(cboOrder.SelectedValue)
                };

                await orderDetailRepository.AddOrderDetail(orderDetail);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                await LoadOrderDetailList();
            }
        }

        private async void btnUpdate_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (cboOrder.SelectedValue != null && cboProduct.SelectedValue != null)
                {
                    OrderDetail orderDetail = await orderDetailRepository.GetOrderDetailByOrderIdProductId(
                        Convert.ToInt32(cboOrder.SelectedValue), Convert.ToInt32(cboProduct.SelectedValue));

                    if (orderDetail != null)
                    {
                        orderDetail.ProductId = Convert.ToInt32(cboProduct.SelectedValue);
                        orderDetail.UnitsInStock = Convert.ToInt32(txtStock.Text);
                        orderDetail.UnitPrice = Convert.ToInt32(txtPrice.Text);
                        orderDetail.OrderId = Convert.ToInt32(cboOrder.SelectedValue);

                        await orderDetailRepository.UpdateOrderDetail(orderDetail);
                    }
                    else
                    {
                        MessageBox.Show("Order detail not found.");
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                await LoadOrderDetailList();
            }
        }

        private async void btnDelete_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (cboOrder.SelectedValue != null && cboProduct.SelectedValue != null)
                {
                    await orderDetailRepository.DeleteOrderDetail(
                        Convert.ToInt32(cboOrder.SelectedValue), Convert.ToInt32(cboProduct.SelectedValue));
                }
                else
                {
                    MessageBox.Show("You must select an order and product.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                await LoadOrderDetailList();
            }
        }

        private void ResetInput()
        {
            txtStock.Text = "";
            txtPrice.Text = "";
            cboProduct.SelectedValue = 0;
            cboOrder.SelectedValue = 0;
        }

        private void btnClose_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.Shutdown();
        }

        private void dgData_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (dgData.SelectedItem is OrderDetail selectedOrderDetail)
            {
                txtStock.Text = selectedOrderDetail.UnitsInStock.ToString();
                txtPrice.Text = selectedOrderDetail.UnitPrice.ToString();
                cboProduct.SelectedValue = selectedOrderDetail.ProductId;
                cboOrder.SelectedValue = selectedOrderDetail.OrderId;
            }
        }
    }
}