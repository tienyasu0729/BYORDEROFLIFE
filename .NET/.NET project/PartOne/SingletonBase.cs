﻿using CodeFirstTest;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PartOne
{
    public class SingletonBase<T> where T : class, new()
    {
        private static T _instance;
        private static readonly object _lock = new object();
        public static UniversityContext _context = new UniversityContext();
        public static T instance
        {
            get
            {
                lock (_lock)
                {
                    if (_instance == null)
                    {
                        _instance = new T();

                    }
                    return _instance;
                }
            }
        }
    }
}