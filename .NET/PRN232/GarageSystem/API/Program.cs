using Data.Models;
using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using Microsoft.OData.ModelBuilder;
using Repositories;
using Repositories.IRepository;
using Services;
using Services.IService;

var builder = WebApplication.CreateBuilder(args);

// --- BẮT ĐẦU CẤU HÌNH DỊCH VỤ ---

// 1. Đăng ký DbContext (kết nối database)
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");
builder.Services.AddDbContext<SU25_PRN232_01Context>(options =>
    options.UseSqlServer(connectionString));

// 2. Đăng ký Repositories và Services (cho Dependency Injection - Bonus)
builder.Services.AddScoped<IUserRepository, UserRepository>();
builder.Services.AddScoped<IAuthService, AuthService>();

// 3. Đăng ký AutoMapper (Bonus)
// builder.Services.AddAutoMapper(AppDomain.CurrentDomain.GetAssemblies());

// 4. Cấu hình OData (MỚI)
var edmBuilder = new ODataConventionModelBuilder();
edmBuilder.EntitySet<Vehicle>("Vehicles"); // Tên endpoint là "Vehicles"

builder.Services.AddControllers().AddOData(options =>
    options.Select().Filter().OrderBy().Expand().Count().SetMaxTop(100)
           .AddRouteComponents("odata", edmBuilder.GetEdmModel()) // Tiền tố /odata
);

// 5. Thêm CORS (Đã có từ bước trước)
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAll",
        policy => policy.AllowAnyOrigin()
                        .AllowAnyMethod()
                        .AllowAnyHeader());
});


builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

// --- KẾT THÚC CẤU HÌNH DỊCH VỤ ---

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

// 6. Sử dụng CORS
app.UseCors("AllowAll");

app.UseAuthorization();

app.MapControllers();

app.Run();