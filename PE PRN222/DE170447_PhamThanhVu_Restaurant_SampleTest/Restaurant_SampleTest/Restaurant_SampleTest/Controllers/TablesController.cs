using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Restaurant_SampleTest.Models;
using ReutanrantBusiness;

namespace Restaurant_SampleTest.Controllers
{
    public class TablesController : Controller
    {
        private readonly AppDbContext _context;

        public TablesController(AppDbContext context)
        {
            _context = context;
        }

        // GET: Tables
        public async Task<IActionResult> Index(string searchQuery)
        {
            var tables = _context.Tables.AsQueryable();

            if (!string.IsNullOrEmpty(searchQuery))
            {
                int seats;
                if (int.TryParse(searchQuery, out seats))
                {
                    tables = tables.Where(t => t.Seats == seats);
                }
            }

            return View(await tables.ToListAsync());
        }

        // GET: Tables/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var tables = await _context.Tables
                .FirstOrDefaultAsync(m => m.ID == id);
            if (tables == null)
            {
                return NotFound();
            }

            return View(tables);
        }

        [Authorize(Roles = "Admin")]
        public async Task<IActionResult> ChangeStatus(int id, string currentStatus)
        {
            var table = await _context.Tables.FindAsync(id);
            if (table == null)
            {
                return NotFound();
            }

            // Cập nhật trạng thái bàn theo vòng lặp "Available" -> "Reserved" -> "Occupied" -> "Available"
            switch (currentStatus)
            {
                case "Available":
                    table.Status = "Reserved";
                    break;
                case "Reserved":
                    table.Status = "Occupied";
                    break;
                case "Occupied":
                    table.Status = "Available";
                    break;
            }

            try
            {
                // Lưu thay đổi vào cơ sở dữ liệu
                await _context.SaveChangesAsync();
            }
            catch (Exception)
            {
                // Nếu có lỗi, trả về NotFound
                return NotFound();
            }

            // Quay lại trang Index với danh sách các bàn đã được cập nhật
            return RedirectToAction(nameof(Index));
        }


        // GET: Tables/Create
        [Authorize(Roles = "Admin")]
        public IActionResult Create()
        {
            return View();
        }

        // POST: Tables/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        [Authorize(Roles = "Admin")]
        public async Task<IActionResult> Create([Bind("TableNumber,Seats")] Tables tables)
        {
            var existingTable = await _context.Tables.FirstOrDefaultAsync(t => t.TableNumber == tables.TableNumber);

            if (existingTable != null)
            {
                // Nếu TableNumber đã tồn tại, thêm lỗi vào ModelState và trả lại view
                ModelState.AddModelError("TableNumber", "Table number already exists.");
            }

            // Tự động gán giá trị cho Status và CreatedAt
            tables.Status = "Available"; // Mặc định là Available
            tables.CreatedAt = DateTime.Now; // Gán thời gian tạo


            if (ModelState.IsValid)
            {
                _context.Add(tables);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(tables);
        }


        // GET: Tables/Edit/5
        [Authorize(Roles = "Admin")]
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var tables = await _context.Tables.FindAsync(id);
            if (tables == null)
            {
                return NotFound();
            }
            return View(tables);
        }

        // POST: Tables/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        [Authorize(Roles = "Admin")]
        public async Task<IActionResult> Edit(int id, [Bind("ID,TableNumber,Seats,Status,CreatedAt")] Tables tables)
        {
            if (id != tables.ID)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(tables);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!TablesExists(tables.ID))
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
            return View(tables);
        }

        // GET: Tables/Delete/5
        [Authorize(Roles = "Admin")]
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var tables = await _context.Tables
                .FirstOrDefaultAsync(m => m.ID == id);
            if (tables == null)
            {
                return NotFound();
            }

            return View(tables);
        }

        // POST: Tables/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        [Authorize(Roles = "Admin")]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var tables = await _context.Tables.FindAsync(id);
            if (tables != null)
            {
                _context.Tables.Remove(tables);
            }

            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool TablesExists(int id)
        {
            return _context.Tables.Any(e => e.ID == id);
        }
    }
}
