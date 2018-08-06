package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

public class ClienteDAO {

    public void cadastraCliente(Cliente objCliente) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionDAO.openConnection();
        PreparedStatement ps;
        String insereCliente = "INSERT INTO cliente (idCliente, nome, idade, email, endereco, cidade, sexo, estado, telefone) VALUES (?,?,?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(insereCliente);
        ps.setString(1, null);
        ps.setString(2, objCliente.getNome());
        ps.setInt(3, objCliente.getIdade());
        ps.setString(4, objCliente.getEmail());
        ps.setString(5, objCliente.getEndereco());
        ps.setString(6, objCliente.getCidade());
        ps.setString(7, objCliente.getSexo());
        ps.setString(8, objCliente.getEstado());
        ps.setInt(9, objCliente.getTelefone());
        ps.executeUpdate();
        conn.close();
        ps.close();
    }

    public ArrayList<Cliente> exibeClientes() {
        ArrayList<Cliente> listCliente = new ArrayList<>();
        try {
            Connection conn = ConectionDAO.openConnection();
            PreparedStatement ps;
            ResultSet rs;

            String buscaCliente = "SELECT * FROM cliente";
            ps = conn.prepareStatement(buscaCliente);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente objCliente = new Cliente();
                objCliente.setCodigo(rs.getInt("idCliente"));
                objCliente.setNome(rs.getString("nome"));
                objCliente.setTelefone(rs.getInt("telefone"));
                objCliente.setEmail(rs.getString("email"));
                objCliente.setIdade(rs.getInt("idade"));
                objCliente.setSexo(rs.getString("sexo"));
                objCliente.setEndereco(rs.getString("endereco"));
                objCliente.setCidade(rs.getString("cidade"));
                objCliente.setEstado(rs.getString("estado"));
                listCliente.add(objCliente);
                objCliente = null;
            }
            conn.close();
            ps.close();
            rs.close();

        } catch (SQLException erroSQL) {
            erroSQL.printStackTrace();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return listCliente;
    }

    public void deletaCliente(int idCliente) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionDAO.openConnection();
        PreparedStatement ps;
        String deletaSala = "DELETE FROM cliente WHERE idCliente = ?";
        ps = conn.prepareStatement(deletaSala);
        ps.setInt(1, idCliente);
        ps.executeUpdate();
        conn.close();
        ps.close();
    }

    public void atualizaDadoCliente(Cliente objCliente) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionDAO.openConnection();
        PreparedStatement ps;
        String atualizaDadoCliente = "UPDATE cliente SET nome = ?, idade = ?, email = ?, endereco = ?, cidade = ?, sexo = ?, estado = ?, telefone = ?  WHERE idCliente = '" + objCliente.getCodigo() + "'";
        ps = conn.prepareStatement(atualizaDadoCliente);
        ps.setString(1, objCliente.getNome());
        ps.setInt(2, objCliente.getIdade());
        ps.setString(3, objCliente.getEmail());
        ps.setString(4, objCliente.getEndereco());
        ps.setString(5, objCliente.getCidade());
        ps.setString(6, objCliente.getSexo());
        ps.setString(7, objCliente.getEstado());
        ps.setInt(8, objCliente.getTelefone());
        ps.executeUpdate();
        conn.close();
        ps.close();
    }

}
