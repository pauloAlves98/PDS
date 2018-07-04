package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Personalizar;
//iniciação,elaboração,constução, transformação;
@SuppressWarnings("serial")
public class ObjetivosPanel extends JPanel {
	private JButton adicionarButton = new JButton("Adicionar objetivo");
	private Box verticalBox ;
	private JPanel panelObInfo;
	private static  DialogCadastroObjetivo dialogCadastroObjetivo;
	private ArrayList<ObjetivoInfoPanel>objetivosInfoPanel = new ArrayList<ObjetivoInfoPanel>();
	public ObjetivosPanel() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(800,550));
		panelObInfo = new JPanel();
		
		dialogCadastroObjetivo = new DialogCadastroObjetivo();
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.NORTH);
		panel.setBackground(Personalizar.violeta);
		JLabel lblObjetivos = new JLabel("Objetivos");
		lblObjetivos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblObjetivos);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(30);
		scrollPane.setViewportView(panel_1);
		panel_1.setBackground(Personalizar.violeta);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flow = (FlowLayout) panel_2.getLayout();
		flow.setAlignment(FlowLayout.CENTER);
		panel_2.add(adicionarButton,BorderLayout.NORTH);
		panel_2.setBackground(Personalizar.violeta);
		panel_2.setPreferredSize(new Dimension(480,30));
		setBackground(Personalizar.violeta);
		verticalBox = Box.createVerticalBox();
		JPanel panelVertical = new JPanel();
		panelVertical.setBackground(Personalizar.violeta);
		Box v =  Box.createVerticalBox();
		v.add(panel_2);
		v.add(panelVertical);
		panelVertical.add(verticalBox);
		panel_1.add(v);//panel1 é o panel do ScroolPane
		//verticalBox.add(panel_2);//panel 2 é o panel do do butão
		

	}
	
	
	
	public ArrayList<ObjetivoInfoPanel> getObjetivosInfoPanel() {
		return objetivosInfoPanel;
	}



	public void setObjetivosInfoPanel(ArrayList<ObjetivoInfoPanel> objetivosInfoPanel) {
		this.objetivosInfoPanel = objetivosInfoPanel;
	}



	public JButton getAdicionarButton() {
		return adicionarButton;
	}



	public Box getVerticalBox() {
		return verticalBox;
	}



	public static DialogCadastroObjetivo getDialogCadastroObjetivo() {
		return dialogCadastroObjetivo;
	}



	public static void setDialogCadastroObjetivo(DialogCadastroObjetivo dialogCadastroObjetivo) {
		ObjetivosPanel.dialogCadastroObjetivo = dialogCadastroObjetivo;
	}



	public void setAdicionarButton(JButton adicionarButton) {
		this.adicionarButton = adicionarButton;
	}



	public void setVerticalBox(Box verticalBox) {
		this.verticalBox = verticalBox;
	}



	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(800,600);
		ObjetivosPanel objetivosPanel = new ObjetivosPanel();
		frame.add(objetivosPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}

}
