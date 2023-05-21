package Sprawdzian1;

import javax.swing.*;
import java.awt.*;

public class ListaOsobHelper {

	public static GridBagConstraints ustawLokalizacje(GridBagConstraints c, int gridx, int gridy, int height, int width){
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridheight = height; // właściwość służąca do zajmowania wskazanej ilości wierszy przez komponent - o ile komórek komponent ma się rozciągnąć wertykalnie
		c.gridwidth = width; // właściwość służąca do zajmowania wskazanej ilości kolumn przez komponent - o ile komórek komponent ma się rozciągnąć horyzontalnie
		return c;
	}

	public static GridBagConstraints ustawLokalizacje(GridBagConstraints c, int gridx, int gridy){
		c.gridx = gridx;
		c.gridy = gridy;
		return c;
	}

	public static void dodajKomponentyDoRodzica(Component parent, Component... components){
		if (parent instanceof JMenuBar) {
			for (Component component : components) {
				((JMenuBar) parent).add(component);
			}
		}
		if (parent instanceof JPanel) {
			for (Component component : components) {
				((JPanel) parent).add(component);
			}
		}
	}
}
