using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace ReutanrantBusiness.Migrations
{
    /// <inheritdoc />
    public partial class Update : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Reservations_Tables_TablesID",
                table: "Reservations");

            migrationBuilder.DropIndex(
                name: "IX_Reservations_TablesID",
                table: "Reservations");

            migrationBuilder.DropColumn(
                name: "TablesID",
                table: "Reservations");

            migrationBuilder.CreateIndex(
                name: "IX_Tables_TableNumber",
                table: "Tables",
                column: "TableNumber",
                unique: true);

            migrationBuilder.CreateIndex(
                name: "IX_Reservations_TableID",
                table: "Reservations",
                column: "TableID");

            migrationBuilder.AddForeignKey(
                name: "FK_Reservations_Tables_TableID",
                table: "Reservations",
                column: "TableID",
                principalTable: "Tables",
                principalColumn: "ID",
                onDelete: ReferentialAction.Cascade);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Reservations_Tables_TableID",
                table: "Reservations");

            migrationBuilder.DropIndex(
                name: "IX_Tables_TableNumber",
                table: "Tables");

            migrationBuilder.DropIndex(
                name: "IX_Reservations_TableID",
                table: "Reservations");

            migrationBuilder.AddColumn<int>(
                name: "TablesID",
                table: "Reservations",
                type: "int",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.CreateIndex(
                name: "IX_Reservations_TablesID",
                table: "Reservations",
                column: "TablesID");

            migrationBuilder.AddForeignKey(
                name: "FK_Reservations_Tables_TablesID",
                table: "Reservations",
                column: "TablesID",
                principalTable: "Tables",
                principalColumn: "ID",
                onDelete: ReferentialAction.Cascade);
        }
    }
}
