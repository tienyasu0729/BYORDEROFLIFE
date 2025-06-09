using Pinciple_Demo;

using System; 
using System.IO; 
using Newtonsoft.Json;
class Program {
    static void Main(string[] args)
    {
        Console.WriteLine(" List of Books");
        Console.WriteLine(" -----");
        var cadJSON = File.ReadAllText("D:\\Code\\BYORDEROFLIFE\\PRN222\\Pinciple_Demo\\Pinciple_Demo\\Data\\Data.json");
        var bookList = JsonConvert.DeserializeObject<Book[]>(cadJSON);
        foreach (var item in bookList)
        {
            Console.WriteLine($" {item.Title.PadRight(39, ' ')} " + $"{item.Author.PadRight(15)} {item.Price}");
        }
        Console.Read();
    }//end Main
}