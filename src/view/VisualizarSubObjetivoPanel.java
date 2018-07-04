package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;

import model.Personalizar;

public class VisualizarSubObjetivoPanel extends JPanel {
	JComboBox escolhaMateriaBox;
	JList listaTopicos;
	JTextArea areaDescricao;
	JList listaMeteriais;
	JScrollPane scrollPane_2;
	
	/**
	 * Create the panel.
	 */
	public VisualizarSubObjetivoPanel() {
		setPreferredSize(new Dimension(800,400));
		setLayout(null);
		setBackground(Personalizar.violeta);
		JLabel lblNome = new JLabel("T\u00F3picos");
		lblNome.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblNome.setBounds(10, 81, 85, 33);
		add(lblNome);
		
		JLabel lblEscolhaAMatria = new JLabel("Escolha a Mat\u00E9ria");
		lblEscolhaAMatria.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblEscolhaAMatria.setBounds(364, 11, 128, 22);
		add(lblEscolhaAMatria);
		
		escolhaMateriaBox = new JComboBox();
		escolhaMateriaBox.setBounds(323, 37, 199, 33);
		add(escolhaMateriaBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 230, 254);
		add(scrollPane);
		
		listaTopicos = new JList();
		listaTopicos.setFont(new Font("Agency FB", Font.PLAIN, 20));
		scrollPane.setViewportView(listaTopicos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(275, 118, 246, 254);
		add(scrollPane_1);
		
		areaDescricao = new JTextArea();
		areaDescricao.setFont(new Font("Agency FB", Font.PLAIN, 18));
		areaDescricao.setLineWrap(true);
		scrollPane_1.setViewportView(areaDescricao);
		areaDescricao.setEditable(false);
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblDescrio.setBounds(275, 81, 102, 33);
		add(lblDescrio);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(555, 119, 235, 253);
		add(scrollPane_2);
		
		 listaMeteriais = new JList();
		 listaMeteriais.setFont(new Font("Agency FB", Font.PLAIN, 20));
		scrollPane_2.setViewportView(listaMeteriais);
		
		JLabel lblMatriais = new JLabel("Mat\u00E9riais");
		lblMatriais.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblMatriais.setBounds(556, 81, 208, 29);
		add(lblMatriais);
	}
	
	public JScrollPane getScrollPane_2() {
		return scrollPane_2;
	}

	public void setScrollPane_2(JScrollPane scrollPane_2) {
		this.scrollPane_2 = scrollPane_2;
	}

	public JComboBox getEscolhaMateriaBox() {
		return escolhaMateriaBox;
	}
	public void setEscolhaMateriaBox(JComboBox escolhaMateriaBox) {
		this.escolhaMateriaBox = escolhaMateriaBox;
	}
	public JList getListaTopicos() {
		return listaTopicos;
	}
	public void setListaTopicos(JList listaTopicos) {
		this.listaTopicos = listaTopicos;
	}
	public JTextArea getAreaDescricao() {
		return areaDescricao;
	}
	public void setAreaDescricao(JTextArea areaDescricao) {
		this.areaDescricao = areaDescricao;
	}
	public JList getListaMeteriais() {
		return listaMeteriais;
	}
	public void setListaMeteriais(JList listaMeteriais) {
		this.listaMeteriais = listaMeteriais;
	}
	
}
