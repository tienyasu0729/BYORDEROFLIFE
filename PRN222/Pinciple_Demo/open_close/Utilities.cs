using Newtonsoft.Json;
using Pinciple_Demo;
using System.Collections.Generic;
using System.IO;
internal class Utilities
{
    static string ReadFile(string filename)
    {
        return File.ReadAllText(filename);
    }
    //
    internal static List<Book> ReadData()
    {
        var cadJSON = ReadFile("D:\\Code\\BYORDEROFLIFE\\PRN222\\Pinciple_Demo\\open_close\\Data\\FileName.json");
        return JsonConvert.DeserializeObject<List<Book>>(cadJSON);
    }
    //-
    internal static List<Book> ReadDataExtra()
    {
        List<Book> books = ReadData();
        var cadJSON = ReadFile("D:\\Code\\BYORDEROFLIFE\\PRN222\\Pinciple_Demo\\open_close\\Data\\FileName2.json");
        books.AddRange(JsonConvert.DeserializeObject<List<Book>>(cadJSON));
        return books;
    }
}