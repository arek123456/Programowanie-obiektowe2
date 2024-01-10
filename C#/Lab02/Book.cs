using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab01
{
    internal class Book
    {
        private string title;
        public string Title { get { return title; } set { title = value; } }
        Person author;
        private DateTime datePublication;

        public Book(string title, Person author, DateTime datePublication)
        {
            this.title = title;
            this.author = author;
            this.datePublication = datePublication;
        }

        public virtual void View()
        {
            Console.WriteLine($"Tytuł: {title} Autor: ");
            author.View();
            Console.WriteLine($"Data publikacji: {datePublication.ToShortDateString()}");
            Console.WriteLine("==============================");
        }
    }
}