package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Personalizar;

public abstract class ManipularMateria extends JPanel{
	private JTextArea areaDescricao;
	private JButton adicionarMaterialButton ;
	private JButton salvarMateriaButton ;
	private JButton validarNomeButton;
	private JTextField nomeField;
	public  ManipularMateria(){
		
		setPreferredSize(new Dimension(800,400));
		setLayout(null);
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblNome.setBounds(218, 37, 85, 33);
		add(lblNome);
		setBackground(Personalizar.violeta);
		nomeField = new JTextField();
		nomeField.setBounds(218, 74, 207, 33);
		add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblDescrio.setBounds(218, 118, 85, 33);
		add(lblDescrio);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(218, 162, 324, 148);
		add(scrollPane);
		
		areaDescricao = new JTextArea();
		areaDescricao.setLineWrap(true);
		scrollPane.setViewportView(areaDescricao);
		
		adicionarMaterialButton = new JButton("Adicionar Material");
		adicionarMaterialButton.setBounds(218, 318, 138, 36);
		add(adicionarMaterialButton);
		
		salvarMateriaButton = new JButton("Salvar Mat\u00E9ria");
		salvarMateriaButton.setBounds(413, 318, 131, 36);
		add(salvarMateriaButton);
		
	    validarNomeButton = new JButton("Validar Nome");
		validarNomeButton.setBounds(432, 74, 110, 33);
		add(validarNomeButton);
	}
	public JTextArea getAreaDescricao() {
		return areaDescricao;
	}
	public void setAreaDescricao(JTextArea areaDescricao) {
		this.areaDescricao = areaDescricao;
	}
	public JButton getAdicionarMaterialButton() {
		return adicionarMaterialButton;
	}
	public void setAdicionarMaterialButton(JButton adicionarMaterialButton) {
		this.adicionarMaterialButton = adicionarMaterialButton;
	}
	public JButton getSalvarMateriaButton() {
		return salvarMateriaButton;
	}
	public void setSalvarMateriaButton(JButton salvarMateriaButton) {
		this.salvarMateriaButton = salvarMateriaButton;
	}
	public JButton getValidarNomeButton() {
		return validarNomeButton;
	}
	public void setValidarNomeButton(JButton validarNomeButton) {
		this.validarNomeButton = validarNomeButton;
	}
	public JTextField getNomeField() {
		return nomeField;
	}
	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

}
