using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace PRN232_MEDICAL.Migrations
{
    /// <inheritdoc />
    public partial class InitialCreate : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Doctors",
                columns: table => new
                {
                    DoctorId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Name = table.Column<string>(type: "nvarchar(100)", maxLength: 100, nullable: false),
                    Specialty = table.Column<string>(type: "nvarchar(100)", maxLength: 100, nullable: false),
                    Fee = table.Column<decimal>(type: "decimal(18,2)", nullable: false),
                    Available = table.Column<bool>(type: "bit", nullable: false),
                    Description = table.Column<string>(type: "nvarchar(300)", maxLength: 300, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Doctors", x => x.DoctorId);
                });

            migrationBuilder.CreateTable(
                name: "Users",
                columns: table => new
                {
                    UserId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    FullName = table.Column<string>(type: "nvarchar(100)", maxLength: 100, nullable: false),
                    Email = table.Column<string>(type: "nvarchar(100)", maxLength: 100, nullable: false),
                    Password = table.Column<string>(type: "nvarchar(100)", maxLength: 100, nullable: false),
                    Role = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Users", x => x.UserId);
                });

            migrationBuilder.CreateTable(
                name: "Appointments",
                columns: table => new
                {
                    AppointmentId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    DoctorId = table.Column<int>(type: "int", nullable: false),
                    UserId = table.Column<int>(type: "int", nullable: false),
                    AppointmentDate = table.Column<DateTime>(type: "datetime2", nullable: false),
                    Status = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: false),
                    Notes = table.Column<string>(type: "nvarchar(300)", maxLength: 300, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Appointments", x => x.AppointmentId);
                    table.ForeignKey(
                        name: "FK_Appointments_Doctors_DoctorId",
                        column: x => x.DoctorId,
                        principalTable: "Doctors",
                        principalColumn: "DoctorId",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Appointments_Users_UserId",
                        column: x => x.UserId,
                        principalTable: "Users",
                        principalColumn: "UserId",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Appointments_DoctorId",
                table: "Appointments",
                column: "DoctorId");

            migrationBuilder.CreateIndex(
                name: "IX_Appointments_UserId",
                table: "Appointments",
                column: "UserId");

            migrationBuilder.CreateIndex(
                name: "IX_Users_Email",
                table: "Users",
                column: "Email",
                unique: true);

            /*
            ================================================================================
             BẮT ĐẦU PHẦN CODE ĐÃ SỬA (THÊM N'' VÀO TRƯỚC CHUỖI TIẾNG VIỆT)
            ================================================================================
            */
            migrationBuilder.Sql(@"
                /* XÓA DỮ LIỆU CŨ VÀ RESET IDENTITY (ĐỂ CHẠY LẠI ĐƯỢC) */
                DELETE FROM [dbo].[Appointments];
                DELETE FROM [dbo].[Doctors];
                DELETE FROM [dbo].[Users];

                DBCC CHECKIDENT ('[Appointments]', RESEED, 0);
                DBCC CHECKIDENT ('[Doctors]', RESEED, 0);
                DBCC CHECKIDENT ('[Users]', RESEED, 0);

                /* Bảng USERS (15 hàng) */
                SET IDENTITY_INSERT [dbo].[Users] ON;
                INSERT INTO [dbo].[Users] (UserId, FullName, Email, Password, Role) VALUES
                (1, N'Admin Chính', 'admin@clinic.com', '123456', 'admin'),
                (2, N'Admin Phụ', 'admin2@clinic.com', '123456', 'admin'),
                (3, N'Quản Trị Viên', 'quantri@clinic.com', '123456', 'admin'),
                (4, N'Dr. Nguyễn Văn A', 'doctor.nguyenvana@clinic.com', '123456', 'doctor'),
                (5, N'Dr. Trần Thị B', 'doctor.tranthib@clinic.com', '123456', 'doctor'),
                (6, N'Nguyễn Văn An', 'an.nguyen@email.com', '123456', 'patient'),
                (7, N'Trần Văn Bình', 'binh.tran@email.com', '123456', 'patient'),
                (8, N'Lê Thị Cẩm', 'cam.le@email.com', '123456', 'patient'),
                (9, N'Phạm Hùng Dũng', 'dung.pham@email.com', '123456', 'patient'),
                (10, N'Hoàng Thị Giang', 'giang.hoang@email.com', '123456', 'patient'),
                (11, N'Vũ Minh Hiếu', 'hieu.vu@email.com', '123456', 'patient'),
                (12, N'Đặng Khánh Linh', 'linh.dang@email.com', '123456', 'patient'),
                (13, N'Bùi Tuấn Nam', 'nam.bui@email.com', '123456', 'patient'),
                (14, N'Dương Quỳnh Oanh', 'oanh.duong@email.com', '123456', 'patient'),
                (15, N'Lại Thái Sơn', 'son.lai@email.com', '123456', 'patient');
                SET IDENTITY_INSERT [dbo].[Users] OFF;

                /* Bảng DOCTORS (10 hàng) */
                SET IDENTITY_INSERT [dbo].[Doctors] ON;
                INSERT INTO [dbo].[Doctors] (DoctorId, Name, Specialty, Fee, Available, Description) VALUES
                (1, N'Dr. Nguyễn Văn A', N'Cardiology', 500.00, 1, N'Chuyên gia tim mạch với 20 năm kinh nghiệm. Trưởng khoa tại Bệnh viện Bạch Mai.'),
                (2, N'Dr. Trần Thị B', N'Neurology', 450.00, 1, N'Chuyên khoa thần kinh, điều trị các bệnh lý về não và cột sống.'),
                (3, N'Dr. Lê Minh C', N'Pediatrics', 250.00, 0, N'Chuyên khoa nhi, rất có kinh nghiệm với trẻ sơ sinh. (Tạm nghỉ)'),
                (4, N'Dr. Phạm Thu Hằng', N'Dermatology', 300.00, 1, N'Chuyên khoa da liễu, điều trị mụn, nám, và các bệnh lý da khác.'),
                (5, N'Dr. Hoàng Quốc Dũng', N'Orthopedics', 400.00, 1, N'Chuyên gia cơ xương khớp, phẫu thuật và điều trị bảo tồn.'),
                (6, N'Dr. Vũ Thị Lan', N'Ophthalmology', 350.00, 1, N'Chuyên khoa mắt, phẫu thuật Lasik và điều trị bệnh lý võng mạc.'),
                (7, N'Dr. Đặng Tiến Minh', N'Oncology', 600.00, 1, N'Chuyên gia ung bướu, tư vấn và điều trị ung thư.'),
                (8, N'Dr. Mai Thanh', N'Endocrinology', 300.00, 1, N'Chuyên khoa nội tiết, điều trị tiểu đường và các bệnh lý tuyến giáp.'),
                (9, N'Dr. Bùi Hữu Tài', N'Gastroenterology', 320.00, 0, N'Chuyên khoa tiêu hóa, nội soi và điều trị các bệnh dạ dày. (Hết lịch)'),
                (10, N'Dr. Hồ Anh Tuấn', N'Psychiatry', 400.00, 1, N'Chuyên gia tâm lý và tâm thần, tư vấn trị liệu.');
                SET IDENTITY_INSERT [dbo].[Doctors] OFF;

                /* Bảng APPOINTMENTS (12 hàng) */
                SET IDENTITY_INSERT [dbo].[Appointments] ON;
                INSERT INTO [dbo].[Appointments] (AppointmentId, DoctorId, UserId, AppointmentDate, Status, Notes) VALUES
                (1, 1, 6, '2025-10-25T09:00:00', 'Completed', N'Khám tim định kỳ, bệnh nhân An Nguyễn'),
                (2, 4, 7, '2025-10-28T14:00:00', 'Completed', N'Khám da, bệnh nhân Bình Trần'),
                (3, 5, 8, '2025-11-01T10:30:00', 'Completed', N'Đau khớp gối, bệnh nhân Lê Thị Cẩm'),
                (4, 1, 9, '2025-11-05T08:00:00', 'Approved', N'Tức ngực, bệnh nhân Phạm Hùng Dũng'),
                (5, 2, 10, '2025-11-05T09:00:00', 'Approved', N'Đau đầu mất ngủ, bệnh nhân Hoàng Thị Giang'),
                (6, 6, 11, '2025-11-06T11:00:00', 'Approved', N'Kiểm tra mắt, bệnh nhân Vũ Minh Hiếu'),
                (7, 7, 12, '2025-11-07T14:00:00', 'Pending', N'Tư vấn sức khỏe, bệnh nhân Đặng Khánh Linh'),
                (8, 8, 13, '2025-11-08T15:00:00', 'Pending', N'Kiểm tra tiểu đường, bệnh nhân Bùi Tuấn Nam'),
                (9, 10, 14, '2025-11-08T16:00:00', 'Pending', N'Tư vấn tâm lý, bệnh nhân Dương Quỳnh Oanh'),
                (10, 1, 15, '2025-11-09T09:30:00', 'Pending', N'Hồi hộp, bệnh nhân Lại Thái Sơn'),
                (11, 2, 6, '2025-11-10T10:00:00', 'Pending', N'Tái khám thần kinh, bệnh nhân An Nguyễn'),
                (12, 4, 7, '2025-11-11T13:30:00', 'Pending', N'Tái khám da, bệnh nhân Bình Trần');
                SET IDENTITY_INSERT [dbo].[Appointments] OFF;
            ");
            /*
            ================================================================================
             KẾT THÚC PHẦN CODE ĐÃ SỬA
            ================================================================================
            */
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Appointments");

            migrationBuilder.DropTable(
                name: "Doctors");

            migrationBuilder.DropTable(
                name: "Users");
        }
    }
}