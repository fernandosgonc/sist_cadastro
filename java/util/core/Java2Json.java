package util.core;



import com.google.gson.Gson;


import util.entity.UsuarioInfos;


public class Java2Json {

	public static String ListToJson(UsuarioInfos info) {
		
		
		Gson gson = new Gson();
		String json = gson.toJson(info);
	
		
		return json;
	}
	
}
