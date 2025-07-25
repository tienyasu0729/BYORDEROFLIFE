﻿using BusinessObjects;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccessLayer
{
    
        public class CategoryDAO
        {
        public List<Category> GetAllCategories()
        {
            using (var context = new FunewsManagementContext())
            {
                return context.Categories.ToList();
            }
        }

        public Category? GetCategoryById(short id)
        {
            using (var context = new FunewsManagementContext())
            {
                return context.Categories.FirstOrDefault(c => c.CategoryId == id);
            }
        }
        public void AddCategory(Category category)
        {
            using (var context = new FunewsManagementContext())
            {
                context.Categories.Add(category);
                context.SaveChanges();
            }
        }

        public void UpdateCategory(Category category)
        {
            using (var context = new FunewsManagementContext())
            {
                var existingCategory = context.Categories.Find(category.CategoryId);
                if (existingCategory != null)
                {
                    existingCategory.CategoryName = category.CategoryName;
                    context.SaveChanges();
                }
            }
        }

        public bool DeleteCategory(short id)
        {
            using (var context = new FunewsManagementContext())
            {
                var category = context.Categories.Find(id);
                var canDelete = context.NewsArticles.Include(n => n.Category).FirstOrDefault(n => n.Category.CategoryId == id) == null;
                if (!canDelete) return false;
                if (category != null && canDelete)
                {
                    context.Categories.Remove(category);
                    context.SaveChanges();
                    return true;
                }
            }
            return false;
        }
    }
    }

