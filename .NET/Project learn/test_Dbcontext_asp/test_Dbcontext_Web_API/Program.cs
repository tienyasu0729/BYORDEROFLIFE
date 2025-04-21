using test_Dbcontext_Web_API.Service;

namespace test_Dbcontext_Web_API
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.

            builder.Services.AddControllers();

            // này là đoạn code để tiêm service vào trong api, được làm theo slide
            builder.Services.AddScoped<BookService>();

            var app = builder.Build();

            // Configure the HTTP request pipeline.

            app.UseHttpsRedirection();

            app.UseAuthorization();


            app.MapControllers();

            app.Run();
        }
    }
}
