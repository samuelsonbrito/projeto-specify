package model.bean;

import java.util.Date;

public class Requisito {
	
	private int codigo; 
	private String id;
	private String sujeito;
	private String acaoRestricao;
	private String valorRazao;
	private GrauP grauPrioridade;
	private GrauD grauDificuldade; 
	private int estimativa;
	private TipoReq tipoRequisito;
	private int projcodigo; 
	private Date horaCriacao; 
	private boolean selected; 
	
	
	public Date getHoraCriacao() {
		return horaCriacao;
	}

	public void setHoraCriacao(Date horaCriacao) {
		this.horaCriacao = horaCriacao;
	}

	public int getProjcodigo() {
		return projcodigo;
	}

	public void setProjcodigo(int projcodigo) {
		this.projcodigo = projcodigo;
	}

	public enum TipoReq{
		FUNCIONAL,NAOFUNCIONAL,USUARIO,NEGOCIO;	
	}
	
	public enum GrauP{
		BAIXA, MEDIA, ALTA;
	}
	
	public enum GrauD{
		BAIXA, MEDIA, ALTA;
	}
	
	public Requisito(){	
	}
	
	public Requisito(TipoReq tipoRequisito, int codigo, String id, String sujeito, String acaoRestricao, String valorRazao, GrauP grauPrioridade, GrauD grauDificuldade, int estimativa) {
		super();
		this.tipoRequisito=tipoRequisito; 
		this.codigo=codigo; 
		this.id = id;
		this.sujeito = sujeito;
		this.acaoRestricao = acaoRestricao;
		this.valorRazao = valorRazao;
		this.grauPrioridade = grauPrioridade;
		this.grauDificuldade = grauDificuldade;
		this.estimativa = estimativa;
	}

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public TipoReq getTipoReq() {
		return tipoRequisito;
	}

	public void setTipoReq(TipoReq tipoRequisito) {
		this.tipoRequisito = tipoRequisito;
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

	public void setSelected(boolean selected) {
		// TODO Auto-generated method stub
		this.selected=selected; 
	}
	public boolean isSelected() {
		return selected;
	}

	
	

}
