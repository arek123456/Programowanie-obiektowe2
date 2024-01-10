using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab04
{
    public interface ICloneable<T>
    {
        T Clone();
    }

    public class Person : ICloneable<Person>
    {
        public string Name { get; set; }
        public int Age { get; set; }

        public Person(string name, int age)
        {
            Name = name;
            Age = age;
        }

        public Person Clone()
        {
            return new Person(Name, Age);
        }
    }

    public class ObjectCopier
    {
        public static T DeepCopy<T>(T source) where T : ICloneable<T>
        {
            if (source == null)
            {
                throw new ArgumentNullException("source", "Cannot copy a null object.");
            }

            return source.Clone();
        }
    }

    class Program
    {
        static void Main()
        {
            Person person1 = new Person("John", 30);

            try
            {
                Person person2 = ObjectCopier.DeepCopy(person1);
                Console.WriteLine("Original: " + person1.Name + ", " + person1.Age);
                Console.WriteLine("Copy: " + person2.Name + ", " + person2.Age);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: " + ex.Message);
            }
        }
    }

}
