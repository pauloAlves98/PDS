package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.BaseDados;
import model.Personalizar;
import model.Usuario;
import view.LoginPanel;
import view.TelaPrincipal;

public class ControllerLoginPanel {
	private LoginPanel loginPanel;
	private BaseDados baseDados;

	public ControllerLoginPanel(LoginPanel loginPanel,BaseDados baseDados){
		this.loginPanel = loginPanel;
		this.baseDados = baseDados;
		ButtonHandler b = new ButtonHandler();
		this.loginPanel.getEntrarButton().addMouseListener(b);
		this.loginPanel.getProximaButton().addMouseListener(b);
		this.loginPanel.getAnteriorButton().addMouseListener(b);

		try {
			loginPanel.getProximaButton().setIcon(new ImageIcon(ImageIO.read(new File("res//image//login//setaD.png"))));
			loginPanel.getAnteriorButton().setIcon(new ImageIcon(ImageIO.read(new File("res//image//login//setaE.png"))));
			//baseDados.getUsuarioCorrente().load(100, 100);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(baseDados.getUsuarios().isEmpty()) {
			try {
				loginPanel.getImagemLoginLabel().setIcon(new ImageIcon(ImageIO.read(new File("res//image//login//imagem.jpg"))));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			loginPanel.getImagemLoginLabel().setIcon(baseDados.getUsuarioCorrente().getImagemPerfil());
			loginPanel.getNomeLoginLabel().setText(baseDados.getUsuarioCorrente().getLogin());
		}
		TelaPrincipal.getInstance().setVisible(true);

	}

	private class ButtonHandler implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			//eventos Comuns para todos os Buttoes
			JButton butoes = (JButton)e.getSource();
			butoes.setBackground(Personalizar.roxoMedio);
			butoes.setBorder(Personalizar.bordaBranca2);
			//eventos individuas

			if(e.getSource() == loginPanel.getEntrarButton()){

				if(baseDados.getUsuarioCorrente().getSenha().equals(new String(loginPanel.getSenhaField().getPassword()))){
					TelaPrincipal.getInstance().mudarPanel("funcionalidades");
					TelaPrincipal.getInstance().getFuncionalidadesPanel().getAbaPerfilPanel().getPerfilPanel().getNomeLabel().setText(baseDados.getUsuarioCorrente().getNome());
					TelaPrincipal.getInstance().getFuncionalidadesPanel().getAbaPerfilPanel().getPerfilPanel().getFotoPerfilLabel().setIcon(baseDados.getUsuarioCorrente().getImagemPerfil());
					baseDados.getUsuarioCorrente().load(150, 150);//redimensiona a imagem
					TelaPrincipal.getInstance().getFuncionalidadesPanel().getAbaPerfilPanel().getPerfilPanel().getFotoPerfilLabel().setIcon(baseDados.getUsuarioCorrente().getImagemPerfil());
				}
				// mudando o panel para panel com funcionalidades (perfil...)
				//mensagem de senha invalida
			}else if(e.getSource() == loginPanel.getProximaButton()){
				
				if(!(baseDados.setProximoUsuario()) ) {
					// limite superior atingido
				}else if(baseDados.getUsuarioCorrente().isAtivo() == false){//excluir
					mouseClicked(e);//recursão
					System.out.println("Testando");
					return;
				}
				else {
					System.out.println(baseDados.r());
					loginPanel.getNomeLoginLabel().setText(baseDados.getUsuarioCorrente().getLogin());
					loginPanel.getImagemLoginLabel().setIcon(baseDados.getUsuarioCorrente().getImagemPerfil());
				}

			}else if(e.getSource() == loginPanel.getAnteriorButton()){
				if(!baseDados.setAnteriorUsuario()) {
					// limite inferior atingido
				}else if(baseDados.getUsuarioCorrente().isAtivo() == false){//chama o teste novamente
					mouseClicked(e);//recursão
					return;
				}else {
					loginPanel.getNomeLoginLabel().setText(baseDados.getUsuarioCorrente().getLogin());
					loginPanel.getImagemLoginLabel().setIcon(baseDados.getUsuarioCorrente().getImagemPerfil());
				}
			}

		}
		public void mouseEntered(MouseEvent e) {
			//eventos Comuns para todos os Buttoes
			JButton butoes = (JButton)e.getSource();
			butoes.setBackground(Personalizar.roxoEscuro);
			butoes.setBorder(Personalizar.bordaBranca2);
		}
		public void mouseExited(MouseEvent e) {
			//eventos Comuns para todos os Buttoes
			JButton butoes = (JButton)e.getSource();
			butoes.setBackground(Personalizar.roxoMedio);
			butoes.setBorder(Personalizar.bordaBranca1);
		}
		public void mousePressed(MouseEvent e) {
			//eventos Comuns para todos os Buttoes
			JButton butoes = (JButton)e.getSource();
			butoes.setBackground(Personalizar.roxoClaro);
			butoes.setBorder(Personalizar.bordaBranca1);
		}
		public void mouseReleased(MouseEvent e) {
			//eventos Comuns para todos os Buttoes
			JButton butoes = (JButton)e.getSource();
			butoes.setBackground(Personalizar.roxoEscuro);
			butoes.setBorder(Personalizar.bordaBranca2);
		}
	}
}
