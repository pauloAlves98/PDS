package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.BaseDados;
import model.Materia;
import model.Material;
import view.AbaObjetivosPanel;
import view.PanelSubObjetivo;
import view.TelasManipulacao;

public class ControllerPanelSubObjetivo {
	public static final int  NENHUM = -1;
	private PanelSubObjetivo panelSubObjetivo;
	BaseDados baseDados;
	public static int objetivoEmUso = NENHUM;
	private ControllerMaterial controllerMaterial;
	public ControllerPanelSubObjetivo(PanelSubObjetivo panelSubObjetivo,AbaObjetivosPanel aba){
		this.panelSubObjetivo = panelSubObjetivo;
		this.baseDados = BaseDados.getInstance();//Singleton

		//mostra o panel AdicionarMateria materia
		this.panelSubObjetivo.getAdicionaButton().addActionListener((ActionEvent e)->{
			panelSubObjetivo.getCardLayout().show(panelSubObjetivo.getPanelVisualizar(),
					TelasManipulacao.ADICIONAR_MATERIA.getValue());limparCamposAdicioarMateria();});
		//mostra o panel visualizar materia
		this.panelSubObjetivo.getVisualizarMateriaButton().addActionListener((ActionEvent e)->{
			panelSubObjetivo.getCardLayout().show(panelSubObjetivo.getPanelVisualizar(),
					TelasManipulacao.VISUALIZAR_MATERIA.getValue());limparCamposAdicioarMateria();});
		//mostra o panel Editar matéria
		this.panelSubObjetivo.getEditarMateriaButton().addActionListener((ActionEvent e)->{
			panelSubObjetivo.getCardLayout().show(panelSubObjetivo.getPanelVisualizar(),
					TelasManipulacao.EDITAR_MATERIA.getValue());limparCamposAdicioarMateria();});
		//retorna ao panel visualizar objetivo!
		this.panelSubObjetivo.getVoltarButton().addActionListener((ActionEvent e)->{
			aba.getCard().show(aba,"visualizarObjetivoPanel"); limparCamposAdicioarMateria();}
				);

		//Adicionar Materia
		//cadastro de material!
		this.panelSubObjetivo.getAdicionarMateriaPanel().getAdicionarMaterialButton().addActionListener(
				(ActionEvent e)->panelSubObjetivo.getCadastrarMaterial().setVisible(true)
				);
		//validar nome!
		this.panelSubObjetivo.getAdicionarMateriaPanel().getValidarNomeButton().addActionListener(
				(ActionEvent e)->{
					String n = panelSubObjetivo.getAdicionarMateriaPanel().getNomeField().getText();
					boolean b = validarNomeMateria(n);
					if (b)
						JOptionPane.showMessageDialog(null,"Nome Válido!!");
					else
						JOptionPane.showMessageDialog(null,"Nome Inválido!!");});
		//salvar Materia!
		this.panelSubObjetivo.getAdicionarMateriaPanel().getSalvarMateriaButton().addActionListener(
				(ActionEvent e)->salvarMateria());
		//Editar Materia
		this.panelSubObjetivo.getEditarMateriaPanel().getValidarNomeButton().addActionListener(
				(ActionEvent e)->{
					String n = panelSubObjetivo.getEditarMateriaPanel().getNomeField().getText();
					boolean b = validarNomeMateria(n);
					if (b)
						JOptionPane.showMessageDialog(null,"Nome Válido!!");
					else
						JOptionPane.showMessageDialog(null,"Nome Inválido!!");});
		this.panelSubObjetivo.getEditarMateriaPanel().getAdicionarMaterialButton().addActionListener(
				(ActionEvent e)->panelSubObjetivo.getCadastrarMaterial().setVisible(true)
				);
		this.panelSubObjetivo.getEditarMateriaPanel().getSalvarMateriaButton().addActionListener(
				(ActionEvent e)->salvarMateriaEditada()
				);
		this.panelSubObjetivo.getEditarMateriaPanel().getEscolhaMateriaBox().addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				//Atualiza a tela Editar
				if(panelSubObjetivo.getEditarMateriaPanel().getEscolhaMateriaBox().getModel().getSize()>0){
					int i = panelSubObjetivo.getEditarMateriaPanel().getEscolhaMateriaBox().getSelectedIndex();
					Materia m = baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getMaterias().get(i);
					panelSubObjetivo.getEditarMateriaPanel().getAreaDescricao().setText(m.getDescricao());
					panelSubObjetivo.getEditarMateriaPanel().getAreaTopicos().setText(m.getTopicos().toString().replace("[","").replace("]",""));
					controllerMaterial.getMateriaisAux().clear();
				}
			}

		});
		//visualizar Materia
		//adiconar evento ao JList material
		this.panelSubObjetivo.getVisualizarSubObjetivoPanel().getEscolhaMateriaBox().addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(panelSubObjetivo.getVisualizarSubObjetivoPanel().getEscolhaMateriaBox().getModel().getSize()>0){
					int i = panelSubObjetivo.getVisualizarSubObjetivoPanel().getEscolhaMateriaBox().getSelectedIndex();
					//Captura a materia em uso
					Materia m = baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getMaterias().get(i);
					///seta a descrição
					panelSubObjetivo.getVisualizarSubObjetivoPanel().getAreaDescricao().setText(m.getDescricao());
					//limpa a lista de topicos antiga
					panelSubObjetivo.getVisualizarSubObjetivoPanel().getListaTopicos().removeAll();
					//Preenche uma nova lista de topicos
					panelSubObjetivo.getVisualizarSubObjetivoPanel().getListaTopicos().setModel(retornaModelLista(m.getTopicos().toString().replace("[","").replace("]","").replace(", ",",").split(",")));
					//limpa a lista de Materiaisantigos
					panelSubObjetivo.getVisualizarSubObjetivoPanel().getListaMeteriais().removeAll();
					//o tradicional codigo seboso, de quem ta sem tempo de perfumar
					String []list =new String[baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getMaterias().get(i).getMateriais().size()];
					int cont = 0;
					//Preenche os materiais!!!
					for(Material material:baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getMaterias().get(i).getMateriais()){
						//((DefaultListModel)(panelSubObjetivo.getVisualizarSubObjetivoPanel().getListaMeteriais().getModel())).insertElementAt(material.getNome(), i);
						list[cont]= material.getNome();
						cont++;
					}
					//Preenche uma nova lista de Materiais.
					panelSubObjetivo.getVisualizarSubObjetivoPanel().getListaMeteriais().setModel(retornaModelLista(list));
					System.gc();//Deve ta comendo uma memoria de Bexiga
				}
			}

		});
		//
		this.panelSubObjetivo.getVisualizarSubObjetivoPanel().getListaMeteriais().addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == e.BUTTON3) {
					System.out.println("III");
					panelSubObjetivo.getPopupMenu().show(panelSubObjetivo.getVisualizarSubObjetivoPanel(), e.getXOnScreen() - 400,e.getYOnScreen()-300);
				}
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}

		});
		this.panelSubObjetivo.getItemAbrirMaterial().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!panelSubObjetivo.getVisualizarSubObjetivoPanel().getListaMeteriais().isSelectionEmpty()) {
					String nome = panelSubObjetivo.getVisualizarSubObjetivoPanel().getListaMeteriais().getSelectedValue().toString();
					int i = panelSubObjetivo.getVisualizarSubObjetivoPanel().getEscolhaMateriaBox().getSelectedIndex();
					for(Material m:baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getMaterias().get(i).getMateriais()) {
						if(m.getNome().equalsIgnoreCase(nome)) {
							System.out.println("llllalal");
							abrirMaterial(m.getCaminho());
							return;
						}
					}
					//não pode addicionar material com mesmo nome
				}
			}
		});
		//this.panelSubObjetivo.getItemEcluirMaterial().addActionListener();//fazer depois

		//Iniciar controller Cadastro Material!
		controllerMaterial  = new ControllerMaterial(panelSubObjetivo.getCadastrarMaterial());
	}
	/**
	 *@author Paulo Alves da Silva
	 * @param  metodo para validação do nome da mattéria, evento de  validarMateriaButton - panelAdicionar!!!
	 * */
	private boolean validarNomeMateria(String n){
		if(verificaMateriaExistente(n) ||  n.trim().length()<=0){
			//JOptionPane.showConfirmDialog(null,"Nome Inválido!!");
			return false;
		}
		else{
			return true;
		}
	}
	private boolean verificaMateriaExistente(String n){
		String nome = n;//panelSubObjetivo.getAdicionarMateriaPanel().getNomeField().getText();
		for(Materia m:baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getMaterias()){
			if(m.getNome().equalsIgnoreCase(nome)){
				return true;
			}
		}
		return false;
	}
	/**
	 *@author Paulo Alves da Silva
	 *@param petence a AdiconarPaneMateria
	 * @param  Salva a matéria, metodo para o evento adicionarMateriaButton - panelAdicionar!!!
	 * */
	private void salvarMateria(){//salva materia do panel AdicionarMateriaPanel
		String n = panelSubObjetivo.getAdicionarMateriaPanel().getNomeField().getText();
		if(validarNomeMateria(n)){
			String nome = panelSubObjetivo.getAdicionarMateriaPanel().getNomeField().getText();
			String desc = panelSubObjetivo.getAdicionarMateriaPanel().getAreaDescricao().getText();
			Materia materia = new Materia(nome,desc,controllerMaterial.getMateriaisAux());
			baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getMaterias().add(materia);
			baseDados.salvarUsuariosXML();//grava na base
			JOptionPane.showMessageDialog(null,"Matéria Salva!!!");
			limparCamposAdicioarMateria();
			panelSubObjetivo.getEditarMateriaPanel().getEscolhaMateriaBox().addItem(materia.getNome());//Limpa as mataterias atuais!
			panelSubObjetivo.getVisualizarSubObjetivoPanel().getEscolhaMateriaBox().addItem(materia.getNome());
			carregarMateriasExistentes();
			ControllerMaterial.getMateriaisAux().clear();
		}
		else
			JOptionPane.showMessageDialog(null,"Nome Inválido!!!");
	}
	/**
	 *Pertence a PanelEdicaoMateria 
	 */
	private void salvarMateriaEditada(){//salva materia do panel EditarMateriaPanel
		if(baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getMaterias().size() > 0){//se existir materias pra editar
			//olha se o campo nome materia esta vazio ou se foi digitado o mesmo nome da materia em uso.
			String n = panelSubObjetivo.getEditarMateriaPanel().getNomeField().getText();
			int indicie = panelSubObjetivo.getEditarMateriaPanel().getEscolhaMateriaBox().getSelectedIndex();
			if(!validarNomeMateria(n) || panelSubObjetivo.getEditarMateriaPanel().getNomeField().getText().trim().length()<=0){
				Materia materiaAux = baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getMaterias().get(indicie);
				String desc = panelSubObjetivo.getEditarMateriaPanel().getAreaDescricao().getText();
				if(!desc.equals(materiaAux.getDescricao()))//olhe se adescrição se alterou
					materiaAux.setDescricao(desc);
				if(ControllerMaterial.getMateriaisAux().size()!=0){
					materiaAux.getMateriais().addAll(ControllerMaterial.getMateriaisAux());
				}
				adicaoDeTopicos(materiaAux);//atualiza os topicos
				baseDados.salvarUsuariosXML();//salva as alterações
				carregarMateriasExistentes();//atualiza la o panelAdicionar
				ControllerMaterial.getMateriaisAux().clear();//limpa o material aux
				panelSubObjetivo.getEditarMateriaPanel().getNomeField().setText("");
				JOptionPane.showMessageDialog(null,"Matéria Modificada!!!");

			}
			//olha se o nome da materia foi alterado e se está disponivel!
			else if(validarNomeMateria(n)){
				String nome = panelSubObjetivo.getEditarMateriaPanel().getNomeField().getText();
				String desc = panelSubObjetivo.getEditarMateriaPanel().getAreaDescricao().getText();
				Materia materia = baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getMaterias().get(indicie);
				if(!desc.equals(materia.getDescricao()))//olha se a descrição foi mudada
					materia.setDescricao(desc);
				if(ControllerMaterial.getMateriaisAux().size()!=0){
					materia.getMateriais().addAll(ControllerMaterial.getMateriaisAux());
				}
				adicaoDeTopicos(materia);//atualiza os topicos
				materia.setNome(nome);
				baseDados.salvarUsuariosXML();//salva a materia editada
				carregarMateriasExistentes();//atualiza a area em adicionarMateriaPanel
				ControllerMaterial.getMateriaisAux().clear();
				panelSubObjetivo.getEditarMateriaPanel().getNomeField().setText("");
				panelSubObjetivo.getEditarMateriaPanel().getEscolhaMateriaBox().insertItemAt(nome,panelSubObjetivo.getEditarMateriaPanel().getEscolhaMateriaBox().getSelectedIndex());
				((DefaultComboBoxModel) panelSubObjetivo.getEditarMateriaPanel().getEscolhaMateriaBox().getModel()).removeElementAt(panelSubObjetivo.getEditarMateriaPanel().getEscolhaMateriaBox().getSelectedIndex());
				//panelSubObjetivo.getEditarMateriaPanel().getEscolhaMateriaBox().updateUI();
				JOptionPane.showMessageDialog(null,"Matéria Modificada!!!");
			}
			else
				JOptionPane.showMessageDialog(null,"Este nome já existe!!!");
		}else
			JOptionPane.showMessageDialog(null,"Adicione Matérias primeiro!!!");
		//		else
		//			JOptionPane.showMessageDialog(null,"Nome Inválido!!!");
	}
	/**
	 *Pertence a PanelEdicaoMateria 
	 *vai olhar se s topicos contidos anteriormente foram alterados
	 *
	 */
	private void adicaoDeTopicos(Materia materia){
		String topicosAntigos = materia.getTopicos().toString().replace("[","").replace("]","");
		System.out.println("Antigos:"+topicosAntigos);
		String[] vetor = panelSubObjetivo.getEditarMateriaPanel().getAreaTopicos().getText().split(",");
		ArrayList<String>aux = new ArrayList();
		for(int i = 0;i<vetor.length;i++){
			aux.add(vetor[i]);
		}
		String topicosNovos = aux.toString().replace("[","").replace("]","");
		System.out.println("Novos:"+topicosNovos);
		//então nada se alterou
		if(topicosNovos.equals(topicosAntigos)){
			return;
		}else{
			materia.setTopicos(aux);//altera os topicos com o editado agr!
		}	
	}
	private DefaultListModel retornaModelLista(String []model){
		DefaultListModel modelo = new DefaultListModel();
		for (int i = 0;i<model.length;i++) {
			modelo.addElement(model[i]);
		}
		return modelo;
	}
	private void limparCamposAdicioarMateria(){
		panelSubObjetivo.getAdicionarMateriaPanel().getNomeField().setText("");
		panelSubObjetivo.getAdicionarMateriaPanel().getAreaDescricao().setText("");
		// panelSubObjetivo.getAdicionarMaterialPanel().getAreaDescricao().setText("");
		controllerMaterial.getMateriaisAux().clear();
	}
	//	private void limparCamposEditarMateria(){
	//		panelSubObjetivo.getEditarMateriaPanel().getNomeField().setText("");
	//		panelSubObjetivo.getEditarMateriaPanel().getAreaDescricao().setText("");
	//		// panelSubObjetivo.getAdicionarMaterialPanel().getAreaDescricao().setText("");
	//		controllerMaterial.getMateriaisAux().clear();
	//	}
	/**
	 * Atualiza as materia no PanelAdicionarateria
	 * */
	private void carregarMateriasExistentes(){
		String text = baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getNome()+"\n";
		for(Materia m:baseDados.getUsuarioCorrente().getObjetivos().get(objetivoEmUso).getMaterias()){
			text+="-"+m.getNome()+"\n";
			//panelSubObjetivo.getEditarMateriaPanel().getEscolhaMateriaBox().addItem(m.getNome());
		}
		panelSubObjetivo.getAdicionarMateriaPanel().getAreaDeMaterias().setText(text);
	}
	private void abrirMaterial(String path){
		try {
			java.awt.Desktop.getDesktop().open(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
