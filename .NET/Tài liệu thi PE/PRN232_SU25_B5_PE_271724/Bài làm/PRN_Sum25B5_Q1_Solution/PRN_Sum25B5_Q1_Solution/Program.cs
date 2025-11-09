// Thay thế TOÀN BỘ file Program.cs của bạn bằng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Đảm bảo namespace này đúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Đảm bảo namespace này đúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. Lấy chuỗi kết nối
var connectionString = builder.Configuration.GetConnectionString("DefaultConnectionString");

// 2. Đăng ký DbContext (SỬA Ở ĐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và cấu hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;

        // SỬA Ở ĐÂY: Dùng bộ chuyển đổi cho DateOnly
        options.JsonSerializerOptions.Converters.Add(new CustomDateOnlyConverter());
        options.JsonSerializerOptions.Converters.Add(new NullableCustomDateOnlyConverter());
    })
    .AddOData(opt =>
        opt.Select().Filter().OrderBy().Count().Expand().SetMaxTop(100)
    );

builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseAuthorization();
app.MapControllers();
app.Run();

// --- Các lớp Helper để định dạng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Đảm bảo namespace này đúng
{
    // SỬA Ở ĐÂY: Chuyển đổi cho DateOnly
    public class CustomDateOnlyConverter : JsonConverter<DateOnly>
    {
        private readonly string _format = "yyyy-MM-dd";
        public override DateOnly Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
        {
            return DateOnly.ParseExact(reader.GetString()!, _format, CultureInfo.InvariantCulture);
        }
        public override void Write(Utf8JsonWriter writer, DateOnly value, JsonSerializerOptions options)
        {
            writer.WriteStringValue(value.ToString(_format));
        }
    }

    // SỬA Ở ĐÂY: Chuyển đổi cho DateOnly? (nullable)
    public class NullableCustomDateOnlyConverter : JsonConverter<DateOnly?>
    {
        private readonly string _format = "yyyy-MM-dd";
        public override DateOnly? Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
        {
            if (string.IsNullOrEmpty(reader.GetString())) return null;
            return DateOnly.ParseExact(reader.GetString()!, _format, CultureInfo.InvariantCulture);
        }
        public override void Write(Utf8JsonWriter writer, DateOnly? value, JsonSerializerOptions options)
        {
            if (value.HasValue) writer.WriteStringValue(value.Value.ToString(_format));
            else writer.WriteNullValue();
        }
    }
}