using GameProjectBusiness.Models;
using GameProjectDataAccess.DAO;
using GameProjectRepositories.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameProjectRepositories.Repositories
{
    public class TeamRepository : ITeamRepository
    {

        private readonly TeamDAO _context = new TeamDAO();


        public void CreateTeam(Team entity)
        {
            _context.CreateTeam(entity);

        }

    }
}
