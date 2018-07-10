package view;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Personalizar;

@SuppressWarnings("serial")
public class CadastroPanel extends FormularioCadastro{
	private JLabel /*nomeLabel,sobrenomeLabel,senhaLabel,sexoLabel,,cpf,*/confirmarSenhaLabel,obs1,obs2,cadastroLabel, loginLabel;
	private JLabel perfilLabel,perfil1Label,perfil2Label,perfil3Label,perfil4Label,acerto;
	private JTextField /*nomeField,sobrenomeField,cpfField,*/loginField;
	private JPasswordField senhaField,confirmarSenhaField;
	//@SuppressWarnings("rawtypes")
	//private JComboBox sexoBox;
	private JButton concluirButton,perfil1Button,perfil2Button,perfil3Button,perfil4Button,voltar;
	
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	public CadastroPanel(){
		super();
		setLayout(null);
		setPreferredSize(new Dimension(800,480));
		
		//Cria uma fonte
		loginLabel = new JLabel("Login");
		loginField = new JTextField(10);
		
		cadastroLabel = new JLabel("Criar um novo Perfil");
		/*
		nomeLabel = new JLabel("Nome");
		sobrenomeLabel = new JLabel("Sobrenome");
		senhaLabel = new JLabel("Senha");
		sexoLabel = new  JLabel("Sexo");
		cpf = new JLabel("CPF");*/
		
		confirmarSenhaLabel = new JLabel("Confirmar Senha");
		obs1 = new JLabel("Use oito ou mais caracteres com uma combinação de letras,");
		obs2 = new JLabel("números e símbolos");
		perfilLabel = new JLabel("Escolha um Avatar");
		perfil1Label = new JLabel();
		perfil2Label = new JLabel();
		perfil3Label = new JLabel();
		perfil4Label = new JLabel();
		acerto = new JLabel();
		
		/*nomeField = new JTextField(10);
		sobrenomeField = new JTextField(10);
		cpfField = new JTextField(8);*/
		
		senhaField = new JPasswordField(8);
		confirmarSenhaField = new JPasswordField(8);
		
		//sexoBox = new JComboBox(new String[]{"Nenhum","Feminino","Masculino"});
		
		concluirButton = new JButton("Concluir");
		perfil1Button = new JButton();
		perfil2Button = new JButton();
		perfil3Button = new JButton();
		perfil4Button = new JButton();
		
		perfil1Button.setBackground(Color.BLACK);
		perfil1Button.setOpaque(false);
		
		perfil2Button.setBackground(Color.BLACK);
		perfil2Button.setOpaque(false);
		
		perfil3Button.setBackground(Color.BLACK);
		perfil3Button.setOpaque(false);
		
		perfil4Button.setBackground(Color.BLACK);
		perfil4Button.setOpaque(false);
		

		
		cadastroLabel.setFont(Personalizar.arial20);
		
		cadastroLabel.setBounds(280, 55, 240, 20);
		
		nomeLabel.setBounds(200, 95, 100, 20);
		nomeField.setBounds(238,95,100,20);
		
		sobrenomeLabel.setBounds(380, 95, 100, 20);
		sobrenomeField.setBounds(450,95, 100,20);
		
		sexoLabel.setBounds(200, 125, 100, 20);
		sexoBox.setBounds(238, 125, 100, 20);
		
		cpf.setBounds(200, 151,100, 20);
		cpfField.setBounds(238, 151, 100, 20);
		
		loginLabel.setBounds(410,151,40,20);
		loginField.setBounds(450,151,100,20);
		
		senhaLabel.setBounds(200, 180,100, 20);
		senhaField.setBounds(238, 180, 100, 20);
		
		confirmarSenhaLabel.setBounds(350, 180, 100, 20);
		confirmarSenhaField.setBounds(450, 180, 100,20);
		
		obs1.setBounds(200, 205, 400, 20);
		obs2.setBounds(200, 220, 150, 20);
		
		perfilLabel.setFont(Personalizar.arial20);
		perfilLabel.setBounds(285, 255,230, 20);
		
		perfil1Label.setBounds(150, 295, 100,101);
		perfil2Label.setBounds(260,295, 100, 101);
		perfil3Label.setBounds(380, 295, 100, 101);
		perfil4Label.setBounds(490, 295, 100, 101);
		
		perfil1Button.setBounds(150, 295, 100,101);
		perfil2Button.setBounds(260,295, 100, 101);
		perfil3Button.setBounds(380, 295, 100, 101);
		perfil4Button.setBounds(490, 295, 100, 101);
				
		concluirButton.setBounds(320, 415, 100, 30);
		concluirButton.setBackground(Personalizar.roxoClaro);
		acerto.setVisible(false);
		
		setBackground(Personalizar.branco);
		
		add(loginLabel);
		add(loginField);
		
		add(cadastroLabel);
		add(nomeLabel);
		add(nomeField);
		add(sobrenomeLabel);
		add(sobrenomeField);
		add(sexoLabel);
		add(sexoBox);
		add(cpf);
		add(cpfField);
		add(senhaLabel);
		add(senhaField);
		add(confirmarSenhaLabel);
		add(confirmarSenhaField);
		add(obs1);
		add(obs2);
		add(perfilLabel);
		add(acerto);
		add(perfil1Label);
		add(perfil2Label);
		add(perfil3Label);
		add(perfil4Label);
		add(perfil1Button);
		add(perfil2Button);
		add(perfil3Button);
		add(perfil4Button);
		add(concluirButton);
		
	}
	
