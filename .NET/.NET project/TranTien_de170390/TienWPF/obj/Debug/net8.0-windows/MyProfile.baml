   M S B A M L   `   `   `  ����B  >TienWPF, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null!clr-namespace:TienWPFTienWPF  5   	       TienWPF.MyProfile   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   'localclr-namespace:TienWPF     5   	   -   5          � Title$  	MyProfile��5	      $	��450��6   $	��800��6$   .��5
      �  � RowDefinitions 5   
   �� 5      $
��Auto �6   �� 5      $��* �6   .+�5   
   �� $��0��6   $��0,0,0,10q�6"   .+�5      �� $��Customer Profile��6   $��20(�60   $
��Bold"�6>   $��0,0,0,10q�6P   � 5       � ColumnDefinitions 5      �� 5      $
��Auto �6'   �� 5      $��* �6'    5      �� 5      $
��Auto �6$   �� 5      $
��Auto �6$   �� 5      $
��Auto �6$   �� 5      $
��Auto �6$   �� 5      $
��Auto �6$   .+�5       �� $��Name:��6   $��Center=�6)   $��0,0,5,0q�6D   $��0��6U   �� 5!      -   5         ��Name$ txtName��5!      $��1��6+   $��0,0,0,5q�6;   $��0��6L   �� 5#      $��Email:��6   $��Center=�6*   $��0,0,5,0q�6E   $��1��6V   �� 5$      -   5        $ txtEmail��5$      $��1��6,   $��0,0,0,5q�6<   $��1��6M   ${�False��6Z   �� 5&      $��Phone:��6   $��Center=�6*   $��0,0,5,0q�6E   $��2��6V   �� 5'      -   5        $ txtPhone��5'      $��1��6,   $��0,0,0,5q�6<   $��2��6M   �� 5)      -   5        $
��Save��5)      $��2��6(   $��Right=�6<   $��0,5,0,0q�6X   $��4��6i   6v   5*      5+      �� 5.   
   $��1��6   .+�5/      �� $��Booking History��6   $��20(�6/   $
��Bold"�6=   $��0,0,0,10q�6O   &   System.Windows.Controls.DataGrid  50      -   5          Name$ BookingHistoryDataGrid��50         AutoGenerateColumns$ False��67   $	��300��6S      Columns 51      0  *System.Windows.Controls.DataGridTextColumn  52      ,  &System.Windows.Controls.DataGridColumn   Header$ 
Booking ID��6)      
IsReadOnly$
 True��6f   1  +System.Windows.Controls.DataGridBoundColumn	   Binding	 6=   �� *BookingReservationId+6f     53      $ Booking date��6)   $
 True��6_   	 6?   �� *BookingDate+6_     54      $ Total Price��6)   $
 True��6]   	 6>   �� *
TotalPrice+6]     55      $ Status��6)   $
 True��6Z   	 69   �� *BooingStatus+6Z   57      58      59      5:      