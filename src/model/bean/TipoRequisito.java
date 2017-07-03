package model.bean;

public class TipoRequisito {
	
	private int codigo;
	private Nome nome; 
	private String descricao;
	
	public enum Nome{
		FUNCIONAL,NAOFUNCIONAL,USUARIO,NEGOCIO;	
	}
	
	public TipoRequisito(){
		
	}
	
	public TipoRequisito(int codigo, Nome nome, String descricao) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Nome getNome() {
		return nome;
	}

	public void setNome(Nome nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

}
