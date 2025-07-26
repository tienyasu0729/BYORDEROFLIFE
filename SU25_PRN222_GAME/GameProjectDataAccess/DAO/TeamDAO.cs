using GameProjectBusiness.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameProjectDataAccess.DAO
{
    public class TeamDAO
    {
        private readonly Su25Prn222Context _context;

        public TeamDAO()
        {
            _context = new Su25Prn222Context();
        }

        public void CreateTeam(Team entity)
        {
            _context.Teams.Add(entity);
        }
    }
}
