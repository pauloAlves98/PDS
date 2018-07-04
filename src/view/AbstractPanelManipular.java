package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Personalizar;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AbstractPanelManipular extends JPanel{
	private ManipularPanel adicionarPanel,editarPanel;
	private CardLayout cardLayout;
	private JPanel auxCardDownPanel;
	private FuncionalidadesPanel funcionalidadesPanel;
	/**
	 * 
	 * @param adicionar_text : titulo para botão ex.: adicionar material 
	 * @param editar_text : titulo para botão
	 * @param remover_text : titulo para botão
	 * @param title_View_text : titulo para panel como um todo ex.: Tela para manipular dados de materias do objetivo tal(quase uma descrição da tela kk)
	 * @param title_add_text : titulo para panel contido na tela , mostrado a partir do evento do botão de respectivo nome
	 * @param title_edit_text : segue logica do item acima
	 */
	

	
	public AbstractPanelManipular(String adicionar_text, String editar_text, String remover_text,String title_View_text, String title_add_text, String title_edit_text) {
		
		// instance
		this.editarPanel = new ManipularPanel(title_edit_text,"Confirmar edição");
		this.adicionarPanel = new ManipularPanel(title_add_text,"Adicionar novo");
		this.funcionalidadesPanel = new FuncionalidadesPanel(adicionar_text, editar_text, remover_text, title_View_text); // panel responsavel pela parte de cima
		this.auxCardDownPanel = new JPanel(); // panel responzavel pela parte de baixo da tela
		this.cardLayout = new CardLayout();
		//Config
		editarPanel.setBackground(Personalizar.violeta);
		adicionarPanel.setBackground(Personalizar.violeta);
		funcionalidadesPanel.setBackground(Personalizar.violeta);
		auxCardDownPanel.setBackground(Personalizar.violeta);
		// set
		auxCardDownPanel.setLayout(cardLayout); 
		auxCardDownPanel.setPreferredSize(new Dimension(790,300));
		this.setLayout(new BorderLayout(10,10));
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(800,550));
		//add 
		auxCardDownPanel.add(editarPanel);
		auxCardDownPanel.add(adicionarPanel);
		
		this.add(auxCardDownPanel,BorderLayout.SOUTH);
		this.add(funcionalidadesPanel,BorderLayout.NORTH);
		
		cardLayout.addLayoutComponent(adicionarPanel,TelasManipulacao.ADICIONAR.value); // enumeração
		cardLayout.addLayoutComponent(editarPanel,TelasManipulacao.EDITAR.value);
		mudarManipularPanel(TelasManipulacao.ADICIONAR);
	}
	/**
	 * Metodo para manipulação entre tela de edicao e adicao de dados
	 */
	public void mudarManipularPanel(TelasManipulacao change) {
		cardLayout.show(auxCardDownPanel,change.value);
	}
		
	
	
	/**
	 * Clase de manipulação generica(possibilidade de extendela ou editala(hight))
	 * @author: Wanderson
	 */
	public class FuncionalidadesPanel extends JPanel{
		private JButton adicionarButton,editarButton,removerButton,voltarButton;// CRUD
		private JLabel titleLabel;
		
		public FuncionalidadesPanel(String adicionar_text, String editar_text, String remover_text,String title_View_text) {
			
			this.adicionarButton =  new JButton(adicionar_text);
			this.editarButton =  new JButton(editar_text);
			this.removerButton =  new JButton(remover_text);
			this.titleLabel = new JLabel(title_View_text);
			voltarButton = new JButton("Voltar a Tela Anterior");
			this.setPreferredSize(new Dimension(790,300));
			
			add(titleLabel);
			add(adicionarButton);
			add(editarButton);
			add(removerButton);
			add(voltarButton);
		}
		
		public JButton getVoltarButton() {
			return voltarButton;
		}

		public void setVoltarButton(JButton voltarButton) {
			this.voltarButton = voltarButton;
		}

		public JButton getAdicionarButton() {
			return adicionarButton;
		}

		public JButton getEditarButton() {
			return editarButton;
		}

		public JButton getRemoverButton() {
			return removerButton;
		}
	}
	
	public class ManipularPanel extends JPanel{
		private JLabel tituloLabel,nomeLabel, descricaoLabel;
		private JTextField nomeField;
		private JTextArea descricaoField;
		private JButton confirmarButton;
		
		public ManipularPanel(String title, String button_confirmar_text) {
			tituloLabel = new JLabel(title);
			nomeLabel = new JLabel("Nome");
			descricaoLabel = new JLabel("Descrição ");
			nomeField = new JTextField(10);
			descricaoField = new JTextArea(5,20);
			confirmarButton = new JButton(button_confirmar_text);
			
			add(tituloLabel);
			add(nomeLabel);
			add(nomeField);
			add(descricaoLabel);
			JScrollPane js = new JScrollPane();
			js.setPreferredSize(descricaoField.getPreferredSize());
			js.add(descricaoField);
			add(js);
			add(confirmarButton);
		}
		
		// gets da classe ManipularPanel
		public JLabel getTituloLabel() {
			return tituloLabel;
		}

		public JTextField getNomeField() {
			return nomeField;
		}

		public JTextArea getDescricaoField() {
			return descricaoField;
		}

		public JButton getConfirmarButton() {
			return confirmarButton;
		}
		// fim get da classe ManipularPanel
		
	
	}// fim classe ManipularPanel
	
	// gets  da classe AbstractPanelManipular

	public ManipularPanel getAdicionarPanel() {
		return adicionarPanel;
	}

	public ManipularPanel getEditarPanel() {
		return editarPanel;
	}

	public FuncionalidadesPanel getFuncionalidadesPanel() {
		return funcionalidadesPanel;
	}
	
	
	// fim gets da classe AbstractPanelManipular
	
}
