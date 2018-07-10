package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.Personalizar;

public class AbaObjetivosPanel extends JPanel{
	private ObjetivosPanel objetivosPanel;
	private PanelVisualizarObjetivo  visualizarObjetivoPanel;
	private AbstractPanelManipular abstractPanelManipular;//depreceated
	private PanelSubObjetivo panelSubObjetivo;
	private CardLayout card;
	public AbaObjetivosPanel(){
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(800,550));
		card = new CardLayout();
		this.objetivosPanel = new ObjetivosPanel();
		visualizarObjetivoPanel = new PanelVisualizarObjetivo();
		panelSubObjetivo = new PanelSubObjetivo();
		abstractPanelManipular = new AbstractPanelManipular("Adicionar","Editar","Remover","Tela","ADD","Editar");
		setLayout(card);
		add(objetivosPanel);
		add(visualizarObjetivoPanel);
		add(panelSubObjetivo);
		add(abstractPanelManipular);
		card.addLayoutComponent(objetivosPanel,"objetivosPanel");
		card.addLayoutComponent(visualizarObjetivoPanel,"visualizarObjetivoPanel");
		card.addLayoutComponent(abstractPanelManipular,"abstractPanelManipular");
		card.addLayoutComponent(panelSubObjetivo,"panelSubObjetivo");
		card.show(this,"objetivosPanel");
		setBackground(Personalizar.roxoClaro);
	}
	
	public PanelSubObjetivo getPanelSubObjetivo() {
		return panelSubObjetivo;
	}

	public void setPanelSubObjetivo(PanelSubObjetivo panelSubObjetivo) {
		this.panelSubObjetivo = panelSubObjetivo;
	}

	public AbstractPanelManipular getAbstractPanelManipular() {
		return abstractPanelManipular;
	}

	public void setAbstractPanelManipular(AbstractPanelManipular abstractPanelManipular) {
		this.abstractPanelManipular = abstractPanelManipular;
	}

	public ObjetivosPanel getObjetivosPanel() {
		return objetivosPanel;
	}
	public void setObjetivosPanel(ObjetivosPanel objetivosPanel) {
		this.objetivosPanel = objetivosPanel;
	}
	public PanelVisualizarObjetivo getVisualizarObjetivoPanel() {
		return visualizarObjetivoPanel;
	}
	public void setVisualizarObjetivoPanel(PanelVisualizarObjetivo visualizarObjetivoPanel) {
		this.visualizarObjetivoPanel = visualizarObjetivoPanel;
	}
	public CardLayout getCard() {
		return card;
	}
	public void setCard(CardLayout card) {
		this.card = card;
	}
	
}
