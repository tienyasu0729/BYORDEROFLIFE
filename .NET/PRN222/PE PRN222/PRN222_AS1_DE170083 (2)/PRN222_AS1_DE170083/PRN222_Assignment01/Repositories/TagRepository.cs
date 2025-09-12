﻿using BusinessObjects;
using DataAccessLayer;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class TagRepository : ITagRepository
    {
        private readonly TagDAO _tagDAO = new TagDAO();

        public List<Tag> GetAllTags()
        {
            return _tagDAO.GetAllTags();
        }



        public Tag? GetTagById(int id)
        {
            return _tagDAO.GetTagById(id);
        }
    }
}
