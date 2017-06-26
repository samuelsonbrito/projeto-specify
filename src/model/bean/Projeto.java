package model.bean;

public class Projeto {
	private int numero;
	private String nome;
	private String dataInicio; // ver depois para dividir em dia, mes, ano no 
								// banco de dados
	private String dataAproxTermino; // ver depois para dividir em dia, mes, ano
										// no banco de dados
	private String descricao;
	private String recursosFinanceiros;

	public Projeto() {
		// construtor vazio
	}

	public Projeto(int id, String nome, String dataInicio, String dataAproxTermino, String descricao,
			String recursosFinanceiros) {
		this.numero = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataAproxTermino = dataAproxTermino;
		this.descricao = descricao;
		this.recursosFinanceiros = recursosFinanceiros;
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

	public String getRecursosFinanceiros() {
		return recursosFinanceiros;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setRecursosFinanceiros(String recursosFinanceiros) {
		this.recursosFinanceiros = recursosFinanceiros;
	}

	public int getNumero() {
		return numero;
	}

	public String getDataInicio() {
		return dataInicio;
	}

}
