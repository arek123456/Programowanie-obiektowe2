using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab03
{
    public interface IStudent : IOsoba
    {
        string Uczelnia { get; set; }
        string Kierunek { get; set; }
        int Rok { get; set; }
        int Semestr { get; set; }
    }

    public class Student : IStudent
    {
        public string Imie { get; set; }
        public string Nazwisko { get; set; }
        public string Uczelnia { get; set; }
        public string Kierunek { get; set; }
        public int Rok { get; set; }
        public int Semestr { get; set; }

        public string ZwrocPelnaNazwe()
        {
            return $"{Imie} {Nazwisko}";
        }

        public string WypiszPelnaNazweIUczelnie()
        {
            return $"{ZwrocPelnaNazwe()} – {Semestr}{Kierunek[0]}{Rok}-{Uczelnia}";
        }
    }

    class Program
    {
        static void Main()
        {
            Student student = new Student()
            {
                Imie = "Jan",
                Nazwisko = "Kowalski",
                Uczelnia = "WSIiZ",
                Kierunek = "IID",
                Rok = 2018,
                Semestr = 4
            };

            Console.WriteLine(student.WypiszPelnaNazweIUczelnie());
        }
    }

}
