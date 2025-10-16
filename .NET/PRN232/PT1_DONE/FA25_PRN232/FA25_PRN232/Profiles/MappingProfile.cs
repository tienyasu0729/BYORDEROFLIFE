using AutoMapper;
using FA25_PRN232.DTOs;
using FA25_PRN232.Models;

namespace FA25_PRN232.Profiles
{
    public class MappingProfile : Profile
    {
        public MappingProfile()
        {
            // Map từ Course (entity) sang CourseDto
            CreateMap<Course, CourseDto>()
                .ForMember(dest => dest.CategoryName, opt => opt.MapFrom(src => src.Category.CategoryName))
                .ForMember(dest => dest.Author, opt => opt.MapFrom(src => src.User.Email));

            // Map từ CreateCourseDto sang Course (entity)
            CreateMap<CreateCourseDto, Course>()
                 .ForMember(dest => dest.CreatedAt, opt => opt.MapFrom(src => DateTime.Now));

            // Map từ CreateEnrollmentDto sang Enrollment
            CreateMap<CreateEnrollmentDto, Enrollment>()
                .ForMember(dest => dest.EnrollmentDate, opt => opt.MapFrom(src => DateTime.Now));
        }
    }
}
