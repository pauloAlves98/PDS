package controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.xml.internal.ws.util.StringUtils;

import model.BaseDados;
import model.Usuario;
import view.CadastroPanel;
import view.Mensagem;

public class ControllerCadastro {
	private CadastroPanel cadastro;
	private BaseDados baseDados ;
	
	public ControllerCadastro(CadastroPanel cadastro,BaseDados baseDados){
		this.baseDados = baseDados;
		this.cadastro = cadastro;
		
		try {
			cadastro.getPerfil1Button().setIcon(new ImageIcon(ImageIO.read(new File("res//image//cadastro//perfil1.jpg"))));
			cadastro.getPerfil2Button().setIcon(new ImageIcon(ImageIO.read(new File("res//image//cadastro//perfil2.jpg"))));
			cadastro.getPerfil3Button().setIcon(new ImageIcon(ImageIO.read(new File("res//image//cadastro//perfil3.jpg"))));
			cadastro.getPerfil4Button().setIcon(new ImageIcon(ImageIO.read(new File("res//image//cadastro//perfil4.jpg"))));
			cadastro.getAcerto().setIcon(new ImageIcon(ImageIO.read(new File("res//image//cadastro//acerto.png"))));
		}catch (IOException e) {
		
		}
		
		cadastro.getPerfil1Button().addActionListener((ActionEvent arg0)-> {
				cadastro.getAcerto().setVisible(true);
				cadastro.getAcerto().setBounds(210,340,50,50);
		});
		cadastro.getPerfil2Button().addActionListener((ActionEvent e) ->{
				cadastro.getAcerto().setVisible(true);
				cadastro.getAcerto().setBounds(320,340,50,50);
		});
		cadastro.getPerfil3Button().addActionListener((ActionEvent e) -> {
				cadastro.getAcerto().setVisible(true);
				cadastro.getAcerto().setBounds(438,340,50,50);

		});
		cadastro.getPerfil4Button().addActionListener((ActionEvent e)-> {
				cadastro.getAcerto().setVisible(true);
				cadastro.getAcerto().setBounds(550,340,50,50);
		});
		cadastro.getConcluirButton().addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// paleativo para saber pq o usuario n foi cadastrado , seria interessante aquele asterisco vermelho ou uma mensagem na primeira tela algo assim kk
				
				if(cadastro.getNomeField().getText().trim().length() <1 || cadastro.getSobrenomeField().getText().trim().length() <1 
				    || cadastro.getCpfField().getText().trim().length()<1 ||  new String(cadastro.getSenhaField().getPassword()).trim().length() <1 
				    || new String(cadastro.getConfirmarSenhaField().getPassword()).trim().length() <1) 
				{
					Mensagem.exibirDialogo("Um ou mais campos estão vazios");
					return;
				}
				else if(!new String(cadastro.getConfirmarSenhaField().getPassword()).equals( new String(cadastro.getSenhaField().getPassword()))) 
				{
					Mensagem.exibirDialogo("Senhas não estão iguais");
					return;
				}else if(!cadastro.getAcerto().isVisible()) 
				{
					Mensagem.exibirDialogo("Selecione uma das imagems");
					return;
				}else if(baseDados.isUsuarioEstaNaBase(cadastro.getLoginField().getText()) != null) 
				{
					Mensagem.exibirDialogo("Já existe um usuario com esse login");
					return;
				}
				
				String nome = StringUtils.capitalize(cadastro.getNomeField().getText().trim())+" "+ StringUtils.capitalize(cadastro.getSobrenomeField().getText().trim());
				char sexo;
		
				 if(((String)(cadastro.getSexoBox().getSelectedItem())).equals("Masculino"))
					 sexo = 'M';
				 else if(((String)(cadastro.getSexoBox().getSelectedItem())).equals("Feminino"))
					 sexo = 'F';
				 else 
					 sexo = 'N';
				String cpf = cadastro.getCpfField().getText();
				String caminhoImagem = null;
				
				if(cadastro.getAcerto().getBounds().equals(new Rectangle(210,340,50,50)))
					caminhoImagem = "res//image//cadastro//perfil1.jpg";
				else if(cadastro.getAcerto().getBounds().equals(new Rectangle(320,340,50,50)))
					caminhoImagem = "res//image//cadastro//perfil2.jpg";
				else if(cadastro.getAcerto().getBounds().equals(new Rectangle(438,340,50,50)))
					caminhoImagem = "res//image//cadastro//perfil3.jpg";
				else if(cadastro.getAcerto().getBounds().equals(new Rectangle(550,340,50,50)))
					caminhoImagem = "res//image//cadastro//perfil4.jpg";
				
				System.out.println(caminhoImagem);
				Usuario usuario = new Usuario(cadastro.getLoginField().getText(),new String(cadastro.getSenhaField().getPassword()), nome, cpf, sexo, caminhoImagem);
				
				if(baseDados.addUsuario(usuario)) {
					criarPastaUsuario(usuario.getLogin());
					Mensagem.exibirDialogo("Usuario cadastrado com sucesso");
//					if(baseDados.getUsuarios().size() - 1 == 0)
//						cadastro.ge precsaria do LoginPanel!!!
				}else {
					Mensagem.exibirDialogo("Erro ao cadastrar");
				}
				cadastro.limparCampos();
			}
		});
	}
	private void criarPastaUsuario(String login){
		//usando mkdirs ele cria todos os diretorios anteriores
		File dir = new File("res//usuarios//"+login);
		if(dir.exists()==false)
			dir.mkdirs();
	}
}
