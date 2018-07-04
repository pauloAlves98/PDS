package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JTextArea;

import model.Personalizar;

import javax.swing.JButton;

public class PanelVisualizarObjetivo extends JPanel {
	private JLabel nomeObjetivoLabel ;
	private JTextArea descricaoArea;
	private JScrollPane subObjetivosScroll;
	private JProgressBar progressoObjetivo;
	private JButton subObjetivoButton;
	private JButton voltarButton;
	public PanelVisualizarObjetivo() {
		setPreferredSize(new Dimension(800,550));
		setLayout(null);
		nomeObjetivoLabel = new JLabel("NOME OBJETIVO");
		nomeObjetivoLabel.setFont(new Font("Agency FB", Font.BOLD, 26));
		nomeObjetivoLabel.setBounds(131, 11, 422, 50);
		add(nomeObjetivoLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 57, 270, 103);
		add(scrollPane);
		
		descricaoArea = new JTextArea();
		descricaoArea.setFont(new Font("Agency FB", Font.BOLD, 24));
		descricaoArea.setEditable(false);
		descricaoArea.setWrapStyleWord(true);
		scrollPane.setViewportView(descricaoArea);
		
		JLabel lblProgresso = new JLabel("PROGRESSO");
		lblProgresso.setFont(new Font("Agency FB", Font.BOLD, 19));
		lblProgresso.setBounds(131, 167, 216, 22);
		add(lblProgresso);
		
		progressoObjetivo = new JProgressBar();
		progressoObjetivo.setForeground(new Color(0, 0, 0));
		progressoObjetivo.setBackground(Color.WHITE);
		progressoObjetivo.setStringPainted(true);
		progressoObjetivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		progressoObjetivo.setBounds(131, 190, 270, 35);
		add(progressoObjetivo);
		
		subObjetivosScroll = new JScrollPane();
		subObjetivosScroll.setBounds(131, 236, 500, 277);
		add(subObjetivosScroll);
		
		subObjetivoButton = new JButton("SUB OBJETIVO");
		subObjetivoButton.setBounds(433, 57, 198, 35);
		add(subObjetivoButton);
		setBackground(Personalizar.violeta);
		voltarButton = new JButton("VOLTAR");
		voltarButton.setBounds(433, 94, 198, 35);
		add(voltarButton);
	}
	
	public JLabel getNomeObjetivoLabel() {
		return nomeObjetivoLabel;
	}
	public void setNomeObjetivoLabel(JLabel nomeObjetivoLabel) {
		this.nomeObjetivoLabel = nomeObjetivoLabel;
	}
	public JTextArea getDescricaoArea() {
		return descricaoArea;
	}
	public void setDescricaoArea(JTextArea descricaoArea) {
		this.descricaoArea = descricaoArea;
	}
	public JScrollPane getSubObjetivosScroll() {
		return subObjetivosScroll;
	}
	public void setSubObjetivosScroll(JScrollPane subObjetivosScroll) {
		this.subObjetivosScroll = subObjetivosScroll;
	}
	public JProgressBar getProgressoObjetivo() {
		return progressoObjetivo;
	}
	public void setProgressoObjetivo(JProgressBar progressoObjetivo) {
		this.progressoObjetivo = progressoObjetivo;
	}
	public JButton getSubObjetivoButton() {
		return subObjetivoButton;
	}
	public void setSubObjetivoButton(JButton subObjetivoButton) {
		this.subObjetivoButton = subObjetivoButton;
	}

	public JButton getVoltarButton() {
		return voltarButton;
	}

	public void setVoltarButton(JButton voltarButton) {
		this.voltarButton = voltarButton;
	}

	
}
