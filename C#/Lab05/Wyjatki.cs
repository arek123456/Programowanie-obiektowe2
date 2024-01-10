using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab04
{
    class WyjatekA : Exception
    {
        public WyjatekA(string message) : base(message) { }
    }

    class WyjatekB : Exception
    {
        public WyjatekB(string message) : base(message) { }
    }

    class WyjatekC : Exception
    {
        public WyjatekC(string message) : base(message) { }
    }

    class Program
    {
        static Random random = new Random();
        static void LosowyWyjatek()
        {
            int losowaLiczba = random.Next(1, 4);

            switch (losowaLiczba)
            {
                case 1:
                    throw new WyjatekA("Zgłoszono WyjatekA.");
                case 2:
                    throw new WyjatekB("Zgłoszono WyjatekB.");
                case 3:
                    throw new WyjatekC("Zgłoszono WyjatekC.");
                default:
                    throw new Exception("Niespodziewany błąd.");
            }
        }

        static void Main()
        {
            try
            {
                LosowyWyjatek();
            }
            catch (WyjatekA exA)
            {
                Console.WriteLine($"Złapany WyjatekA: {exA.Message}");
            }
            catch (WyjatekB exB)
            {
                Console.WriteLine($"Złapany WyjatekB: {exB.Message}");
            }
            catch (WyjatekC exC)
            {
                Console.WriteLine($"Złapany WyjatekC: {exC.Message}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Złapany niespodziewany wyjątek: {ex.Message}");
            }
        }
    }

}
