using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Restaurant_SampleTest.Models;
using ReutanrantBusiness;

namespace Restaurant_SampleTest.Controllers
{
    public class ReservationsController : Controller
    {
        private readonly AppDbContext _context;

        public ReservationsController(AppDbContext context)
        {
            _context = context;
        }

        // GET: Reservations
        public async Task<IActionResult> Index()
        {
            var appDbContext = _context.Reservations.Include(r => r.User);
            return View(await appDbContext.ToListAsync());
        }

        [Authorize(Roles = "Customer")]
        public async Task<IActionResult> MakeReservation(int tableId, DateTime reservationDate)
        {
            var userId = User.FindFirst(ClaimTypes.NameIdentifier)?.Value; // Lấy UserId của người dùng hiện tại
            if (userId == null)
            {
                return RedirectToAction("Login", "Account"); // Nếu chưa đăng nhập, yêu cầu đăng nhập
            }

            // Kiểm tra xem bàn có còn trống hay không
            var table = await _context.Tables.FindAsync(tableId);
            if (table == null || table.Status != "Available")
            {
                ViewBag.ErrorMessage = "The table is no longer available.";
                return View("Error"); // Bàn không có sẵn
            }

            // Kiểm tra xem khách hàng đã có đặt chỗ trong thời gian này chưa
            var existingReservation = await _context.Reservations
                .FirstOrDefaultAsync(r => r.UserID.ToString() == userId && r.ReservationDate == reservationDate);
            if (existingReservation != null)
            {
                ViewBag.ErrorMessage = "You have already made a reservation at this time.";
                return View("Error"); // Khách hàng đã có đặt chỗ
            }

            // Tạo mới một đặt chỗ
            var reservation = new Reservation
            {
                UserID = int.Parse(userId), // Chuyển đổi UserId thành số
                TableID = tableId,
                ReservationDate = reservationDate,
                Status = "Pending", // Đặt trạng thái ban đầu là Pending
                CreatedAt = DateTime.Now
            };

            _context.Reservations.Add(reservation);
            table.Status = "Reserved"; // Đổi trạng thái của bàn thành "Reserved"
            await _context.SaveChangesAsync();

            return RedirectToAction(nameof(Index)); // Quay lại trang danh sách đặt chỗ
        }



        // GET: Reservations/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var reservation = await _context.Reservations
                .Include(r => r.User)
                .FirstOrDefaultAsync(m => m.ID == id);
            if (reservation == null)
            {
                return NotFound();
            }

            return View(reservation);
        }

        [Authorize(Roles = "Customer")]
        public IActionResult Create()
        {
            // Lấy danh sách các bàn có trạng thái "Available"
            var availableTables = _context.Tables.Where(t => t.Status == "Available").ToList();

            // Truyền danh sách bàn vào ViewBag
            ViewBag.Tables = new SelectList(availableTables, "ID", "TableNumber");

            return View();
        }
        [Authorize(Roles = "Customer")]

        // POST: Reservations/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create(Reservation reservation)
        {
            var userId = User.FindFirst(ClaimTypes.NameIdentifier)?.Value;
            if (userId == null)
            {
                return RedirectToAction("Login", "Account");
            }

            // Kiểm tra xem bàn có còn trống hay không
            var table = await _context.Tables.FindAsync(reservation.TableID);
            if (table == null || table.Status != "Available")
            {
                ViewBag.ErrorMessage = "The selected table is no longer available.";
                return View();
            }

            // Kiểm tra xem khách hàng đã có đặt chỗ tại thời gian này chưa
            var existingReservation = await _context.Reservations
                .FirstOrDefaultAsync(r => r.UserID.ToString() == userId && r.ReservationDate == reservation.ReservationDate);
            if (existingReservation != null)
            {
                ViewBag.ErrorMessage = "You have already made a reservation at this time.";
                return View();
            }

            // Tạo mới một đơn đặt chỗ
            reservation.UserID = int.Parse(userId);
            reservation.Status = "Pending"; // Trạng thái ban đầu
            reservation.CreatedAt = DateTime.Now;

            _context.Reservations.Add(reservation);

            // Đổi trạng thái bàn thành Reserved
            table.Status = "Reserved";

            // Cập nhật bàn vào cơ sở dữ liệu
            _context.Tables.Update(table);

            await _context.SaveChangesAsync();

            return RedirectToAction(nameof(Index)); // Quay lại trang danh sách đặt chỗ
        }



        // GET: Reservations/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var reservation = await _context.Reservations.FindAsync(id);
            if (reservation == null)
            {
                return NotFound();
            }
            ViewData["UserID"] = new SelectList(_context.Users, "ID", "Email", reservation.UserID);
            return View(reservation);
        }

        // POST: Reservations/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("ID,UserID,TableID,ReservationDate,Status,CreatedAt")] Reservation reservation)
        {
            if (id != reservation.ID)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(reservation);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!ReservationExists(reservation.ID))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            ViewData["UserID"] = new SelectList(_context.Users, "ID", "Email", reservation.UserID);
            return View(reservation);
        }

        // GET: Reservations/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var reservation = await _context.Reservations
                .Include(r => r.User)
                .FirstOrDefaultAsync(m => m.ID == id);
            if (reservation == null)
            {
                return NotFound();
            }

            return View(reservation);
        }

        // POST: Reservations/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var reservation = await _context.Reservations.FindAsync(id);
            if (reservation != null)
            {
                _context.Reservations.Remove(reservation);
            }

            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool ReservationExists(int id)
        {
            return _context.Reservations.Any(e => e.ID == id);
        }
    }
}
