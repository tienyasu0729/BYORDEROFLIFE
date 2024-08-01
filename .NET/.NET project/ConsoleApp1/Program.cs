namespace ConsoleApp1
{
    public delegate void Notify(string message);

    public class Publisher
    {
        public event Notify OnNotification;

        public void RaiseEvent()
        {
            OnNotification?.Invoke("Event raised!");
        }
    }

    public class Subscriber
    {
        public void HandleNotification(string message)
        {
            Console.WriteLine("Received message: " + message);
        }
    }

    class Program
    {
        static void Main()
        {
            Publisher publisher = new Publisher();
            Subscriber subscriber = new Subscriber();

            publisher.OnNotification += subscriber.HandleNotification;

        }
    }
}
