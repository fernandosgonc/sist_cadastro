package util.entity;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import util.core.Java2Json;

public class UsuarioInfos {
	
	private List<Usuario> lista = new ArrayList<Usuario>();
	//private Usuario usuario = new Usuario();
	
	
	public  UsuarioInfos(List<Usuario> lista) {
		this.lista = lista;
	}
	
	public  UsuarioInfos() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return lista.toString();
	}
	
	
	/*public static void main(String[] args) {
		List<Usuario> lista = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();
		usuario.setNome("jose");
		lista.add(usuario);
		UsuarioInfos ui = new UsuarioInfos(lista);
		String convert = Java2Json.ListToJson(ui);
		System.out.println(ui.toString());
	}*/
	
}