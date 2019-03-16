package z21;

public class Student {
	
	private String indeks, ime, prezime;

	public Student(String indeks, String ime, String prezime) {
		this.indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public Student(Student s) {
		this.indeks = s.indeks;
		this.ime = s.ime;
		this.prezime = s.prezime;
	}

	public String getIndeks() {
		return indeks;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	@Override
	public String toString() {
		return "Student [indeks = " + indeks + ", ime = " + ime + ", prezime = " + prezime + "]";
	}

}
