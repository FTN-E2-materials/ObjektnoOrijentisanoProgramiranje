package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import operations.App;

public class StudentskaSluzba {

	private ArrayList<Student> studenti; // Pametnije je ovde koristi HashMapu ali bi se kljuc sastojao iz tri polja 
	
	public StudentskaSluzba() {
		studenti= new ArrayList<Student>();
	}
	
	public void ucitajIspitniRok(String text) {
		String [] redovi = text.split(";");
		String predmet;
		String ime;
		String prezime;
		String punIndeks;
		String smer;
		String brojIndeksaText;
		int brojIndeksa;
		String godinaUpisaText;
		int godinaUpisa;
		String brojPoenaText;
		int brojPoena;
		
		
		for (String string : redovi) {
			string.trim();
			String student[] = string.split(","); // Oba nacina pravljenja niza
			
			predmet = student[0];
			ime= student[1];
			prezime = student[2];
			punIndeks = student[3];
			String deloviIndeksa[] = punIndeks.split("-");
			smer = deloviIndeksa[0];
			String brojevi[] = deloviIndeksa[1].split("/");
			brojIndeksaText = brojevi[0];
			godinaUpisaText = brojevi[1];
			
			
			try {
			 brojIndeksa=	Integer.parseInt(brojIndeksaText);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Nije uspelo konvertovanje brojaIndeksa");
				break;
			}
			
			try {
				godinaUpisa = Integer.parseInt(godinaUpisaText);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Nije uspelo konvertovanje godineUpisa");
				break;
			}
			
			brojIndeksaText = student[4];
			
			
			try {
				brojPoena = Integer.parseInt(brojIndeksaText);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Nije uspelo konvertovanje brojaPoena");
				break;
			}
			
			
			Student temp = new Student(ime,prezime,smer,brojIndeksa, godinaUpisa);
			Predmet p = new Predmet(predmet, brojPoena);
			boolean postoji = false;
			for (Student s : this.studenti) {
				if(s.equals(temp)) {
					postoji=true;
					if(s.getPredmeti().containsKey(predmet)) {
						Predmet trenutni = s.getPredmeti().get(predmet);
						if(trenutni.getOsvojeniBrojPoena()< p.getOsvojeniBrojPoena()) {
							s.getPredmeti().get(predmet).setOsvojeniBrojPoena(p.getOsvojeniBrojPoena());
						}
					}else {
						s.getPredmeti().put(predmet, p);
					}
				}
			}
			
			if(!postoji) {
				temp.getPredmeti().put(predmet, p);
				studenti.add(temp);
			}
			
			
		}
		
		
	}
	
	
	private ArrayList<Student> sortiraj(ArrayList<Student> studenti, String predmet){
		
		Student tempI;
		Student tempJ;
		
		for(int i = 0; i < studenti.size() - 1; i++){
			for(int j = i + 1; j <studenti.size(); j++ ){
				
				if(studenti.get(i).getPredmeti().get(predmet).getOsvojeniBrojPoena()<studenti.get(j).getPredmeti().get(predmet).getOsvojeniBrojPoena() ) {
					tempI = studenti.get(i);
					tempJ = studenti.get(j);
					studenti.remove(j);
					studenti.add(j, tempI);
					studenti.remove(i);
					studenti.add(i, tempJ);
				}
			}
		}
		
		
		return studenti;
	}
	
	public void polozili(String predmet) {
		
		ArrayList<Student> studentiKojiSuPolozili = new ArrayList<Student>();
		
		
		for (Student student : studenti) {
			
			if(student.getPredmeti().containsKey(predmet)) {
				
				if(student.getPredmeti().get(predmet).getOsvojeniBrojPoena()>=51) {
					studentiKojiSuPolozili.add(student);
				}
			}
			
		}
		
		studentiKojiSuPolozili= sortiraj(studentiKojiSuPolozili, predmet);
		
		String text ="";
		
		for (Student student : studentiKojiSuPolozili) {
			text+=student.getSmer() + "-" + student.getBrIndeksa()+"/"+student.getGodinaUpisa() + " " + student.getIme() + " " + student.getPrezime() + " " + student.getPredmeti().get(predmet).getOsvojeniBrojPoena() + ";\n";
		}
		String file = predmet + ".txt";
		App.SaveToFile(text, file);
		
		
		
	}
	
	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	@Override
	public String toString() {
		
		String s = "";
		
		for (Student student : studenti) {
			s+=student.toString();
			s+="\n";
		}
		
		return s;
	}
	
}
