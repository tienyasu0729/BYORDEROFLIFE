using Microsoft.AspNetCore.Mvc;

namespace test_asp.net.Controllers
{
    public class Math : Controller
    {
        //public IActionResult sum(int x, int y)
        //{
        //    return Content((x + y).ToString());
        //}


        // thông thường không dùng kiểu trả về một kiểu dữ liệu trả về cụ thể như này
        public String sum(int x, int y)
        {
            return (x + y).ToString();
        }
    }
}
