package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Personalizar;

@SuppressWarnings("serial")
public class FuncionalidadesPanel extends JPanel{
	private JTabbedPane jTabbedPabe;
	private AbaPerfilPanel abaPerfilPanel;
	private AbaObjetivosPanel abaObjetivosPanel;
	private AbaAgendaPanel abaAgendaPanel;
	
	
	public FuncionalidadesPanel(){
		setLayout(null);
		jTabbedPabe = new JTabbedPane();
		jTabbedPabe.setBackground(Personalizar.roxoClaro);
		jTabbedPabe.setBackground(Personalizar.branco);
		abaPerfilPanel = new AbaPerfilPanel();
		abaObjetivosPanel = new AbaObjetivosPanel();
		abaAgendaPanel = new AbaAgendaPanel();
		jTabbedPabe.addTab("Perfil", abaPerfilPanel);
		jTabbedPabe.addTab("Objetivos", abaObjetivosPanel);
		jTabbedPabe.addTab("Agenda", abaAgendaPanel);
		add(jTabbedPabe);
		jTabbedPabe.setBounds(0,20,800,600);
		setBackground(Personalizar.roxoClaro);
		
	}

	public JTabbedPane getjTabbedPabe() {
		return jTabbedPabe;
	}

	public void setjTabbedPabe(JTabbedPane jTabbedPabe) {
		this.jTabbedPabe = jTabbedPabe;
	}

	public AbaAgendaPanel getAbaAgendaPanel() {
		return abaAgendaPanel;
	}

	public void setAbaAgendaPanel(AbaAgendaPanel abaAgendaPanel) {
		this.abaAgendaPanel = abaAgendaPanel;
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
