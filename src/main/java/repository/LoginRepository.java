package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class LoginRepository {
	
	private Connection conexao = ConnectionFactory.getConnection();
	
	public Usuario buscarUsuario(Usuario usuario) {
		

		Usuario user = null;
		try {
			String sql = new String("select * from usuario where email=? and senha=?");
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				user = new Usuario();
				user.setEmail(result.getString("email"));
				user.setSenha(result.getString("senha"));
			}
			
			stmt.close();
			result.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return user;
	}

}
