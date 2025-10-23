using System.Text.Json;

var builder = WebApplication.CreateBuilder(args);

// === 1. Cấu hình HttpClient ===
builder.Services.AddHttpClient("ApiClient", client =>
{
    // QUAN TRỌNG: Thay đổi URL và cổng này
    // cho khớp với project API của bạn.
    client.BaseAddress = new Uri("https://localhost:7157/");
});

// === 2. Cấu hình Session ===
builder.Services.AddDistributedMemoryCache(); // Cần thiết để lưu session trong memory
builder.Services.AddSession(options =>
{
    options.IdleTimeout = TimeSpan.FromMinutes(30); // Thời gian hết hạn session
    options.Cookie.HttpOnly = true;
    options.Cookie.IsEssential = true;
});

// === 3. Thêm dịch vụ MVC ===
builder.Services.AddControllersWithViews()
    .AddJsonOptions(options =>
    {
        // Giúp đọc JSON trả về từ API (trường hợp tên property không khớp hoa/thường)
        options.JsonSerializerOptions.PropertyNameCaseInsensitive = true;
    });


var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

// === 4. Bật Session ===
// (Phải đặt trước app.MapControllerRoute)
app.UseSession();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();