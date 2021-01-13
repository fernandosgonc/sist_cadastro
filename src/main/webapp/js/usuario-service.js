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

}
