package operations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import model.Osoba;
import model.Predmet;
import model.Student;
import model.StudentskaSluzba;

public class App {

	
	public static void main(String[] args) {
		
		Osoba o = new Osoba();
		Osoba o2 = new Osoba("Ime", "Prezime");
		o.setIme(o2.getIme());
		o.setPrezime(o2.getPrezime());
		Predmet p = new Predmet();
		Predmet p2 = new Predmet("Objektno", 100);
		p.setNaziv(p2.getNaziv());
		p.setOsvojeniBrojPoena(p2.getOsvojeniBrojPoena());
		Student s = new Student();
		HashMap<String, Predmet> mapa = new HashMap<String, Predmet>();
		mapa.put(p.getNaziv(), p);
		mapa.put(p2.getNaziv(), p2);
		Student s1 = new Student("Marko", "Markovic", "RA", 123, 2000, mapa);
		s.setBrIndeksa(s1.getBrIndeksa());
		s.setGodinaUpisa(s1.getGodinaUpisa());
		s.setSmer(s1.getSmer());
		s.setPredmeti(s1.getPredmeti());
		System.out.println(s);
		
		String text = LoadFromFile("IspitniRok.txt");
		StudentskaSluzba ss = new StudentskaSluzba();
		ss.ucitajIspitniRok(text);
		System.out.println(ss);
		ss.polozili("PJISP");
	}
	
	public static void SaveToFile(String text, String file) {
		
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file));
			out.write(text);
		
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Neuspelo cuvanje u fajl");
        } finally {
            if(out != null){
                try {
                    out.close();
                } catch (Exception e) {
        			e.printStackTrace();
        			System.out.println("Neuspelo zatvaranje fajla nakon upisa");
                }
            }
        }
		
		
	}
	

	public static String LoadFromFile(String fileLocation) {
		
		BufferedReader in = null;
		
		String returnValue = "";
		String line;
		try {
			in = new BufferedReader(new FileReader(fileLocation));
			while ((line = in.readLine()) != null) {
					returnValue+=line;
			}
		} catch (Exception e) {
			returnValue= "Neuspesno ucitavanje fajla";
			e.printStackTrace();
			System.out.println("Neuspesno ucitavanje fajla");
		
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (Exception e) {
                	returnValue="Neuspesno zatvaranje fajla nakon citanja";
        			e.printStackTrace();
        			System.out.println("Neuspesno zatvaranje fajla nakon citanja");
                }
            }
        }
		
		return returnValue;
	}
	
	
	
	
}
