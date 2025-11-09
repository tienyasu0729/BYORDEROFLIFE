namespace GarageSystem.Web
{
    public class ODataResponse<T>
    {
        public List<T> Value { get; set; } = new();
    }
}
