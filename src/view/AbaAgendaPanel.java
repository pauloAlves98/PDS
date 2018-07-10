package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AbaAgendaPanel extends JPanel{
	private AgendaPanel agendaPanel;
	private JButton configuracoesAgendaButton;
	
	public AbaAgendaPanel() {
		setLayout(new BorderLayout(10,10));
		agendaPanel = new AgendaPanel();
		configuracoesAgendaButton = new JButton("Configurações Da Agenda");
		
		// criando panel para armazenar botões do topo , inicialmente (agora) o de configurações
		JPanel topoPanel = new JPanel();
		FlowLayout layoutTopo =(FlowLayout) topoPanel.getLayout();
		layoutTopo.setAlignment(FlowLayout.RIGHT);
		topoPanel.add(configuracoesAgendaButton);
		// termino de definição de panel do topo
		
		//sets
	
		// adicionando a raiz
		add(topoPanel,BorderLayout.NORTH); // adicionando topo configurado
		add(agendaPanel,BorderLayout.CENTER);
		add(agendaPanel);
	}
	public AgendaPanel getAgendaPanel() {
		return agendaPanel;
	}

	public JButton getConfiguracoesAgendaButton() {
		return configuracoesAgendaButton;
	}
//	public static void main(String[] args) {
//		AbaAgendaPanel abaAgendaPanel  = new AbaAgendaPanel();
//		AbaAgendaPanel app = new AbaAgendaPanel();
//		JFrame f = new JFrame();
//		f.setLayout(new FlowLayout());
//		f.add(abaAgendaPanel);
//		f.setSize(800,600);
//		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
//		abaAgendaPanel.getAgendaPanel().getDias().get(0).getVerticalBox().add(new TopicoPanel("Portugues","Fonetica","Inconpleto","13:00","22:00"));
//		abaAgendaPanel.getAgendaPanel().getDias().get(1).getVerticalBox().add(new TopicoPanel("Portugues","Fonetica","Inconpleto","13:00","22:00"));
//		abaAgendaPanel.getAgendaPanel().getDias().get(1).getVerticalBox().add(new TopicoPanel("Portugues","Fonetica","Inconpleto","13:00","22:00"));
//		abaAgendaPanel.getAgendaPanel().getDias().get(2).getVerticalBox().add(new TopicoPanel("Portugues","Fonetica","Inconpleto","13:00","22:00"));
//		abaAgendaPanel.getAgendaPanel().getDias().get(3).getVerticalBox().add(new TopicoPanel("Portugues","Fonetica","Inconpleto","13:00","22:00"));
//		abaAgendaPanel.getAgendaPanel().getDias().get(3).getVerticalBox().add(new TopicoPanel("Portugues","Fonetica","Inconpleto","13:00","22:00"));
//		abaAgendaPanel.getAgendaPanel().getDias().get(3).getVerticalBox().add(new TopicoPanel("Portugues","Fonetica","Inconpleto","13:00","22:00"));
//		abaAgendaPanel.getAgendaPanel().getDias().get(4).getVerticalBox().add(new TopicoPanel("Portugues","Fonetica","Inconpleto","13:00","22:00"));
//		abaAgendaPanel.getAgendaPanel().getDias().get(5).getVerticalBox().add(new TopicoPanel("Portugues","Fonetica","Inconpleto","13:00","22:00"));
//		abaAgendaPanel.getAgendaPanel().getDias().get(6).getVerticalBox().add(new TopicoPanel("Portugues","Fonetica","Inconpleto","13:00","22:00"));
//		f.setVisible(true);
//		
//	}
}

class AgendaPanel extends JPanel{
	private ArrayList<DiaPanel> dias = new ArrayList<>();
	{
		dias.add(new DiaPanel("Domingo"));
		dias.add(new DiaPanel("Segunda"));
		dias.add(new DiaPanel("Terça"));
		dias.add(new DiaPanel("Quarta"));
		dias.add(new DiaPanel("Quinta"));
		dias.add(new DiaPanel("Sexta"));
		dias.add(new DiaPanel("Sábado"));
		
	}
	private JLabel titleLabel;
	public AgendaPanel (){
		super(new BorderLayout(10,10));
		titleLabel = new JLabel("Agenda");
		
		//Panel para armazenar dias da agenda
		JPanel diasPanel = new JPanel();
		diasPanel.setLayout(new GridLayout(1,7,10,2));
		for(DiaPanel e : dias)
			diasPanel.add(e);
		
		// adicionando a raiz
		add(titleLabel,BorderLayout.NORTH);
		add(diasPanel,BorderLayout.CENTER);
	}
	public ArrayList<DiaPanel> getDias() {
		return dias;
	}
	public void setDias(ArrayList<DiaPanel> dias) {
		this.dias = dias;
	}
	
}
class TopicoPanel extends JLabel{
	public TopicoPanel(String nomeMateria,String nomeTopico,String estado,String horaInicio,String horaFim) {
		setText("<html>"+nomeMateria+" - "+nomeTopico+"<br/>"
					+ "das "+horaInicio+" as "+horaFim+"<br/>"
						+ "Estado -> "+estado+"</html>");
		SecureRandom s = new SecureRandom();
		setForeground(new Color(s.nextInt(255),s.nextInt(255),s.nextInt(255)));
	}
}
class DiaPanel extends JPanel{
	JLabel titulo;
	Box verticalBox ;
	public DiaPanel(String title) {
		super(new BorderLayout());
		titulo = new JLabel(title);
		verticalBox = Box.createVerticalBox();
		setBackground(Color.white);
		add(BorderLayout.NORTH, titulo);
		add(BorderLayout.CENTER,verticalBox);
		
	}
	public JLabel getTitulo() {
		return titulo;
	}
	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}
	public Box getVerticalBox() {
		return verticalBox;
	}
	public void setVerticalBox(Box verticalBox) {
		this.verticalBox = verticalBox;
	}
	
}
