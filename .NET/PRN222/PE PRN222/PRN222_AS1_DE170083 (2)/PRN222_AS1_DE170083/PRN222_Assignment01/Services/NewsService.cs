using BusinessObjects;
using Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class NewsService : INewsService
    {
        private readonly INewsRepository newsRepository = new NewsRepository();

        public List<NewsArticle> GetAllNews() => newsRepository.GetAllNews();
        public List<NewsArticle> GetAllNewsApprove() => newsRepository.GetAllNewsApprove();
        public NewsArticle GetNewsById(string id) => newsRepository.GetNewsById(id);
        public void AddNews(NewsArticle news) => newsRepository.AddNews(news);
        public void UpdateNews(NewsArticle news) => newsRepository.UpdateNews(news);
        public void DeleteNews(string id) => newsRepository.DeleteNews(id);

        public List<NewsArticle> GetNewsByCategory(short categoryId)
        {
            return newsRepository.GetNewsByCategory(categoryId);
        }

        public List<NewsArticle> GetNewsByCreator(short userId)
        {
            return newsRepository.GetNewsByCreator(userId);
        }

        public void ApproveNews(string id) => newsRepository.ApproveNews(id);
    }
}
