package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import model.BaseDados;
import model.BaseMaterial;
import model.Material;
import model.Usuario;
import view.AbaPerfilPanel;
import view.Mensagem;

public class ControllerAbaPerfilPanel implements ActionListener{
	private AbaPerfilPanel abaPerfilPanel;
	private BaseDados baseDados;
	//	private BaseMaterial baseMaterial;
	public ControllerAbaPerfilPanel(AbaPerfilPanel abaPerfilPanel) {
		super();
		this.abaPerfilPanel = abaPerfilPanel;
		this.baseDados = BaseDados.getInstance();
		//this.baseMaterial=baseMaterial;;
		// botôes de mudança entre telas
		abaPerfilPanel.getPerfilPanel().getEditarPerfilButton().addActionListener(this);
		abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigContaPanel().getVoltarButton().addActionListener(this);
		abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigPerfilPanel().getVoltarButton().addActionListener(this);

		//quando exclui a base deu erro!

		abaPerfilPanel.getEditarPerfilPanel().getOpcoesPanel().getPerfilButton().addActionListener(this);
		abaPerfilPanel.getEditarPerfilPanel().getOpcoesPanel().getContaButton().addActionListener(this);
		// atualizando perfil com dados do usuario corrente
		if(baseDados.getUsuarios().size()>0){
			abaPerfilPanel.getPerfilPanel().getNomeLabel().setText(baseDados.getUsuarioCorrente().getNome());//este nome sempre conterá o de indicie 0
			abaPerfilPanel.getPerfilPanel().getFotoPerfilLabel().setIcon(baseDados.getUsuarioCorrente().getImagemPerfil());
		}
		// botão para atualizar informações de perfil/usuario
		/**
		 Wanderson ao pegar esse codigo ele adiciona a mudança que ele fez pra voltar ao painel inicial quando o usuario é excluido	
		 */
		abaPerfilPanel.getPerfilPanel().getExcluirPerfilButton().addActionListener(this);//exclui o usuario
		abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigPerfilPanel().getConfirmarButton().addActionListener((ActionEvent a)->validarEdicaoDadosPerfil());
		abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigContaPanel().getConfirmarLoginButton().addActionListener((ActionEvent e)->validarEdicaoLogin());
		abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigContaPanel().getConfirmarSenhaButton().addActionListener((ActionEvent e)->{validarEdicaoSenha();});
		//		abaPerfilPanel.getPerfilPanel().getCadastrarMaterialButton().addActionListener((ActionEvent e)->{
		//			abaPerfilPanel.getCadastrarMaterial().setVisible(true); abaPerfilPanel.getCadastrarMaterial().setLocationRelativeTo(null);
		//		});
		//abaPerfilPanel.getCadastrarMaterial().getSelecioneArquivoButton().addActionListener((ActionEvent e)->buscarArquivo());
		//abaPerfilPanel.getCadastrarMaterial().getAdicionarButton().addActionListener((ActionEvent e)->cadastrarMaterial());
		//abaPerfilPanel.getPerfilPanel().getEditarMaterialButton().addActionListener((ActionEvent e)->{abaPerfilPanel.getEditarMaterialPanel().setVisible(true);atualizarTree();});
		//abaPerfilPanel.getEditarMaterialPanel().getAplicarAuteracaoButton().addActionListener((ActionEvent e)->alteracaoButton());
		//		abaPerfilPanel.getEditarMaterialPanel().getArquivosTree().addTreeSelectionListener(new TreeSelectionListener() {
		//			@Override
		//			public void valueChanged(TreeSelectionEvent e) {
		//				TreePath nodepaths = abaPerfilPanel.getEditarMaterialPanel().getArquivosTree().getSelectionPath();
		//				StringBuilder caminho = new StringBuilder("res//data//usuarios//"+baseDados.getUsuarioCorrente().getLogin()+"//OBJETIVO TESTE");
		//				System.out.println(caminho.toString());
		//				TreePath nodepath = abaPerfilPanel.getEditarMaterialPanel().getArquivosTree().getSelectionPath();
		//				if(nodepath==null){
		//					System.out.println("REGREDIU");
		//					abaPerfilPanel.getEditarMaterialPanel().getCaminhoLabel().setText("");
		//					abaPerfilPanel.getEditarMaterialPanel().getNomeArqField().setText("");
		//					abaPerfilPanel.getEditarMaterialPanel().getTipoDematerialField().setText("");
		//					return;
		//				}
		//				DefaultMutableTreeNode node = (DefaultMutableTreeNode) nodepath.getLastPathComponent();
		//				Material  m = buscarMaterialNaArvore();
		//				if(m != null) {
		//					abaPerfilPanel.getEditarMaterialPanel().getNomeArqField().setText(m.getNome().substring(0,m.getNome().lastIndexOf(".")));
		//					abaPerfilPanel.getEditarMaterialPanel().getDescricaoArea().setText(m.getDescricao());
		//					abaPerfilPanel.getEditarMaterialPanel().getCaminhoLabel().setText(m.getCaminho());
		//					abaPerfilPanel.getEditarMaterialPanel().getTipoDematerialField().setText(tipodeArquivoNaArvore());
		//				}else{
		//					abaPerfilPanel.getEditarMaterialPanel().getCaminhoLabel().setText("");
		//					abaPerfilPanel.getEditarMaterialPanel().getNomeArqField().setText("");
		//					abaPerfilPanel.getEditarMaterialPanel().getTipoDematerialField().setText("");
		//					abaPerfilPanel.getEditarMaterialPanel().getTipoDematerialField().setText("");
		//				}
		//			}
		//		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// controle de mudança entre a tela de perfil e edicao de perfil 
		if(e.getSource() == abaPerfilPanel.getPerfilPanel().getEditarPerfilButton()) 
		{
			abaPerfilPanel.mudarPanel("editarPerfilPanel");
		}
		else if(e.getSource() == abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigContaPanel().getVoltarButton() 
				||e.getSource() ==  abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigPerfilPanel().getVoltarButton()) 
		{
			abaPerfilPanel.mudarPanel("perfilPanel");
		}
		// controle de mudança de panel com formularios a partir dos botões que estão no panel de opções
		else if(e.getSource() == abaPerfilPanel.getEditarPerfilPanel().getOpcoesPanel().getPerfilButton()) 
		{
			abaPerfilPanel.getEditarPerfilPanel().mudarPanel("formularioConfigPerfilPanel");
		}
		else if(e.getSource() == abaPerfilPanel.getEditarPerfilPanel().getOpcoesPanel().getContaButton()) 
		{
			abaPerfilPanel.getEditarPerfilPanel().mudarPanel("formularioConfigContaPanel");
		}
		else if(e.getSource() == abaPerfilPanel.getPerfilPanel().getExcluirPerfilButton()){
			baseDados.getUsuarioCorrente().setAtivo(false);
			//voltar ao painel inicial
			baseDados.salvarUsuariosXML();
			System.exit(0);//substituir por voltar a tela inicial
		}

	}

