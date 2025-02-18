using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace test1
{
    class BaseRepository
    {
        private readonly string connectionString = "Server=localhost;Database=shipping_project;User ID=root;Password=12345;";
        private MySqlConnection connection;

        public BaseRepository() { }

        public MySqlConnection GetConnection()
        {
            try
            {
                connection = new MySqlConnection(connectionString);
                connection.Open();
                return connection;
            }
            catch (MySqlException ex)
            {
                Console.WriteLine("Lỗi kết nối MySQL: " + ex.Message);
                return null;
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
