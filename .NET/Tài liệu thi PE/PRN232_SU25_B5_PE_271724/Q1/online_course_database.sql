create database // Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
}// Thay th? TOÀN B? file Program.cs c?a b?n b?ng code này

using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Ð?m b?o namespace này dúng
using PRN_Sum25B5_Q1_Solution.Helpers; // <-- Ð?m b?o namespace này dúng
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Globalization;

var builder = WebApplication.CreateBuilder(args);

// 1. L?y chu?i k?t n?i
var connectionString = builder.Configuration.GetConnectionString("MyCnn");

// 2. Ðang ký DbContext (S?A ? ÐÂY)
builder.Services.AddDbContext<CodeDbContext>(options =>
    options.UseSqlServer(connectionString));

// 3. Thêm Controllers, OData và c?u hình JSON
builder.Services.AddControllers()
    .AddJsonOptions(options =>
    {
        options.JsonSerializerOptions.PropertyNamingPolicy = JsonNamingPolicy.CamelCase;
        
        // S?A ? ÐÂY: Dùng b? chuy?n d?i cho DateOnly
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

// --- Các l?p Helper d? d?nh d?ng DateOnly ---
namespace PRN_Sum25B5_Q1_Solution.Helpers // <-- Ð?m b?o namespace này dúng
{
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly
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
    
    // S?A ? ÐÂY: Chuy?n d?i cho DateOnly? (nullable)
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
go
use PRN_Sum25B5_232
go
CREATE TABLE Student (
    StudentID INT PRIMARY KEY IDENTITY(1,1),
    FullName NVARCHAR(100),
    Email NVARCHAR(100),
    EnrollmentDate DATE
);

CREATE TABLE Instructor (
    InstructorID INT PRIMARY KEY IDENTITY(1,1),
    FullName NVARCHAR(100),
    Email NVARCHAR(100),
    HireDate DATE
);

CREATE TABLE Course (
    CourseID INT PRIMARY KEY IDENTITY(1,1),
    Title NVARCHAR(150),
    Description NVARCHAR(MAX),
    InstructorID INT FOREIGN KEY REFERENCES Instructor(InstructorID)
);

CREATE TABLE Topic (
    TopicID INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100)
);

CREATE TABLE Enrollment (
    StudentID INT,
    CourseID INT,
    EnrollDate DATE,
    Grade FLOAT,
    PRIMARY KEY (StudentID, CourseID),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
);

CREATE TABLE CourseTopic (
    CourseID INT,
    TopicID INT,
    PRIMARY KEY (CourseID, TopicID),
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID),
    FOREIGN KEY (TopicID) REFERENCES Topic(TopicID)
);

INSERT INTO Student (FullName, Email, EnrollmentDate) VALUES ('Molly Martin', 'michellecampbell@gmail.com', '2025-01-03');
INSERT INTO Student (FullName, Email, EnrollmentDate) VALUES ('Christy Keith', 'lnewton@everett.com', '2025-03-08');
INSERT INTO Student (FullName, Email, EnrollmentDate) VALUES ('Christopher Fernandez', 'holly84@lambert.com', '2023-08-30');
INSERT INTO Student (FullName, Email, EnrollmentDate) VALUES ('Loretta Roberson', 'xaustin@hotmail.com', '2023-12-25');
INSERT INTO Student (FullName, Email, EnrollmentDate) VALUES ('Linda Fowler', 'hollandmegan@cole.net', '2023-12-30');
INSERT INTO Student (FullName, Email, EnrollmentDate) VALUES ('Sherri Webster', 'shelbyliu@glenn.info', '2025-01-15');
INSERT INTO Student (FullName, Email, EnrollmentDate) VALUES ('Richard Young', 'nicholaspeterson@roberts.com', '2024-04-22');
INSERT INTO Student (FullName, Email, EnrollmentDate) VALUES ('Jessica Carter', 'rodrigueztimothy@sullivan.biz', '2024-10-29');
INSERT INTO Student (FullName, Email, EnrollmentDate) VALUES ('Heather Choi', 'lacey35@hall.net', '2023-12-21');
INSERT INTO Student (FullName, Email, EnrollmentDate) VALUES ('Joseph Martin', 'ngonzales@newton.info', '2025-03-16');
INSERT INTO Instructor (FullName, Email, HireDate) VALUES ('Jacob Brennan Jr.', 'brianmyers@hotmail.com', '2022-10-08');
INSERT INTO Instructor (FullName, Email, HireDate) VALUES ('Edward Mcknight', 'michelle61@gmail.com', '2022-09-04');
INSERT INTO Instructor (FullName, Email, HireDate) VALUES ('Samuel Roberts', 'tamarawoods@hotmail.com', '2021-03-21');
INSERT INTO Instructor (FullName, Email, HireDate) VALUES ('Steven Martin', 'erindickerson@gmail.com', '2022-02-14');
INSERT INTO Instructor (FullName, Email, HireDate) VALUES ('Amber Jacobson', 'lopezjonathan@yahoo.com', '2021-04-17');
INSERT INTO Instructor (FullName, Email, HireDate) VALUES ('Richard Rangel', 'janice67@gmail.com', '2023-05-09');
INSERT INTO Instructor (FullName, Email, HireDate) VALUES ('Alice Perez', 'rkemp@hotmail.com', '2024-03-04');
INSERT INTO Instructor (FullName, Email, HireDate) VALUES ('James Lynch', 'mercadostephanie@yahoo.com', '2024-06-12');
INSERT INTO Instructor (FullName, Email, HireDate) VALUES ('Heather Madden', 'yross@hensley.net', '2020-11-25');
INSERT INTO Instructor (FullName, Email, HireDate) VALUES ('James Johnson', 'steve30@johnson-wilson.com', '2023-12-16');
INSERT INTO Course (Title, Description, InstructorID) VALUES ('Integrated didactic collaboration', 'Worry call enter. Include control because bring require. Ball really yes artist challenge face.', 2);
INSERT INTO Course (Title, Description, InstructorID) VALUES ('Networked asynchronous database', 'So huge name likely family clearly natural. As stay sister tree.', 7);
INSERT INTO Course (Title, Description, InstructorID) VALUES ('Digitized mission-critical array', 'Perform long voice turn case. None science nation age sing.', 4);
INSERT INTO Course (Title, Description, InstructorID) VALUES ('Implemented needs-based definition', 'Seek expect similar toward cut. Into defense nearly unit find computer enter meet.', 7);
INSERT INTO Course (Title, Description, InstructorID) VALUES ('Robust composite website', 'Between receive quite will suddenly day.', 10);
INSERT INTO Course (Title, Description, InstructorID) VALUES ('Managed executive moderator', 'Business agreement policy. Tonight listen hotel work billion factor ago.', 4);
INSERT INTO Course (Title, Description, InstructorID) VALUES ('Mandatory local task-force', 'Place study probably book role just. Oil help western together side south. Story light player even.', 10);
INSERT INTO Course (Title, Description, InstructorID) VALUES ('Compatible object-oriented ability', 'Fish race buy. Notice little too trade measure particular.', 1);
INSERT INTO Course (Title, Description, InstructorID) VALUES ('Cross-group object-oriented service-desk', 'Financial may simple size rise marriage career. Institution shake tough leg expert wait.', 1);
INSERT INTO Course (Title, Description, InstructorID) VALUES ('Networked cohesive parallelism', 'Similar among use not. Remember share they whatever. Kitchen health speak exist report send.', 10);
INSERT INTO Topic (Name) VALUES ('Artificial Intelligence');
INSERT INTO Topic (Name) VALUES ('Web Development');
INSERT INTO Topic (Name) VALUES ('Data Science');
INSERT INTO Topic (Name) VALUES ('Cybersecurity');
INSERT INTO Topic (Name) VALUES ('Mobile Development');
INSERT INTO Topic (Name) VALUES ('Cloud Computing');
INSERT INTO Topic (Name) VALUES ('DevOps');
INSERT INTO Topic (Name) VALUES ('Machine Learning');
INSERT INTO Topic (Name) VALUES ('Game Development');
INSERT INTO Topic (Name) VALUES ('Database Systems');
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (9, 4, '2024-07-28', 6.25);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (2, 9, '2024-06-23', 7.33);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (2, 3, '2024-12-22', 7.34);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (6, 4, '2025-05-17', 7.98);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (4, 5, '2024-11-09', 8.52);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (4, 6, '2024-09-08', 6.56);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (2, 6, '2025-01-16', 8.69);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (3, 2, '2024-12-10', 9.33);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (4, 2, '2024-12-16', 9.81);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (4, 3, '2024-11-22', 8.92);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (5, 1, '2025-04-18', 7.0);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (10, 10, '2024-12-01', 6.88);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (1, 1, '2024-10-31', 8.55);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (3, 4, '2024-11-07', 8.35);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (2, 2, '2024-07-13', 8.21);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (1, 1, '2025-03-08', 9.31);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (6, 3, '2024-11-02', 6.76);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (6, 1, '2024-06-24', 7.58);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (4, 10, '2024-07-24', 7.57);
INSERT INTO Enrollment (StudentID, CourseID, EnrollDate, Grade) VALUES (2, 5, '2024-12-25', 7.89);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (2, 7);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (9, 2);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (3, 7);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (9, 4);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (8, 5);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (7, 2);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (5, 6);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (9, 2);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (5, 10);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (10, 6);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (4, 7);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (9, 7);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (9, 1);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (9, 5);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (6, 7);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (8, 2);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (9, 8);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (6, 4);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (1, 10);
INSERT INTO CourseTopic (CourseID, TopicID) VALUES (5, 9);