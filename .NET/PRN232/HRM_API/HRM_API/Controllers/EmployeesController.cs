using AutoMapper;
using HRM_API.DTOs.Employee;
using HRM_API.Models;
using HRM_API.Repositories;
using Microsoft.AspNetCore.Mvc;

[Route("api")]
[ApiController]
public class EmployeesController : ControllerBase
{
    private readonly IRepositoryManager _repo;
    private readonly IMapper _mapper;

    public EmployeesController(IRepositoryManager repo, IMapper mapper)
    {
        _repo = repo;
        _mapper = mapper;
    }

    [HttpGet("employees/{id}")]
    [HttpGet("staff/{id}")] // Multiple URLs cho cùng resource [cite: 18, 19, 20]
    public IActionResult GetEmployee(int id, [FromHeader(Name = "X-Client-Id")] string clientId) // Binding từ header [cite: 30]
    {
        // Logic lấy employee...
        return Ok();
    }

    [HttpGet("employees/search")]
    public IActionResult SearchEmployees(
        [FromQuery] string name,
        [FromQuery] decimal? minSalary) // Primitive binding từ query [cite: 17, 26]
    {
        // Logic tìm kiếm...
        return Ok();
    }

    [HttpPost("employees/bulk")]
    public IActionResult CreateBulkEmployees([FromBody] List<EmployeeCreateDto> employeesDto) // Collection binding [cite: 33]
    {
        if (!ModelState.IsValid)
            return BadRequest(ModelState);

        // Logic tạo nhiều employee...
        _repo.Save();
        return Ok();
    }

    //... các actions khác
}