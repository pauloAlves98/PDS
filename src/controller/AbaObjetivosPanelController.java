package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.BaseDados;
import model.Materia;
import model.Objetivo;
import view.AbaObjetivosPanel;
import view.DialogCadastroObjetivo;
import view.ObjetivoInfoPanel;
import view.ObjetivosPanel;

public class AbaObjetivosPanelController implements ActionListener{
	AbaObjetivosPanel abaObjetivosPanel;
	ObjetivosPanel objetivosPanel;
	DialogCadastroObjetivo cadastroObjetivo;
	BaseDados baseDados;
	public AbaObjetivosPanelController(AbaObjetivosPanel abaObjetivosPanel) {
		super();
		baseDados = BaseDados.getInstance();
		//Carregar todos os Objetivos info panel ja cadastrados!
		this.abaObjetivosPanel = abaObjetivosPanel;
		this.objetivosPanel = abaObjetivosPanel.getObjetivosPanel();
		this.objetivosPanel.getAdicionarButton().addActionListener((ActionEvent e)-> addObjetivoInfo());
		this.cadastroObjetivo = this.objetivosPanel.getDialogCadastroObjetivo();
		this.cadastroObjetivo.getCadastrarButton().addActionListener((ActionEvent e)->eventoCadastrarObjetivo());
		this.abaObjetivosPanel.getVisualizarObjetivoPanel().getSubObjetivoButton().addActionListener((ActionEvent e1)->crudSubObjetivo());
		this.abaObjetivosPanel.getVisualizarObjetivoPanel().getVoltarButton().addActionListener((ActionEvent e1)->{abaObjetivosPanel.getCard().show(abaObjetivosPanel,"objetivosPanel");
		abaObjetivosPanel.getPanelSubObjetivo().getEditarMateriaPanel().getEscolhaMateriaBox().removeAllItems();
		abaObjetivosPanel.getPanelSubObjetivo().getVisualizarSubObjetivoPanel().getEscolhaMateriaBox().removeAllItems();
		});
		this.carregarObjetivos();
		//instaciar o controller de subObjetivo;
		new ControllerPanelSubObjetivo(abaObjetivosPanel.getPanelSubObjetivo(),abaObjetivosPanel);
	}
	private void carregarObjetivos(){
		//atualizar objetivos quando forem criados!!!
		for(Objetivo o:baseDados.getUsuarioCorrente().getObjetivos()){
			ObjetivoInfoPanel ob = new ObjetivoInfoPanel ();
			ob.getNome_sub_objetivoLabel().setText(o.getNome());
			ob.getPrioridadeLabel().setText("Prioridade:"+o.getPrioridade());
			ob.getProgressBar().setValue(o.getProgresso());
			ob.getSubir_prioridadeButton().setIcon(new ImageIcon("seta verde.png"));
			ob.getDescer_prioridadeButton().setIcon(new ImageIcon("seta vermelha.png"));
			ob.getExcluirButton().setIcon(new ImageIcon("close.png"));
			ob.getConfirmarButton().setIcon(new ImageIcon("continuar.png"));
			ob.getProgressBar().setValue(o.getProgresso());
			ob.getProgressBar().setStringPainted(true);

			ob.getDescer_prioridadeButton().addActionListener(this);
			ob.getConfirmarButton().addActionListener(this);
			ob.getSubir_prioridadeButton().addActionListener(this);
			ob.getExcluirButton().addActionListener(this);

			objetivosPanel.getObjetivosInfoPanel().add(ob);
			objetivosPanel.getVerticalBox().add(ob);
		}
		//editar desc objetivo 
		//tela Edicao  - inserçõ de topicos olhar oque foi mudado na base antiga para o que foi inserido!
	}
	public void eventoCadastrarObjetivo(){
		String nome = cadastroObjetivo.getNomeField().getText();
		String descricao = cadastroObjetivo.getDescricaoArea().getText();
		String prioridade = cadastroObjetivo.getPrioridadeComboBox().getSelectedItem().toString();

		ObjetivoInfoPanel obInfo = new ObjetivoInfoPanel();
		obInfo.getSubir_prioridadeButton().setIcon(new ImageIcon("seta verde.png"));
		obInfo.getDescer_prioridadeButton().setIcon(new ImageIcon("seta vermelha.png"));
		obInfo.getExcluirButton().setIcon(new ImageIcon("close.png"));
		obInfo.getConfirmarButton().setIcon(new ImageIcon("continuar.png"));


		obInfo.getNome_sub_objetivoLabel().setText(nome);
		obInfo.getPrioridadeLabel().setText("Prioridade: "+prioridade);
		obInfo.getPrioridadeLabel().setForeground(Color.red);

		obInfo.getDescer_prioridadeButton().addActionListener(this);
		obInfo.getConfirmarButton().addActionListener(this);
		obInfo.getSubir_prioridadeButton().addActionListener(this);
		obInfo.getExcluirButton().addActionListener(this);

		objetivosPanel.getObjetivosInfoPanel().add(obInfo);
		objetivosPanel.getVerticalBox().add(obInfo);
		objetivosPanel.updateUI();

		baseDados.getUsuarioCorrente().getObjetivos().add(new Objetivo(nome,descricao,prioridade));
		baseDados.salvarUsuariosXML();
	}
	public void addObjetivoInfo() {
		objetivosPanel.getDialogCadastroObjetivo().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//eventos dos butoes de objetivoInfoPanel
		for(int i = 0;i<objetivosPanel.getObjetivosInfoPanel().size();i++){
			if(e.getSource() == objetivosPanel.getObjetivosInfoPanel().get(i).getConfirmarButton()){
				abaObjetivosPanel.getVisualizarObjetivoPanel().getNomeObjetivoLabel().setText(baseDados.getUsuarioCorrente().getObjetivos().get(i).getNome());
				//abaObjetivosPanel.getVisualizarObjetivoPanel().getPri).setText(BaseDados.objetivos.get(i).getPrioridade());
				abaObjetivosPanel.getVisualizarObjetivoPanel().getDescricaoArea().setText(baseDados.getUsuarioCorrente().getObjetivos().get(i).getDescricao());
				abaObjetivosPanel.getCard().show(abaObjetivosPanel,"visualizarObjetivoPanel");
				ControllerPanelSubObjetivo.objetivoEmUso = i;
				limparProximasTela();
				carregarMateriasExistentes();
				//carregar Materias no combo
				return;
			}
			else if(e.getSource() == objetivosPanel.getObjetivosInfoPanel().get(i).getExcluirButton()){
				String senha = JOptionPane.showInputDialog(null,"Insira sua senha");
				if(baseDados.getUsuarioCorrente().getSenha().equals(senha)){
					baseDados.getUsuarioCorrente().getObjetivos().remove(i);
					objetivosPanel.getObjetivosInfoPanel().clear();
					objetivosPanel.getVerticalBox().removeAll();
					carregarObjetivos();
					baseDados.salvarUsuariosXML();
					JOptionPane.showMessageDialog(null,"Objetivo Excluido!!!");
				}else
					JOptionPane.showMessageDialog(null,"Senha Inválida!!!");
				return;
			}
			else if(e.getSource()==objetivosPanel.getObjetivosInfoPanel().get(i).getSubir_prioridadeButton()){
				return;
			}
			else if(e.getSource()==objetivosPanel.getObjetivosInfoPanel().get(i).getDescer_prioridadeButton()){
				return;
			}
		}
	}
	/**
	 * @ Metodo para Action Performad do botão Sub Objetivo da tela
	 * abaObjetivosPanel.getVisualizarObjetivoPanel().
	 */
	private  void crudSubObjetivo(){
		abaObjetivosPanel.getCard().show(abaObjetivosPanel,"panelSubObjetivo");
	}
	private void carregarMateriasExistentes(){
		String text = baseDados.getUsuarioCorrente().getObjetivos().get(ControllerPanelSubObjetivo.objetivoEmUso ).getNome()+"\n";
		abaObjetivosPanel.getPanelSubObjetivo().getEditarMateriaPanel().getEscolhaMateriaBox().removeAll();
		for(Materia m:baseDados.getUsuarioCorrente().getObjetivos().get(ControllerPanelSubObjetivo.objetivoEmUso ).getMaterias()){
			text+="-"+m.getNome()+"\n";
			abaObjetivosPanel.getPanelSubObjetivo().getEditarMateriaPanel().getEscolhaMateriaBox().addItem(m.getNome());//carrega os items
			abaObjetivosPanel.getPanelSubObjetivo().getVisualizarSubObjetivoPanel().getEscolhaMateriaBox().addItem(m.getNome());
		}
		abaObjetivosPanel.getPanelSubObjetivo().getAdicionarMateriaPanel().getAreaDeMaterias().setText(text);
	}
	//Limpa os campos das telas Seguintes a esta - telas do panelSubObjetivo
	public void limparProximasTela(){
		abaObjetivosPanel.getPanelSubObjetivo().getEditarMateriaPanel().getAreaDescricao().setText("");
		abaObjetivosPanel.getPanelSubObjetivo().getEditarMateriaPanel().getAreaTopicos().setText("");
		abaObjetivosPanel.getPanelSubObjetivo().getVisualizarSubObjetivoPanel().getAreaDescricao().setText("");
		abaObjetivosPanel.getPanelSubObjetivo().getVisualizarSubObjetivoPanel().getListaTopicos().setModel(new DefaultListModel());
		abaObjetivosPanel.getPanelSubObjetivo().getVisualizarSubObjetivoPanel().getListaMeteriais().setModel(new DefaultListModel());
	}
}
