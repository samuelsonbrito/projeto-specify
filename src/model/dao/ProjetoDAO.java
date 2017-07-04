package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Projeto;
import model.bean.Requisito;

public class ProjetoDAO {
	Connection con;

	public ProjetoDAO() {
		con = ConnectionFactory.getConnection();
	}

	public void create(Projeto p) {

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO projeto(nome, dataInicio, dataAproxTermino, descricao, recursosFinanceiros)VALUES(?,?,?,?,?)");
			//stmt.setInt(1, p.getNumero());
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getDataInicio());
			stmt.setString(3, p.getDataAproxTermino());
			stmt.setString(4, p.getDescricao());
			stmt.setDouble(5, p.getRecursosFinanceiros());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Projeto salvo com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar projeto: "+ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

}
