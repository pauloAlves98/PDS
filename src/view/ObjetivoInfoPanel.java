package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import model.Personalizar;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class ObjetivoInfoPanel extends JPanel {
	private JButton confirmarButton,subir_prioridadeButton,descer_prioridadeButton,excluirButton;
	private JLabel nome_sub_objetivoLabel,prioridadeLabel;
	private JProgressBar progressBar;
	public int id;
	
	public ObjetivoInfoPanel(){
		setPreferredSize(new Dimension(500, 150));
		setLayout(new BorderLayout(0, 7));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(3, 0, 0, 15));
		panel.setBackground(Personalizar.violeta);
		excluirButton = new JButton();
		panel.add(excluirButton);
		excluirButton.setOpaque(false);
		excluirButton.setBorder(null);
		
		subir_prioridadeButton = new JButton();
		subir_prioridadeButton .setBorder(null);
		subir_prioridadeButton.setOpaque(false);
		panel.add(subir_prioridadeButton);
		//subir_prioridadeButton.setBorder(new LineBorder(Color.white,1,true));
		//subir_prioridadeButton.setBackground(new Color(0,0,0,0));
		
		descer_prioridadeButton = new JButton();
		descer_prioridadeButton .setBorder(null);
		descer_prioridadeButton.setOpaque(true);
		panel.add(descer_prioridadeButton);
		//descer_prioridadeButton.setBorder(new LineBorder(Color.white,1,true));
		//descer_prioridadeButton.setBackground(new Color(0,0,0,0));
		
		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 60));
		panel_3.setBackground(Personalizar.violeta);
		confirmarButton = new JButton();
		confirmarButton .setBorder(null);
		confirmarButton.setOpaque(false);
		//confirmarButton.setBorder(new LineBorder(Color.white,1,true));
		//confirmarButton.setBackground(new Color(0,0,0,0));
		panel_3.add(confirmarButton);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setPreferredSize(new Dimension(500,150));
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 22));
		panel_1.setBackground(Personalizar.violeta);
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(280, 100));
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 1, 0, 0));
		panel_2.setBackground(Personalizar.violeta);
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Personalizar.violeta);
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_4);
		
		nome_sub_objetivoLabel = new JLabel("Objetivo");
		nome_sub_objetivoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(nome_sub_objetivoLabel);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(250, 25));
		panel_5.add(progressBar);
		panel_5.setBackground(Personalizar.violeta);
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		prioridadeLabel = new JLabel("prioridade : ");
		panel_6.add(prioridadeLabel);
		panel_6.setBackground(Personalizar.violeta);
		setBackground(Personalizar.violeta);
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		add(separator, BorderLayout.NORTH);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public void setConfirmarButton(JButton confirmarButton) {
		this.confirmarButton = confirmarButton;
	}


	public void setSubir_prioridadeButton(JButton subir_prioridadeButton) {
		this.subir_prioridadeButton = subir_prioridadeButton;
	}


	public void setDescer_prioridadeButton(JButton descer_prioridadeButton) {
		this.descer_prioridadeButton = descer_prioridadeButton;
	}


	public void setExcluirButton(JButton excluirButton) {
		this.excluirButton = excluirButton;
	}


	public void setNome_sub_objetivoLabel(JLabel nome_sub_objetivoLabel) {
		this.nome_sub_objetivoLabel = nome_sub_objetivoLabel;
	}


	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}


	public JButton getConfirmarButton() {
		return confirmarButton;
	}


	public JButton getSubir_prioridadeButton() {
		return subir_prioridadeButton;
	}


	public JButton getDescer_prioridadeButton() {
		return descer_prioridadeButton;
	}


	public JButton getExcluirButton() {
		return excluirButton;
	}


	public JLabel getNome_sub_objetivoLabel() {
		return nome_sub_objetivoLabel;
	}


	public JProgressBar getProgressBar() {
		return progressBar;
	}


	public JLabel getPrioridadeLabel() {
		return prioridadeLabel;
	}


	public void setPrioridadeLabel(JLabel prioridadeLabel) {
		this.prioridadeLabel = prioridadeLabel;
	}

}
