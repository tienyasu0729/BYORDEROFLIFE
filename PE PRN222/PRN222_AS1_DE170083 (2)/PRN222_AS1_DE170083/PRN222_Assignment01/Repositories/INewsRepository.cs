using BusinessObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public interface INewsRepository
    {
        List<NewsArticle> GetAllNews();
        List<NewsArticle> GetAllNewsApprove();
        NewsArticle GetNewsById(string id);
        void AddNews(NewsArticle news);
        void UpdateNews(NewsArticle news);
        void DeleteNews(string id);
        List<NewsArticle> GetNewsByDateRange(DateTime startDate, DateTime endDate);
        List<NewsArticle> GetNewsByCategory(short categoryId);
        List<NewsArticle> GetNewsByCreator(short userId);
        void ApproveNews(string id);

    }
}
