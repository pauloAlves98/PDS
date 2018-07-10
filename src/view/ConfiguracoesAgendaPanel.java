package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.text.MaskFormatter;

public class ConfiguracoesAgendaPanel extends JPanel{
	private JLabel titleLabel;
	private JButton confirmarEdicao;
	ArrayList<DiaConfigPanel> diasConfigPanel = new ArrayList<>();
	public static String diasDaSemana[] = {"Domingo","Segunda","Terça","Quarta","Quinta","Sexta","Sabado"};
	
	public ConfiguracoesAgendaPanel() {
		super(new BorderLayout(10,10));
		titleLabel = new JLabel("Selecione os dias de estudo");
		confirmarEdicao = new JButton("Confirmar Alteração");
		
		for(int i = 0 ; i < 7 ; i++)
			diasConfigPanel.add(new DiaConfigPanel(diasDaSemana[i],2));
		
		// panel apenas para organizar dias e suas configurações na tela
		JPanel auxPanel = new JPanel(new GridLayout(1,7));
		for(DiaConfigPanel e :diasConfigPanel) {
			JPanel auxInterno = new JPanel(new BorderLayout(5,5));
			auxInterno.add(e,BorderLayout.CENTER);
			auxInterno.add(new JSeparator(JSeparator.VERTICAL),BorderLayout.WEST);
			auxPanel.add(auxInterno);
		}
		//panel que Felipe mandou
		JPanel panelFelipe = new JPanel(null);
		panelFelipe.setPreferredSize(new Dimension(470,200));
		
		JCheckBox chckbxDomingo = new JCheckBox("Domingo");
		chckbxDomingo.setBounds(21, 131, 78, 23);
		panelFelipe.add(chckbxDomingo);
		
		JCheckBox chckbxSegunda = new JCheckBox("Segunda");
		chckbxSegunda.setBounds(103, 131, 78, 23);
		panelFelipe.add(chckbxSegunda);
		
		JCheckBox chckbxTera = new JCheckBox("Ter\u00E7a");
		chckbxTera.setBounds(183, 131, 62, 23);
		panelFelipe.add(chckbxTera);
		
		JCheckBox chckbxQuarta = new JCheckBox("Quarta");
		chckbxQuarta.setBounds(247, 131, 67, 23);
		panelFelipe.add(chckbxQuarta);
		
		JCheckBox chckbxQuinta = new JCheckBox("Quinta");
		chckbxQuinta.setBounds(311, 131, 62, 23);
		panelFelipe.add(chckbxQuinta);
		
		JCheckBox chckbxSexta = new JCheckBox("Sexta");
		chckbxSexta.setBounds(375, 131, 62, 23);
		panelFelipe.add(chckbxSexta);
		
		JCheckBox chckbxSabado = new JCheckBox("Sabado");
		chckbxSabado.setBounds(439, 131, 97, 23);
		panelFelipe.add(chckbxSabado);
		
		JLabel lblDiasDaSemana = new JLabel("Dias Da Semana");
		lblDiasDaSemana.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiasDaSemana.setBounds(210, 103, 146, 14);
		panelFelipe.add(lblDiasDaSemana);
		
		JLabel lblMaterias = new JLabel("Materias");
		lblMaterias.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaterias.setBounds(233, 52, 97, 23);
		panelFelipe.add(lblMaterias);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(207, 76, 113, 20);
		panelFelipe.add(comboBox);
		
		JLabel lblSeleciondeOsDias = new JLabel("Selecionde os dias que podera estudar cada materia");
		lblSeleciondeOsDias.setBounds(31, 27, 329, 14);
		panelFelipe.add(lblSeleciondeOsDias);
		// fim dados felipe
		
		
		add(titleLabel,BorderLayout.NORTH);
		add(auxPanel);
		add(panelFelipe,BorderLayout.SOUTH);
	}
	
	
	public class DiaConfigPanel extends JPanel {
		private JLabel nomeDiaLabel;
		private JCheckBox checkBox;		
		private ArrayList<JFormattedTextField> horariosField = new ArrayList<>();
		public DiaConfigPanel(String nomeDia, int quantidadeHorarios) {
			nomeDiaLabel = new JLabel(nomeDia);
			JLabel descricaodoPanelLabel = new JLabel("Horario Disponivel");
			checkBox = new JCheckBox();
			// adicao de mascara e instanciação de campos de texto para pegar horario(s) disponiveis na quele dia
			MaskFormatter mask = null;
			try {
				mask = new MaskFormatter();
				mask.setMask(" ##:## as ##:## ");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			for(int i = 0 ; i <quantidadeHorarios ; i ++) {
				JFormattedTextField f = new JFormattedTextField(mask);
				f.setColumns(8);
				horariosField.add(f);
			}
			//sets
			setPreferredSize(new Dimension(110,170));
			setBackground(Color.LIGHT_GRAY);
			// adicao a raiz
			add(nomeDiaLabel);
			add(checkBox);
			add(descricaodoPanelLabel);
			for(JFormattedTextField e : horariosField)
				add(e);
		}
		public JCheckBox getCheckBox() {
			return checkBox;
		}
		public ArrayList<JFormattedTextField> getHorariosField() {
			return horariosField;
		}
		
	}
	public static void main(String[] args) {
			JFrame f = new JFrame();
			f.setLayout(new FlowLayout());
			f.add(new ConfiguracoesAgendaPanel());
			f.setSize(800,600);
			f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
			f.setVisible(true);
		
	}
}

