package util.entity;

import model.Usuario;
import util.core.Java2Json;

public class UsuarioInfos {

	private Usuario usuario;
	
	public UsuarioInfos() {}
	
	public UsuarioInfos(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public String toString() {
		return usuario.toString();
	}
	
	
	
	/*public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setNome("vishMaria");
		String json = Java2Json.UsuarioToJson(usuario);
		System.out.println(json);
	}*/
}