	public void validarEdicaoDadosPerfil() {
		StringBuffer alterado = new StringBuffer("Os seguintes dados foram atualizados : ");
		Usuario usuario  = baseDados.getUsuarioCorrente();
		String nomeTela = abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigPerfilPanel().getNomeField().getText().trim();
		String sobrenomeTela = abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigPerfilPanel().getSobrenomeField().getText().trim();
		String cpfTela = abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigPerfilPanel().getCpfField().getText().trim();
		String sexo = ((String) (abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigPerfilPanel().getSexoBox().getSelectedItem())).trim();

		if(nomeTela.length()>0 && sobrenomeTela.length() >0 ) 
		{
			usuario.setNome(nomeTela+" "+sobrenomeTela);
			alterado.append(" -Nome e sobrenome- ");
			abaPerfilPanel.getPerfilPanel().getNomeLabel().setText(usuario.getNome());

		}
		else if(nomeTela.length()>0 || sobrenomeTela.length() >0 ) {
			if(nomeTela.length() >0)
			{
				usuario.setNome(nomeTela+" "+usuario.getNome().substring(usuario.getNome().indexOf(" "),usuario.getNome().length()));
				alterado.append(" -Nome- ");
			}
			if(sobrenomeTela.length() >0) 
			{
				usuario.setNome(usuario.getNome().substring(0,usuario.getNome().indexOf(" "))+" "+sobrenomeTela);
				alterado.append(" -Sobrenome- ");

			}
			abaPerfilPanel.getPerfilPanel().getNomeLabel().setText(usuario.getNome());
		}
		if(cpfTela.length()>0) {
			usuario.setCpf(cpfTela);
			alterado.append(" -CPF- ");
		}
		if(sexo.length()>0) {
			if(sexo.equals("Masculino"))
				usuario.setSexo('M');
			else if(sexo.equals("Feminino"))
				usuario.setSexo('F');
			else 
				usuario.setSexo('N');
			alterado.append(" -Sexo- ");
		}

		Mensagem.exibirDialogo(alterado.toString());
		baseDados.salvarUsuariosXML();
	}

