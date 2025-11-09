using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using Microsoft.OpenApi.Models;
using Prn232PracticeExam.Data; // Using thư mục Data
using System.Text;

var builder = WebApplication.CreateBuilder(args);

// --- 1. Lấy chuỗi kết nối từ appsettings.json (Mục 1.2) ---
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");

// --- 2. Đăng ký DbContext (Code First) ---
builder.Services.AddDbContext<PracticeExamContext>(options =>
    options.UseSqlServer(connectionString));

// --- 3. Đăng ký Controller và OData (Mục 2.2) ---
// Thêm .AddNewtonsoftJson() nếu bạn dùng OData với phiên bản .NET cũ hơn
// hoặc để xử lý các vấn đề về vòng lặp JSON
builder.Services.AddControllers().AddOData(options =>
    options.Select().Filter().OrderBy().Expand().Count().SetMaxTop(null)
);

// --- 4. Cấu hình JWT Authentication (Mục 2.1) ---
builder.Services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
    .AddJwtBearer(options =>
    {
        options.TokenValidationParameters = new TokenValidationParameters
        {
            ValidateIssuer = true,
            ValidateAudience = true,
            ValidateLifetime = true,
            ValidateIssuerSigningKey = true,
            ValidIssuer = builder.Configuration["Jwt:Issuer"],
            ValidAudience = builder.Configuration["Jwt:Audience"],
            IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(builder.Configuration["Jwt:Key"]))
        };
    });
builder.Services.AddAuthorization(); // Thêm dòng này

// --- 5. Cấu hình Swagger để dùng JWT (Mục 2.4) ---
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen(c =>
{
    c.SwaggerDoc("v1", new OpenApiInfo { Title = "PRN232 Practice Exam", Version = "v1" });

    // Thêm định nghĩa bảo mật "Bearer"
    c.AddSecurityDefinition("Bearer", new OpenApiSecurityScheme
    {
        Description = "JWT Authorization header. Example: 'Bearer 12345abcdef'",
        Name = "Authorization",
        In = ParameterLocation.Header,
        Type = SecuritySchemeType.ApiKey,
        Scheme = "Bearer"
    });

    // Yêu cầu token cho các endpoint
    c.AddSecurityRequirement(new OpenApiSecurityRequirement()
    {
        {
            new OpenApiSecurityScheme
            {
                Reference = new OpenApiReference { Type = ReferenceType.SecurityScheme, Id = "Bearer" },
                Scheme = "oauth2",
                Name = "Bearer",
                In = ParameterLocation.Header,
            },
            new List<string>()
        }
    });
});

// --- 6. Tùy chỉnh lỗi Validation 400 (Mục 2.3) ---
builder.Services.Configure<ApiBehaviorOptions>(options =>
{
    options.InvalidModelStateResponseFactory = context =>
    {
        var errors = context.ModelState.Values
                        .SelectMany(v => v.Errors)
                        .Select(e => e.ErrorMessage);

        // Nối các lỗi validation lại thành 1 chuỗi
        var errorMessage = string.Join(" | ", errors);

        var errorResponse = new
        {
            errorCode = "HB40001", // Mã lỗi cho validation (Missing/invalid input)
            errorMessage = errorMessage
        };
        // Trả về lỗi 400 Bad Request với format JSON yêu cầu
        return new BadRequestObjectResult(errorResponse);
    };
});


// =================================================================
// XÂY DỰNG ỨNG DỤNG
// =================================================================
var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

// --- 7. Thêm 2 dòng này ĐÚNG THỨ TỰ ---
app.UseAuthentication(); // 1. Xác thực (Bạn là ai?)
app.UseAuthorization();  // 2. Phân quyền (Bạn được làm gì?)

app.MapControllers();

app.Run();