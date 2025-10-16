using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace FA25_PRN232.Migrations
{
    /// <inheritdoc />
    public partial class InitialCreate : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Categories",
                columns: table => new
                {
                    CategoryId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    CategoryName = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Categories", x => x.CategoryId);
                });

            migrationBuilder.CreateTable(
                name: "Users",
                columns: table => new
                {
                    UserId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Email = table.Column<string>(type: "nvarchar(450)", nullable: false),
                    Password = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Users", x => x.UserId);
                });

            migrationBuilder.CreateTable(
                name: "Courses",
                columns: table => new
                {
                    CourseId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Title = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Description = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    Price = table.Column<decimal>(type: "decimal(18,2)", nullable: false),
                    CreatedAt = table.Column<DateTime>(type: "datetime2", nullable: false),
                    CategoryId = table.Column<int>(type: "int", nullable: false),
                    UserId = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Courses", x => x.CourseId);
                    table.ForeignKey(
                        name: "FK_Courses_Categories_CategoryId",
                        column: x => x.CategoryId,
                        principalTable: "Categories",
                        principalColumn: "CategoryId",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Courses_Users_UserId",
                        column: x => x.UserId,
                        principalTable: "Users",
                        principalColumn: "UserId",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "Enrollments",
                columns: table => new
                {
                    EnrollmentId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    EnrollmentDate = table.Column<DateTime>(type: "datetime2", nullable: false),
                    CourseId = table.Column<int>(type: "int", nullable: false),
                    UserId = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Enrollments", x => x.EnrollmentId);
                    table.ForeignKey(
                        name: "FK_Enrollments_Courses_CourseId",
                        column: x => x.CourseId,
                        principalTable: "Courses",
                        principalColumn: "CourseId",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Enrollments_Users_UserId",
                        column: x => x.UserId,
                        principalTable: "Users",
                        principalColumn: "UserId",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.InsertData(
                table: "Categories",
                columns: new[] { "CategoryId", "CategoryName" },
                values: new object[,]
                {
                    { 1, "Technology" },
                    { 2, "Business" },
                    { 3, "Personal Development" },
                    { 4, "Creative Arts" }
                });

            migrationBuilder.InsertData(
                table: "Users",
                columns: new[] { "UserId", "Email", "Password" },
                values: new object[,]
                {
                    { 1, "teacher@fpt.edu.vn", "HashedPassword1" },
                    { 2, "student1@fpt.edu.vn", "HashedPassword2" },
                    { 3, "student2@fpt.edu.vn", "HashedPassword3" }
                });

            migrationBuilder.InsertData(
                table: "Courses",
                columns: new[] { "CourseId", "CategoryId", "CreatedAt", "Description", "Price", "Title", "UserId" },
                values: new object[,]
                {
                    { 1, 1, new DateTime(2025, 9, 14, 0, 0, 0, 0, DateTimeKind.Utc), "Learn ASP.NET Core from scratch", 120.00m, "ASP.NET Core Basics", 1 },
                    { 2, 1, new DateTime(2025, 9, 19, 0, 0, 0, 0, DateTimeKind.Utc), "Introduction to Blockchain technology", 250.50m, "Blockchain Fundamentals", 1 },
                    { 3, 1, new DateTime(2025, 9, 24, 0, 0, 0, 0, DateTimeKind.Utc), "Master C# with advanced topics", 180.00m, "Advanced C# Programming", 1 },
                    { 4, 2, new DateTime(2025, 9, 26, 0, 0, 0, 0, DateTimeKind.Utc), "Learn how to design scalable microservices", 220.75m, "Microservices Architecture", 1 },
                    { 5, 2, new DateTime(2025, 9, 29, 0, 0, 0, 0, DateTimeKind.Utc), "Implement AI solutions in business scenarios", 300.00m, "AI for Business", 1 },
                    { 6, 3, new DateTime(2025, 10, 2, 0, 0, 0, 0, DateTimeKind.Utc), "Enhance productivity with better time management", 90.00m, "Time Management Skills", 1 },
                    { 7, 3, new DateTime(2025, 10, 4, 0, 0, 0, 0, DateTimeKind.Utc), "Improve your public speaking confidence", 110.00m, "Public Speaking Mastery", 1 },
                    { 8, 4, new DateTime(2025, 10, 9, 0, 0, 0, 0, DateTimeKind.Utc), "Learn the basics of digital art and illustration.", 150.00m, "Introduction to Digital Painting", 1 }
                });

            migrationBuilder.InsertData(
                table: "Enrollments",
                columns: new[] { "EnrollmentId", "CourseId", "EnrollmentDate", "UserId" },
                values: new object[,]
                {
                    { 1, 1, new DateTime(2025, 10, 4, 0, 0, 0, 0, DateTimeKind.Utc), 2 },
                    { 2, 6, new DateTime(2025, 10, 6, 0, 0, 0, 0, DateTimeKind.Utc), 2 },
                    { 3, 8, new DateTime(2025, 10, 12, 0, 0, 0, 0, DateTimeKind.Utc), 2 },
                    { 4, 1, new DateTime(2025, 10, 5, 0, 0, 0, 0, DateTimeKind.Utc), 3 },
                    { 5, 4, new DateTime(2025, 10, 9, 0, 0, 0, 0, DateTimeKind.Utc), 3 }
                });

            migrationBuilder.CreateIndex(
                name: "IX_Courses_CategoryId",
                table: "Courses",
                column: "CategoryId");

            migrationBuilder.CreateIndex(
                name: "IX_Courses_UserId",
                table: "Courses",
                column: "UserId");

            migrationBuilder.CreateIndex(
                name: "IX_Enrollments_CourseId",
                table: "Enrollments",
                column: "CourseId");

            migrationBuilder.CreateIndex(
                name: "IX_Enrollments_UserId",
                table: "Enrollments",
                column: "UserId");

            migrationBuilder.CreateIndex(
                name: "IX_Users_Email",
                table: "Users",
                column: "Email",
                unique: true);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Enrollments");

            migrationBuilder.DropTable(
                name: "Courses");

            migrationBuilder.DropTable(
                name: "Categories");

            migrationBuilder.DropTable(
                name: "Users");
        }
    }
}
