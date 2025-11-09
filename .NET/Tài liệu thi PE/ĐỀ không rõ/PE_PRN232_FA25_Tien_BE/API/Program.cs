using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using Microsoft.OpenApi.Models;
using System.Text;
using BusinessLogic.Repositories;
using BusinessLogic.Repositories.Interfaces;
using DataAccess;

var builder = WebApplication.CreateBuilder(args);
var configuration = builder.Configuration;

// 1. Cấu hình CORS (theo yêu cầu đề bài)
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAll",
        builder =>
        {
            builder.AllowAnyOrigin()
                   .AllowAnyMethod()
                   .AllowAnyHeader();
        });
});


// 2. Thêm Controllers và DI
builder.Services.AddControllers();

// Đăng ký DbContext
builder.Services.AddDbContext<FA25BearDBContext>(options =>
    options.UseSqlServer(configuration.GetConnectionString("DefaultConnection")));

// Đăng ký Repositories (Dependency Injection)
builder.Services.AddScoped<IAccountRepository, AccountRepository>();
builder.Services.AddScoped<IBearProfileRepository, BearProfileRepository>();


// 3. Cấu hình Swagger (cho Part 02)
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen(c =>
{
    c.SwaggerDoc("v1", new OpenApiInfo { Title = "Bear Pet Management API", Version = "v1" });

    // Thêm định nghĩa bảo mật (Authorize button) cho Swagger
    c.AddSecurityDefinition("Bearer", new OpenApiSecurityScheme
    {
        Description = @"JWT Authorization header using the Bearer scheme. 
                      Enter 'Bearer' [space] and then your token in the text input below.
                      Example: 'Bearer 12345abcdef'",
        Name = "Authorization",
        In = ParameterLocation.Header,
        Type = SecuritySchemeType.ApiKey,
        Scheme = "Bearer"
    });

    c.AddSecurityRequirement(new OpenApiSecurityRequirement()
    {
        {
            new OpenApiSecurityScheme
            {
                Reference = new OpenApiReference
                {
                    Type = ReferenceType.SecurityScheme,
                    Id = "Bearer"
                },
                Scheme = "oauth2",
                Name = "Bearer",
                In = ParameterLocation.Header,
            },
            new List<string>()
        }
    });
});

// 4. Cấu hình JWT Authentication
builder.Services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
    .AddJwtBearer(options =>
    {
        options.TokenValidationParameters = new TokenValidationParameters
        {
            ValidateIssuer = true,
            ValidateAudience = true,
            ValidateLifetime = true,
            ValidateIssuerSigningKey = true,
            ValidIssuer = configuration["Jwt:Issuer"],
            ValidAudience = configuration["Jwt:Audience"],
            IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(configuration["Jwt:Key"]))
        };
    });

// 5. Cấu hình Authorization (Phân quyền)
builder.Services.AddAuthorization(options =>
{
    // RoleId: 1=Admin, 2=Manager, 3=Staff, 4=Member

    // Manager: có mọi quyền
    options.AddPolicy("ManagerPolicy", policy =>
        policy.RequireRole("2"));

    // Staff & Member: chỉ có quyền Search
    // (Ta gộp cả Manager vào đây cho dễ, vì Manager cũng có quyền search)
    options.AddPolicy("SearchPolicy", policy =>
        policy.RequireRole("2", "3", "4"));
});


var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

// Kích hoạt CORS
app.UseCors("AllowAll");

// Kích hoạt Authentication VÀ Authorization
app.UseAuthentication();
app.UseAuthorization();

app.MapControllers();

app.Run();