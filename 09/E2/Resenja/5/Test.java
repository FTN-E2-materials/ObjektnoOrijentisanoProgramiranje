package z5;

public class Test {

	public static void main(String[] args) {
		Restoran r = new Restoran();
		System.out.println(r);
		System.out.println();
		
		//staviti fajl u folder od projekta (pored bin i src foldera)
		r.importJelovnik("Jelovnik.txt");
		System.out.println(r);
		System.out.println();
		
		r.sort();
		
		System.out.println(r);
		
		r.exportJelovnik("Jelovnik sredjen.txt");
		//nalazice se u folderu projekta (pored bin i src foldera)
	}


}
