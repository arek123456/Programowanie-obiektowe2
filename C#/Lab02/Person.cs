using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab02
{
    internal class Person
    {
        string firstName;
        string lastName;
        string pesel;

        public void SetfirstName(string imie)
        {
            firstName = imie;
        }
        public void SetlastName(string nazwisko)
        {
            lastName = nazwisko;
        }
        public void SetPesel(string pesel)
        {
            pesel = pesel;
        }

        public int GetAge()
        {
            int year = int.Parse(pesel.Substring(0, 2));
            int currentYear = DateTime.Now.Year;
            int age = currentYear - (1900 + year);
            return age;
        }
        public char GetGender()
        {
            return pesel[9] % 2 == 0 ? 'K' : 'M';
        }

        public virtual string GetEducationInfo()
        {
            return "Osoba";
        }
        public string GetFullName()
        {
            return $" {firstName} {lastName}";
        }
        public virtual bool CanGoAloneToHome()
        {
            return false;
        }

    }
}
