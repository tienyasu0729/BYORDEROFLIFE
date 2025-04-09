using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using test_asp.net.Data;

namespace test_asp.net
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddControllersWithViews();

            //builder.Services.AddTransient<IRepository>(services => new MyRepository());

            builder.Services.AddTransient<IRepository>(services => new MyRepository(services.GetRequiredService<ILogger<MyRepository>>()));

            //builder.Services.AddTransient<IRepository>(services => new test1Repository());

            builder.Services.AddDbContext<AppDbContext>(options =>
            options.UseMySql(builder.Configuration.GetConnectionString("MyDb"),
            new MySqlServerVersion(new Version(8, 0, 29)))); // Thay phiên bản theo bản MySQL bạn dùng


            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            // đây là đặt địa chỉ tắt cho product/details/123 thành p/123, có cách khác là dùng route để đặt địa chỉ khác cho action method đó
            app.MapControllerRoute(
                name: "product-details",
                pattern: "p/{id}",
                defaults: new { Controller = "product", action = "details" });
            
            // đây là cài đặt địa chỉ mặt định nếu không nhập địa chỉ url
            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Home}/{action=index}/{id?}");

            app.Run();
        }
    }
}