	public JLabel getPerfilLabel() {
		return perfilLabel;
	}


	public JLabel getPerfil1Label() {
		return perfil1Label;
	}


	public JLabel getPerfil2Label() {
		return perfil2Label;
	}


	public JLabel getPerfil3Label() {
		return perfil3Label;
	}


	public JLabel getPerfil4Label() {
		return perfil4Label;
	}


	public JLabel getAcerto() {
		return acerto;
	}


	public JLabel getLoginLabel() {
		return loginLabel;
	}

	/*public JTextField getCpfField() {
		return cpfField;
	}*/

	public JTextField getLoginField() {
		return loginField;
	}

	public void setSobrenomeField(JTextField sobrenomeField) {
		this.sobrenomeField = sobrenomeField;
	}

	/*public JTextField getNomeField() {
		return nomeField;
	}*/


	/*public JTextField getSobrenomeField() {
		return sobrenomeField;
	}*/


	public JPasswordField getSenhaField() {
		return senhaField;
	}


	public JPasswordField getConfirmarSenhaField() {
		return confirmarSenhaField;
	}


	/*public JComboBox getSexoBox() {
		return sexoBox;
	}*/


	public JButton getConcluirButton() {
		return concluirButton;
	}


	public JButton getPerfil1Button() {
		return perfil1Button;
	}


	public JButton getPerfil2Button() {
		return perfil2Button;
	}


	public JButton getPerfil3Button() {
		return perfil3Button;
	}


	public JButton getPerfil4Button() {
		return perfil4Button;
	}
	public void limparCampos() {
		nomeField.setText("");
		sobrenomeField.setText("");
		cpfField.setText("");
		loginField.setText("");
		senhaField.setText("");
		confirmarSenhaField.setText("");
		sexoBox.setSelectedItem("Nenhum");
		acerto.setVisible(false);
	}


//	public static void main(String[] args) {
//		JFrame f = new JFrame();
//		CadastroPanel p = new CadastroPanel();
//		//f.setLayout(new FlowLayout());
//		f.setSize(800, 480);
//		f.setResizable(false);
//		f.setLocationRelativeTo(null);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.add(p);
//		//f.setBackground(bgColor);
//		f.setVisible(true);
//		
//		new ControleCadastro(p); 
//		
//	}
	
}
