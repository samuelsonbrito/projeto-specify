package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Interessado;
import model.bean.InteressadoProjeto;
import model.bean.Projeto;
import model.bean.Requisito;

public class InteressadoDAO {
	
	
    Connection con;
    
    public InteressadoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Interessado i) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO interessado(nome, sobrenome, endereco, rg, cpf, telefone, email)VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, i.getNome());
            stmt.setString(2, i.getSobrenome());
            stmt.setString(3, i.getEndereco());
            stmt.setString(4, i.getRg());
            stmt.setString(5, i.getCpf());
            stmt.setString(6, i.getTelefone());
            stmt.setString(7, i.getEmail());
        
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Interessado cadastrado com sucesso!");
        } 
        
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar interessado: "+ex);
        } finally {
           ConnectionFactory.closeConnection(con, stmt);
       }

    }
    
    public List<Interessado> readForDesc(String nome) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Interessado> interessados = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT codigo, nome, sobrenome FROM interessado WHERE nome LIKE ? or sobrenome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            stmt.setString(2, "%"+nome+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

               Interessado interessado = new Interessado();
               
               interessado.setCodigo(rs.getInt("codigo"));
               interessado.setNome(rs.getString("nome")+" "+rs.getString("sobrenome"));
              // interessado.setSobrenome(rs.getString("sobrenome"));
               
                interessados.add(interessado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InteressadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return interessados;

    }
    
    public List<Interessado> readNomeSobreN() {   //para JTable

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Interessado> interessado = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT codigo,nome, sobrenome FROM interessado");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Interessado i = new Interessado(); 
				i.setCodigo(rs.getInt("codigo"));
				i.setNome(rs.getString("nome")+" "+ rs.getString("sobrenome"));
				interessado.add(i);
	
			}

		} catch (SQLException ex) {
			Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return interessado;

	}
    


}
