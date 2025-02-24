using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
    class Repository
    {
        private readonly BaseRepository baseRepository = new BaseRepository();
        private readonly SqlStatement sqlStatement = new SqlStatement();

        public void addNewSalariedEmployee()
        {
            using (MySqlConnection connection = baseRepository.GetConnection())
            {
                if(connection != null)
                {
<<<<<<< HEAD
                    using (MySqlCommand cammand = new MySqlCommand())
                    {

                    }
=======

>>>>>>> e4b3b2bf49ad98f4b7f5373fa2b4bd40820d2d74
                }
            }
        }
    }
}
