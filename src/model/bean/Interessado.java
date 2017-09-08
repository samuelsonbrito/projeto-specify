package model.bean;

import java.util.Date;

public class Interessado {
	private int codigo; 
	private String nome; 
	private String sobrenome; 
	private String endereco; 
	private String rg;
	private String cpf; 
	private String telefone;
	private String email; 
	private String dataCriacao; 
	private boolean selected; 
	
	
	public Interessado (){
		
	}

	public Interessado(int codigo, String nome, String sobrenome, String endereco, String rg, String cpf, String telefone,
			String email, String dataCriacao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.dataCriacao = dataCriacao;
	}
	
	public void setSelected(boolean selected) {
		// TODO Auto-generated method stub
		this.selected=selected; 
	}
	public boolean isSelected() {
		return selected;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	
	

}
