using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fraction
{
    public class Fraction
    {
        public int Numerator { get; set; }
        public int Denominator { get; set; }

        public Fraction()
        {
            Numerator = 0;
            Denominator = 1;
        }

        public Fraction(int integer)
        {
            Numerator = integer;
            Denominator = 1;
        }

        public Fraction(int numerator, int denominator)
        {
            if (denominator >= 0)
            {
                this.Numerator = numerator;
                this.Denominator = denominator;
            }
            else
            {
                this.Numerator = -numerator;
                this.Denominator = -denominator;
            }
        }

        private int GetGreatestCommonDivisor(int firstNumber, int secondNumber)
        {
            if (firstNumber == 0 || secondNumber == 0)
            {
                return 1;
            }

            var uFirstNumber = Math.Abs(firstNumber);
            var uSecondNumber = Math.Abs(secondNumber);
            while (uFirstNumber != uSecondNumber)
            {
                if (uFirstNumber > uSecondNumber)
                {
                    uFirstNumber = uFirstNumber - uSecondNumber;
                }
                else
                {
                    uSecondNumber = uSecondNumber - uFirstNumber;
                }
            }

            return uSecondNumber;
        }

        private int GetLeastCommonMultiple(int firstNumber, int secondNumber)
        {
            var greatestCommonDivisor = this.GetGreatestCommonDivisor(firstNumber, secondNumber);
            var leastCommonMultiple = (firstNumber * secondNumber) / greatestCommonDivisor;

            return Math.Abs(leastCommonMultiple);
        }

        public void GetNormalForm()
        {
            var greatestCommonDivisor = this.GetGreatestCommonDivisor(this.Numerator, this.Denominator);
            if (greatestCommonDivisor > 1)
            {
                this.Numerator = this.Numerator / greatestCommonDivisor;
                this.Denominator = this.Denominator / greatestCommonDivisor;
            }

            if (this.Denominator < 0)
            {
                this.Numerator = -this.Numerator;
                this.Denominator = -this.Denominator;
            }
        }

        public void Add(Fraction secondFraction)
        {
            var numerator = this.Numerator * secondFraction.Denominator + this.Denominator * secondFraction.Numerator;
            var denominator = this.Denominator * secondFraction.Denominator;

            this.Numerator = numerator;
            this.Denominator = denominator;
            this.GetNormalForm();
        }

        public void Subtract(Fraction secondFraction)
        {
            var numerator = this.Numerator * secondFraction.Denominator - this.Denominator * secondFraction.Numerator;
            var denominator = this.Denominator * secondFraction.Denominator;

            this.Numerator = numerator;
            this.Denominator = denominator;
            this.GetNormalForm();
        }

        public void Print()
        {
            if (Denominator == 0)
            {
                Console.WriteLine("Error when print a fraction with denomination equal 0");
            }
            else if (Denominator == 1)
            {
                Console.WriteLine(string.Format("{0}", this.Numerator));
            }
            else
            {
                Console.WriteLine(string.Format("{0}/{1}", this.Numerator, this.Denominator));
            }
        }

    }
}
