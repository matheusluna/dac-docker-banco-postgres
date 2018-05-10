/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dao;

import br.edu.ifpb.entidades.Cliente;
import br.edu.ifpb.fabrica.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheus
 */
public class DaoCliente {
    public List<Cliente> list() throws ClassNotFoundException, SQLException{
        List<Cliente> clientes = new ArrayList<>();
        Connection connection = new ConnectionFactory().getConnection();
        String sql = "select * from cliente";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            int id  = rs.getInt("id");
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            Cliente cliente = new Cliente(id, nome, cpf);
            clientes.add(cliente);
        }
        return clientes;
    }
    
    public boolean create(Cliente cliente) throws ClassNotFoundException, SQLException{
        Connection connection = new ConnectionFactory().getConnection();
        String sql = "insert into cliente values(?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, cliente.getId());
        stmt.setString(2, cliente.getNome());
        stmt.setString(3, cliente.getCpf());
        boolean resultado = !stmt.execute();
        stmt.close();
        connection.close();
        return resultado;
    }
}
