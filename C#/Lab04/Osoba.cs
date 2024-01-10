using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab03
{
    class Osoba
    {
        public string Imie { get; protected set; }
        public string Nazwisko { get; protected set; }
        public string Pesel { get; protected set; }

        public void SetFirstName(string imie)
        {
            Imie = imie;
        }

        public void SetLastName(string nazwisko)
        {
            Nazwisko = nazwisko;
        }

        public void SetPesel(string pesel)
        {
            Pesel = pesel;
        }

        public int GetAge()
        {
            return 0;
        }

        public char GetGender()
        {
            return ' ';
        }

        public virtual string GetEducationInfo()
        {
            return "Brak informacji o edukacji.";
        }

        public string GetFullName()
        {
            return $"{Imie} {Nazwisko}";
        }

        public virtual bool CanGoAloneToHome()
        {
            return false;
        }
    }

    class Uczen : Osoba
    {
        public string Szkola { get; private set; }
        public bool MozeSamWracacDoDomu { get; private set; }

        public void SetSchool(string szkola)
        {
            Szkola = szkola;
        }

        public void ChangeSchool(string nowaSzkola)
        {
            Szkola = nowaSzkola;
        }

        public void SetCanGoHomeAlone(bool mozeSam)
        {
            MozeSamWracacDoDomu = mozeSam;
        }

        public override string GetEducationInfo()
        {
            return $"Uczeń uczęszcza do szkoły: {Szkola}.";
        }

        public override bool CanGoAloneToHome()
        {
            if (GetAge() < 12 && !MozeSamWracacDoDomu)
            {
                return false;
            }

            return true;
        }
    }

    class Nauczyciel : Uczen
    {
        public string TytulNaukowy { get; private set; }
        public List<Uczen> PodwladniUczniowie { get; private set; }

        public Nauczyciel()
        {
            PodwladniUczniowie = new List<Uczen>();
        }

        public void WhichStudentCanGoHomeAlone(DateTime dateToCheck)
        {
            Console.WriteLine($"Uczniowie, którzy mogą iść sami do domu w dniu {dateToCheck.ToShortDateString()}:");

            foreach (var uczen in PodwladniUczniowie)
            {
                if (uczen.CanGoAloneToHome())
                {
                    Console.WriteLine($"- {uczen.GetFullName()}");
                }
            }
        }
    }

    class Program
    {
        static void Main()
        {
            Nauczyciel nauczyciel = new Nauczyciel();

            Uczen uczen1 = new Uczen();
            uczen1.SetFirstName("Jan");
            uczen1.SetLastName("Kowalski");
            uczen1.SetPesel("12345678901");
            uczen1.SetSchool("Szkoła Podstawowa nr 1");
            uczen1.SetCanGoHomeAlone(true);

            Uczen uczen2 = new Uczen();
            uczen2.SetFirstName("Anna");
            uczen2.SetLastName("Nowak");
            uczen2.SetPesel("98765432109");
            uczen2.SetSchool("Szkoła Podstawowa nr 2");
            uczen2.SetCanGoHomeAlone(false);

            nauczyciel.PodwladniUczniowie.Add(uczen1);
            nauczyciel.PodwladniUczniowie.Add(uczen2);

            nauczyciel.WhichStudentCanGoHomeAlone(DateTime.Now);
        }
    }

}
