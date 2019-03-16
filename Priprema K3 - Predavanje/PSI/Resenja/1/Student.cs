using System;
using System.Collections.Generic;
using System.Text;

namespace temp
{
    class Student:Osoba
    {
        private string smer;
        private int broj;//broj indexa
        private int godina;
        private Dictionary<string, Predmet> predmeti;
        //druga verzija
        //private Dictionary<string, Predmet> predmeti = new Dictionary<string, Predmet>();

        public string Smer { get { return smer; } set { smer = value; } }
        public int Broj { get { return broj; } set { broj = value; } }
        public int Godina { get { return godina; } set { godina = value; } }
        public Dictionary<string, Predmet> Predmeti { get { return predmeti; } set { predmeti = value; } }

        public Student():base()
        {
            smer = "PR";
            broj = 156;
            godina = 1970;
            predmeti = new Dictionary<string, Predmet>();
        }

        public Student(string ime, string prezime, string smer, int broj, int godina):base(ime, prezime)
        {
            this.smer = smer;
            this.broj = broj;
            this.godina = godina;
            predmeti = new Dictionary<string, Predmet>();
        }

        public override string ToString()
        {
            string retVal = "";
            retVal += base.ToString();
            retVal += Environment.NewLine+ "Broj indexa:" + smer + "-" + broj + "/" + godina + Environment.NewLine;

            foreach(Predmet p in predmeti.Values)
            {
                retVal += p;
                retVal += Environment.NewLine;
            }

            return retVal;

        }
    }
}
