using Model_Shopee_Project.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interface_Shopee_Project
{
    public interface ICRUD <T>
    {
        List<T> GetAll();
        T GetById(int id);
        T GetByName( String name );
        List<T> GetListByName( String name );
        void Add( T entity );
        void Update( T entity );
        void Delete( T entity );
        void DeleteByID( int id );
        void DeleteByName( String name );
        void DeleteAll();
        void DeleteOfChooseID(int[] ids);
        void DeleteOfChooseName(String[] names);
        void SaveChanges();
    }
}
