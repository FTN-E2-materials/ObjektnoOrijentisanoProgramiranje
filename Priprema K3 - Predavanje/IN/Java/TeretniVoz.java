public class TeretniVoz {
	private Vagon[] vagoni;
	private int vagonMaxKG;
	
	public TeretniVoz(int brVagona, int maxDozvoljenoKG) {
		vagoni = new Vagon[brVagona];
		for(int i = 0; i < vagoni.length; ++i) {
			vagoni[i] = new Vagon();
		}
		vagonMaxKG = maxDozvoljenoKG;
	}
	
	public int getSlobodanProstor(int brVagona) {
		if(brVagona < 0 || brVagona >= vagoni.length) {
			return -1;
		}
	
		return vagonMaxKG - vagoni[brVagona].getTezinaRobe();
	}
	
	public boolean utovariTeret(Roba teret, int brVagona) {
		if (brVagona < 0 || brVagona >= vagoni.length) {
			return false;
		}
		
		if (teret.getTezinaKG() > this.getSlobodanProstor(brVagona)) {
			return false;
		}
		
		vagoni[brVagona].dodajRobu(teret);
        return true;
	}
    
	public String getMarkaNajtezeRobe() {
		int kgNajteze = 0;
		String markaNajteze = "PRAZAN";
		for(int i = 0; i < vagoni.length; ++i) {
			for(int j = 0; j < vagoni[i].getTeret().size(); ++j) {
				if(vagoni[i].getTeret().get(j).getTezinaKG() > kgNajteze) {
					markaNajteze = vagoni[i].getTeret().get(j).getMarka();
					kgNajteze = vagoni[i].getTeret().get(j).getTezinaKG();
				}
			}
		}
				
        return markaNajteze;
	}
	
	@Override
	public String toString() {
		String ret = "TERETNI VOZ\n";
        ret += "Maksimalna tezina po vagonu = " + vagonMaxKG + " KG\n";
        for(int i = 0; i < vagoni.length; ++i) {
            ret += "---------------------------------------\n";
            ret += vagoni[i];
            ret += "\n---------------------------------------\n";
        }
        return ret;
	}
}