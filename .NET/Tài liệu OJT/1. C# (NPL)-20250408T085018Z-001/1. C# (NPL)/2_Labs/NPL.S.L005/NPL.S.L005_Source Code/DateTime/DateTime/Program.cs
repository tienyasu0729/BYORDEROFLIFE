using System;

namespace DateTimes
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Get present from system
            System.DateTime now = System.DateTime.Now;

            Console.WriteLine("Today is {0}", now.ToLongDateString());
            Console.WriteLine("Year: {0}", now.Year);
            Console.WriteLine("Month: {0}", now.Month);
            Console.WriteLine("Day: {0}", now.Day);
            Console.WriteLine("Hour: {0}", now.Hour);
            Console.WriteLine("Minute: {0}", now.Minute);
            Console.WriteLine("Second: {0}", now.Second);

            //// To get month's name, use ToString method
            Console.WriteLine("This month is: {0}", now.ToString("MMMM"));

            //// To increment or decrement datetime value, use Add method
            System.DateTime nextMonth = new System.DateTime(now.Year, now.Month, 1).AddMonths(1);
            Console.WriteLine("Fisrt day of next month is {0}", nextMonth.ToLongDateString());

            //// Define an uninitialized date.  
            Console.WriteLine($"Min of date is: {DateTime.MinValue}");

            //// Determine a maximum date.
            Console.WriteLine($"Max of date is: {DateTime.MaxValue}");

            //// Enum {Monday, Tuesday,... Sunday}
            DayOfWeek dayOfWeek = now.DayOfWeek;

            //// Get day of week.
            Console.WriteLine("Day of Week: {0}", dayOfWeek);

            //// Get day off year.
            Console.WriteLine("Day of Year: {0}", now.DayOfYear);

            //// Get yesterday.
            Console.WriteLine("Yesterday is: {0}", GetYesterday(now));

            //// Get all datetime format.
            Console.WriteLine("All datetime formats!");
            GetAllDateTimeFormat(now);

            //// Keep the console window open in debug mode.
            Console.WriteLine("Press any key to exit.");
            Console.ReadKey();
        }
        /// <summary>
        /// Take yesterday of the date entered.
        /// </summary>
        /// <returns></returns>
        public static DateTime GetYesterday(DateTime dateTime)
        {
            //// Get yesterday.
            return dateTime.AddDays(-1);
        }

        /// <summary>
        /// Get all datetime formats.
        /// </summary>
        /// <param name="dateTime"></param>
        public static void GetAllDateTimeFormat(DateTime dateTime)
        {
            // Các định dạng date-time được hỗ trợ.
            string[] formattedStrings = dateTime.GetDateTimeFormats();

            foreach (string format in formattedStrings)
            {
                Console.WriteLine(format);
            }
        }
    }
}
