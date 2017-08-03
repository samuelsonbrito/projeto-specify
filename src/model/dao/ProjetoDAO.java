package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.util.logging.Level;
import java.util.logging.Logger;

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
			stmt = con.prepareStatement("INSERT INTO projeto(nome, dataInicio, dataAproxTermino, descricao, recursosFinanceiros, diaHoraCriacao)VALUES(?,?,?,?,?,?)");
			stmt.setString(1, p.getNome());
			
			
			stmt.setString(2, p.getDataInicio());
			stmt.setString(3, p.getDataAproxTermino());
			
			
			
			stmt.setString(4, p.getDescricao());
			stmt.setDouble(5, p.getRecursosFinanceiros());
			//stmt.setDate(2, );

			stmt.executeUpdate();
							
			
			JOptionPane.showMessageDialog(null, "Projeto salvo com sucesso!");
		} catch (SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar projeto: "+ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}
	
	
	
	public List<Projeto> read() {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Projeto> projetos = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM projeto");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Projeto projeto = new Projeto();

				projeto.setCodigo(rs.getInt("codigo"));
				projeto.setNome(rs.getString("nome"));
				projeto.setDataInicio(rs.getString("dataInicio"));
				projeto.setDataAproxTermino(rs.getString("dataAproxTermino"));
				projeto.setDescricao(rs.getString("descricao"));
				projeto.setRecursosFinanceiros(rs.getDouble("recursosFinanceiros"));
				projetos.add(projeto);
					
			}

		} catch (SQLException ex) {
			Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return projetos;

	}
	

}
