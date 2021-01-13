autenticacao = function () {

    this.valida = function () {

        nome = document.getElementById("inpNome").value;
        email = document.getElementById("inpEmail").value;
        senha = document.getElementById("inpSenha").value;

        if (nome == "" || email == "" || senha == "") {
            
            return false;
        } else {
            return true;
        }

    }
}