package util.validation;

import model.Usuario;

public class LoginValidation {

	public static boolean validaUser (Usuario usuario1, Usuario usuario2) {
		
		if(usuario1.getEmail().equals(usuario2.getEmail())  &&
				usuario1.getSenha().equals(usuario2.getSenha())) {
			return true;
		}
		
		return false;
		
	}
	
}
