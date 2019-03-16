package z5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Restoran {
	private String naziv;
	private String adresa;
	private ArrayList<Stavka> jelovnik; //zbog sortiranja
	
	public Restoran(){
		naziv = "Masinac";
		adresa = "Trg Dositeja Obradovica 6";
		jelovnik = new ArrayList<Stavka>();
	}
	
	public void importJelovnik(String file){
		BufferedReader in = null;
		String naziv;
		double cena;
		String line;
		
		try {
			in = new BufferedReader(new FileReader(file));
			while ((line = in.readLine()) != null) {
				
				//razdvajanje po delimiteru |
				String[] lineParts = line.split("\\|");
				
				naziv = lineParts[0];
				cena = Double.parseDouble(lineParts[lineParts.length - 2]); // ili lineParts[1], ovde je dat primer kako da se pristupi nekom elementu sa kraja
				
				//dodavanje u jelovnik ako vec nema jela sa tim nazivom
				if(!nazivStavkePostoji(naziv)){
					jelovnik.add(new Stavka(naziv, cena));
				}
					
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
	}
	
	public void sort(){
		Stavka tempI, tempJ;
		for(int i = 0; i < jelovnik.size() - 1; i++){
			for(int j = i + 1; j <jelovnik.size(); j++ ){
				if(jelovnik.get(i).getCena() < jelovnik.get(j).getCena()){
					tempI = jelovnik.get(i);
					tempJ = jelovnik.get(j);
					jelovnik.remove(j);
					jelovnik.add(j, tempI);
					jelovnik.remove(i);
					jelovnik.add(i, tempJ);
				}
			}
		}
	}
	
	public void exportJelovnik(String file){
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file));
			
			out.write(this.toString()); //ovde mora eksplicitno toString da se pozove
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
	
	@Override
	public String toString() {
		String retVal = "Restoran \"" + naziv + "\"\n";
		retVal += "Adresa: " + adresa + "\n\n";
		retVal += "Jelovnik \n******************\n";
		for(Stavka s: jelovnik)
			retVal += s + "\n";
		retVal += "******************\n";
		return retVal;
	}
	
	
	
    // privatna pomocna metoda - nije obavezno
    private boolean nazivStavkePostoji(String nazivStavke)
    {
        for (Stavka s: jelovnik)
        {
            if (s.getNaziv().equals(nazivStavke))
                return true;
        }
        return false;
    }


}
