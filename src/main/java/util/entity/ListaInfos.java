package util.entity;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class ListaInfos {
	
	private List<Usuario> lista = new ArrayList<Usuario>();
	//private Usuario usuario = new Usuario();
	
	
	public  ListaInfos(List<Usuario> lista) {
		this.lista = lista;
	}
	
	
	
	public  ListaInfos() {
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
		Usuario usuario2 = new Usuario();
		usuario2.setNome("fernando");
		lista.add(usuario);
		lista.add(usuario2);
		UsuarioInfos ui = new UsuarioInfos(lista);
		String convert = Java2Json.ListToJson(ui);
		System.out.println(convert);
	}*/
	
}