using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
    class BaseRepository
    {
        private readonly string connectionString = "Server=localhost;Database=Employee;User ID=root;Password=12345;";
        private MySqlConnection connection;

        public BaseRepository() { }

        public String GetConnection()
        {
            try
            {
                connection = new MySqlConnection(connectionString);
                connection.Open();
                return "ok";
            }
            catch (MySqlException ex)
            {
                Console.WriteLine("Lỗi kết nối MySQL: " + ex.Message);
                return "no";
            }
        }

        public void CloseConnection()
        {
            if (connection != null && connection.State == ConnectionState.Open)
            {
                connection.Close();
                Console.WriteLine("Đã đóng kết nối.");
            }
        }
    }
}
