using FA25_PRN232.DTOs; // Thêm namespace DTOs
using FA25_PRN232.Models; // Namespace Models (DbContext)
using FA25_PRN232.Repositories; // Thêm namespace Repositories
using FA25_PRN232.Services; // Thêm namespace Services
using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using Microsoft.OData.Edm;
using Microsoft.OData.ModelBuilder;

// Hàm GetEdmModel() để định nghĩa OData EDM
// QUAN TRỌNG: Nó phải làm việc với DTO, không phải Entity
static IEdmModel GetEdmModel()
{
    ODataConventionModelBuilder builder = new ODataConventionModelBuilder();
    // Đặt tên EntitySet là "Vehicles" nhưng nó trỏ đến VehicleDto
    builder.EntitySet<VehicleDto>("Vehicles");
    return builder.GetEdmModel();
}

var builder = WebApplication.CreateBuilder(args);

// 1. Đăng ký DbContext (như cũ)
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");
builder.Services.AddDbContext<SU25_PRN232_01Context>(options =>
    options.UseSqlServer(connectionString));

// === CẤU HÌNH ĐỂ LẤY ĐIỂM THƯỞNG ===
// 2. Đăng ký AutoMapper
// Nó sẽ tự động quét project để tìm các class kế thừa từ 'Profile' (như MappingProfile)
builder.Services.AddAutoMapper(typeof(Program));

// 3. Đăng ký Repository Pattern (dùng AddScoped)
// Khi ai đó yêu cầu IRepository<T>, hãy cung cấp một đối tượng Repository<T>
builder.Services.AddScoped(typeof(IRepository<>), typeof(Repository<>));

// 4. Đăng ký Service Layer (dùng AddScoped)
// Khi ai đó yêu cầu IVehicleService, hãy cung cấp một đối tượng VehicleService
builder.Services.AddScoped<IVehicleService, VehicleService>();
// === KẾT THÚC PHẦN ĐIỂM THƯỞNG ===

// 5. Thêm Controllers và Cấu hình OData
builder.Services.AddControllers().AddOData(opt =>
    opt.AddRouteComponents("odata", GetEdmModel()) // Đặt tiền tố route là "odata"
       .Select()  // Hỗ trợ $select
       .Filter()  // Hỗ trợ $filter
       .OrderBy() // Hỗ trợ $orderby
       .Expand()
       .Count()
       .SetMaxTop(null)
);

// Add services to the container.
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();