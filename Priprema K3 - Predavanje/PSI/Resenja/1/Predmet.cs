using System;
using System.Collections.Generic;
using System.Text;

namespace temp
{
    class Predmet
    {
        private string naziv;
        private int poeni;

        public string Naziv { get { return naziv; } set { naziv = value; } }
        public int Poeni { get { return poeni; } set { poeni = value; } }

        public Predmet()
        {
            naziv = "OBJEKTNO";
            poeni = 51;
        }

        public Predmet(string naziv, int poeni)
        {
            this.naziv = naziv;
            this.poeni = poeni;
        }

        public override string ToString()
        {
            return "Naziv predmeta:" + naziv + Environment.NewLine + "Broj osvojenih poena:" + poeni;
        }
    }
}
