package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Personalizar;

@SuppressWarnings("serial")
public class FuncionalidadesPanel extends JPanel{
	private JTabbedPane jTabbedPabe;
	private AbaPerfilPanel abaPerfilPanel;
	private AbaObjetivosPanel abaObjetivosPanel;
	
	public FuncionalidadesPanel(){
		setLayout(null);
		jTabbedPabe = new JTabbedPane();
		jTabbedPabe.setBackground(Personalizar.roxoClaro);
		jTabbedPabe.setBackground(Personalizar.branco);
		abaPerfilPanel = new AbaPerfilPanel();
		abaObjetivosPanel = new AbaObjetivosPanel();
		jTabbedPabe.addTab("Perfil", abaPerfilPanel);
		jTabbedPabe.addTab("Objetivos", abaObjetivosPanel);
		add(jTabbedPabe);
		jTabbedPabe.setBounds(0,20,800,600);
		setBackground(Personalizar.roxoClaro);
		
	}

	public AbaObjetivosPanel getAbaObjetivosPanel() {
		return abaObjetivosPanel;
	}

	public void setAbaObjetivosPanel(AbaObjetivosPanel abaObjetivosPanel) {
		this.abaObjetivosPanel = abaObjetivosPanel;
	}

	public void setAbaPerfilPanel(AbaPerfilPanel abaPerfilPanel) {
		this.abaPerfilPanel = abaPerfilPanel;
	}

	public AbaPerfilPanel getAbaPerfilPanel() {
		return abaPerfilPanel;
	}
	
}
