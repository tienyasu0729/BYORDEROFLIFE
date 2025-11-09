using AutoMapper;
using FPTShopLaptopAPI.DTOs;
using FPTShopLaptopAPI.Models;

namespace FPTShopLaptopAPI.Mapping
{
    public class MappingProfile : Profile
    {
        public MappingProfile()
        {
            CreateMap<Laptop, LaptopDTO>()
                .ForMember(dest => dest.UploaderEmail, opt => opt.MapFrom(src => src.User.Email));

            CreateMap<Order, OrderDTO>()
                .ForMember(dest => dest.LaptopName, opt => opt.MapFrom(src => src.Laptop.Name))
                .ForMember(dest => dest.BuyerEmail, opt => opt.MapFrom(src => src.User.Email));
        }
    }
}
