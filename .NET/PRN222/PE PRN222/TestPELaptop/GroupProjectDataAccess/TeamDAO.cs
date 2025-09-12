using GroupProjectBusiness.Models;
using GroupProjectRepositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GroupProjectDataAccess
{
    public class TeamDAO
    {
        private static readonly TeamRepository repository = new TeamRepository(new InnoCodeDbContext());

        public static List<Team> GetAll()
        {
            return repository.GetAll();
        }

        public static Team? GetById(int id)
        {
            return repository.GetById(id);
        }

        public static void Add(Team team)
        {
            repository.Add(team);
            repository.Save();
        }

        public static void Update(Team team)
        {
            repository.Update(team);
            repository.Save();
        }

        public static void Delete(Team team)
        {
            repository.Delete(team);
            repository.Save();
        }
    }
}
