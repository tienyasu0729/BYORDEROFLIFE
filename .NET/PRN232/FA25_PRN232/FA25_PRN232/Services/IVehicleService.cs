using FA25_PRN232.DTOs;

namespace FA25_PRN232.Services
{
    public interface IVehicleService
    {
        // Dịch vụ trả về DTO, không phải Entity
        // Vẫn phải là IQueryable<VehicleDto> để OData hoạt động
        IQueryable<VehicleDto> GetVehicles();

        Task<VehicleDto?> GetVehicleByIdAsync(int id);
        Task<VehicleDto> CreateVehicleAsync(VehicleCreateDto createDto);
        Task<bool> UpdateVehicleAsync(int id, VehicleCreateDto updateDto);
        Task<bool> DeleteVehicleAsync(int id);
    }
}