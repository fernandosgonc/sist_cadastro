loginService = function(){

    this.buscarUser = function(user, sucesso, erro){


       var xhttp = new XMLHttpRequest();
       xhttp.onreadystatechange = function(){
            if(xhttp.readyState == 4){
                if(xhttp.status == 200){
                    sucesso();
                }else{
                    erro();
                   
                }
            }
        }
            
            xhttp.open("GET", "login?username="+user.username+"&password="+user.password, true);
            xhttp.send();
            
    }


}