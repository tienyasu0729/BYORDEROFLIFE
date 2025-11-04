using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using PRN232_MEDICAL.Data;
using System.Text;

var builder = WebApplication.CreateBuilder(args);

// 1. Cấu hình CORS (Quan trọng)
// Cho phép dự án Web (chạy ở port khác) gọi được API này
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAll",
        policy => policy.AllowAnyOrigin()
                        .AllowAnyMethod()
                        .AllowAnyHeader());
});

// 2. Cấu hình DbContext (Kết nối SQL Server)
builder.Services.AddDbContext<ApplicationDbContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection")));

// 3. Cấu hình JWT Authentication (Câu 1.2)
var secretKey = builder.Configuration["JwtSettings:Key"];
var key = Encoding.ASCII.GetBytes(secretKey);

builder.Services.AddAuthentication(options =>
{
    options.DefaultAuthenticateScheme = JwtBearerDefaults.AuthenticationScheme;
    options.DefaultChallengeScheme = JwtBearerDefaults.AuthenticationScheme;
})
.AddJwtBearer(options =>
{
    options.RequireHttpsMetadata = false; // Tắt HTTPS nếu đang dev
    options.SaveToken = true;
    options.TokenValidationParameters = new TokenValidationParameters
    {
        ValidateIssuerSigningKey = true,
        IssuerSigningKey = new SymmetricSecurityKey(key),
        ValidateIssuer = false, // Tắt validate Issuer
        ValidateAudience = false // Tắt validate Audience
    };
});

// 4. Cấu hình Authorization Policies (Câu 1.2)
builder.Services.AddAuthorization(options =>
{
    options.AddPolicy("Admin", policy => policy.RequireRole("admin"));
    options.AddPolicy("Doctor", policy => policy.RequireRole("doctor"));
    options.AddPolicy("Patient", policy => policy.RequireRole("patient"));
});


// 5. Cấu hình Controllers, OData và NewtonsoftJson
builder.Services.AddControllers()
    .AddOData(options =>
        options.Select().Filter().OrderBy().Expand().Count().SetMaxTop(100) // Hỗ trợ OData (Câu 1.5)
    )
    .AddNewtonsoftJson(options => //
        options.SerializerSettings.ReferenceLoopHandling = Newtonsoft.Json.ReferenceLoopHandling.Ignore
    );


builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

// BẬT CÁC DỊCH VỤ ĐÃ CẤU HÌNH

app.UseHttpsRedirection();

app.UseRouting(); // Phải có UseRouting

app.UseCors("AllowAll"); // Bật CORS

app.UseAuthentication(); // Bật xác thực (JWT)
app.UseAuthorization(); // Bật cấp quyền (Policies)

app.MapControllers();

app.Run();