package z4;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class Files {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Osoba o = new Osoba("Marko", "Markovic");
		
		System.out.println("Upis osobe u datoteku...");
		save("javaObject.raw", o); //moze i druga fajl ekstenzija + moze i apsolutna putanja "C:\\javaObject.raw"
		
		System.out.println("Citanje osobe iz datoteke...");
		Osoba retO = load("javaObject.raw"); // ili "C:\\javaObject.raw" 
		System.out.println(retO);
		
		System.out.println("-------------------------------------");
		
		int redovi = unesiBroj();
		
		System.out.println("Broj redova je: " + redovi);
		
		System.out.println("Unesite zeljeni tekst:");
	    
		ArrayList<String> text = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
	    		
		for(int i=0; i<redovi; i++)
			text.add(in.nextLine());
			
		System.out.println("Upis zeljenog teksta u datoteku...");
		saveText("javaText.txt", text); // ili "C:\\javaText.txt"
		
		System.out.println("Citanje teksta iz datoteke...");
		ArrayList<String> ret = loadText("javaText.txt"); // ili "C:\\javaText.txt"
		
		for(int i=0; i<ret.size(); i++)
			System.out.println(ret.get(i));
		
	}
	
	//metoda koja se poziva rekurzivno sve dok korisnik ne unese broj
	@SuppressWarnings("resource")
	private static int unesiBroj(){
		int pom=0;
		Scanner in = new Scanner(System.in);
	    
		System.out.println("Koliko biste redova teksta da unesete u fajl?");
		
		try{
			pom = Integer.parseInt(in.nextLine());
			if (pom <= 0) {
				pom = unesiBroj();
			}
		} catch (Exception e) {
			System.out.println("Niste uneli broj!");
			pom = unesiBroj();
		}
		
		return pom;
	}
	
	//metoda koja snima objekat klase Osoba u fajl
	public static void save(String file, Osoba o){
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			out.writeObject(o);
		} catch (Exception e) {
			e.printStackTrace();
        } finally {
            if(out != null){
                try {
                    out.close();
                } catch (Exception e) {
        			e.printStackTrace();
                }
            }
        }
	}
	
	//metoda koja cita objekat klase Osoba iz fajla
	public static Osoba load(String file){
		ObjectInputStream in = null;
		Osoba ret = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			ret = (Osoba) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (Exception e) {
        			e.printStackTrace();
                }
            }
        }
		
		return ret;
	}

	//metoda koja snima multiline tekst u fajl
	public static void saveText(String file, ArrayList<String> text) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file));
			
			for(int i=0; i<text.size(); i++) {
				out.write(text.get(i));
				
				if(i!=text.size()-1)
					out.newLine();
			}
		} catch (Exception e){
			e.printStackTrace();
        } finally {
            if(out != null){
                try {
                    out.close();
                } catch (Exception e) {
        			e.printStackTrace();
                }
            }
        }
	}
	
	//metoda koja cita multiline tekst iz fajla
	public static ArrayList<String> loadText(String file) {
		BufferedReader in = null;
		String line;
		ArrayList<String> retVal = new ArrayList<String>();
		try {
			in = new BufferedReader(new FileReader(file));
			while ((line = in.readLine()) != null) {
				retVal.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (Exception e) {
        			e.printStackTrace();
                }
            }
        }
		
		return retVal;
	}

}
