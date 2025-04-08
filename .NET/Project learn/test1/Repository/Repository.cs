using Model;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Intrinsics.X86;
using System.Text;
using System.Threading.Tasks;

namespace RepositoryE
{
    public class Repository
    {
        private readonly BaseRepository baseRepository = new BaseRepository();
        private readonly SqlStatement sqlStatement = new SqlStatement();

        public void addNewSalariedEmployee()
        {
            using (MySqlConnection connection = baseRepository.GetConnection())
            {
                if(connection != null)
                {
                    using (MySqlCommand cammand = new MySqlCommand(SqlStatement.addNewSalariedEmployee, connection))
                    {
                    }

                }
            }
        }

        public List<SalariedEmployee> selectAllSalariedEmployee()
        {
            List<SalariedEmployee> employees = new List<SalariedEmployee>();
            using (MySqlConnection connection = baseRepository.GetConnection())
            {
                if (connection != null)
                {
                    using (MySqlCommand cammand = new MySqlCommand(SqlStatement.selectAllSalariedEmployee, connection))
                    using (MySqlDataReader reader = cammand.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            employees.Add(new SalariedEmployee(
                             reader.GetString("SSN"),
                             reader.GetString("FirstName"),
                             reader.GetString("LastName"),
                             reader.GetDateTime("BirthDate").ToString("dd/MM/yyyy"),
                             reader.GetString("Phone"),
                             reader.GetString("Email"),
                             reader.GetDouble("CommissionRate"),
                             reader.GetDouble("GrossSales"),
                             reader.GetDouble("BasicSalary")
                         ));
                        }
                    }

                }
                connection.Close();
            }
            return employees;
        }
    }
}
