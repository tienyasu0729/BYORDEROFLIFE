using AutoMapper;
using HRM_API.DTOs.Company;
using HRM_API.Models;
using HRM_API.Repositories;
using Microsoft.AspNetCore.Mvc;

[Route("api/companies")]
[ApiController]
public class CompaniesController : ControllerBase
{
    private readonly IRepositoryManager _repo;
    private readonly IMapper _mapper;

    public CompaniesController(IRepositoryManager repo, IMapper mapper)
    {
        _repo = repo;
        _mapper = mapper;
    }

    [HttpGet("{id}", Name = "GetCompanyById")]
    public IActionResult GetCompany([FromRoute] int id) // Primitive binding từ route [cite: 25]
    {
        var company = _repo.Company.GetCompany(id, trackChanges: false);
        if (company == null)
            return NotFound(); // Trả về 404 

        var companyDto = _mapper.Map<CompanyDto>(company);
        return Ok(companyDto);
    }

    [HttpPost]
    public IActionResult CreateCompany([FromBody] CompanyCreateDto companyDto) // Complex binding từ body [cite: 27, 28]
    {
        if (!ModelState.IsValid) // Kiểm tra validation [cite: 45]
            return BadRequest(ModelState); // Trả về 400 

        var companyEntity = _mapper.Map<Company>(companyDto);
        _repo.Company.CreateCompany(companyEntity);
        _repo.Save();

        var companyToReturn = _mapper.Map<CompanyDto>(companyEntity);
        return CreatedAtRoute("GetCompanyById", new { id = companyToReturn.Id }, companyToReturn);
    }

    [HttpDelete("{id}")]
    public IActionResult DeleteCompany(int id)
    {
        var company = _repo.Company.GetCompany(id, trackChanges: true);
        if (company == null) return NotFound();

        company.IsDeleted = true; // Soft delete [cite: 60]
        _repo.Save();

        return NoContent();
    }

    // ... các actions khác như GET (all), PUT
}