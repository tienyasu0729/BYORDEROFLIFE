namespace BusinessLogic.DTOs
{
    public class LoginResponseDto
    {
        public string Token { get; set; }
        public string FullName { get; set; }
        public int RoleId { get; set; }
    }
}