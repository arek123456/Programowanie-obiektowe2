using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab01
{
    internal class Samochod
    {
        String Marka, Model, Nadwozie, Kolor;
        int Rok_produkcji, Przebieg;

        public Samochod()
        {
            Console.WriteLine("\nWprowadz marke samochodu: ");
            this.Marka = Console.ReadLine();
            Console.WriteLine("Wprowadz model samochodu: ");
            this.Model = Console.ReadLine();
            Console.WriteLine("Wprowadz nadwozie samochodu: ");
            this.Nadwozie = Console.ReadLine();
            Console.WriteLine("Wprowadz kolor samochodu: ");
            this.Kolor = Console.ReadLine();
            Console.WriteLine("Wprowadz rok produkcji samochodu: ");
            this.Rok_produkcji = int.Parse(Console.ReadLine());
            Console.WriteLine("Wprowadz przebieg samochodu: ");
            this.Przebieg = int.Parse(Console.ReadLine());
        }
        public void Samochod_opis()
        {
            Console.WriteLine("\nMarka samochodu: " + Marka);
            Console.WriteLine("Model samochodu: " + Model);
            Console.WriteLine("Nadwozie samochodu: " + Nadwozie);
            Console.WriteLine("Kolor samochodu: " + Kolor);
            Console.WriteLine("Rok produkcji samochodu: " + Rok_produkcji);
            Console.WriteLine("Przebieg samochodu: " + Przebieg);
        }
    }
}
