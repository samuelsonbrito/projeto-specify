package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Interessado;
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
    

}
