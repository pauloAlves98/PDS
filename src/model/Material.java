package model;

public class Material {
	private String nome,caminho,descricao;
	private boolean isPasta;
	public Material(){}								//idetificar a qual usuario e objetivo o material esta associado
	public Material(String nome,String caminho,String descricao,boolean isPasta) {
		super();
		this.nome = nome;
		this.caminho = caminho;
		this.descricao = descricao;
		this. isPasta = isPasta;
	}
	
	public boolean isPasta() {
		return isPasta;
	}
	public void setPasta(boolean isPasta) {
		this.isPasta = isPasta;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
