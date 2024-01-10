using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab03
{
    public interface IOsoba
    {
        string Imie { get; set; }
        string Nazwisko { get; set; }

        string ZwrocPelnaNazwe();
    }

    public class Osoba : IOsoba
    {
        public string Imie { get; set; }
        public string Nazwisko { get; set; }

        public string ZwrocPelnaNazwe()
        {
            return $"{Imie} {Nazwisko}";
        }
    }

    class Program
    {
        static void Main()
        {
            List<IOsoba> listaOsob = new List<IOsoba>();

            Osoba osoba1 = new Osoba() { Imie = "Jan", Nazwisko = "Kowalski" };
            Osoba osoba2 = new Osoba() { Imie = "Anna", Nazwisko = "Nowak" };
            Osoba osoba3 = new Osoba() { Imie = "Michał", Nazwisko = "Wiśniewski" };

            listaOsob.Add(osoba1);
            listaOsob.Add(osoba2);
            listaOsob.Add(osoba3);

            foreach (var osoba in listaOsob)
            {
                Console.WriteLine(osoba.ZwrocPelnaNazwe());
            }
        }
    }

}
