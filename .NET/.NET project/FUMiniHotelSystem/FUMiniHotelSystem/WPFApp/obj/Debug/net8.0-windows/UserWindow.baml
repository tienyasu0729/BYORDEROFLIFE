   M S B A M L   `   `   `  ����A  =WPFApp, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullclr-namespace:WPFAppWPFApp  5   	       WPFApp.UserWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   &localclr-namespace:WPFApp     5   	     � Title$  
UserWindow��5   	   $	��450��6   $	��800��6)   .��5	      � .+�5
   
   �� -   5        $��Manage Profile��5
      $
��Left=�6*   $��50,100,300,0q�6E   $	��Top=�6[   $��51��6s   $	��140��6   6�   �� 5   
   -   5        $��View Booking History��5      $
��Left=�60   $��
50,200,0,0q�6K   $	��Top=�6_   $��51��6w   $	��140��6�   6�   &   System.Windows.Controls.DataGrid  5   
   -   5        $��dgData��5      $��229,36,50,84q�6!   � 5   
   -   5         �Name$ ProfileGrid��5      $y�	Collapsed=�6$   $��229,36,50,84q�6;   ���#F2F2F2.+�5      ��  �� Orientation$ Vertical=�6   $��30,30,30,37q�60   .+�5      �� $��ID��6   $
��Bold"�6%   $��0,10,0,0q�67   �� 5      -   5        $��txtId��5      $��70,-21,10,10q�6'   ${�False��6=   �� 5      $
��Name��6   $
��Bold"�6'   $��0,10,0,0q�69   �� 5      -   5        $��txtName��5      $��70,-21,10,10q�6)   ${�False��6?   �� 5      $��Phone��6   $
��Bold"�6(   $��0,10,0,0q�6:   �� 5      -   5        $��txtPhone��5      $��70,-21,10,10q�6*   ${�False��6@   �� 5      $��Email��6   $
��Bold"�6(   $��0,10,0,0q�6:   �� 5      -   5        $��txtEmail��5      $��70,-21,10,10q�6*   ${�False��6@   �� 5      $��Birthday��6   $
��Bold"�6+   $��0,10,0,0q�6=   (  "System.Windows.Controls.DatePicker  5      -	   5        $��
dpBirthday��5      $��70,-21,10,10q�6/   ${�False��6E   5      �� 5      -
   5        $
��Edit��5      $��
40,240,0,0q�6$   $��30��68   $	��100��6D   6P   �� 5      -   5        $
��Save��5      $��340,240,0,0q�6$   $��30��69   $	��100��6E   6Q   5      �� 5   
   -   5        $��Close��5      $
��Left=�6!   $��230,340,0,0q�6<   $��30��6Q   $	��100��6]   6i   5      5      