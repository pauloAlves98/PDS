package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import app.App;
import model.Personalizar;

@SuppressWarnings("serial")
public class EditarMaterialPanel extends JFrame{//temporario
	 private JTextArea descricaoArea;
	 private JTextField nomeArqField;
	 private JLabel tipoMaterialLabel,nomeAqrLabel, descricaoLabel,tituloPrincipalLabel,subTituloLabel,caminhoLabel;
	 private JButton aplicarAuteracaoButton;
	 private JTree arquivosTree;
	 private JTextField tipoDematerialField;
	 private DefaultMutableTreeNode root = new DefaultMutableTreeNode("");
	
	public EditarMaterialPanel() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLayout(null);
		setSize(800,600);
		//setPreferredSize(new Dimension(800,550));
		descricaoArea = new JTextArea();
		nomeArqField = new JTextField();
		nomeAqrLabel = new JLabel("Nome do arquivo");
		descricaoLabel = new JLabel("Descricao");
		tituloPrincipalLabel = new JLabel("Editar material");
		subTituloLabel = new JLabel("Selecione o arquivo para edição");
		tipoMaterialLabel = new JLabel("Tipo do arquivo");
		aplicarAuteracaoButton = new JButton("Aplicar alteracões");
		App.lookWindows();
		arquivosTree = new JTree(root);
		App.lookPadrao();
		caminhoLabel = new JLabel();
		tipoDematerialField = new JTextField();
		JScrollPane treeJscrollPane = new JScrollPane(arquivosTree);
		JScrollPane descricaoJscrollPane = new JScrollPane(descricaoArea);
		
		tipoDematerialField.setEditable(false);
		caminhoLabel.setForeground(Color.red);
		tituloPrincipalLabel.setFont(Personalizar.agency30);
		subTituloLabel.setFont(Personalizar.agency19);
		subTituloLabel.setForeground(Color.WHITE);
	
		getContentPane().setBackground(Personalizar.roxoClaro);
		
		add(descricaoJscrollPane);
		add(nomeAqrLabel);
		add(nomeArqField);
		add(descricaoLabel);
		add(tituloPrincipalLabel);
		add(subTituloLabel);
		add(aplicarAuteracaoButton);
		add(treeJscrollPane);
		add(tipoDematerialField);
		add(tipoMaterialLabel);
		add(caminhoLabel);
		
		tituloPrincipalLabel.setBounds(330,20,150,30);
		subTituloLabel.setBounds(20,100,190,30);
		treeJscrollPane.setBounds(20,130,190,390);
		caminhoLabel.setBounds(20,520,190,20);
		tipoMaterialLabel.setBounds(300,135,100,20);
		tipoDematerialField.setBounds(410,130,180,25);
		nomeAqrLabel.setBounds(295,165,100,20);
		nomeArqField.setBounds(410,160,180,25);
		descricaoLabel.setBounds(332,200,100,20);
		descricaoJscrollPane.setBounds(410,195,250,100);
		aplicarAuteracaoButton.setBounds(530,500,180,25);
	}
	
	
	public JLabel getCaminhoLabel() {
		return caminhoLabel;
	}


	public void setCaminhoLabel(JLabel caminhoLabel) {
		this.caminhoLabel = caminhoLabel;
	}


	public JTextArea getDescricaoArea() {
		return descricaoArea;
	}


	public JTextField getNomeArqField() {
		return nomeArqField;
	}


	public JButton getAplicarAuteracaoButton() {
		return aplicarAuteracaoButton;
	}
	public JTextField getTipoDematerialField() {
		return tipoDematerialField;
	}
	public void setTipoDematerialField(JTextField tipoDematerialField) {
		this.tipoDematerialField = tipoDematerialField;
	}
	public DefaultMutableTreeNode getRoot() {
		return root;
	}
	


	public JTree getArquivosTree() {
		return arquivosTree;
	}
}
