
public class Test {

	public static void main(String[] args) {
		
		TeretniVoz tv = new TeretniVoz(3, 100);
		System.out.println(tv);
		System.out.println(tv.getMarkaNajtezeRobe());
		
		Roba r = new Roba();
		Roba r2 = new Roba("Adidas", "patike", 2);
		Roba r3 = new Roba("Adidas", "trenerka", 1);

		System.out.println(tv.utovariTeret(r, 1));
		System.out.println(tv.utovariTeret(r2, 2));
		System.out.println(tv.utovariTeret(r3, 2));
		System.out.println(tv);

		System.out.println(tv.getMarkaNajtezeRobe());
		System.out.println(tv.getSlobodanProstor(0));
		System.out.println(tv.getSlobodanProstor(1));
		System.out.println(tv.getSlobodanProstor(2));
		System.out.println(tv.getSlobodanProstor(3));

	}

}
