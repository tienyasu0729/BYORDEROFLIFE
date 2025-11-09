using BusinessLogic.DTOs;
using DataAccess.Models;
using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.DTOs;
using DataAccess.Models;

namespace BusinessLogic.Repositories.Interfaces
{
    public interface IBearProfileRepository
    {
        Task<IEnumerable<BearProfileDto>> GetAllAsync();
        Task<BearProfileDto> GetByIdAsync(int id);
        Task<BearProfile> CreateAsync(BearProfileCreateDto createDto);
        Task<bool> UpdateAsync(BearProfile profile); // Dùng cho PUT /BearProfiles
        Task<bool> DeleteAsync(int id);
        Task<SearchResponseDto<BearProfileDto>> SearchAsync(SearchRequestDto request);
    }
}