
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class BaseDados {
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private int usuarioCorrente;
	private static BaseDados instance;
	public int r(){
		return usuarioCorrente;
	}
	private BaseDados(){
		File file = new File("res//data//usuarios.xml");
		if(file.exists()) {
			carregarUsuariosXML();
			for(Usuario u :usuarios) // atualizando a imagem a partir de caminho salvo (é iviavel salvar imagems no banco)
				u.load(100,100);
		}
		usuarios.stream().filter(p -> p.getNome().startsWith("J"));
		usuarios.forEach(n ->  n.getNome());
	}
	
	public static BaseDados getInstance() {
		if(instance == null)
			instance = new BaseDados();
		return instance;
	}
	public static void setInstance(BaseDados instance) {
		BaseDados.instance = instance;
	}
	/**
	 * Carrega dados de usuarios a partir de um arquivo xml e atribui
	 * a atributos da classe BaseDados
	 */
	@SuppressWarnings("unchecked")
	public void carregarUsuariosXML() {
		XStream xStream = new XStream(new Dom4JDriver());
		FileReader file;
		try {
			file = new FileReader("res//data//usuarios.xml");
			xStream.autodetectAnnotations(true);
			xStream.alias("Usuario", Usuario.class);
			xStream.alias("usuarios", ArrayList.class);
			usuarios = ((ArrayList<Usuario>) (xStream.fromXML(file)));
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Salva dados que estão armazenados na lista de usuarios em um arquivo xml
	 */
	public void salvarUsuariosXML() {
		XStream xStream = new XStream(new Dom4JDriver());
		File file = new File("res//data//usuarios.xml");
		try {
			PrintWriter printWriter = new PrintWriter(file);
			xStream.autodetectAnnotations(true);
			printWriter.write(xStream.toXML(usuarios));
			printWriter.flush();
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Adiciona uma unidade de usuario a lista de usuarios
	 * @param usuario
	 * @return true para quando o usuario foi adicionado com exito e false caso já esteja cadastrado na base
	 */
	public boolean addUsuario(Usuario usuario) {
		if(isUsuarioEstaNaBase(usuario.getLogin() )!= null)
			return false;
		usuarios.add(usuario);
		salvarUsuariosXML();
		return true;
	}
	
	/**
	 * Muda o status do atributo boolean "ativo" do usuario para false assim o mesmo é considerado como não
	 * existente para que no futuro possa ser recuperado se nescessário
	 * @param usuario
	 */
	public void exluirUsuario(Usuario usuario) {
		for(Usuario u : usuarios)
			if(u.equals(usuario))
				u.setAtivo(false);
	}
	/**
	 * Verifica se o usuário está na lista de usuarios
	 * @param usuario
	 * @return 
	 */
	public Usuario getUsuarioCorrente() {
		return usuarios.get(usuarioCorrente);
	}
	
	public Usuario isUsuarioEstaNaBase(String login) {
		for(Usuario u : usuarios)
			if(u.getLogin().equalsIgnoreCase(login))
				return u;
		return null;
	}
	
	public boolean setProximoUsuario() {
		if(usuarioCorrente < usuarios.size()-1) {
			usuarioCorrente++;
			return true;
		}
		return false;
		
	}
	
	public boolean setAnteriorUsuario() {
		if(usuarioCorrente > 0) {
			usuarioCorrente--;
			return true;
		}
		return false;
	}
	public ArrayList<Usuario> getUsuarios(){
		return usuarios;
	}
	
}
