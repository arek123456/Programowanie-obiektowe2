using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab04
{
    class Program
    {
        static void WypiszDlugoscNapisu(string napis)
        {
            try
            {
                int dlugosc = napis.Length;
                Console.WriteLine($"Długość napisu: {dlugosc}");
            }
            catch (NullReferenceException ex)
            {
                Console.WriteLine("Wyjątek: " + ex.Message);
                Console.WriteLine("StackTrace:");
                Console.WriteLine(ex.StackTrace);

                throw new Exception("Obsługiwany wyjątek", ex);
            }
        }

        static void Main()
        {
            try
            {
                WypiszDlugoscNapisu(null);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Główny obsługiwany wyjątek: " + ex.Message);
                Console.WriteLine("StackTrace:");
                Console.WriteLine(ex.StackTrace);
            }
        }
    }

}
