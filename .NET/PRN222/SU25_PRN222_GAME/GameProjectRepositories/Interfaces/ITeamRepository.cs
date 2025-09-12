using GameProjectBusiness.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameProjectRepositories.Interfaces
{
    public interface ITeamRepository
    {
        void CreateTeam(Team entity);
    }
}
