package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import model.Personalizar;

public class LoginPanel extends JPanel{
	private JLabel imagemLoginLabel,nomeLoginLabel,senhaLabel;
	private JPasswordField senhaField;
	private JPanel painelD1,painelD2;
	private JLabel nomeSistamaLabel,logoSistema;
	private JButton entrarButton,proximaButton,anteriorButton;
	private JPanel fotoPainel;
	
	public LoginPanel(){
		setPreferredSize(new Dimension(800,120));
		setLayout(new GridLayout(1,2));
		//instancias
		painelD1 = new JPanel(null);
		painelD2 =  new JPanel(null);
		fotoPainel = new JPanel(new GridLayout(1,1));
		imagemLoginLabel = new JLabel();//Modificar no controller com o Usuario da Base.
		nomeLoginLabel = new JLabel("Hatake Kakashi");//Modificar no controller com o Usuario da Base
		senhaLabel = new JLabel("Senha");
		//logoSistema = new JLabel(new ImageIcon("res//image//login//logoPds_by_P_Alves.png"));
		senhaField = new JPasswordField(10);
		Image image = new ImageIcon("res//image//login//logoPds_by_P_Alves.png").getImage();
		image = image.getScaledInstance(150,100,100);
		nomeSistamaLabel = new JLabel(new ImageIcon(image));
		entrarButton = new JButton("Entrar");
		proximaButton = new JButton();
		anteriorButton = new JButton();
		//configurando Atributos
		nomeLoginLabel.setForeground(Color.white);
		nomeLoginLabel.setFont(Personalizar.agency19);
		senhaLabel.setForeground(Color.white);
		senhaLabel.setFont(Personalizar.agency19);
		nomeSistamaLabel.setFont(Personalizar.solidSans60);
		nomeSistamaLabel.setForeground(Color.white);
		entrarButton.setBackground(Personalizar.cinza);
		entrarButton.setBorder(Personalizar.bordaBranca1);
		entrarButton.setForeground(Color.white);
		entrarButton.setFocusPainted(false);
		proximaButton.setBackground(Personalizar.cinza);
		proximaButton.setBorder(Personalizar.bordaBranca1);
		proximaButton.setFocusPainted(false);
		anteriorButton.setBackground(Personalizar.cinza);
		anteriorButton.setBorder(Personalizar.bordaBranca1);
		anteriorButton.setFocusPainted(false);
		fotoPainel.setBorder(Personalizar.bordaBranca1);
		fotoPainel.setOpaque(false);
		
		fotoPainel.add(imagemLoginLabel);
		painelD2.add(fotoPainel);
		painelD2.add(nomeLoginLabel);
		painelD2.add(senhaLabel);
		painelD2.add(senhaField);
		painelD2.add(entrarButton);
		painelD2.add(proximaButton);
		painelD2.add(anteriorButton);
		painelD1.add(nomeSistamaLabel);
		//painelD1.add(logoSistema);
		add(painelD1);
		add(painelD2);
		
		//Bounds
		painelD2.setBackground(Personalizar.roxoClaro);
		painelD1.setBackground(Personalizar.roxoClaro);
		
		nomeSistamaLabel.setBounds(-100,12,400,100);
		fotoPainel.setBounds(50,3,102,100);
		
		nomeLoginLabel.setBounds(50,fotoPainel.getY()+	fotoPainel.getHeight(),400,19);
		senhaField.setBounds(fotoPainel.getX() + fotoPainel.getWidth()+15,fotoPainel.getHeight()/2,150,30);
		senhaLabel.setBounds(senhaField.getX(),senhaField.getY()-22,100,20);
		entrarButton.setBounds(senhaField.getX()+senhaField.getWidth()+5,senhaField.getY(),70,30);
		anteriorButton.setBounds(fotoPainel.getX()-22,fotoPainel.getY(),20,20);
		proximaButton.setBounds(fotoPainel.getX()+fotoPainel.getWidth()+2,fotoPainel.getY(),20,20);
	}
	
	public JLabel getImagemLoginLabel() {
		return imagemLoginLabel;
	}
	public void setImagemLoginLabel(JLabel imagemLoginLabel) {
		this.imagemLoginLabel = imagemLoginLabel;
	}
	public JLabel getNomeLoginLabel() {
		return nomeLoginLabel;
	}
	public void setNomeLoginLabel(JLabel nomeLoginLabel) {
		this.nomeLoginLabel = nomeLoginLabel;
	}
	public JPasswordField getSenhaField() {
		return senhaField;
	}
	public void setSenhaField(JPasswordField senhaField) {
		this.senhaField = senhaField;
	}
	public JButton getEntrarButton() {
		return entrarButton;
	}
	public void setEntrarButton(JButton entrarButton) {
		this.entrarButton = entrarButton;
	}
	public JButton getProximaButton() {
		return proximaButton;
	}
	public void setProximaButton(JButton proximaButton) {
		this.proximaButton = proximaButton;
	}
	public JButton getAnteriorButton() {
		return anteriorButton;
	}
	public void setAnteriorButton(JButton anteriorButton) {
		this.anteriorButton = anteriorButton;
	}
	
}
