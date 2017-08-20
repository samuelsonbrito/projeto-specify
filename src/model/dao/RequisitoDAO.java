package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.bean.Projeto;
import model.bean.Requisito;


public class RequisitoDAO {
	
    Connection con;
    
    public RequisitoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Requisito r) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO requisito(tipoRequisito, id, sujeito, acaoRestricao, valorRazao, grauPrioridade, grauDificuldade, estimativa, pcodigo)VALUES(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, r.getTipoReq().name());
            stmt.setString(2, r.getId());
            stmt.setString(3, r.getSujeito());
            stmt.setString(4, r.getAcaoRestricao());
            stmt.setString(5, r.getValorRazao());
            stmt.setString(6, r.getGrauPrioridade().name());
            stmt.setString(7, r.getGrauDificuldade().name());
            stmt.setInt(8, r.getEstimativa());
            stmt.setInt(9, r.getProjcodigo());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Requisito salvo com sucesso!");
        } 
        
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar requisito: "+ex);
        } finally {
           ConnectionFactory.closeConnection(con, stmt);
       }

    }
    
    public List<Requisito> readID() {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Requisito> reqID = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT id, pcodigo FROM requisito");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Requisito requisito = new Requisito();
	
				requisito.setId(rs.getString("id"));
				requisito.setProjcodigo(rs.getInt("pcodigo"));
				
				
				reqID.add(requisito);
	
			}

		} catch (SQLException ex) {
			Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return reqID;

	}
    
    public void delete(String id) {

        PreparedStatement stmt = null;
	//	ResultSet rs = null;
        try {
            stmt = con.prepareStatement("DELETE FROM requisito WHERE id = ?");
            stmt.setString(1, id);
            stmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
           ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
   
}
