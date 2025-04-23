using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace test_2_ASP_Dbcontext_Web_API.Migrations
{
    /// <inheritdoc />
    public partial class test_2_ASP_Dbcontest_DB : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Books",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Title = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Description = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Rate = table.Column<int>(type: "int", nullable: true),
                    Genre = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Author = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    DateAdded = table.Column<DateTime>(type: "datetime2", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Books", x => x.Id);
                });

            migrationBuilder.InsertData(
                table: "Books",
                columns: new[] { "Id", "Author", "DateAdded", "Description", "Genre", "Rate", "Title" },
                values: new object[,]
                {
                    { 1, "First Author", new DateTime(2025, 4, 23, 14, 19, 18, 719, DateTimeKind.Local).AddTicks(2173), "1st book description", "Biography", 5, "1st book title" },
                    { 2, "Second Author", new DateTime(2025, 4, 23, 14, 19, 18, 721, DateTimeKind.Local).AddTicks(2200), "2nd book description", "Biography", 4, "2nd book title" }
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Books");
        }
    }
}
