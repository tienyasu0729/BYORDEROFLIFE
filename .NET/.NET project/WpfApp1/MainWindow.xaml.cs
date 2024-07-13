﻿using System.DirectoryServices.ActiveDirectory;
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

namespace WpfApp1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow() { }
//Show Page_01
        private void btnToPage01_Click(object sender, RoutedEventArgs e){
            frMain.Content = new Page1();
        }
        
        //Show Page_02
        private void btnToPage02_Click(object sender, RoutedEventArgs e)
        {
            frMain.Content = new Page2();
        }
    }
}