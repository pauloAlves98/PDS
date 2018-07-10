package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Personalizar;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
	private CardLayout cardLayout;
	private JPanel panelParaCard ;
	private HomePanel homePanel;
	private FuncionalidadesPanel funcionalidadesPanel;
	private static TelaPrincipal instance;// singleton
	
	private TelaPrincipal() {
		
		
		//setUndecorated(true);
		cardLayout = new CardLayout();
		panelParaCard = new JPanel();
		homePanel = new HomePanel();
		funcionalidadesPanel = new FuncionalidadesPanel();
		
		panelParaCard.setLayout(cardLayout);
		cardLayout.addLayoutComponent(funcionalidadesPanel,"funcionalidades");
		cardLayout.addLayoutComponent(homePanel,"login");
		
		panelParaCard.add(homePanel);
		panelParaCard.add(funcionalidadesPanel);
		
		add(panelParaCard);
		
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(Personalizar.roxoClaro);
		
	}
	
	public void mudarPanel(String nomePanel) {
		cardLayout.show(panelParaCard,nomePanel);
	}
	
	public static TelaPrincipal getInstance() {
		if(instance == null) 
			instance = new TelaPrincipal();
		return instance;
	}
	

	public HomePanel getHomePanel() {
		return homePanel;
	}

	public FuncionalidadesPanel getFuncionalidadesPanel() {
		return funcionalidadesPanel;
	}
	
}
