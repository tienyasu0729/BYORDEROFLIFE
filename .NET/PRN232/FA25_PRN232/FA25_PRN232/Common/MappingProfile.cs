using AutoMapper;
using FA25_PRN232.DTOs;   // Namespace DTOs
using FA25_PRN232.Models; // Namespace Models (Entities)

namespace FA25_PRN232.Common
{
    public class MappingProfile : Profile
    {
        public MappingProfile()
        {
            // Map từ Entity -> DTO (để trả về)
            CreateMap<Vehicle, VehicleDto>();

            // Map từ DTO -> Entity (để tạo mới/cập nhật)
            CreateMap<VehicleCreateDto, Vehicle>();

            // (Bạn có thể thêm 1 DTO nữa cho Update nếu muốn)
        }
    }
}