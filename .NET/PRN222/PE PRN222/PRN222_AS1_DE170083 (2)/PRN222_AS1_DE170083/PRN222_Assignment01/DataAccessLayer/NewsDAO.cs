using BusinessObjects;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccessLayer
{
    public class NewsDAO
    {
        public List<NewsArticle> GetAllNews()
        {
            using (var context = new FunewsManagementContext())
            {
                return context.NewsArticles
                    .Include(n => n.Category)
                    .Where(n => n.NewsStatus.HasValue && n.NewsStatus.Value)
                    .Include(n => n.CreatedBy)
                    .ToList();
            }
        }

        public List<NewsArticle> GetAllNewsApprove()
        {
            using (var context = new FunewsManagementContext())
            {
                return context.NewsArticles
                    .Include(n => n.Category)
                    .Include(n => n.CreatedBy)
                    .ToList();
            }
        }

        public NewsArticle GetNewsById(string id)
        {
            using (var context = new FunewsManagementContext())
            {
                return context.NewsArticles
                    .Include(n => n.Category)
                    .FirstOrDefault(n => n.NewsArticleId == Guid.Parse(id));

            }
        }

        public void AddNews(NewsArticle news)
        {
            using (var context = new FunewsManagementContext())
            {
                news.NewsArticleId = Guid.NewGuid();

                context.NewsArticles.Add(news);
                context.SaveChanges();
            }
        }

        public void UpdateNews(NewsArticle news)
        {
            using (var context = new FunewsManagementContext())
            {
                var existingNews = context.NewsArticles.Find(news.NewsArticleId);
                if (existingNews != null)
                {
                    existingNews.NewsTitle = news.NewsTitle;
                    existingNews.Headline = news.Headline;
                    existingNews.Category = news.Category;
                    existingNews.NewsContent = news.NewsContent;
                    existingNews.ModifiedDate = DateTime.Now;
                    context.SaveChanges();
                }
            }
        }

        public void DeleteNews(string id)
        {
            using (var context = new FunewsManagementContext())
            {
                //var news = context.NewsArticles.Find(id);
                var news = context.NewsArticles.Find(Guid.Parse(id));

                if (news != null)
                {
                    context.NewsArticles.Remove(news);
                    context.SaveChanges();
                }
            }
        }
        public List<NewsArticle> GetNewsByDateRange(DateTime startDate, DateTime endDate)
        {
            using (var context = new FunewsManagementContext())
            {
                return context.NewsArticles
                                .Include(n => n.Category)
                                .Where(n => n.CreatedDate >= startDate && n.CreatedDate < endDate.Date.AddDays(1))
                                .OrderByDescending(n => n.CreatedDate)
                                .ToList();
            }

        }
        public List<NewsArticle> GetNewsByCategory(short categoryId)
        {
            using (var context = new FunewsManagementContext())
            {
                return context.NewsArticles
                                .Include(n => n.Category)
                                .Where(n => n.Category.CategoryId == categoryId)
                                .ToList();
            }
        }

        public List<NewsArticle> GetNewsByCreator(short userId)
        {
            using var context = new FunewsManagementContext();
            return context.NewsArticles
                        .Include(n => n.Category)
                          .Where(n => n.CreatedById == userId)
                          .OrderByDescending(n => n.CreatedDate)
                          .ToList();
        }

        public void ApproveNews(string id)
        {
            using (var context = new FunewsManagementContext())
            {
                if (!Guid.TryParse(id, out Guid newsId))
                {
                    Console.WriteLine("ID không hợp lệ!");
                    return;
                }

                var news = context.NewsArticles.FirstOrDefault(n => n.NewsArticleId == newsId);
                if (news != null)
                {
                    news.NewsStatus = true;
                    news.ModifiedDate = DateTime.Now;
                    context.SaveChanges();
                }
                else
                {
                    Console.WriteLine("Không tìm thấy bài viết có ID: " + id);
                }
            }
        }

    }
}
