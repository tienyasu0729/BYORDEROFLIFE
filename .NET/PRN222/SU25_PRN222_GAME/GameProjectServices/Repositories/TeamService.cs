using GameProjectBusiness.Models;
using GameProjectRepositories.Repositories;
using GameProjectServices.Interfaces;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameProjectServices.Repositories
{
    public class TeamService : ITeamService
    {

        private readonly TeamRepository _context = new TeamRepository();
 
        public void CreateTeam(Team entity)
        {
            _context.CreateTeam(entity);
        }
    }
}
