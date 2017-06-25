package model.bean;

public class Requisito {
	private int id;
	private String sujeito;
	private String acaoRestricao;
	private String valorRazao;
	private int grauPrioridade;
	private int grauDificuldade; 
	private int estimativa;
	
	public Requisito(){
		
	}
	
	public Requisito(int id, String sujeito, String acaoRestricao, String valorRazao, int grauPrioridade, int grauDificuldade, int estimativa) {
		super();
		this.id = id;
		this.sujeito = sujeito;
		this.acaoRestricao = acaoRestricao;
		this.valorRazao = valorRazao;
		this.grauPrioridade = grauPrioridade;
		this.grauDificuldade = grauDificuldade;
		this.estimativa = estimativa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSujeito() {
		return sujeito;
	}

	public void setSujeito(String sujeito) {
		this.sujeito = sujeito;
	}

	public String getAcaoRestricao() {
		return acaoRestricao;
	}

	public void setAcaoRestricao(String acaoRestricao) {
		this.acaoRestricao = acaoRestricao;
	}

	public String getValorRazao() {
		return valorRazao;
	}

	public void setValorRazao(String valorRazao) {
		this.valorRazao = valorRazao;
	}

	public int getGrauPrioridade() {
		return grauPrioridade;
	}

	public void setGrauPrioridade(int grauPrioridade) {
		this.grauPrioridade = grauPrioridade;
	}

	public int getGrauDificuldade() {
		return grauDificuldade;
	}

	public void setGrauDificuldade(int grauDificuldade) {
		this.grauDificuldade = grauDificuldade;
	}

	public int getEstimativa() {
		return estimativa;
	}

	public void setEstimativa(int estimativa) {
		this.estimativa = estimativa;
	} 
	
	

}
