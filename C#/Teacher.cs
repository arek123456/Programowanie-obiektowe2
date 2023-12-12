using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab02
{
    internal class Teacher : Student
    {
        protected string scientificTitle;
        protected List<Student> subordinateStudents;

        public string ScientificTitle { get; set; }
        public List<Student> SubordinateStudents { get; set; }

        public void AddStudent(Student student)
        {
            if (subordinateStudents == null)
            {
                subordinateStudents = new List<Student>();
            }

            subordinateStudents.Add(student);
        }

        public void RemoveStudent(Student student)
        {
            subordinateStudents?.Remove(student);
        }

        public void WhichStudentCanGoHomeAlone(DateTime dateToCheck)
        {
            Console.WriteLine($"Uczniowie, którzy mogą iść sami do domu {dateToCheck.ToShortDateString()}:");
            foreach (var student in subordinateStudents)
            {
                if (student.CanGoAloneToHome())
                {
                    Console.WriteLine(student.GetFullName());
                }
            }
        }
    }
}
