autenticacaologin = function(){

    this.valida = function(){

        username = document.getElementById("txtUsername").value;
        password = document.getElementById("txtPassword").value;

        if(username == "" || password == ""){
            
            return false;
        }else{
            return true;
        }


    }

}