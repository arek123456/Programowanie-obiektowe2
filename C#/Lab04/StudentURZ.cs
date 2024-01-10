using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab03
{
    using System;
using System.Collections.Generic;

public class StudentWSIiZ : Student
{
    public StudentWSIiZ()
    {
        Uczelnia = "WSIiZ";
    }
}

class Program
{
    static void Main()
    {
        List<IStudent> listaStudentow = new List<IStudent>();

        StudentWSIiZ student1 = new StudentWSIiZ()
        {
            Imie = "Anna",
            Nazwisko = "Nowak",
            Kierunek = "IP",
            Rok = 2020,
            Semestr = 2
        };

        StudentWSIiZ student2 = new StudentWSIiZ()
        {
            Imie = "Piotr",
            Nazwisko = "Kowalczyk",
            Kierunek = "TI",
            Rok = 2019,
            Semestr = 3
        };

        listaStudentow.Add(student1);
        listaStudentow.Add(student2);

        foreach (var student in listaStudentow)
        {
            Console.WriteLine(student.WypiszPelnaNazweIUczelnie());
        }
    }
}

}
