package view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public abstract class FormularioCadastro extends JPanel{
	protected JLabel nomeLabel,sobrenomeLabel,senhaLabel,sexoLabel,cpf;
	protected JTextField nomeField,sobrenomeField,cpfField;
	protected JComboBox<String> sexoBox;
	
	public FormularioCadastro() {
		
		sexoBox = new JComboBox<String>(new String[]{"Nenhum","Feminino","Masculino"});
		nomeField = new JTextField(10);
		sobrenomeField = new JTextField(10);
		cpfField = new JTextField(8);
		nomeLabel = new JLabel("Nome");
		sobrenomeLabel = new JLabel("Sobrenome");
		senhaLabel = new JLabel("Senha");
		sexoLabel = new  JLabel("Sexo");
		cpf = new JLabel("CPF");
	}
	
	public JTextField getCpfField() {
		return cpfField;
	}
	
	public JTextField getNomeField() {
		return nomeField;
	}
	
	public JTextField getSobrenomeField() {
		return sobrenomeField;
	}
	
	public JComboBox<String> getSexoBox() {
		return sexoBox;
	}

	

	
}
