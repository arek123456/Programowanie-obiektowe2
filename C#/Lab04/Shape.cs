using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab03
{
    class Shape
    {
        public int X { get; set; }
        public int Y { get; set; }
        public int Height { get; set; }
        public int Width { get; set; }

        public virtual void Draw()
        {
            Console.WriteLine("Drawing a generic shape.");
        }
    }

    class Rectangle : Shape
    {
        public override void Draw()
        {
            Console.WriteLine($"Drawing a rectangle at ({X}, {Y}) with height {Height} and width {Width}.");
        }
    }

    class Triangle : Shape
    {
        public override void Draw()
        {
            Console.WriteLine($"Drawing a triangle at ({X}, {Y}) with height {Height} and width {Width}.");
        }
    }

    class Circle : Shape
    {
        public override void Draw()
        {
            Console.WriteLine($"Drawing a circle at ({X}, {Y}) with radius {Height}.");
        }
    }

    class Program
    {
        static void Main()
        {
            List<Shape> shapes = new List<Shape>();

            shapes.Add(new Rectangle() { X = 1, Y = 2, Height = 3, Width = 4 });
            shapes.Add(new Triangle() { X = 5, Y = 6, Height = 7, Width = 8 });
            shapes.Add(new Circle() { X = 9, Y = 10, Height = 11, Width = 0 });

            foreach (var shape in shapes)
            {
                shape.Draw();
            }
        }
    }

}