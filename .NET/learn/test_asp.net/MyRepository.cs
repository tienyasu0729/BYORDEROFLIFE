namespace test_asp.net
{
    public class MyRepository : IRepository
    {
        private readonly ILogger<MyRepository> logger;

        public MyRepository(ILogger<MyRepository> logger)
        {
            this.logger = logger;

            logger.LogInformation("new");
        }

        public string getId(string id)
        {
            return "ID: " + id;
        }
    }
}
