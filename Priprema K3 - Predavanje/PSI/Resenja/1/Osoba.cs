using System;
using System.Collections.Generic;
using System.Text;

namespace temp
{
    class Osoba
    {
        protected string ime;
        protected string prezime;

        public string Ime { get { return ime; } set { ime = value; } }
        public string Prezime { get { return prezime; } set { prezime = value; } }

        public Osoba()
        {
            ime = "Prazno_ime";
            prezime = "Prazno_prezime";
        }

        public Osoba(string ime, string prezime)
        {
            this.ime = ime;
            this.prezime = prezime;
        }

        public override string ToString()
        {
            return "Ime:" + ime + Environment.NewLine + "Prezime:" + prezime;
        }
    }
}
