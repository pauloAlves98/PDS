package model;

import java.util.ArrayList;

public class Materia {
	private String nome,descricao;
	private ArrayList<Material>materiais = new ArrayList<Material>();
	private ArrayList<String>topicos  = new ArrayList<String>();
	public Materia(){}
	public  Materia(String nome,String descricao,ArrayList<Material>materiais){
		this.nome = nome;
		this.descricao = descricao;
		this.materiais = materiais;
	}
	
	public ArrayList<String> getTopicos() {
		return topicos;
	}
	public void setTopicos(ArrayList<String> topicos) {
		this.topicos = topicos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ArrayList<Material> getMateriais() {
		return materiais;
	}
	public void setMateriais(ArrayList<Material> materiais) {
		this.materiais = materiais;
	}
	
}
