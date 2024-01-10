using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab05
{
    class Address
    {
        public string Street { get; set; }
        public string City { get; set; }
        public string ZipCode { get; set; }
    }

    class Person
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public Address Address { get; set; }
        public string Pesel { get; set; }
        public string Email { get; set; }

        public override string ToString()
        {
            return $"{FirstName} {LastName} - {Pesel}";
        }
    }

    class CsvDataManager
    {
        private const string FilePath = "persons.csv";

        public List<Person> ReadData()
        {
            List<Person> persons = new List<Person>();

            try
            {
                if (File.Exists(FilePath))
                {
                    var lines = File.ReadAllLines(FilePath);
                    foreach (var line in lines)
                    {
                        var data = line.Split(',');
                        var person = new Person
                        {
                            FirstName = data[0],
                            LastName = data[1],
                            Address = new Address
                            {
                                Street = data[2],
                                City = data[3],
                                ZipCode = data[4]
                            },
                            Pesel = data[5],
                            Email = data[6]
                        };
                        persons.Add(person);
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Błąd odczytu danych: " + ex.Message);
            }

            return persons;
        }

        public void SaveData(List<Person> persons)
        {
            try
            {
                var lines = persons.Select(p =>
                    $"{p.FirstName},{p.LastName},{p.Address.Street},{p.Address.City},{p.Address.ZipCode},{p.Pesel},{p.Email}");

                File.WriteAllLines(FilePath, lines);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Błąd zapisu danych: " + ex.Message);
            }
        }
    }

    class Program
    {
        static void Main()
        {
            CsvDataManager dataManager = new CsvDataManager();
            List<Person> persons = dataManager.ReadData();

            while (true)
            {
                Console.WriteLine("Menu Główne:");
                Console.WriteLine("1. Wyświetl dane");
                Console.WriteLine("2. Dodaj osobę");
                Console.WriteLine("3. Modyfikuj osobę");
                Console.WriteLine("4. Usuń osobę");
                Console.WriteLine("5. Wyjście z programu");

                Console.Write("Wybierz opcję: ");
                string choice = Console.ReadLine();

                switch (choice)
                {
                    case "1":
                        DisplayData(persons);
                        break;
                    case "2":
                        AddPerson(persons);
                        break;
                    case "3":
                        ModifyPerson(persons);
                        break;
                    case "4":
                        DeletePerson(persons);
                        break;
                    case "5":
                        dataManager.SaveData(persons);
                        Environment.Exit(0);
                        break;
                    default:
                        Console.WriteLine("Nieprawidłowy wybór. Spróbuj ponownie.");
                        break;
                }
            }
        }

        static void DisplayData(List<Person> persons)
        {
            Console.WriteLine("\nLista osób:");
            foreach (var person in persons)
            {
                Console.WriteLine(person);
            }
        }

        static void AddPerson(List<Person> persons)
        {
            Person newPerson = new Person();
            try
            {
                Console.Write("Podaj imię: ");
                newPerson.FirstName = Console.ReadLine();

                Console.Write("Podaj nazwisko: ");
                newPerson.LastName = Console.ReadLine();

                Console.Write("Podaj ulicę: ");
                newPerson.Address = new Address
                {
                    Street = Console.ReadLine()
                };

                Console.Write("Podaj miasto: ");
                newPerson.Address.City = Console.ReadLine();

                Console.Write("Podaj kod pocztowy: ");
                newPerson.Address.ZipCode = Console.ReadLine();

                Console.Write("Podaj PESEL (11 cyfr): ");
                newPerson.Pesel = Console.ReadLine();
                if (newPerson.Pesel.Length != 11 || !int.TryParse(newPerson.Pesel, out _))
                {
                    throw new ArgumentException("Nieprawidłowy PESEL.");
                }

                Console.Write("Podaj adres e-mail: ");
                newPerson.Email = Console.ReadLine();
                if (!newPerson.Email.Contains("@"))
                {
                    throw new ArgumentException("Nieprawidłowy adres e-mail.");
                }

                persons.Add(newPerson);
                Console.WriteLine("Dodano osobę do bazy.");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Błąd dodawania osoby: " + ex.Message);
            }
        }

        static void ModifyPerson(List<Person> persons)
        {
            try
            {
                Console.Write("Podaj PESEL osoby do modyfikacji: ");
                string peselToModify = Console.ReadLine();

                Person personToModify = persons.FirstOrDefault(p => p.Pesel == peselToModify);

                if (personToModify == null)
                {
                    throw new ArgumentException("Osoba o podanym PESEL nie została znaleziona.");
                }

                Console.WriteLine($"Aktualne dane osoby: {personToModify}");
                Console.WriteLine("Podaj nowe dane:");

                Console.Write("Podaj imię: ");
                personToModify.FirstName = Console.ReadLine();

                Console.Write("Podaj nazwisko: ");
                personToModify.LastName = Console.ReadLine();

                Console.Write("Podaj ulicę: ");
                personToModify.Address.Street = Console.ReadLine();

                Console.Write("Podaj miasto: ");
                personToModify.Address.City = Console.ReadLine();

                Console.Write("Podaj kod pocztowy: ");
                personToModify.Address.ZipCode = Console.ReadLine();

                Console.Write("Podaj nowy adres e-mail: ");
                personToModify.Email = Console.ReadLine();

                Console.WriteLine("Osoba została zaktualizowana.");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Błąd modyfikacji osoby: " + ex.Message);
            }
        }

        static void DeletePerson(List<Person> persons)
        {
            try
            {
                Console.Write("Podaj PESEL osoby do usunięcia: ");
                string peselToDelete = Console.ReadLine();

                Person personToDelete = persons.FirstOrDefault(p => p.Pesel == peselToDelete);

                if (personToDelete == null)
                {
                    throw new ArgumentException("Osoba o podanym PESEL nie została znaleziona.");
                }

                persons.Remove(personToDelete);
                Console.WriteLine("Osoba została usunięta z bazy.");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Błąd usuwania osoby: " + ex.Message);
            }
        }
    }
}
