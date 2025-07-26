using GroupProjectBusiness.Models;
using GroupProjectRepositories.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GroupProjectRepositories
{
    public class TeamRepository : IRepository<Team>
    {
        private readonly InnoCodeDbContext _context;

        public TeamRepository(InnoCodeDbContext context)
        {
            _context = context;
        }

        public void Add(Team entity)
        {
            _context.Teams.Add(entity);
        }

        public void Delete(Team entity)
        {
            _context.Teams.Remove(entity);
        }

        public List<Team> GetAll()
        {
            return _context.Teams.ToList();
        }

        public Team? GetById(int id)
        {
            return _context.Teams.FirstOrDefault(u => u.Id == id);
        }

        public void Save()
        {
            _context.SaveChanges();
        }

        public void Update(Team entity)
        {
            _context.Teams.Update(entity);
        }
    }
}
