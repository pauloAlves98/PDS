package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import model.Personalizar;

public class PanelSubObjetivo extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel panelOpcoes;
	JPanel panelVisualizar;
	JButton adicionaButton;
	JButton editarMateriaButton;
	JButton visualizarMateriaButton;
	private JButton voltarButton;
	private AdicionarMateriaPanel adicionarMateriaPanel;
	private CardLayout cardLayout;
	private EditarMateriaPanel editarMateriaPanel;
	private CadastroMaterialDialog cadastrarMaterial;
	private VisualizarSubObjetivoPanel visualizarSubObjetivoPanel;
	private JPopupMenu popupMenu;
	private JMenuItem itemAbrirMaterial,itemExcluirMaterial;
	public PanelSubObjetivo() {
		this.setPreferredSize(new Dimension(800,550));
		setLayout(new BorderLayout(0, 0));
		cadastrarMaterial = new CadastroMaterialDialog();
		adicionarMateriaPanel = new AdicionarMateriaPanel();
		editarMateriaPanel = new EditarMateriaPanel();
		visualizarSubObjetivoPanel = new VisualizarSubObjetivoPanel();
		popupMenu= new JPopupMenu();
		itemAbrirMaterial = new JMenuItem("Abrir Material");
		itemExcluirMaterial = new JMenuItem("Excluir Material");
		popupMenu.add(itemAbrirMaterial);
		popupMenu.add(itemExcluirMaterial);
		cardLayout = new CardLayout();
		panelOpcoes = new JPanel();
		panelOpcoes.setPreferredSize(new Dimension(800,100));
		panelVisualizar = new JPanel();
		panelVisualizar.setLayout(cardLayout);
		
		cardLayout.addLayoutComponent(adicionarMateriaPanel,TelasManipulacao.ADICIONAR_MATERIA.getValue());
		cardLayout.addLayoutComponent(editarMateriaPanel,TelasManipulacao.EDITAR_MATERIA.getValue());
		cardLayout.addLayoutComponent(visualizarSubObjetivoPanel,TelasManipulacao.VISUALIZAR_MATERIA.getValue());
		
		
		panelVisualizar.add(adicionarMateriaPanel);
		panelVisualizar.add(editarMateriaPanel);
		panelVisualizar.add(visualizarSubObjetivoPanel);
		//cardLayout.show(this,"editarMateriaPanel");
		add(panelOpcoes,BorderLayout.NORTH);
		panelOpcoes.setLayout(new GridLayout(0, 4, 0, 0));
		
		adicionaButton = new JButton("Adicionar Mat\u00E9ria");
		panelOpcoes.add(adicionaButton);
		adicionaButton.setBackground(Personalizar.roxoClaro);
		adicionaButton.setFont(Personalizar.agency30);
		
		editarMateriaButton = new JButton("Editar Mat\u00E9ria");
		editarMateriaButton  .setBackground(Personalizar.roxoClaro);
		editarMateriaButton .setFont(Personalizar.agency30);
		panelOpcoes.add(editarMateriaButton);
		
		visualizarMateriaButton = new JButton("Visualizar Mat\u00E9ria");
		visualizarMateriaButton .setBackground(Personalizar.roxoClaro);
		visualizarMateriaButton .setFont(Personalizar.agency30);
		panelOpcoes.add(visualizarMateriaButton);
		
		voltarButton = new JButton("Voltar");
		voltarButton .setBackground(Personalizar.roxoClaro);
		voltarButton.setFont(Personalizar.agency30);
		panelOpcoes.add(voltarButton);
		add(panelVisualizar, BorderLayout.CENTER);
	}
	
	public CadastroMaterialDialog getCadastrarMaterial() {
		return cadastrarMaterial;
	}

	public void setCadastrarMaterial(CadastroMaterialDialog cadastrarMaterial) {
		this.cadastrarMaterial = cadastrarMaterial;
	}

	public JPanel getPanelOpcoes() {
		return panelOpcoes;
	}
	public void setPanelOpcoes(JPanel panelOpcoes) {
		this.panelOpcoes = panelOpcoes;
	}
	public JPanel getPanelVisualizar() {
		return panelVisualizar;
	}
	public void setPanelVisualizar(JPanel panelVisualizar) {
		this.panelVisualizar = panelVisualizar;
	}
	public JButton getAdicionaButton() {
		return adicionaButton;
	}
	public void setAdicionaButton(JButton adicionaButton) {
		this.adicionaButton = adicionaButton;
	}
	public JButton getEditarMateriaButton() {
		return editarMateriaButton;
	}
	public void setEditarMateriaButton(JButton editarMateriaButton) {
		this.editarMateriaButton = editarMateriaButton;
	}
	public JButton getVisualizarMateriaButton() {
		return visualizarMateriaButton;
	}
	public void setVisualizarMateriaButton(JButton visualizarMateriaButton) {
		this.visualizarMateriaButton = visualizarMateriaButton;
	}
	public JButton getVoltarButton() {
		return voltarButton;
	}
	public void setVoltarButton(JButton voltarButton) {
		this.voltarButton = voltarButton;
	}
	public AdicionarMateriaPanel getAdicionarMateriaPanel() {
		return adicionarMateriaPanel;
	}
	public void setAdicionarMateriaPanel(AdicionarMateriaPanel adicionarMaterialPanel) {
		this.adicionarMateriaPanel = adicionarMaterialPanel;
	}
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}
	public EditarMateriaPanel getEditarMateriaPanel() {
		return editarMateriaPanel;
	}
	public void setEditarMateriaPanel(EditarMateriaPanel editarMateriaPanel) {
		this.editarMateriaPanel = editarMateriaPanel;
	}

	public VisualizarSubObjetivoPanel getVisualizarSubObjetivoPanel() {
		return visualizarSubObjetivoPanel;
	}

	public void setVisualizarSubObjetivoPanel(VisualizarSubObjetivoPanel visualizarSubObjetivoPanel) {
		this.visualizarSubObjetivoPanel = visualizarSubObjetivoPanel;
	}

	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}

	public void setPopupMenu(JPopupMenu popupMenu) {
		this.popupMenu = popupMenu;
	}

	public JMenuItem getItemAbrirMaterial() {
		return itemAbrirMaterial;
	}

	public void setItemAbrirMaterial(JMenuItem itemAbrirMaterial) {
		this.itemAbrirMaterial = itemAbrirMaterial;
	}

	public JMenuItem getItemExcluirMaterial() {
		return itemExcluirMaterial;
	}

	public void setItemExcluirMaterial(JMenuItem itemExcluirMaterial) {
		this.itemExcluirMaterial = itemExcluirMaterial;
	}

	
}
