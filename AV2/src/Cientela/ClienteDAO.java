package Cientela;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

	public void incluirCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = ConnectionFactory.createConnection();

        String sql = "INSERT INTO Clientes (nome, cpf, email, endereco, cep) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getEndereco());
        ps.setString(5, cliente.getCep());
        ps.execute();
    }

    public void alterarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = ConnectionFactory.createConnection();

        String sql = "UPDATE Clientes SET nome = ?, email = ?, endereco = ?, cep = ? WHERE cpf = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEmail());
        ps.setString(3, cliente.getEndereco());
        ps.setString(4, cliente.getCep());
        ps.setString(5, cliente.getCpf());
        ps.executeUpdate();
    }

    public void excluirCliente(String cpf) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = ConnectionFactory.createConnection();

        String sql = "DELETE FROM Clientes WHERE cpf = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cpf);
        ps.executeUpdate();
    }

    public List<Cliente> listarClientes() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = ConnectionFactory.createConnection();

        String sql = "SELECT * FROM Clientes";
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);

        List<Cliente> clientes = new ArrayList<>();
        while (rs.next()) {
            Cliente cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("endereco"),
                    rs.getString("cep")
            );
            clientes.add(cliente);
        }
        return clientes;
    }
}
