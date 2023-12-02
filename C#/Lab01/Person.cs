using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab01
{
    internal class Person
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        int age;

        public Person(string firstName, string lastName, int age)
        {
            FirstName = firstName;
            LastName = lastName;
            this.age = age;
        }

        public Person(string firstName, string lastName)
        {
            FirstName = firstName;
            LastName = lastName;
        }

        public virtual void View()
        {
            Console.WriteLine($"Imie i nazwisko: {FirstName} {LastName}");
        }
    }
}
