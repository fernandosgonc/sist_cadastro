package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import repository.UsuarioRespositoryJDBC;
import util.core.Java2Json;
import util.entity.ListaInfos;
import util.entity.UsuarioInfos;
import util.exceptions.UsuarioRepositoryException;



@WebServlet(urlPatterns = "/sistCadastro")

public class UsuarioController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UsuarioRespositoryJDBC usuRepo = new UsuarioRespositoryJDBC();
	ListaInfos listaInfo = null;
	UsuarioInfos usuInfo = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String sexo = req.getParameter("sexo");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setEndereco(endereco);
		usuario.setSexo(sexo);
		usuario.setSenha(senha);
		
		
		//ADICIONAR NO REPOSITORY
		try {
			usuRepo.adicionar(usuario);
		} catch (UsuarioRepositoryException e) {
			throw new ServletException(e);
		}
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if(req.getParameter("id")!=null) {
			
			Usuario usuario = null;
			try {
				Integer id = Integer.parseInt(req.getParameter("id"));
				usuario = usuRepo.buscarPorId(id);
				
				String json = Java2Json.UsuarioToJson(usuario);
				
				resp.getWriter().print(json);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (UsuarioRepositoryException e) {
				throw new ServletException(e);
			}
			
		}else {
		
		
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			
			lista = usuRepo.buscarTodos();
			
			listaInfo = new ListaInfos(lista);
			String json = Java2Json.ListToJson(listaInfo);
			
			//for(int i = 0; i<lista.size(); i++){
				
				//resp.getWriter().print((lista.get(i).getNome()+"\n"));
				
			resp.getWriter().print(json);
			//}
			
		} catch (UsuarioRepositoryException e) {
			throw new ServletException(e);
		}
	}
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String sexo = req.getParameter("sexo");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setEndereco(endereco);
		usuario.setSexo(sexo);
		usuario.setSenha(senha);
		
		try {
			usuRepo.editar(usuario);
		} catch (UsuarioRepositoryException e) {
			throw new ServletException(e);
		}
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try{
			Integer id = Integer.parseInt((req.getParameter("id")));
			
			Usuario usuario = new Usuario();
			usuario.setId(id);
			
			usuRepo.excluir(id);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}catch (UsuarioRepositoryException e) {
			throw new ServletException(e);
		}
		
	}
	
}
