using Programowanie_obiektowe_2.Lab02;

    Rectangle shape = new Rectangle();

    Triangle shape2 = new Triangle();

    Circle shape3 = new Circle();

    List<Shape> shapes = new List<Shape>();
    shapes.Add(shape);
    shapes.Add(shape2);
    shapes.Add(shape3);
    foreach (Shape a in shapes)
    {
        a.Draw();
    }