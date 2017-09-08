package interfacesG;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.bean.Interessado;
import model.bean.InteressadoProjeto;
import model.bean.Requisito;


public class TableExibeInteressadosP extends AbstractTableModel{
	//private static final int Selecionar = 0;
	private static final int Codigo = 1;
	private static final int Nome = 2;
	private static final int PapelDesempenhado = 3;
	private static final int DataEntrada = 4;

	private List<InteressadoProjeto> dados = new ArrayList<>();
	private String[] colunas = {"...","Código","Nome","Papel Desempenhado", "Data Entrada"};

	@Override
	public String getColumnName(int column) {
		return colunas[column]; //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	public boolean isCellEditable(int linha, int coluna) {
		// apenas o campo "ATIVO" será editável
		return coluna == 0;
	}


	public void setValueAt(Object aValue, int linha, int coluna){
		InteressadoProjeto intproj=dados.get(linha);
		switch(coluna){
		case 0:
			intproj.setSelected((Boolean)aValue);
			break;
		case 1: 
			intproj.setCodInteressado((Integer)aValue);
			break;
		case 2: 
			intproj.setNome((String)aValue);
			break;
		case 3: 
			intproj.setPapelDesempenhado((String)aValue);
			break;
		case 4: 
			intproj.setDataEntrada((String)aValue);

		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");	
		}
		fireTableCellUpdated(linha, coluna); // Notifica a atualização da célula

	}

	@Override
	public Object getValueAt(int linha, int coluna) {

		switch(coluna){
		case 0:
			return dados.get(linha).isSelected();
		case 1:
			return dados.get(linha).getCodInteressado();
		case 2: 
			return dados.get(linha).getNome();
		case 3:
			return dados.get(linha).getPapelDesempenhado();
		case 4: 
			return dados.get(linha).getDataEntrada();
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");

		}
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Boolean.class;
		case Codigo:
			return Integer.class;
		case Nome: 
			return String.class;
		case PapelDesempenhado:
			return String.class;
		case DataEntrada:
			return String.class;

		default:
			// Não deve ocorrer, pois só existem 3 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	public void addRow(InteressadoProjeto ip){
		this.dados.add(ip);
		this.fireTableDataChanged();
	}

	public void removeRow(int linha){
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public InteressadoProjeto getInteressadoProjeto(int linha) {
		return dados.get(linha);
	}
	public void limpar() {
		// Remove todos os elementos da lista de requisitos
		dados.clear();
		fireTableDataChanged();
	}



}



