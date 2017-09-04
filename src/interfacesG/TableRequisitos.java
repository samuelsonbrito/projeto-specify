package interfacesG;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.bean.Requisito;


public class TableRequisitos extends AbstractTableModel{
	private static final int Selecionar = 0;
	private static final int Codigo = 1;
	private static final int Identificador = 2;

	private List<Requisito> dados = new ArrayList<>();
	private String[] colunas = {"Selecionar","Código","Identificador"};

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
		return coluna == Selecionar;
	}


	public void setValueAt(Object aValue, int linha, int coluna){
		Requisito requisito=dados.get(linha);
		switch(coluna){
		case 0:
			requisito.setSelected((Boolean)aValue);
			break;
		case 1: 
			requisito.setCodigo((Integer)aValue);
			break;
		case 2: 
			requisito.setId((String)aValue);
			break;

		default:
			// Não deve ocorrer, pois só existem 3 colunas
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
			return dados.get(linha).getCodigo();
		case 2: 
			return dados.get(linha).getId();
		default:
			// Não deve ocorrer, pois só existem 3 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");

		}
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case Selecionar:
			return Boolean.class;
		case Codigo:
			return Integer.class;
		case Identificador: 
			return String.class;

		default:
			// Não deve ocorrer, pois só existem 3 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	public void addRow(Requisito r){
		this.dados.add(r);
		this.fireTableDataChanged();
	}

	public void removeRow(int linha){
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public Requisito getRequisito(int linha) {
		return dados.get(linha);
	}
	public void limpar() {
		// Remove todos os elementos da lista de requisitos
		dados.clear();
		fireTableDataChanged();
	}



}
