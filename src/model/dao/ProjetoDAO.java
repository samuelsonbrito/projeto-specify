package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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
		} 

	}
	
	 public void update(Projeto p) {

	       PreparedStatement stmt = null ;

	        try {
	        	//Projeto p = new Projeto();

	            stmt = con.prepareStatement("UPDATE projeto SET nome=?, dataAproxTermino=?, descricao=?, recursosFinanceiros=?, diaHoraCriacao=? WHERE codigo = ?");
	            stmt.setString(1, p.getNome());
				stmt.setString(2, p.getDataAproxTermino());	
				stmt.setString(3, p.getDescricao());
				stmt.setDouble(4, p.getRecursosFinanceiros());
				stmt.setString(5, p.getHoraCriacao());
				stmt.setInt(6, p.getCodigo());   

	            stmt.executeUpdate();

	            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
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
				projeto.setHoraCriacao(rs.getString("diaHoraCriacao"));
				projeto.setNome(rs.getString("nome"));
				projeto.setDataInicio(rs.getString("dataInicio"));
				projeto.setDataAproxTermino(rs.getString("dataAproxTermino"));
				projeto.setDescricao(rs.getString("descricao"));
				projeto.setRecursosFinanceiros(rs.getDouble("recursosFinanceiros"));
				projeto.setUltimaAtualizacao(rs.getString("ultimaAtualizacao"));
				projetos.add(projeto);
				

	
			}

		} catch (SQLException ex) {
			Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return projetos;

	}
	
	public List<Projeto> readName() {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Projeto> projetosN = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT nome, codigo FROM projeto");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Projeto projeto = new Projeto();
	
				projeto.setNome(rs.getString("nome"));
				projeto.setCodigo(rs.getInt("codigo"));
				
				projetosN.add(projeto);
	
			}

		} catch (SQLException ex) {
			Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return projetosN;

	}
	
	public void delete(int codigo) {

        PreparedStatement stmt = null;
	//	ResultSet rs = null;


        try {
            stmt = con.prepareStatement("DELETE FROM projeto WHERE codigo = ?");
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
           ConnectionFactory.closeConnection(con, stmt);
        }

    }
	
	

}
