using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

/*
 * Utwórz klasę Reviewer dziedziczącą z klasy Reader. 
 * Wypisz () recenzenta powinno wypisać listę książek, 
 * które przeczytał, a obok każdej pozycji losową ocenę 
 * (różną dla każdego wykonania metody Wypisz ()). 
 * Czy do stworzenia takiej funkcjonalności konieczne j
 * est aby lista książek w klasie Reader była protected? 
 * Czy też może posiadać widoczność private? Utwórz 2 recenzentów, 
 * przypisz im książki i wykonaj stworzoną metodę.
 */
namespace Programowanie_obiektowe_2.Lab01
{
    internal class Reviewer : Reader
    {
        public Reviewer(string firstName, string lastName) : base(firstName, lastName)
        {
        }

        public void Wypisz()
        {
            Console.WriteLine($"{FirstName} {LastName} recenzja: ");
            foreach (var item in ReadBooks)
            {
                Console.WriteLine($"{item.Title}: Ocena - {GenerateRating()}");
            }
        }

        private int GenerateRating()
        {
            Random rand = new Random();
            return rand.Next(1, 6);
        }
    }
}
