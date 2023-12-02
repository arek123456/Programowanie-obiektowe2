using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab01
{
    internal class AdventureBook
    {
        int rok_wydania;
        public string autor { get; set; }
        public string kategoria { get; set; }
        int ilosc_stron;

        public AdventureBook(int rok_wydania, string autor, string kategoria, int ilosc_stron)
        {
            this.rok_wydania = rok_wydania;
            this.autor = autor;
            this.kategoria = kategoria;
            this.ilosc_stron = ilosc_stron;
        }
        public void View()
        {
            Console.WriteLine($"Rok wydania: {rok_wydania}");
            Console.WriteLine($"Autor: {autor}");
            Console.WriteLine($"Kategoria: {kategoria}");
            Console.WriteLine($"Ilość stron: {ilosc_stron}");
        }
    }
}
