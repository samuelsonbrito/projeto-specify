package model.bean;

import java.util.Date;

public class InteressadoProjeto {

	private int codProj;
	private int codInteressado;
	private String nome; 
	private String dataEntrada;
	private String dataSaida; 
	private String papelDesempenhado; 
	private boolean selected; 
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCodProj() {
		return codProj;
	}
	public void setCodProj(int codProj) {
		this.codProj = codProj;
	}
	public int getCodInteressado() {
		return codInteressado;
	}
	public void setCodInteressado(int codInteressado) {
		this.codInteressado = codInteressado;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	public String getPapelDesempenhado() {
		return papelDesempenhado;
	}
	public void setPapelDesempenhado(String papelDesempenhado) {
		this.papelDesempenhado = papelDesempenhado;
	}

	public void setSelected(boolean selected) {
		// TODO Auto-generated method stub
		this.selected=selected; 
	}
	public boolean isSelected() {
		return selected;
	}

	
}
