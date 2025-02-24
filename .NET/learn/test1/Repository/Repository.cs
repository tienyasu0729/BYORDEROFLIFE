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
                    using (MySqlCommand cammand = new MySqlCommand())
                    {

                    }
                }
            }
        }
    }
}
