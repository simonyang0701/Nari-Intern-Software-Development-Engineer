
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.sourceforge.jheader.JpegFormatException;
import net.sourceforge.jheader.JpegHeaders;
import net.sourceforge.jheader.gui.TagTable;

// Klasa odpowiadajaca za wcisniecie wczytaj oraz wczytywanie zdjecia
public class LoadButton implements ActionListener {

	private JFrame frame;
	private JPanel obrazek;
	private JScrollPane scroller;
	private JLabel label;
	private TagTable table;

	public LoadButton(JFrame frame, JPanel obrazek, JScrollPane scroller,JLabel label, TagTable table) {
		this.frame = frame;
		this.obrazek = obrazek;
		this.scroller = scroller;
		this.label = label;
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {


            
            JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File plik = fc.getSelectedFile(); // nazwa pliku ?

			
			String filename = plik.getName();
			String filePath = plik.getAbsolutePath();
                        
			try {
				GUI.app.Headers = new JpegHeaders(filePath);
			} catch (IOException | JpegFormatException e1) {
				e1.printStackTrace();
			}
			GUI.app.App1Header = GUI.app.Headers.getApp1Header();

                        
			frame.setTitle("Exifowy Edytor: " + filename);
			Component[] comp = obrazek.getComponents();
			if (comp.length > 0)
				obrazek.remove(comp[0]);

			obrazek.add(new JLabel(new ImageIcon(filePath)));
			if (obrazek.getParent() == frame)
				frame.remove(obrazek);

			frame.add(obrazek);
			table.loadData(GUI.app.App1Header);

			if (label.getComponents().length > 0)
				label.remove(label.getComponents()[0]);

			// Wyswietlanie tabelki
			scroller = new JScrollPane(table); // wyswietlenie danych exif i edycji w nowym obiekcie ScrollPane
			scroller.setBounds(20, 180, 500, 300); // wymiary i rozmiar tabelki
			label.add(scroller);
			frame.add(label); // dodanie label do frame

			// ---------------------------------------------------------------
			frame.setVisible(true); // wyswietlenie frame'a zeby bylo wszystko
			frame.revalidate();
			frame.repaint();
		}
	}
}
