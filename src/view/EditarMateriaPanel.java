package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Personalizar;

public class EditarMateriaPanel extends ManipularMateria {
	JComboBox escolhaMateriaBox;
	JButton adiconarTopicoButton,adicionarTopico;
	private JTextArea areaTopicos;
	public EditarMateriaPanel(){
		super();
		JLabel lbl = new JLabel("Escolha a Matéria");
		lbl.setBounds(10, 37, 207, 33);
		escolhaMateriaBox = new JComboBox();
		escolhaMateriaBox .setBounds(10, 74, 200, 33);
		JLabel lblTopico = new JLabel("Tópicos");
		lblTopico.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblTopico.setBounds(554, 120, 154, 29);
		JScrollPane scrollPane = new JScrollPane();
		setBackground(Personalizar.violeta);
		scrollPane.setBounds(554, 162, 190, 148);
		add(scrollPane);
		
		areaTopicos = new JTextArea();
		scrollPane.setViewportView(areaTopicos);
		areaTopicos.setLineWrap(true);
		
		add(lbl);
		add(lblTopico);
		add(scrollPane);
		add(escolhaMateriaBox);
	}
	
	public JComboBox getEscolhaMateriaBox() {
		return escolhaMateriaBox;
	}

	public void setEscolhaMateriaBox(JComboBox escolhaMateriaBox) {
		this.escolhaMateriaBox = escolhaMateriaBox;
	}

	public JButton getAdiconarTopicoButton() {
		return adiconarTopicoButton;
	}

	public void setAdiconarTopicoButton(JButton adiconarTopicoButton) {
		this.adiconarTopicoButton = adiconarTopicoButton;
	}

	public JTextArea getAreaTopicos() {
		return areaTopicos;
	}

	public void setAreaTopicos(JTextArea areaTopicos) {
		this.areaTopicos = areaTopicos;
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(800,550);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new EditarMateriaPanel());
		f.setVisible(true);
	}
	

}
