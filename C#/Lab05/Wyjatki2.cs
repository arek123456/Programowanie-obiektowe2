using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab04
{

    public class SomeClass
    {
        public void CanThrowException()
        {
            if (new Random().Next(5) == 0)
                throw new Exception();
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            SomeClass someClassObj = new SomeClass();

            try
            {
                someClassObj.CanThrowException();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Złapany wyjątek w pierwszej instrukcji: " + ex.Message);
            }

            try
            {
                someClassObj.CanThrowException();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Złapany wyjątek w drugiej instrukcji: " + ex.Message);
            }

            try
            {
                someClassObj.CanThrowException();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Złapany wyjątek w trzeciej instrukcji: " + ex.Message);
            }

            try
            {
                someClassObj.CanThrowException();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Złapany wyjątek w czwartej instrukcji: " + ex.Message);
            }

            try
            {
                someClassObj.CanThrowException();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Złapany wyjątek w piątej instrukcji: " + ex.Message);
            }
        }
    }

}
