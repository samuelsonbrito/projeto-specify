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
import model.bean.Requisito;


public class RequisitoDAO {
	
    Connection con;
    
    public RequisitoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Requisito r) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO requisito(tipoRequisito, id, sujeito, acaoRestricao, valorRazao, grauPrioridade, grauDificuldade, estimativa)VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, r.getTipoReq().name());
            stmt.setString(2, r.getId());
            stmt.setString(3, r.getSujeito());
            stmt.setString(4, r.getAcaoRestricao());
            stmt.setString(5, r.getValorRazao());
            stmt.setString(6, r.getGrauPrioridade().name());
            stmt.setString(7, r.getGrauDificuldade().name());
            stmt.setInt(8, r.getEstimativa());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Requisito salvo com sucesso!");
        } 
        
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar requisito: "+ex);
        } finally {
           ConnectionFactory.closeConnection(con, stmt);
       }

    }

}
