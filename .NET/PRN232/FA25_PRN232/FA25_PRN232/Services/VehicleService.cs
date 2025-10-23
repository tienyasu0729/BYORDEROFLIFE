using AutoMapper;
using AutoMapper.QueryableExtensions; // Cần cho ProjectTo
using FA25_PRN232.DTOs;
using FA25_PRN232.Models;
using FA25_PRN232.Repositories;
using Microsoft.EntityFrameworkCore;

namespace FA25_PRN232.Services
{
    public class VehicleService : IVehicleService
    {
        private readonly IRepository<Vehicle> _vehicleRepo;
        private readonly IMapper _mapper;

        public VehicleService(IRepository<Vehicle> vehicleRepo, IMapper mapper)
        {
            _vehicleRepo = vehicleRepo;
            _mapper = mapper;
        }

        public IQueryable<VehicleDto> GetVehicles()
        {
            // Lấy IQueryable<Vehicle> từ Repo
            var vehicles = _vehicleRepo.GetAll();

            // Dùng ProjectTo của AutoMapper để chuyển nó thành IQueryable<VehicleDto>
            // OData sẽ hoạt động trên IQueryable này
            return vehicles.ProjectTo<VehicleDto>(_mapper.ConfigurationProvider);
        }

        public async Task<VehicleDto?> GetVehicleByIdAsync(int id)
        {
            var vehicle = await _vehicleRepo.GetByIdAsync(id);
            return _mapper.Map<VehicleDto>(vehicle);
        }

        public async Task<VehicleDto> CreateVehicleAsync(VehicleCreateDto createDto)
        {
            // Map DTO -> Entity
            var vehicle = _mapper.Map<Vehicle>(createDto);

            await _vehicleRepo.AddAsync(vehicle);
            await _vehicleRepo.SaveChangesAsync();

            // Map Entity -> DTO để trả về
            return _mapper.Map<VehicleDto>(vehicle);
        }

        public async Task<bool> UpdateVehicleAsync(int id, VehicleCreateDto updateDto)
        {
            var vehicle = await _vehicleRepo.GetByIdAsync(id);
            if (vehicle == null)
            {
                return false;
            }

            // Map DTO vào Entity đã tồn tại
            _mapper.Map(updateDto, vehicle);

            _vehicleRepo.Update(vehicle);
            await _vehicleRepo.SaveChangesAsync();
            return true;
        }

        public async Task<bool> DeleteVehicleAsync(int id)
        {
            var vehicle = await _vehicleRepo.GetByIdAsync(id);
            if (vehicle == null)
            {
                return false;
            }

            _vehicleRepo.Delete(vehicle);
            await _vehicleRepo.SaveChangesAsync();
            return true;
        }
    }
}