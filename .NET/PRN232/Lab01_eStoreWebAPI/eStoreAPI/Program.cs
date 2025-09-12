using eStoreAPI.Data;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// --- T?T C? D?CH V? PH?I ???C ??NG K� ? ?�Y ---

// Add services to the container.
var connectionString = builder.Configuration.GetConnectionString("eStoreDb");

builder.Services.AddDbContext<eStoreDbContext>(options =>
    options.UseSqlServer(connectionString)
);

builder.Services.AddControllersWithViews();

// --- K?T TH�C PH?N ??NG K� D?CH V? ---


// D�ng n�y "x�y d?ng" ?ng d?ng, ph?i n?m sau khi ?� ??ng k� h?t d?ch v?
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

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();