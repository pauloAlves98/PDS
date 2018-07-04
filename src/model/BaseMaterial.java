package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class BaseMaterial {
	private ArrayList<Material> materiais = new ArrayList<>();
	public BaseMaterial(){
		
		File file = new File("res//data//material.xml");
		if(file.exists()) {
			carregarMateriaisXML();
			//for(Material u :materiais) // atualizando a imagem a partir de caminho salvo (é iviavel salvar imagems no banco)
				//u.load(100,100);
		}
	}
	
	public ArrayList<Material> getMateriais() {
		return materiais;
	}
	public void setMateriais(ArrayList<Material> materiais) {
		this.materiais = materiais;
	}
	{
		//materiais.add(new Material("video","res//data//video//video.mp4","Arquivo em video para testes bla bla","João","Local"));
	}
	public Material getMaterial(String caminho) {
		for(Material m : materiais) 
			if(caminho.equalsIgnoreCase(m.getCaminho()))
					return m;
		return null;
	}
	public void carregarMateriaisXML() {
		XStream xStream = new XStream(new Dom4JDriver());
		FileReader file;
		try {
			file = new FileReader("res//data//material.xml");
			xStream.alias("Material", Material.class);
			xStream.alias("materiais", ArrayList.class);
			materiais  = ((ArrayList<Material>) (xStream.fromXML(file)));
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
	public void salvarMateriasXML() {
		XStream xStream = new XStream(new Dom4JDriver());
		File file = new File("res//data//material.xml");
		try {
			PrintWriter printWriter = new PrintWriter(file);
			xStream.autodetectAnnotations(true);
			printWriter.write(xStream.toXML(materiais));
			printWriter.flush();
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
