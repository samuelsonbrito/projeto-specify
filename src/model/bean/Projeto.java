package model.bean;

public class Projeto {
	private int codigo; //antes era numero
	private String nome;
	private String dataInicio; 
	private String dataAproxTermino; 
	private String descricao;
	private float recursosFinanceiros;

	public Projeto() {
		// construtor vazio
	}

	public Projeto(int id, String nome, String dataInicio, String dataAproxTermino, String descricao,
			Float recursosFinanceiros) {
		this.codigo = id;
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

	public float getRecursosFinanceiros() {
		return recursosFinanceiros;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setRecursosFinanceiros(float recursosFinanceiros) {
		this.recursosFinanceiros = recursosFinanceiros;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDataInicio() {
		return dataInicio;
	}

}
