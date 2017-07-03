package model.bean;

public class Requisito {
	private int codigo; 
	private int id;
	private String sujeito;
	private String acaoRestricao;
	private String valorRazao;
	private GrauP grauPrioridade;
	private GrauD grauDificuldade; 
	private int estimativa;
	
	public enum GrauP{
		BAIXA, MEDIA, ALTA;
	}
	
	public enum GrauD{
		BAIXA, MEDIA, ALTA;
	}
	
	
	public Requisito(){
		
	}
	
	public Requisito(int id, String sujeito, String acaoRestricao, String valorRazao, GrauP grauPrioridade, GrauD grauDificuldade, int estimativa) {
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

	public GrauP getGrauPrioridade() {
		return grauPrioridade;
	}

	public void setGrauPrioridade( GrauP grauPrioridade) {
		this.grauPrioridade = grauPrioridade;
	}

	public  GrauD getGrauDificuldade() {
		return grauDificuldade;
	}

	public void setGrauDificuldade(GrauD grauDificuldade) {
		this.grauDificuldade = grauDificuldade;
	}

	public int getEstimativa() {
		return estimativa;
	}

	public void setEstimativa(int estimativa) {
		this.estimativa = estimativa;
	} 
	
	

}
