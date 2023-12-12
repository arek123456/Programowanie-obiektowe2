using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab02
{
    internal class Circle : Shape
    {
        public override void Draw()
        {
            base.Draw();
            Console.WriteLine("Koło");
        }
    }
}
