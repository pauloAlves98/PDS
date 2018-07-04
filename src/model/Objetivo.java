package model;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Objetivo")
public class Objetivo {
	
	public String nome,descricao,prioridade;
	private int progresso;
	private ArrayList<Materia>materias = new ArrayList<Materia>();
	public Objetivo(){}
	public Objetivo(String nome,String descricao,String prioridade){
		this.nome = nome;
		this.descricao = descricao;
		this.prioridade = prioridade;
	}
	public int getProgresso() {
		return progresso;
	}

	public void setProgresso(int progresso) {
		this.progresso = progresso;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
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
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	
}
