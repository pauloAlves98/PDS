package view;

import javax.swing.JOptionPane;

public abstract class Mensagem {
	public static void exibirDialogo(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
