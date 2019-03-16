using System;
using System.Collections.Generic;
using System.Text;

namespace temp
{
    class StudentskaSluzba
    {
        List<Student> studenti;

        public StudentskaSluzba()
        {
            studenti = new List<Student>();
        }

        public void UcitajIspitniRok(string podaci)
        {
            string[] redovi = podaci.Split(';');

            string ime;
            string prezime;
            string smer;
            string ceoIndex;
            string brojString;
            string godinaStrint;
            string poeniString;
            string predmet;
            int broj;
            int godina;
            int poeni;


            foreach(string red in redovi)
            {
                
                string[] delovi = red.Split(',');
                if (delovi.Length!=5) continue; //u slucaju da je red prazan/samo razmaci/nema odgovarajuc broj zareza, preskace celu iteraciju
                                                //jako bitno, jer se u slucaju da ovo izostavimo mogu pojaviti "cudni" exceptioni
                predmet = delovi[0];
                ime = delovi[1];
                prezime = delovi[2];
                ceoIndex = delovi[3];
                poeniString = delovi[4];

                try
                {
                    poeni = Int32.Parse(poeniString);
                }
                catch
                {
                    Console.WriteLine("Greska pri konvertovanju...");
                    continue;//u slucaju da ne moze da konvertuje, preskace celu iteraciju
                }

                string[] deloviIndexa = ceoIndex.Split('-');
                smer = deloviIndexa[0];
                string[] deloviIndexa2 = deloviIndexa[1].Split('/');
                brojString = deloviIndexa2[0];
                godinaStrint = deloviIndexa2[1];

                try
                {
                    broj = Int32.Parse(brojString);
                    godina = Int32.Parse(godinaStrint);
                }
                catch
                {
                    Console.WriteLine("Greska pri konvertovanju...");
                    continue;//u slucaju da ne moze da konvertuje, preskace celu iteraciju
                }

                bool pronalsiSmoStudenta = false ;
                foreach(Student s in studenti)
                {
                    if(CheckIfExists(s, ime, prezime, smer, broj, godina))
                    {
                        pronalsiSmoStudenta = true;
                        if (s.Predmeti.ContainsKey(predmet))
                        {
                            s.Predmeti[predmet].Poeni = poeni;
                        }
                        else
                        {
                            Predmet nov = new Predmet(predmet, poeni);
                            s.Predmeti.Add(nov.Naziv, nov);
                        }
                        break;
                    }
                }

                if (!pronalsiSmoStudenta)
                {
                    Student s = new Student(ime, prezime, smer, broj, godina);
                    Predmet nov = new Predmet(predmet, poeni);

                    s.Predmeti.Add(nov.Naziv, nov);
                    studenti.Add(s);
                }

                


            }


        }

        public void Polozili(string predmet)
        {
            List<Student> polozili = new List<Student>();

            foreach(Student s in studenti)
            {
                if (s.Predmeti.ContainsKey(predmet))
                {
                    if (s.Predmeti[predmet].Poeni >= 51)
                    {
                        polozili.Add(s);
                    }
                }
            }

            /*
             * Jedan od primera ugradjenog sortiranja lista u C#
             * polozili.Sort(delegate(Student s1, Student s2)
            {
                return s2.Predmeti[predmet].Poeni.CompareTo(s1.Predmeti[predmet].Poeni);
            }
            );*/

            Sort(polozili, predmet);

            string zaIspis = "";

            foreach(Student s in polozili)
            {
                zaIspis += s.Smer + "-" + s.Broj + "/" + s.Godina + " " + s.Ime + " " + s.Prezime + " " + s.Predmeti[predmet].Poeni + Environment.NewLine;
            }

            Program.SaveToFile(predmet+".txt", zaIspis);
        }

        private void Sort(List<Student> lista, string predmet)
        {
            for (int i = 0; i < lista.Count; i++)//bubble sort algoritam, uredu je da se koristi bilo koji algoritam za sortiranje
            {
                for (int j = 0; j < lista.Count; j++)
                {
                    if (lista[i].Predmeti[predmet].Poeni > lista[j].Predmeti[predmet].Poeni)
                    {
                        Student temp = lista[i];
                        lista[i] = lista[j];
                        lista[j] = temp;
                    }

                }
            }
        }
        private bool CheckIfExists(Student s, string ime, string prezime, string smer, int broj, int godina)
        {
            if (s.Ime == ime && s.Prezime == prezime && s.Smer == smer && s.Broj == broj && s.Godina == godina)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public override string ToString()
        {
            string retVal = "";

            foreach(Student s in studenti)
            {
                retVal += s;
            }

            return retVal;
        }

    }
}
