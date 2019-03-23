
import javax.swing.*;
import net.sourceforge.jheader.*;
import net.sourceforge.jheader.gui.TagTable;

public class GUI {

	public static GUI app;
	public JpegHeaders Headers;
	public App1Header App1Header;
	private JFrame frame;
	private JPanel obrazek;
	private JLabel label;
	private TagTable table;

	public static void main(String[] args) {
		app = new GUI();
		app.Run();

	}

	public void Run() {

		try // kontrola bledow
		{
			JpegHeaders.preheat();

			// ---------------------------------------------------------------
			// Tworzenie okna JFRAME gdzie wszystko bedzie sie wyswietlac

			frame = new JFrame("Exif Information Editor"); // nowy obiekt JFrame ktory bedzie zawierac reszte rzeczy, deklaracja z nazwa

			frame.setSize(1200, 600); // wielkosc okienka
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // zamkniecie okna na koncu aplikacji?
			// ---------------------------------------------------------------

			// Tworzenie i ustawianie przyciskow

			JButton wczytaj = new JButton("Open files"); // Tworzenie nowego obiektu(przycisku) odrazu z napisem

			JButton zapisz = new JButton("Save files"); // Tworzenie nowego obiektu(przycisku) odrazu z napisem
			
			wczytaj.setBounds(20, 20, 150, 20); // wielkość i polozenie
												// przycisku wczytaj
			zapisz.setBounds(200, 20, 150, 20); // wielkość i polozenie
												// przycisku zapisz

			frame.add(wczytaj); // dodanie do obiektu frame przycisku wczytaj
			frame.add(zapisz); // dodanie do obiektu frame przycisku zapisz

			// ---------------------------------------------------------------

			// Ustawienie obrazka

			obrazek = new JPanel(); // tworzenie nowego Jpanel o nazwie obrazek ktory bedzie wyswietlac zdjecie
			obrazek.setVisible(true); // nie wiem po co to jest ale chyba jest zbedne
			obrazek.setBounds(550, 40, 600, 450); // wymiary obrazka

			label = new JLabel();
			// // construct an editable tag table
			table = new TagTable(frame, true);
			//
			// // Wyswietlanie tabelki
			JScrollPane scroller = new JScrollPane(table); // wyswietlenie danych exif i edycji w nowym obiekcie JScrollPane
			frame.add(label); // dodanie label do frame

			wczytaj.addActionListener(new LoadButton(frame, obrazek, scroller, label, table)); 
																								
			zapisz.addActionListener(new SaveButton());
			// ---------------------------------------------------------------
			frame.setVisible(true); // wyswietlenie frame'a zeby bylo wszystko widoczne
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
