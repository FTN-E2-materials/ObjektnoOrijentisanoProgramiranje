package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;

public class Student extends Osoba {

	private String smer; 
	private int brIndeksa; 
	private int godinaUpisa;
	private HashMap<String, Predmet> predmeti;
	
	
	public Student() {
		super();
		this.predmeti = new HashMap<String, Predmet>();
		this.smer="RA";
		this.brIndeksa=123;
		this.godinaUpisa=2017;
	}
	
	public Student(String ime, String prezime, String smer, int brIndeksa, int godinaUpisa, HashMap<String, Predmet> predmeti) {
		this.ime=ime;
		this.prezime=prezime;
		this.smer=smer;
		this.brIndeksa=brIndeksa;
		this.godinaUpisa=godinaUpisa;
		this.predmeti=predmeti;
	}
	
	public Student(String ime, String prezime, String smer, int brIndeksa, int godinaUpisa) {
		this.ime=ime;
		this.prezime=prezime;
		this.smer=smer;
		this.brIndeksa=brIndeksa;
		this.godinaUpisa=godinaUpisa;
		this.predmeti= new HashMap<String, Predmet>();
	}

	public String getSmer() {
		return smer;
	}

	public void setSmer(String smer) {
		this.smer = smer;
	}

	public int getBrIndeksa() {
		return brIndeksa;
	}

	public void setBrIndeksa(int brIndeksa) {
		this.brIndeksa = brIndeksa;
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	
	public HashMap<String, Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(HashMap<String, Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	@Override
	public String toString() {
		String s = "Zovem se : "+ime + " prezivam se : " + prezime + " broj indeksa mi je : " + smer+"-"+brIndeksa+"/"+godinaUpisa+"\n"+"Predmeti koje slusam su : ";
		
		for (Predmet predmet : predmeti.values()) {
			s+="\n";
			s+=predmet.toString();
		}
		
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student s = (Student) obj;
		
		boolean b= false;
		
		if(this.brIndeksa == s.brIndeksa && this.godinaUpisa == s.godinaUpisa && this.smer.equals(s.smer))
			b=true;
		
		
		return b;
	}
}
