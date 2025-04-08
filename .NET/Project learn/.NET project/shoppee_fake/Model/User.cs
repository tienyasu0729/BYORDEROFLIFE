using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class User
    {
        public int IdUser { get; set; }
        public string PhoneNumber { get; set; }
        public string Password { get; set; }
        public string AccountName { get; set; }
        public string RealName { get; set; }
        public string Email { get; set; }
        public string Sex { get; set; }
        public DateOnly DateOfBirth { get; set; }
        public string AvatarImage { get; set; }
        public DateTime JoiningDate { get; set; }
        public ICollection<address> AddressList { get; set; }
        public ICollection<Blocked_User> ListShopBlockTheUser { get; set; }
        public User_Wallet User_Wallet {  get; set; }
        public User_Identification_information User_Identification_information { get; set; }
        public User_Spending User_Spending { get; set; }
        public User_Notifications User_Notifications { get; set; }
        public ICollection<Coin_History> Coin_Historys { get; set; }



    }
}
