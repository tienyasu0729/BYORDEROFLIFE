// File: Program.cs

var builder = WebApplication.CreateBuilder(args);

// Thêm dịch vụ HttpClientFactory để quản lý các instance HttpClient.
builder.Services.AddHttpClient("MyWebAPI", client =>
{
    // Đặt địa chỉ cơ sở của API.
    // !!! QUAN TRỌNG: Thay đổi port 7136 thành port của project API của bạn.
    client.BaseAddress = new Uri("https://localhost:7292/api/");
});

// Thêm các dịch vụ cho controllers và views.
builder.Services.AddControllersWithViews();

var app = builder.Build();

// Cấu hình HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

// Thiết lập route mặc định để khi chạy, ứng dụng sẽ vào trang Courses/Index.
app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Courses}/{action=Index}/{id?}");

app.Run();


