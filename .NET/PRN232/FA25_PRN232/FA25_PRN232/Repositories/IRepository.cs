using System.Linq.Expressions;

namespace FA25_PRN232.Repositories
{
    // Interface chung (generic) cho mọi Entity
    public interface IRepository<T> where T : class
    {
        // QUAN TRỌNG: Phải trả về IQueryable để OData hoạt động
        IQueryable<T> GetAll();

        Task<T?> GetByIdAsync(int id);
        Task AddAsync(T entity);
        void Update(T entity); // Update thường là đồng bộ
        void Delete(T entity); // Delete thường là đồng bộ
        Task SaveChangesAsync(); // Hàm lưu thay đổi
    }
}