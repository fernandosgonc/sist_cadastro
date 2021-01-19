usuarioService = function() {

	this.teste = [];

	this.adicionar = function(usuario, sucesso, erro) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4) {
				if (this.status == 200) {
					sucesso();
				} else {
					erro();
				}
			}
		}

		usuarioStr = JSON.stringify(usuario);
		xhttp.open("POST", "sistCadastro?nome=" + usuario.nome + "&email=" + usuario.email + "&endereco=" + usuario.endereco + "&sexo=" + usuario.sexo + "&senha=" + usuario.senha, true);
		xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhttp.send();

		//this.teste.push(usuario);
	}


	this.buscarTodos = function(cb, erro) {
		//return this.teste;

		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4) {
				if (this.status == 200) {
					usuarios = JSON.parse(this.responseText);
					cb(usuarios);
				} else {
					erro();
				}
			}
		}
		xhttp.open("GET", "sistCadastro", true);
		xhttp.send();
	}

	this.buscarPorId = function(id, cb, erro) {

		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4) {
				if (this.status == 200) {
					usuario = JSON.parse(this.responseText);
					cb(usuario);
				} else {
					erro();
				}
			}
		}

		xhttp.open("GET", "sistCadastro?id=" + id, true);
		xhttp.send();

		return this.teste[id];
	}

	this.alterar = function(id, usuario, sucesso, erro) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4) {
				if (this.status == 200) {
					sucesso();
				} else {
					erro();
				}
			}
		}

		xhttp.open("PUT", "sistCadastro?nome=" + usuario.nome + "&email=" + usuario.email + "&endereco=" + usuario.endereco + "&sexo=" + usuario.sexo + "&senha=" + usuario.senha + "&id=" + usuario.id, true);
		xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhttp.send();
		//this.teste.splice(id, 1, usuario);
	}

	this.excluir = function(id, sucesso, erro) {

		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4) {
				if (this.status == 200) {
					sucesso();
				} else {
					erro();
				}
			}
		}

		xhttp.open("DELETE", "sistCadastro?id=" + id, true);
		xhttp.send();
		//this.teste.splice(id, 1);
	}


}
