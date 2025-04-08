namespace test_asp.net
{
    public class test1Repository : IRepository
    {
        public string getId(string id)
        {
            return "ID 2: " + id;
        }
    }
}
