package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.BaseDados;
import model.Material;
import view.CadastroMaterialDialog;
import view.PanelSubObjetivo;

public class ControllerMaterial {
	private CadastroMaterialDialog cadastroMaterial;
	private static ArrayList<Material>materiaisAux = new ArrayList<Material>();//atenção gambiarra a vista!
	public ControllerMaterial(CadastroMaterialDialog cadastroMaterial){
		this.cadastroMaterial = cadastroMaterial;
		this.cadastroMaterial.getBtnBuscar().addActionListener((ActionEvent e)->buscarArquivo());
		this.cadastroMaterial.getAdicionarButton().addActionListener((ActionEvent e)->cadastrarMaterial());
	}
	public CadastroMaterialDialog getCadastroMaterial() {
		return cadastroMaterial;
	}

	public void setCadastroMaterial(CadastroMaterialDialog cadastroMaterial) {
		this.cadastroMaterial = cadastroMaterial;
	}

	public static ArrayList<Material> getMateriaisAux() {
		return materiaisAux;
	}

	public static void setMateriaisAux(ArrayList<Material> materiaisAux) {
		ControllerMaterial.materiaisAux = materiaisAux;
	}

	private void buscarArquivo(){
		boolean isDir = cadastroMaterial.getDiretorioRadio().isSelected();
		if(isDir){//verifica se eh diretorio!
			cadastroMaterial.getChooser().setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}else
			cadastroMaterial.getChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);

		int returnVal = cadastroMaterial.getChooser().showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {    
			File arq = cadastroMaterial.getChooser().getSelectedFile().getAbsoluteFile();  
			String caminho = arq.getPath();  
			cadastroMaterial.getArquivoField().setText(caminho);
		}else{
			JOptionPane.showMessageDialog(null,"Nenhum Arquivo Selecionado");
			cadastroMaterial.getArquivoField().setText("");
		}
	}

	private void cadastrarMaterial(){
		if( cadastroMaterial.getArquivoField().getText().trim().length()<1){
			JOptionPane.showMessageDialog(null,"Selecione um Arquivo");
			return;
		}
		boolean isDir = cadastroMaterial.getDiretorioRadio().isSelected();
		String caminho = cadastroMaterial.getArquivoField().getText();
		String nome = caminho.substring(caminho.lastIndexOf("\\")+1,caminho.length());
		String descricao = cadastroMaterial.getDescricaoArea().getText();
		Material m = new Material(nome,caminho,descricao,isDir);//cria o material!
		materiaisAux.add(m);//lembrar de limpar cada vez que for cadastrar uma nova materia!
		//JOptionPane.showMessageDialog(null,"Material Registrado!");
		String s = "Material Adiconado!!\nDeseja continuar Adicionando?";
		int result = JOptionPane.showConfirmDialog(null,s);
		if(result != JOptionPane.YES_OPTION)
			cadastroMaterial.setVisible(false);
		cadastroMaterial.getArquivoField().setText("");;
		cadastroMaterial.getDescricaoArea().setText("");
	}
	//public void atualizarTree() {
	//		File file = new File("res//usuarios//"+baseDados.getUsuarioCorrente().getLogin()+"//OBJETIVO TESTE");
	//		if(!file.exists())
	//			file.mkdirs();
	//		abaPerfilPanel.getEditarMaterialPanel().getRoot().removeAllChildren();
	//		TreeModel arvore = new DefaultTreeModel(abaPerfilPanel.getEditarMaterialPanel().getRoot());           
	//		abaPerfilPanel.getEditarMaterialPanel().getArquivosTree().setModel(arvore);    
	//		abaPerfilPanel.getEditarMaterialPanel().getRoot().setUserObject("OBJETIVO TESTE");
	//		System.out.println(file.getPath());
	//		listAllFiles(file.getPath(),abaPerfilPanel.getEditarMaterialPanel().getRoot(),true);
	//	}
	//	public static void listAllFiles(String directory, DefaultMutableTreeNode parent, Boolean recursive) {
	//		File[] children = new File(directory).listFiles();
	//		if(children == null){
	//			System.out.println("NUlo");
	//			return;
	//		}
	//		for (int i = 0; i < children.length; i++) {
	//			DefaultMutableTreeNode node = new DefaultMutableTreeNode(children[i].getName());
	//			if (children[i].isDirectory() && recursive) {
	//				parent.add(node); 
	//				listAllFiles(children[i].getPath(), node, recursive);//pega esse no e adicona filhos a ele, assim ele vira pai
	//			} else if (!children[i].isDirectory()) { 
	//				parent.add(node); 
	//			}
	//		}
	//	}
	//	private Material buscarMaterialNaArvore(){
	//	TreePath nodepath = abaPerfilPanel.getEditarMaterialPanel().getArquivosTree().getSelectionPath();//todos os nos
	//	if(nodepath==null)
	//		return null;
	//	DefaultMutableTreeNode node = (DefaultMutableTreeNode) nodepath.getLastPathComponent();
	//	
	//	for(Material m:baseMaterial.getMateriais()){
	//		if(m.getNome().equals(node.toString()) && m.getNomeUsuario().equals(baseDados.getUsuarioCorrente().getLogin())){
	//			return m;
	//		}
	//	}
	//	return null;
	//}
	public static void main(String[] args) {
		CadastroMaterialDialog c = new CadastroMaterialDialog();
		new ControllerMaterial(c);
		System.out.println("j");
		c.setVisible(true);
	}
}
