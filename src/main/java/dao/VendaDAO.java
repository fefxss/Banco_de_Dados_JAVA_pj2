package dao;

import factory.ConnectionFactory;
import model.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VendaDAO implements GenericDAO<Venda, Integer> {

    @Override
    public void inserir(Venda entidade) {
        String sql = "insert into java_venda(id_vendedor, total, data) values(?, ?, ?)";

        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, entidade.getVendedor());
            ps.execute(); // ps.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Venda> listar() {
        return List.of();
    }
}
