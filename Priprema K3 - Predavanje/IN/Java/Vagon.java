import java.util.ArrayList;

public class Vagon {
	private String opisTereta = "PRAZAN";
	private ArrayList<Roba> teret = new ArrayList<>();
	
	public ArrayList<Roba> getTeret() {
		return teret;
	}

	public int getTezinaRobe() {
		int suma = 0;
		for(int i = 0; i < teret.size(); ++i) {
			suma += teret.get(i).getTezinaKG();
		}
		return suma;
	}
	
	public void dodajRobu(Roba roba) {
		teret.add(roba);
		opisTereta = teret.get(0).getMarka();
		for(int i = 0; i < teret.size(); ++i) {
			if (teret.get(i).getMarka() != opisTereta) {
				opisTereta = "RAZNO";
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		String ret = "teret ";
		int count = teret.size();
		
		if (count == 0)
            ret += "prazan";
		for(int i = 0; i < teret.size(); ++i) {
			ret += teret.get(i);
			if (i < count - 1)
				ret += ", ";
		}
		ret += " > opisTereta = \"" + opisTereta + "\"";

		return ret;
	}
}