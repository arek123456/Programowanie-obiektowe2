using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab01
{
    internal class Main
    {
        static void main(string[] args)
        {
            Samochod samochod1 = new Samochod();
            Samochod samochod2 = new Samochod();
            samochod1.Samochod_opis();
            Console.WriteLine("-----------------------------");
            samochod2.Samochod_opis();
        }
    }
}
