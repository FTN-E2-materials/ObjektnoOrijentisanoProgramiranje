package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import podaci.Aplikacija;
import podaci.Racunar;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aplikacija a = new Aplikacija();
		
		Racunar r = new Racunar();
		
		r.DodajAplikaciju(a);
		System.out.println(r);
		
		r.Zaustavi(a.getNaziv());
		System.out.println(r);
		
		String x = loadFromFile("Aplikacije.txt");
		r.pokreniAplikacije(x);
		r.sortiraj();
		saveToFile(r.toString(), "Sortirani.txt");
		
	}
	
	public static void saveToFile(String text, String file) {
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(text);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String loadFromFile(String file) {
		
		BufferedReader br = null;
		String nekaPromenljiva = "";
		try {
			br = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = br.readLine()) != null) {
				nekaPromenljiva += line;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return nekaPromenljiva;
	}

}
