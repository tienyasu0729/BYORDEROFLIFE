using BusinessObjects;
using Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class ReportService : IReportService
    {
        private readonly INewsRepository _newsRepository = new NewsRepository();
        public List<NewsArticle> GenerateReport(DateTime startDate, DateTime endDate)
        {
            return _newsRepository.GetNewsByDateRange(startDate, endDate);
        }
    }
}
