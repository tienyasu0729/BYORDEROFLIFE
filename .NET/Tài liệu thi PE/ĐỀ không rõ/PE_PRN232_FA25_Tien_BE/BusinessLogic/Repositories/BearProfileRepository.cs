using BusinessLogic.DTOs;
using BusinessLogic.Repositories.Interfaces;
using DataAccess;
using DataAccess.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BusinessLogic.DTOs;
using BusinessLogic.Repositories.Interfaces;
using DataAccess;
using DataAccess.Models;

namespace BusinessLogic.Repositories
{
    public class BearProfileRepository : IBearProfileRepository
    {
        private readonly FA25BearDBContext _context;

        public BearProfileRepository(FA25BearDBContext context)
        {
            _context = context;
        }

        public async Task<BearProfile> CreateAsync(BearProfileCreateDto createDto)
        {
            var newProfile = new BearProfile
            {
                BearTypeId = createDto.BearTypeId,
                BearName = createDto.BearName,
                BearWeight = createDto.BearWeight,
                Characteristics = createDto.Characteristics,
                CareNeeds = createDto.CareNeeds,
                ModifiedDate = DateTime.UtcNow // Đặt ngày giờ hiện tại
            };

            _context.BearProfiles.Add(newProfile);
            await _context.SaveChangesAsync();
            return newProfile;
        }

        public async Task<bool> DeleteAsync(int id)
        {
            var profile = await _context.BearProfiles.FindAsync(id);
            if (profile == null)
            {
                return false;
            }

            _context.BearProfiles.Remove(profile);
            await _context.SaveChangesAsync();
            return true;
        }

        public async Task<IEnumerable<BearProfileDto>> GetAllAsync()
        {
            // Yêu cầu: "newly added item should appear at the top of the list"
            // Sắp xếp theo BearProfileId giảm dần (vì nó tự tăng)
            return await _context.BearProfiles
                .Include(p => p.BearType) // Join với BearType
                .OrderByDescending(p => p.BearProfileId)
                .Select(p => new BearProfileDto
                {
                    BearProfileId = p.BearProfileId,
                    BearTypeId = p.BearTypeId,
                    BearTypeName = p.BearType.BearTypeName, // Lấy BearTypeName
                    BearName = p.BearName,
                    BearWeight = p.BearWeight,
                    Characteristics = p.Characteristics,
                    CareNeeds = p.CareNeeds,
                    ModifiedDate = p.ModifiedDate
                })
                .ToListAsync();
        }

        public async Task<BearProfileDto> GetByIdAsync(int id)
        {
            return await _context.BearProfiles
                .Include(p => p.BearType)
                .Where(p => p.BearProfileId == id)
                .Select(p => new BearProfileDto
                {
                    BearProfileId = p.BearProfileId,
                    BearTypeId = p.BearTypeId,
                    BearTypeName = p.BearType.BearTypeName,
                    BearName = p.BearName,
                    BearWeight = p.BearWeight,
                    Characteristics = p.Characteristics,
                    CareNeeds = p.CareNeeds,
                    ModifiedDate = p.ModifiedDate
                })
                .FirstOrDefaultAsync();
        }

        public async Task<SearchResponseDto<BearProfileDto>> SearchAsync(SearchRequestDto request)
        {
            var query = _context.BearProfiles.Include(p => p.BearType).AsQueryable();

            // Áp dụng điều kiện tìm kiếm
            // 1. BearName (relative search - contains)
            if (!string.IsNullOrEmpty(request.BearName))
            {
                query = query.Where(p => p.BearName.Contains(request.BearName));
            }

            // 2. BearWeight (exact search)
            if (request.BearWeight.HasValue)
            {
                query = query.Where(p => p.BearWeight == request.BearWeight.Value);
            }

            // 3. BearTypeName (relative search - contains)
            if (!string.IsNullOrEmpty(request.BearTypeName))
            {
                query = query.Where(p => p.BearType.BearTypeName.Contains(request.BearTypeName));
            }

            // Tính toán tổng số item
            var totalItems = await query.CountAsync();

            // Phân trang
            var items = await query
                .OrderByDescending(p => p.BearProfileId) // Vẫn giữ yêu cầu "mới nhất ở trên"
                .Skip((request.CurrentPage - 1) * request.PageSize)
                .Take(request.PageSize)
                .Select(p => new BearProfileDto
                {
                    BearProfileId = p.BearProfileId,
                    BearTypeId = p.BearTypeId,
                    BearTypeName = p.BearType.BearTypeName,
                    BearName = p.BearName,
                    BearWeight = p.BearWeight,
                    Characteristics = p.Characteristics,
                    CareNeeds = p.CareNeeds,
                    ModifiedDate = p.ModifiedDate
                })
                .ToListAsync();

            // Chuẩn bị kết quả trả về
            var response = new SearchResponseDto<BearProfileDto>
            {
                TotalItems = totalItems,
                TotalPages = (int)Math.Ceiling(totalItems / (double)request.PageSize),
                CurrentPage = request.CurrentPage,
                PageSize = request.PageSize,
                Items = items
            };

            return response;
        }

        public async Task<bool> UpdateAsync(BearProfile profileUpdate)
        {
            // Đây là hàm cho `PUT /BearProfiles`, ID nằm trong body
            var existingProfile = await _context.BearProfiles.FindAsync(profileUpdate.BearProfileId);
            if (existingProfile == null)
            {
                return false;
            }

            // Cập nhật các giá trị từ body (trừ ID)
            _context.Entry(existingProfile).CurrentValues.SetValues(profileUpdate);
            existingProfile.ModifiedDate = DateTime.UtcNow; // Cập nhật ngày

            try
            {
                await _context.SaveChangesAsync();
                return true;
            }
            catch (DbUpdateConcurrencyException)
            {
                return false;
            }
        }
    }
}