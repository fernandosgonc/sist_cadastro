package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import util.exceptions.UsuarioRepositoryException;

public class UsuarioRespositoryJDBC {

	private Connection conexao = ConnectionFactory.getConnection();

	public void adicionar(Usuario usuario) throws UsuarioRepositoryException {

		try {
			String sql = new String("insert into usuario (nome, email, endereco, sexo, senha) values(? , ? , ? ,? ,?)");
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getEndereco());
			stmt.setString(4, usuario.getSexo());
			stmt.setString(5, usuario.getSenha());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new UsuarioRepositoryException(e);
		}

	}

	public void excluir(Integer id) throws UsuarioRepositoryException {

		try {
			String sql = new String("delete from usuario where id=?");
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new UsuarioRepositoryException(e);
		}
	}

	public List<Usuario> buscarTodos() throws UsuarioRepositoryException {

		List<Usuario> lista = new ArrayList<Usuario>();

		try {
			String sql = new String("select * from usuario order by id");
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(result.getInt("id"));
				usuario.setNome(result.getString("nome"));
				usuario.setEmail(result.getString("email"));
				usuario.setEndereco(result.getString("endereco"));
				usuario.setSexo(result.getString("sexo"));
				usuario.setSenha(result.getString("senha"));
				lista.add(usuario);
			}

			stmt.close();
			result.close();

		} catch (SQLException e) {
			throw new UsuarioRepositoryException(e);
		}

		return lista;
	}

	public Usuario buscarPorId(Integer id) throws UsuarioRepositoryException {

		Usuario usuario = null;
		try {
			String sql = new String("select * from usuario where id=?");
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				usuario = new Usuario();
				usuario.setNome(result.getString("nome"));
				usuario.setEmail(result.getString("email"));
				usuario.setEndereco(result.getString("endereco"));
				usuario.setSexo(result.getString("sexo"));
				usuario.setSenha(result.getString("senha"));
			}
			result.close();
			stmt.close();
		} catch (SQLException e) {
			throw new UsuarioRepositoryException(e);
		}

		return usuario;
	}

	public Usuario editar(Usuario usuario) throws UsuarioRepositoryException {

		try {
			String sql = new String("update usuario set nome=?, email=?, endereco=?, sexo=?, senha=? where id=?");
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getEndereco());
			stmt.setString(4, usuario.getSexo());
			stmt.setString(5, usuario.getSenha());
			stmt.setInt(6, usuario.getId());

			stmt.execute();

			stmt.close();
		} catch (SQLException e) {
			throw new UsuarioRepositoryException(e);
		}

		return usuario;
	}

}
