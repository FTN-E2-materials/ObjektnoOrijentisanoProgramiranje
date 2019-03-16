package podaci;

import java.util.ArrayList;

public class Racunar {
	
	private ArrayList<Aplikacija> aplikacije = new ArrayList<Aplikacija>();
	private double slobodnaMemorija;
	
	public Racunar(double slobodnaMemorija) {
		super();
		this.slobodnaMemorija = slobodnaMemorija;
		
	}

	public Racunar() {
		super();
		slobodnaMemorija = 15000;
		// TODO Auto-generated constructor stub
	}
	
	public void pokreniAplikacije(String ulaz) {
		
		String[] linije = ulaz.split(";");
		
		for(int i = 0; i < linije.length; i++) {
		
			String[] delovi = linije[i].split(",");
			
			if (delovi.length == 2) {
			
				String nazivAplikacije = delovi[0];
				String memorija = delovi[1];
				double zauzetaMemorija = 0;
				
				if (memorija.contains("gb")) {
					memorija = memorija.substring(0, memorija.length() - 2);
					zauzetaMemorija = Double.parseDouble(memorija) * 1024;
				} else {
					memorija = memorija.substring(0, memorija.length() - 2);
					zauzetaMemorija = Double.parseDouble(memorija);
				}
				
				DodajAplikaciju(new Aplikacija(nazivAplikacije, zauzetaMemorija));
			}
		}
		
	}
	
	public void DodajAplikaciju(Aplikacija a) {

		if (slobodnaMemorija >= a.getZauzetaMemorija()) {
			slobodnaMemorija -= a.getZauzetaMemorija();
			aplikacije.add(a);
		}
	}
	
	public void Zaustavi(String naziv) {

		for (int i = 0; i < aplikacije.size(); i++) {
			
			Aplikacija a = aplikacije.get(i);
			if (a.getNaziv().equals(naziv)) {
				slobodnaMemorija += a.getZauzetaMemorija();
				aplikacije.remove(i);
				break;
			}
		}
	}
	
	public void sortiraj() {
		
		for(int i = 0; i < aplikacije.size() - 1; i++) {
			for (int j = i + 1; j < aplikacije.size(); j++) {
				
				Aplikacija a1 = aplikacije.get(i);
				Aplikacija a2 = aplikacije.get(j);
				
				if (a1.getZauzetaMemorija() > a2.getZauzetaMemorija()) {
					aplikacije.remove(i);
					aplikacije.add(i, a2);
					
					aplikacije.remove(j);
					aplikacije.add(j, a1);
				}
				
			}
		}
	}

	@Override
	public String toString() {
		
		String ret = "";
		
		ret += "Racunar:\n";
		ret += "Slobodna memorija: " + slobodnaMemorija + "\n";
		ret += "Programi:\n";
		
		for (int i = 0; i < aplikacije.size(); i++) {
			ret += aplikacije.get(i) + "\n";
		}
		
		return ret;
		
	
	}
	
	
	
	
}
