package software;

public class Projeto {
	private int id;
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
		this.id = id;
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

	public void setRecursosFinanceiros(String recursosFinanceiros) {
		this.recursosFinanceiros = recursosFinanceiros;
	}

	public int getId() {
		return id;
	}

	public String getDataInicio() {
		return dataInicio;
	}

}
