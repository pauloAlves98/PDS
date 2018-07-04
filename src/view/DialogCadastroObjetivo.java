package view;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class DialogCadastroObjetivo extends JDialog {
	private JTextField nomeField;
	private JScrollPane descricaoScroll;
	private JComboBox prioridadeComboBox;
	private  JTextArea descricaoArea;
	private JButton cadastrarButton ;
	public DialogCadastroObjetivo() {
		
		setResizable(false);
		getContentPane().setBackground(new Color(153, 51, 255));
		getContentPane().setLayout(null);
		setSize(600,400);
		setLocationRelativeTo(null);
		JLabel lblAdiconarObjetivo = new JLabel("ADICIONAR OBJETIVO");
		lblAdiconarObjetivo.setFont(new Font("Agency FB", Font.BOLD, 32));
		lblAdiconarObjetivo.setForeground(Color.WHITE);
		lblAdiconarObjetivo.setBounds(113, 31, 321, 41);
		getContentPane().add(lblAdiconarObjetivo);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblNome.setBounds(113, 83, 53, 27);
		getContentPane().add(lblNome);
		
		JLabel lblPrioridade = new JLabel("PRIORIDADE");
		lblPrioridade.setForeground(Color.WHITE);
		lblPrioridade.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblPrioridade.setBounds(113, 121, 85, 27);
		getContentPane().add(lblPrioridade);
		
		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblDescrio.setBounds(113, 159, 85, 27);
		getContentPane().add(lblDescrio);
		
		nomeField = new JTextField();
		nomeField.setBounds(193, 83, 157, 27);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		descricaoScroll = new JScrollPane();
		descricaoScroll.setBounds(193, 159, 241, 132);
		getContentPane().add(descricaoScroll);
		
		descricaoArea = new JTextArea();
		descricaoArea.setLineWrap(true);
		descricaoArea.setWrapStyleWord(true);
		descricaoArea.setText("");
		descricaoScroll.setViewportView(descricaoArea);
		
		prioridadeComboBox = new JComboBox();
		prioridadeComboBox.setModel(new DefaultComboBoxModel(new String[] {"ALTA", "M\u00C9DIA", "BAIXA"}));
		prioridadeComboBox.setBackground(Color.WHITE);
		prioridadeComboBox.setBounds(193, 121, 157, 24);
		getContentPane().add(prioridadeComboBox);
		
		cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setBounds(193, 302, 106, 27);
		getContentPane().add(cadastrarButton);
		setModal(true);
		//setVisible(true);
	}
	public JTextField getNomeField() {
		return nomeField;
	}
	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JComboBox getPrioridadeComboBox() {
		return prioridadeComboBox;
	}
	public void setPrioridadeComboBox(JComboBox prioridadeComboBox) {
		this.prioridadeComboBox = prioridadeComboBox;
	}
	public JTextArea getDescricaoArea() {
		return descricaoArea;
	}
	public void setDescricaoArea(JTextArea descricaoArea) {
		this.descricaoArea = descricaoArea;
	}
	public JButton getCadastrarButton() {
		return cadastrarButton;
	}
	public void setCadastrarButton(JButton cadastrarButton) {
		this.cadastrarButton = cadastrarButton;
	}
	
	
}
