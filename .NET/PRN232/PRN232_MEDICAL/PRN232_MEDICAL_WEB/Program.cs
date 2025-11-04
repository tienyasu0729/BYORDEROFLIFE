using Microsoft.AspNetCore.Authentication.Cookies; //
using System.Net.Http.Headers;

var builder = WebApplication.CreateBuilder(args);

// 1. Cấu hình Cookie Authentication (cho MVC)
// Client (MVC) sẽ lưu thông tin đăng nhập bằng Cookie
builder.Services.AddAuthentication(CookieAuthenticationDefaults.AuthenticationScheme)
    .AddCookie(options =>
    {
        options.LoginPath = "/Account/Login"; //
        options.AccessDeniedPath = "/Account/AccessDenied";
        options.ExpireTimeSpan = TimeSpan.FromDays(1);
    });

// 2. Cấu hình Session (Theo yêu cầu Câu 2.1)
builder.Services.AddSession(options =>
{
    options.IdleTimeout = TimeSpan.FromMinutes(30); //
    options.Cookie.HttpOnly = true;
    options.Cookie.IsEssential = true;
});

// 3. Cấu hình HttpClient (để gọi API)
builder.Services.AddHttpContextAccessor(); //
builder.Services.AddHttpClient("ApiClient", (serviceProvider, client) =>
{
    // Lấy địa chỉ API từ appsettings.json
    client.BaseAddress = new Uri(builder.Configuration["ApiSettings:BaseUrl"]);

    var contextAccessor = serviceProvider.GetRequiredService<IHttpContextAccessor>();

    // Lấy token từ Session (Câu 2.1)
    var token = contextAccessor.HttpContext?.Session.GetString("JWToken");

    if (!string.IsNullOrEmpty(token))
    {
        // Gắn token vào header Authorization cho mọi request (Câu 2.1)
        client.DefaultRequestHeaders.Authorization =
            new AuthenticationHeaderValue("Bearer", token);
    }
});


builder.Services.AddControllersWithViews();

var app = builder.Build();

if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseSession(); // Bật Session

app.UseAuthentication(); // Bật xác thực (Cookie)
app.UseAuthorization(); // Bật cấp quyền

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();