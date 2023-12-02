using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace Programowanie_obiektowe_2.Lab01
{
    internal class Reader : Person
    {
        public Reader(string firstName, string lastName, int age)
            : base(firstName, lastName, age)
        {
            ReadBooks = new Book[0];
        }

        public Reader(string firstName, string lastName)
            : base(firstName, lastName) { }

        public Book[] ReadBooks { get; set; }

        public void ViewBook()
        {
            Console.WriteLine($"{FirstName} {LastName} przeczytał/a poniższe książki:");

            foreach (Book book in ReadBooks)
            {
                Console.WriteLine(book.Title);
            }
        }

        public override void View()
        {
            base.View();
            ViewBook();
        }
    }
}
