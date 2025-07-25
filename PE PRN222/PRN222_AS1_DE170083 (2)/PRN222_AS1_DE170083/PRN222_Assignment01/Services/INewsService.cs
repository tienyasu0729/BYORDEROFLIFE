using BusinessObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public interface INewsService
    {
        public List<NewsArticle> GetAllNews();
        public List<NewsArticle> GetAllNewsApprove();
        public NewsArticle GetNewsById(string id);
        public void AddNews(NewsArticle news);
        public void UpdateNews(NewsArticle news);
        public void DeleteNews(string id);
        List<NewsArticle> GetNewsByCategory(short categoryId);
        List<NewsArticle> GetNewsByCreator(short userId);
        void ApproveNews(string id);

    }
}
