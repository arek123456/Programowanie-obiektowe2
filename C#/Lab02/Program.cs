using Programowanie_obiektowe_2.Lab01;

Person[] people = new Person[] {
    new Person("Jan", "Nowak", 34),
    new Person("Janina", "Kowalska", 23),
    new Person("Maria", "Lonc", 12),
    new Person("Kazimierz", "Wilusz", 56)
};

Book[] books = new Book[] {
    new Book("Tytul 1", people[0], new DateTime(2023,11,29)),
    new Book("Tytul 2", people[1], new DateTime(1999,05,16)),
    new Book("Tytul 3", people[2], new DateTime(2021,12,01)),
    new Book("Tytul 4", people[3], new DateTime(2020,02,21)),
};

DocumentaryBook[] documentarybooks = new DocumentaryBook[]
{
    new DocumentaryBook(1999,"Jan Brzechwa","science-fiction",575),
    new DocumentaryBook(2001,"Adam Szczurek","discovery",445),
    new DocumentaryBook(2015,"Kacper Szela","przygodowy",395),
};

AdventureBook[] adventurebooks = new AdventureBook[]
{
    new AdventureBook(1999,"Jan Kowalski","komedia",515),
    new AdventureBook(2001,"Kacper Szczur","discos",495),
    new AdventureBook(2015,"Ola Mach","horror",425),
};



//// metoda view dla klasy Person
//Console.WriteLine("=========== Person ================");
//foreach (Person item in people)
//{
//    item.View();
//}

//// metoda view dla klasy Book
//Console.WriteLine("=========== Dostępne książki ================");
//foreach (Book item in books)
//{
//    item.View();
//}

//tablica obiektów czytelników wraz z przypisaniem przeczytanych ksiażek
Reader[] readers = new Reader[people.Length];

for (int i = 0; i < readers.Length; i++)
{
    readers[i] = new Reader(people[i].FirstName, people[i].LastName);
    if (i == 0)
        readers[i].ReadBooks = new Book[] { books[intRand()], books[intRand()] };
    else if (i == 1)
        readers[i].ReadBooks = new Book[] { books[intRand()], books[intRand()], books[intRand()] };
    else
        readers[i].ReadBooks = new Book[] { books[intRand()], books[intRand()], books[intRand()], books[intRand()] };
}

//metoda do losowania indeksów książek która wykorzystam do przypisania do czytelników
int intRand()
{
    Random rand = new Random();
    int index = rand.Next(books.Length);
    return index;
}


//Console.WriteLine("========= Książki przeczytane przez czytelników: =========");
//foreach (Reader item in readers)
//{
//    item.ViewBook();
//}



List<Person> peopleList = new List<Person>
{
    new Reader("Jan", "Nowak"),
    new Reader("Janina", "Kowalska"),
    new Reviewer("Janusz", "Nowakowski"),
    new Reviewer("Maria", "Nowak")
};

List<Book> bookList = new List<Book> {
    new Book("Tytul 1", people[0], new DateTime(2023,11,29)),
    new Book("Tytul 2", people[1], new DateTime(1999,05,16)),
    new Book("Tytul 3", people[2], new DateTime(2021,12,01)),
    new Book("Tytul 4", people[3], new DateTime(2020,02,21))
};


foreach (Person person in peopleList) person.View();
