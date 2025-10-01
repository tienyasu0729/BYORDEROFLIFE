using DataAccess; // Namespace ch?a ApplicationDbContext
using Microsoft.EntityFrameworkCore; // Namespace cho Entity Framework Core

var builder = WebApplication.CreateBuilder(args);

// --- 1. Thêm CORS Policy ---
// Chính sách này cho phép frontend (ví d?: React app) ch?y ? domain khác
// có th? g?i ??n API này trong môi tr??ng phát tri?n.
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


// --- 2. K?t n?i Database và ??ng ký DbContext ---
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");
builder.Services.AddDbContext<ApplicationDbContext>(options =>
    options.UseSqlServer(connectionString));


// Add services to the container.
builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
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

// --- 3. S? d?ng CORS Policy ---
app.UseCors("AllowAll"); // ??t tr??c UseAuthorization

app.UseAuthorization();

app.MapControllers();

app.Run();