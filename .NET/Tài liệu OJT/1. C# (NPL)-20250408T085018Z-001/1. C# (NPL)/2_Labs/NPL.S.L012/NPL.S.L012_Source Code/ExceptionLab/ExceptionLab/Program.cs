using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExceptionLab
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Input your file name: ");
            //// Read the file name with location
            var filePath = Console.ReadLine();
            StreamReader streamReader = null;

            try
            {
                if (filePath.ToLower().EndsWith(".exe"))
                {
                    throw new MyException(filePath);
                }
                //// Try to open file as StreamReader
                streamReader = new StreamReader(filePath);
                var line = string.Empty;
                //// Read line by line then print to console window
                while ((line = streamReader.ReadLine()) != null)
                {
                    Console.WriteLine(line);
                }
            }
            catch (ArgumentException argumentException)
            {
                //// Hand exception when file name is empty
                Console.WriteLine("File name is empty.");
            }
            catch (FileNotFoundException fileNotFound)
            {
                //// Hand exception when file not found.
                //// May user is wrong location or spelling
                Console.WriteLine("File not found. Please check you location or spelling.");
            }
            catch (IOException ioException)
            {
                //// Hand exception when could not open the file.
                Console.WriteLine("Could not open the file. Please check permision on your file.");
            }
            catch (MyException myException)
            {
                //// Hand exception when file is executor
                Console.WriteLine(myException.Message);
            }
            catch (Exception exception)
            {
                //// Hand general exception.
                //// Put it at the bottom of all
                Console.WriteLine(exception.Message);
            }
            finally
            {
                //// Should be close stream all ways
                if (streamReader != null)
                {
                    streamReader.Close();
                }
            }

            Console.ReadKey();
        }
    }
}
