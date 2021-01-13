usuarioService = function() {

	this.teste = [];

	this.adicionar = function(usuario) {
		this.teste.push(usuario);
	}
	this.buscarTodos = function() {
		return this.teste;
	}

	this.buscarPorId = function(id) {
		return this.teste[id];
	}

	this.alterar = function(id, usuario){
		this.teste.splice(id, 1, usuario);
	}

	this.excluir = function(id){
		this.teste.splice(id, 1);
	}


}
