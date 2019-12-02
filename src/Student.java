public class Student {

    private String imie;
    private String nazwisko;
    private String numerAlbumu;

    public Student(String imie, String nazwisko, String numerAlbumu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerAlbumu = numerAlbumu;
    }

    public Student(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String infoSformatowane() {
        return String.format("Student %s %s, album %s", imie, nazwisko, numerAlbumu);
    }

    public String info() {
        return String.format("%s %s %s", imie, nazwisko, numerAlbumu);
    }

    public String wyswietlNazwiskoAlbum() {
        return String.format("%s %s", nazwisko, numerAlbumu);
    }

    public void aktualizujAlbum(String numerAlbumu) {
        this.numerAlbumu = numerAlbumu;
    }


}
