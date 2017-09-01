package model.bean;

import java.util.Date;

public class Projeto {
	private int codigo; //antes era numero
	private String nome;
	private String dataInicio; 
	private String dataAproxTermino; 
	private String descricao;
	private double recursosFinanceiros;
	private Date horaCriacao; 
	private String ultimaAtualizacao; 

	public Projeto() {
		// construtor vazio
	}

	public Projeto(int id, String nome, String dataInicio, String dataAproxTermino, String descricao,
			double recursosFinanceiros, Date horaCriacao, String ultimaAtualizacao) {
		this.codigo = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataAproxTermino = dataAproxTermino;
		this.descricao = descricao;
		this.recursosFinanceiros = recursosFinanceiros;
		this.horaCriacao = horaCriacao; 
		this.ultimaAtualizacao= ultimaAtualizacao;
		
	}
	
	public String getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(String date) {
		this.ultimaAtualizacao = date;
	}

	public Date getHoraCriacao(){
		return horaCriacao;
	}
	
	public void setHoraCriacao(Date horaCriacao){
		this.horaCriacao = horaCriacao; 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataAproxTermino() {
		return dataAproxTermino;
	}

	public void setDataAproxTermino(String dataAproxTermino) {
		this.dataAproxTermino = dataAproxTermino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getRecursosFinanceiros() {
		return recursosFinanceiros;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setRecursosFinanceiros(double recursosFinanceiros) {
		this.recursosFinanceiros = recursosFinanceiros;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDataInicio() {
		return dataInicio;
	}



}
