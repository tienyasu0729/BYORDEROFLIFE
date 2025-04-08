using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExceptionLab
{
    public class MyException : Exception
    {
        public MyException()
        {

        }

        public MyException(string name)
            : base(string.Format("The file {0} is not allow !!!", name))
        {
            this.HelpLink = "https://docs.microsoft.com/en-us/";
        }
    }
}
