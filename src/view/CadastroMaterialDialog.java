package view;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import app.App;
import model.Personalizar;

public class CadastroMaterialDialog extends JDialog{
	 private JTextArea descricaoArea;
	 private JLabel descricaoLabel,cadastroMaterialLabel;
	 private JButton selecioneArquivoButton,adicionarButton;
	 private JTextField nomeArquivoField;
	 private JTextField arquivoField;
	 private JButton btnBuscar;
	 private JRadioButton arquivoRadio;
	 private JRadioButton diretorioRadio;
	 private ButtonGroup group;
	 private JFileChooser chooser;
	 public CadastroMaterialDialog(){
		 //setLayout(null);
		 setSize(400,400);
		 setLocationRelativeTo(null);
		 this.setResizable(false);
		 this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		 nomeArquivoField = new JTextField();
		 descricaoLabel = new JLabel("Descrição");
		 descricaoLabel.setFont(new Font("Agency FB", Font.PLAIN, 18));
		 cadastroMaterialLabel =  new JLabel("Cadastro de Material");
		 selecioneArquivoButton = new JButton("Arquivo");
		 adicionarButton = new JButton("Adicionar Material");
		 
		 App.lookWindows();
		 chooser = new JFileChooser();
		 App.lookPadrao();
		 cadastroMaterialLabel.setFont(Personalizar.agency30);
		 nomeArquivoField.setEditable(false);
		 JPanel panelCor= new JPanel(null);
		 JScrollPane descricaoJscrollPane = new JScrollPane();
		 panelCor.setBackground(Personalizar.roxoClaro);
		 panelCor. add(cadastroMaterialLabel);
		 panelCor.add(nomeArquivoField);
		 panelCor.add(selecioneArquivoButton);
		 panelCor.add(descricaoLabel);
		 panelCor.add(descricaoJscrollPane);
		 panelCor. add(adicionarButton);
		 getContentPane().add(panelCor);
		 
		 cadastroMaterialLabel.setBounds(100,20,380,30);
		 descricaoLabel.setBounds( 5,124,100,30);//30 tamanho, do componente anterior, 10 separação
		 descricaoJscrollPane.setBounds(5,160,379,130);
		 descricaoArea = new JTextArea();
		 descricaoJscrollPane.setViewportView(descricaoArea);
		 descricaoArea.setLineWrap(true);
		 adicionarButton.setBounds(8,298,150,30);
		 
		 JLabel lblEscolherMaterial = new JLabel("Escolher Material");
		 lblEscolherMaterial.setFont(new Font("Agency FB", Font.PLAIN, 18));
		 lblEscolherMaterial.setBounds(5, 61, 114, 22);
		 panelCor.add(lblEscolherMaterial);
		 
		 arquivoRadio = new JRadioButton("Arquivo");
		 arquivoRadio.setBounds(5, 94, 86, 23);
		 panelCor.add(arquivoRadio);
		 
		 diretorioRadio = new JRadioButton("Diret\u00F3rio");
		 diretorioRadio.setBounds(82, 94, 76, 23);
		 panelCor.add(diretorioRadio);
		 
		 arquivoField = new JTextField();
		 arquivoField.setEditable(false);
		 arquivoField.setBounds(160, 94, 138, 23);
		 panelCor.add(arquivoField);
		 arquivoField.setColumns(10);
	
		 
		 btnBuscar = new JButton("Buscar");
		 btnBuscar.setBounds(308, 94, 76, 23);
		 panelCor.add(btnBuscar);
		 group = new ButtonGroup();
		 group.add(arquivoRadio);
		 group.add(diretorioRadio);
		 diretorioRadio.setOpaque(false);
		 arquivoRadio.setSelected(true);
		 arquivoRadio.setOpaque(false);
		 setModal(true);
		 setVisible(false);
	 }
//	 public static void main(String[] args) {
//		new CadastroMaterialDialog();
//	}

	public JTextArea getDescricaoArea() {
		return descricaoArea;
	}

	public JFileChooser getChooser() {
		return chooser;
	}

	public void setChooser(JFileChooser chooser) {
		this.chooser = chooser;
	}

	public JLabel getDescricaoLabel() {
		return descricaoLabel;
	}

	public void setDescricaoLabel(JLabel descricaoLabel) {
		this.descricaoLabel = descricaoLabel;
	}

	public JLabel getCadastroMaterialLabel() {
		return cadastroMaterialLabel;
	}

	public void setCadastroMaterialLabel(JLabel cadastroMaterialLabel) {
		this.cadastroMaterialLabel = cadastroMaterialLabel;
	}

	public JTextField getArquivoField() {
		return arquivoField;
	}

	public void setArquivoField(JTextField arquivoField) {
		this.arquivoField = arquivoField;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JRadioButton getArquivoRadio() {
		return arquivoRadio;
	}

	public void setArquivoRadio(JRadioButton arquivoRadio) {
		this.arquivoRadio = arquivoRadio;
	}

	public JRadioButton getDiretorioRadio() {
		return diretorioRadio;
	}

	public void setDiretorioRadio(JRadioButton diretorioRadio) {
		this.diretorioRadio = diretorioRadio;
	}

	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}

	public void setDescricaoArea(JTextArea descricaoArea) {
		this.descricaoArea = descricaoArea;
	}

	public JButton getSelecioneArquivoButton() {
		return selecioneArquivoButton;
	}

	public void setSelecioneArquivoButton(JButton selecioneArquivoButton) {
		this.selecioneArquivoButton = selecioneArquivoButton;
	}

	public JButton getAdicionarButton() {
		return adicionarButton;
	}

	public void setAdicionarButton(JButton adicionarButton) {
		this.adicionarButton = adicionarButton;
	}

	public JTextField getNomeArquivoField() {
		return nomeArquivoField;
	}

	public void setNomeArquivoField(JTextField nomeArquivoField) {
		this.nomeArquivoField = nomeArquivoField;
	}
}