	public void validarEdicaoLogin() {
		String loginTela = abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigContaPanel().getLoginField().getText().trim();
		if(loginTela.length() <1) 
		{
			Mensagem.exibirDialogo("Nenhum login foi informado");
			return;
		}
		if(loginTela.equals(baseDados.getUsuarioCorrente().getLogin())) 
		{
			Mensagem.exibirDialogo("O login atual foi informado, favor entrar outro");
			return;
		}
		if(baseDados.isUsuarioEstaNaBase(loginTela) != null) 
		{
			Mensagem.exibirDialogo("Já existe um usuario com esse login");
			return;
		}

		baseDados.getUsuarioCorrente().setLogin(loginTela);
		Mensagem.exibirDialogo("Login atualizado!");
		baseDados.salvarUsuariosXML();
	}
	public void validarEdicaoSenha() {
		Usuario usuario = baseDados.getUsuarioCorrente();
		String senhaAtual = new String(abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigContaPanel().getSenhaAtualField().getPassword());

		if(!senhaAtual.equals(usuario.getSenha()) || senhaAtual.length()<1) 
		{
			Mensagem.exibirDialogo("Senha atual incorreta");
			return;
		}

		String novaSenha = new String(abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigContaPanel().getNovaSenhaField().getPassword());
		String confirmarSenha = new String(abaPerfilPanel.getEditarPerfilPanel().getFormularioConfigContaPanel().getConfirmarSenhaField().getPassword());
		if(novaSenha.length()<1 || confirmarSenha.length() <1) {
			Mensagem.exibirDialogo("Erro - Um ou mais campos vazios");
			return;
		}
		if(!novaSenha.equals(confirmarSenha)) {
			Mensagem.exibirDialogo("nova senha e sua confirmação não correspondem");
			return;
		}
		usuario.setSenha(novaSenha);
		Mensagem.exibirDialogo("Senha atualizada!");
		baseDados.salvarUsuariosXML();
	}


	//	private void cadastrarMaterial(){
	//		if( abaPerfilPanel.getCadastrarMaterial().getNomeArquivoField().getText().length()<1){
	//			JOptionPane.showMessageDialog(null,"Selecione um Arquivo");
	//			return;
	//		}
	//		String caminho = abaPerfilPanel.getCadastrarMaterial().getNomeArquivoField().getText();
	//		String nome = caminho.substring(caminho.lastIndexOf("\\")+1,caminho.length());
	//		String meuC = "res//usuarios//"+baseDados.getUsuarioCorrente().getLogin()+"//OBJETIVO TESTE"+"//"+abaPerfilPanel.getCadastrarMaterial().getTipoArquivoCombo().getSelectedItem().toString();
	//		File criaOb = new File(meuC);
	//		if(criaOb.exists()==false)
	//			criaOb.mkdirs();//cria o diretorio caso nao exista
	//		String novoCaminho = meuC+"//"+nome;//novo caminho do arquivo
	//		try {
	//			this.salvar(new File(caminho.replace("\\","//")),new File(novoCaminho));//copia o arquivo
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//		//Material m = new Material(nome,novoCaminho,abaPerfilPanel.getCadastrarMaterial().getDescricaoArea().getText(),baseDados.getUsuarioCorrente().getLogin(),"OBJETIVO TESTE");
	//		baseMaterial.getMateriais().add(m);
	//		baseMaterial.salvarMateriasXML();//salvar.
	//		abaPerfilPanel.getCadastrarMaterial().getNomeArquivoField().setText("");//limpa o campo
	//		atualizarTree();
	//	}

