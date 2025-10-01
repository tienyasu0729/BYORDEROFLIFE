using AutoMapper;
using HRM_API.DTOs.Company;
using HRM_API.DTOs.Employee;
using HRM_API.Models;

namespace HRM_API.Mappings
{
    public class MappingProfile : Profile
    {
        public MappingProfile()
        {
            // Company Mappings
            CreateMap<Company, CompanyDto>();
            CreateMap<CompanyCreateDto, Company>();
            CreateMap<CompanyUpdateDto, Company>();

            // Employee Mappings
            CreateMap<Employee, EmployeeDto>();
            CreateMap<EmployeeCreateDto, Employee>();
            CreateMap<EmployeeUpdateDto, Employee>();
        }
    }
}