loginController = function(){

    this.autentica = new autenticacaologin();
    this.service = new loginService();

    this.aoClicarLogin =function(){

        valido = this.autentica.valida();

        if(valido){
            
            username = document.getElementById("txtUsername").value;
            password = document.getElementById("txtPassword").value;

            user = {username: username, password: password};

            this.service.buscarUser(user, function(){
                redr = "/sist_cadastro/cadastro-usuario.html";
                window.location.href = redr;
            }, function(){
                window.alert("Usuario e/ou senha incorreto(s).");
                window.location.reload();
            });
           

        }else{
            window.alert("Campos devem ser preenchidos.");
        }
    }


}