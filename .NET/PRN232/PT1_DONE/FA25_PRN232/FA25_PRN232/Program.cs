using FA25_PRN232.Data;
using FA25_PRN232.Interfaces;
using FA25_PRN232.Profiles;
using FA25_PRN232.Services;
using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using SP25_PRN231.Services;

var builder = WebApplication.CreateBuilder(args);

// 1. Configure DbContext with connection string
builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection")));

// 2. Register AutoMapper
builder.Services.AddAutoMapper(typeof(MappingProfile));

// 3. Register services for Dependency Injection
builder.Services.AddScoped<ICourseService, CourseService>();
builder.Services.AddScoped<IEnrollmentService, EnrollmentService>();

// 4. Add Controllers and configure OData
builder.Services.AddControllers()
    .AddOData(options =>
    {
        options.Select()
               .Filter()
               .OrderBy()
               .Expand()
               .Count()
               .SetMaxTop(100);
    });

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

app.UseAuthorization();

app.MapControllers();

app.Run();
