﻿using BusinessObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public interface IReportService
    {
        List<NewsArticle> GenerateReport(DateTime startDate, DateTime endDate);
    }
}
