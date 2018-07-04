

package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("Usuario")
public class Usuario {
	private String login,senha,nome,cpf;
	private char sexo;
	private boolean ativo = true;
	private String caminhoImage;
	private ArrayList<Objetivo>objetivos = new ArrayList<Objetivo>();
	@XStreamOmitField
	ImageIcon imagemPerfil;
	public Usuario(){}
	public Usuario(String login, String senha, String nome, String cpf,char sexo,String caminhoImage) {
		super();
		this.caminhoImage = caminhoImage;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		load(100,100);
	}
	public ArrayList<Objetivo> getObjetivos() {
		return objetivos;
	}
	public void setObjetivos(ArrayList<Objetivo> objetivos) {
		this.objetivos = objetivos;
	}
	public void load(int l,int a) {
		try {
			imagemPerfil = new ImageIcon(ImageIO.read(new File(caminhoImage)));
			Image image = imagemPerfil.getImage().getScaledInstance(l,a, 100);
			imagemPerfil.setImage(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public ImageIcon getImagemPerfil() {
		return imagemPerfil;
	}

	public void setImagemPerfil(ImageIcon imagemPerfil) {
		this.imagemPerfil = imagemPerfil;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}

