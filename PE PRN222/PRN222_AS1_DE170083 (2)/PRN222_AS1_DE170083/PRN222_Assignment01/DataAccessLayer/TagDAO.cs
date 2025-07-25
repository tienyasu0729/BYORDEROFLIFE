using BusinessObjects;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccessLayer
{
    public class TagDAO
    {
        public List<Tag> GetAllTags()
        {
            using (var context = new FunewsManagementContext())
            {
                return context.Tags.ToList();
            }
        }

        


        public Tag? GetTagById(int id)
        {
            using (var context = new FunewsManagementContext())
            {
                return context.Tags.FirstOrDefault(t => t.TagId == id);
            }
        }
    }
}
