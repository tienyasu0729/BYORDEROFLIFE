using DataAccess; // Namespace ch?a ApplicationDbContext
using Microsoft.EntityFrameworkCore; // Namespace cho Entity Framework Core

var builder = WebApplication.CreateBuilder(args);

// --- 1. Th�m CORS Policy ---
// Ch�nh s�ch n�y cho ph�p frontend (v� d?: React app) ch?y ? domain kh�c
// c� th? g?i ??n API n�y trong m�i tr??ng ph�t tri?n.
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


// --- 2. K?t n?i Database v� ??ng k� DbContext ---
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