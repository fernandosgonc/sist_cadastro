usuarioService = function() {

	this.teste = [];

	this.adicionar = function(usuario, sucesso, erro) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function(){
			if(this.readyState == 4){
				if(this.status==200){
					sucesso();
				}else{
					erro();
			}
		}
	}

		usuarioStr = JSON.stringify(usuario);
		xhttp.open("POST", "sistCadastro?nome="+usuario.nome+"&email="+usuario.email+"&endereco="+usuario.endereco+"&sexo="+usuario.sexo+"&senha="+usuario.senha, true);
		xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhttp.send();

		//this.teste.push(usuario);
	}


	this.buscarTodos = function(cb) {
		//return this.teste;

		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function(){
			if(this.status == 200 && this.readyState==4){
				usuarios = JSON.parse(xhttp.responseText);
				 cb(usuarios);
			}
		}

		xhttp.open("GET", "sistCadastro", true);
		xhttp.send();
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
