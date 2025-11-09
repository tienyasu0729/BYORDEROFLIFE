using FPTShopLaptopMVC.ViewModels;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace FPTShopLaptopMVC.Controllers
{
    public class LaptopsController : Controller
    {
        private readonly HttpClient _httpClient;
        private readonly string _apiBaseUrl = "https://localhost:7046/api"; // Adjust port as needed

        public LaptopsController()
        {
            _httpClient = new HttpClient();
        }

        public async Task<IActionResult> Index()
        {
            var response = await _httpClient.GetStringAsync($"{_apiBaseUrl}/laptops");
            var laptops = JsonConvert.DeserializeObject<List<LaptopViewModel>>(response);
            return View(laptops);
        }

        public async Task<IActionResult> Details(int id)
        {
            var response = await _httpClient.GetStringAsync($"{_apiBaseUrl}/laptops/{id}");
            var laptop = JsonConvert.DeserializeObject<LaptopViewModel>(response);
            return View(laptop);
        }

        [HttpPost]
        public async Task<IActionResult> Order(OrderViewModel model)
        {
            var response = await _httpClient.PostAsJsonAsync($"{_apiBaseUrl}/orders", model);
            if (response.IsSuccessStatusCode)
            {
                TempData["Success"] = "Order placed successfully!";
                return RedirectToAction("Index");
            }
            var error = await response.Content.ReadAsStringAsync();

            TempData["Error"] = "Failed to place order.";
            return RedirectToAction("Details", new { id = model.LaptopId });
        }
    }
}
