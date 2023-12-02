using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab01
{
    class SamochodOsobowy : Samochod
    {
 
        int Ilosc_osob;
        double Waga, Pojemnosc_silnika;

        public SamochodOsobowy()
        {
            Console.WriteLine("Wprowadz ilosc osob samochodu: ");
            this.Ilosc_osob = int.Parse(Console.ReadLine());
            do
            {
                Console.WriteLine("Wprowadz wage samochodu: ");
                this.Waga = double.Parse(Console.ReadLine());
            } while (Waga < 2 || Waga > 4.5);
            do
            {
                Console.WriteLine("Wprowadz pojemnosc silnika samochodu: ");
                this.Pojemnosc_silnika = double.Parse(Console.ReadLine());
            } while (Pojemnosc_silnika < 0.8 || Pojemnosc_silnika > 3.0);
            base.Samochod_opis();
        }
    }
}
