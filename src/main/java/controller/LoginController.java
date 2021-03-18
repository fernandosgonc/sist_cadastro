package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import repository.LoginRepository;
import util.validation.LoginValidation;


@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginRepository lr = new LoginRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Usuario usuario = new Usuario();
		usuario.setEmail(username);
		usuario.setSenha(password);
		
		try{
			boolean valido = LoginValidation.validaUser(usuario, lr.buscarUsuario(usuario));
			resp.getWriter().print("deu certo");
			
		}catch (Exception e) {
			throw new ServletException();
		}
		
		
		
	}
	
}
