import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    private final static String NAZWA_PLIKU_TEKSTOWEGO = "plikX.txt";

    public static void main(String[] args) throws FileNotFoundException {

        zapisDoPliku(NAZWA_PLIKU_TEKSTOWEGO);
        odczytZPliku(NAZWA_PLIKU_TEKSTOWEGO);

}

    private static void zapisDoPliku(String nazwaPliku) {
        int liczbaObiektow;
        String imie;
        String nazwisko;
        String numerAlbumu;

        // poniżej tworzymy obiekty klass Scanner oraz PrintWriter
        Scanner odczyt = null;
        PrintWriter zapis = null;


        try {
          // obiekt odczyt powolujemy do zycia tworzac jego instacje klasy Scanner (new SCanner)
            odczyt = new Scanner(System.in);
            System.out.print("Podaj liczbę studentow: ");
            liczbaObiektow = odczyt.nextInt();

            // Tutaj tworzymy liste obiektow klasy Student
            List<Student> studentList = new ArrayList<>();

            for (int i = 1; i < liczbaObiektow + 1; i++) {
                System.out.print("[student " + i + "] Podaj imie: ");
                imie = odczyt.next();

                System.out.print("[student " + i + "] Podaj nazwisko: ");
                nazwisko = odczyt.next();

                System.out.print("[student " + i + "] Podaj numer albumu: ");
                numerAlbumu = odczyt.next();

                Student student = new Student(imie, nazwisko, numerAlbumu);

                studentList.add(student);
            }

            /// Zapis do pliku
            zapis = new PrintWriter(NAZWA_PLIKU_TEKSTOWEGO);
            for (Student student : studentList) {
                zapis.println(student.info());
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (odczyt != null)
                odczyt.close();
            if (zapis != null)
                zapis.close();
        }
    }

    private static void odczytZPliku(String nazwaPliku) {
        System.out.println("Odczytuje plik tekstowy: " + nazwaPliku);
        List<Student> studentList = new ArrayList<>();
        try {
            File file = new File(nazwaPliku);
            Scanner dane = new Scanner(file);
            //odzytujemy wiersze z naszego pliku póki one są
            while (dane.hasNext()) {
                // robimy tablice wyrazów  z danej linii zczytanej z pliku - rozdzielająć ją po spacji
                String[] linia = dane.nextLine().split(" ");
                String imie = linia[0];
                String nazwisko = linia[1];
                String album = linia[2];
                Student student = new Student(imie, nazwisko, album);
                studentList.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Odczytani studenci:");
        for (Student student : studentList) {
            System.out.println(student.infoSformatowane());
        }
    }
}
