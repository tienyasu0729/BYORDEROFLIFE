using FA25_PRN232.Models; // Namespace DbContext
using Microsoft.EntityFrameworkCore;
using System.Linq.Expressions;

namespace FA25_PRN232.Repositories
{
    public class Repository<T> : IRepository<T> where T : class
    {
        private readonly SU25_PRN232_01Context _context;
        private readonly DbSet<T> _dbSet;

        public Repository(SU25_PRN232_01Context context)
        {
            _context = context;
            _dbSet = _context.Set<T>();
        }

        public IQueryable<T> GetAll()
        {
            // Trả về IQueryable, OData sẽ xử lý filter/sort trên đây
            return _dbSet.AsQueryable();
        }

        public async Task<T?> GetByIdAsync(int id)
        {
            return await _dbSet.FindAsync(id);
        }

        public async Task AddAsync(T entity)
        {
            await _dbSet.AddAsync(entity);
        }

        public void Update(T entity)
        {
            _dbSet.Update(entity);
        }

        public void Delete(T entity)
        {
            _dbSet.Remove(entity);
        }

        public async Task SaveChangesAsync()
        {
            await _context.SaveChangesAsync();
        }
    }
}