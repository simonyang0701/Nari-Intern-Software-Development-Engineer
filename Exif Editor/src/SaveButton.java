
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.*;

import net.sourceforge.jheader.JpegFormatException;

public class SaveButton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
            
         //   SetTag.main(toString(GUI.app.Headers));
            
		if (GUI.app.Headers != null) {
			try {
				GUI.app.Headers.save(true);
			} catch (IOException | JpegFormatException e1) {
			}

		//	JOptionPane.showMessageDialog(null, "Zapisano plik.");

		}
	}
}
