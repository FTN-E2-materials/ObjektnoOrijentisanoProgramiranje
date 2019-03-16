using System;
using System.IO;

namespace temp
{
    class Program
    {
        static void Main(string[] args)
        {
            /*
             * Testiranje klase osoba
             * Osoba o = new Osoba();
            Osoba o1 = new Osoba("Pera", "Peric");

            Console.WriteLine(o);
            Console.WriteLine(o1);*/

            /*
             * Testiranje klase predmet
            Predmet p = new Predmet();
            Predmet p1 = new Predmet("PJISP", 100);

            Console.WriteLine(p);
            Console.WriteLine(p1);
            */

            /*
             * Testiranje funkcije student
            Student s = new Student();
            Student s1 = new Student("Pera", "Peric", "PR", 156, 1987);

            Console.WriteLine(s);
            Console.WriteLine(s1);
            */

            //TESTIRANJE GLAVNIH FUNKCIJA
            StudentskaSluzba sluzba = new StudentskaSluzba();
            sluzba.UcitajIspitniRok(LoadFromFile("IspitniRok.txt"));
            Console.WriteLine(sluzba); 
            sluzba.Polozili("OBJEKTNO");
            sluzba.Polozili("ANALIZA");

        }

        public static void SaveToFile(string path, string data)
        {
            StreamWriter str = null;

            try
            {
                str = new StreamWriter(path);
                str.WriteLine(data);
                str.Close();
            }
            catch
            {
                Console.WriteLine("Greska..");
            }
        }

        public static string LoadFromFile(string path)
        {
            StreamReader str;
            string linija;
            string retVal = "";

            try
            {
                str = new StreamReader(path);
                while ((linija = str.ReadLine()) != null)//paziti ukoliko se koristi "str.ReadToEnd", ostatak koda mora biti drugaciji, jer novi redovi tj. "\n" ostanu u stringu
                {
                    retVal += linija;
                }
                str.Close();
            }
            catch
            {
                Console.WriteLine("Greska pri otvaranju/zatvaranju fajla");
            }

            return retVal;
        }
    }
}
