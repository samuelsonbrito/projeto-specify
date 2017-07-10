package model.bean;

public class Interessado {
	private String nome;
	private String sobrenome;
	private String endereco; 
	private int rg;
	private int cpf;
	private String telefone; 
	private String email;
	
	public Interessado(){
		
	}
	
	public Interessado(String nome, String sobrenome, String endereco, int rg, int cpf, String telefone, String email) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
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

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
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
	
	
	

}
