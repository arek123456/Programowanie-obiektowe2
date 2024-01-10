using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab04
{
    // Własna generyczna lista
    class CustomList<T>
    {
        private List<T> items = new List<T>();

        public void Add(T item)
        {
            items.Add(item);
        }

        public void PrintAll()
        {
            foreach (var item in items)
            {
                Console.WriteLine(item);
            }
        }
    }

    // Klasa testująca
    class Program
    {
        static void Main()
        {
            // Utwórz kolejkę przechowującą obiekty typu int
            CustomList<int> numbersList = new CustomList<int>();

            // Dodaj liczby do listy
            for (int i = 1; i <= 10; i++)
            {
                numbersList.Add(i);
            }

            // Wypisz listę
            Console.WriteLine("Wszystkie liczby:");
            numbersList.PrintAll();

            // Wypisz tylko liczby parzyste
            Console.WriteLine("\nLiczby parzyste:");
            foreach (var number in numbersList)
            {
                if (number % 2 == 0)
                {
                    Console.WriteLine(number);
                }
            }
        }
    }

}
