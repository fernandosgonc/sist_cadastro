package util.core;



import com.google.gson.Gson;

import model.Usuario;
import util.entity.ListaInfos;


public class Java2Json {

	public static String ListToJson(ListaInfos info) {
		
		
		Gson gson = new Gson();
		String json = gson.toJson(info);
	
		
		return json;
	}
	
	
	public static String UsuarioToJson(Usuario usuario) {
		
		Gson gson = new Gson();
		String json = gson.toJson(usuario);
		
		return json;
	}
	
}
