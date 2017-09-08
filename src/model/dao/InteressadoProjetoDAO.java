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

public class InteressadoProjetoDAO {

    Connection con;
    
    public InteressadoProjetoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public void create(InteressadoProjeto i) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO interessadoProjeto(intersCodigo, projCodigo, papelDesempenhado)VALUES(?,?,?)");
            stmt.setInt(1, i.getCodInteressado());
            stmt.setInt(2, i.getCodProj());
            stmt.setString(3, i.getPapelDesempenhado());
            
        
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Interessado cadastrado no projeto sucesso!");
        } 
        
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar interessado no projeto: "+ex);
        } finally {
           ConnectionFactory.closeConnection(con, stmt);
       }

    }
    
    public List<InteressadoProjeto> buscaInteressados() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<InteressadoProjeto> interessadosp = new ArrayList<>();

        try {
            stmt = con.prepareStatement(
            		"SELECT projCodigo, intersCodigo, papelDesempenhado, dataEntrada FROM interessadoProjeto WHERE dataSaida is null"
            		);
            
            rs = stmt.executeQuery();
            while (rs.next()) {

               InteressadoProjeto ip = new InteressadoProjeto();
               ip.setCodProj(rs.getInt("projCodigo"));              
               ip.setCodInteressado(rs.getInt("intersCodigo"));
               ip.setPapelDesempenhado(rs.getString("papelDesempenhado"));
               ip.setDataEntrada(rs.getString("dataEntrada"));
              // interessado.setSobrenome(rs.getString("sobrenome"));
               interessadosp.add(ip);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InteressadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return interessadosp;

    }
    
}