	//	public static void salvar(File source, File destination) throws IOException {
	//		        if (destination.exists())
	//		            destination.delete();
	//		FileChannel sourceChannel = null;
	//		FileChannel destinationChannel = null;
	//		try {
	//			sourceChannel = new FileInputStream(source).getChannel();
	//			destinationChannel = new FileOutputStream(destination).getChannel();
	//			sourceChannel.transferTo(0, sourceChannel.size(),
	//					destinationChannel);
	//		} finally {
	//			if (sourceChannel != null && sourceChannel.isOpen())
	//				sourceChannel.close();
	//			if (destinationChannel != null && destinationChannel.isOpen())
	//				destinationChannel.close();
	//		}
	//	}
	//Coisas do Editar Perfil
	public void atualizarTree() {
		File file = new File("res//usuarios//"+baseDados.getUsuarioCorrente().getLogin()+"//OBJETIVO TESTE");
		if(!file.exists())
			file.mkdirs();
		abaPerfilPanel.getEditarMaterialPanel().getRoot().removeAllChildren();
		TreeModel arvore = new DefaultTreeModel(abaPerfilPanel.getEditarMaterialPanel().getRoot());           
		abaPerfilPanel.getEditarMaterialPanel().getArquivosTree().setModel(arvore);    
		abaPerfilPanel.getEditarMaterialPanel().getRoot().setUserObject("OBJETIVO TESTE");
		System.out.println(file.getPath());
		listAllFiles(file.getPath(),abaPerfilPanel.getEditarMaterialPanel().getRoot(),true);
	}
	public static void listAllFiles(String directory, DefaultMutableTreeNode parent, Boolean recursive) {
		File[] children = new File(directory).listFiles();
		if(children == null){
			System.out.println("NUlo");
			return;
		}
		for (int i = 0; i < children.length; i++) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(children[i].getName());
			if (children[i].isDirectory() && recursive) {
				parent.add(node); 
				listAllFiles(children[i].getPath(), node, recursive);//pega esse no e adicona filhos a ele, assim ele vira pai
			} else if (!children[i].isDirectory()) { 
				parent.add(node); 
			}
		}
	}
	/**
	 * alterar arquivo posto na arvore;
	 * */
	//	private void alteracaoButton(){
	//		if(abaPerfilPanel.getEditarMaterialPanel().getNomeArqField().getText().length()<1){
	//			JOptionPane.showMessageDialog(null,"Selecione um arquivo para aplicar as alterações");
	//			return;
	//		}
	//		//String caminho = buscarMaterialNaArvore().getCaminho();
	//		Material  m = baseMaterial.getMaterial(caminho);
	//		if(m != null) {
	//			File file = new File(caminho);
	//			String extencao = caminho.substring(caminho.indexOf("."),caminho.length());
	//			String novoCaminho = caminho.substring(0,caminho.lastIndexOf("//"))+"//"+abaPerfilPanel.getEditarMaterialPanel().getNomeArqField().getText().trim()+extencao;
	//			file.renameTo(new File(novoCaminho));
	//
	//			m.setDescricao(abaPerfilPanel.getEditarMaterialPanel().getDescricaoArea().getText().trim());
	//			m.setCaminho(novoCaminho);
	//			m.setNome(abaPerfilPanel.getEditarMaterialPanel().getNomeArqField().getText().trim());
	//
	//			//abaPerfilPanel.getEditarMaterialPanel().repaint();
	//			//abaPerfilPanel.getEditarMaterialPanel().getArquivosTree().repaint();
	//			
	//			abaPerfilPanel.getEditarMaterialPanel().getCaminhoLabel().setText("");
	//			abaPerfilPanel.getEditarMaterialPanel().getNomeArqField().setText("");
	//			abaPerfilPanel.getEditarMaterialPanel().getTipoDematerialField().setText("");
	//			baseMaterial.salvarMateriasXML();
	//			abaPerfilPanel.getEditarMaterialPanel().repaint();
	//			atualizarTree();
	//		}
	//	}
	/**
	 * retorna o tipo de arquivo do nó selecionado na arvore.
	 * se for um diretorio ou o caminho não existir retorna null.
	 * */
	private String tipodeArquivoNaArvore(){//retorna  se o arquivo clicado na arvore é video, artigo...
		TreePath nodepath = abaPerfilPanel.getEditarMaterialPanel().getArquivosTree().getSelectionPath();
		System.out.println(nodepath);
		System.out.println(nodepath.getLastPathComponent());
		for(int i = nodepath.getPathCount()-1;i>=0;i--){
			if(!nodepath.getPathComponent(i).toString().contains(".")){
				return nodepath.getPathComponent(i).toString();//esse sera o tipo de arquivo
			}
		}
		return null;
	}
	/**
	 * retorna o material do nó selecionado na arvore.
	 * se for um diretorio ou o caminho não existir retorna null.
	 * */
	//	private Material buscarMaterialNaArvore(){
	//		TreePath nodepath = abaPerfilPanel.getEditarMaterialPanel().getArquivosTree().getSelectionPath();//todos os nos
	//		if(nodepath==null)
	//			return null;
	//		DefaultMutableTreeNode node = (DefaultMutableTreeNode) nodepath.getLastPathComponent();
	//		
	//		for(Material m:baseMaterial.getMateriais()){
	//			if(m.getNome().equals(node.toString()) && m.getNomeUsuario().equals(baseDados.getUsuarioCorrente().getLogin())){
	//				return m;
	//			}
	//		}
	//		return null;
	//	}
	//fim coisas editar Perfil
}
