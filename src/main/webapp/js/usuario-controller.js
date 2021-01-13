usuarioController = function () {

    this.us = new usuarioService();


    

    this.aoClicarSalvar = function () {

        nomeUsuario = document.getElementById("inpNome").value;
        emailUsuario = document.getElementById("inpEmail").value;
        enderecoUsuario = document.getElementById("inpEndereco").value;
        sexoUsuario = document.getElementById("inpSexo").value;
        senhaUsuario = document.getElementById("inpSenha").value;

        usuario = { nome: nomeUsuario, email: emailUsuario, endereco: enderecoUsuario, sexo: sexoUsuario, senha: senhaUsuario };
        this.us.adicionar(usuario);


        this.aoClicarListar();
    }


    this.aoClicarListar = function () {
        
        this.renderizarTabela();
    }



    this.aoClicarEditar = function (id){

        usuario = this.us.buscarPorId(id);
        
        document.getElementById("inpNome").value = usuario.nome;
        document.getElementById("inpEmail").value = usuario.email;
        document.getElementById("inpEndereco").value = usuario.endereco;
        document.getElementById("inpSexo").value = usuario.sexo;
        document.getElementById("inpSenha").value = usuario.senha;

    }

    
    
    this.aoClicarExcluir = function (){}



    this.aoClicarCancelar = function () {
        document.getElementById("inpNome").value = "";
        document.getElementById("inpEmail").value = "";
        document.getElementById("inpEndereco").value = "";
        document.getElementById("inpSexo").value = "";
        document.getElementById("inpSenha").value = "";
    }


    this.renderizarTabela = function(){
        usuarios = this.us.buscarTodos();

        dados = "";
        for(i = 0; i<usuarios.length; i++){
            dados += "<tr>";
            dados += "<td>"+usuarios[i].nome+"</td>";
            dados += "<td>"+usuarios[i].email+"</td>";
            dados += "<td>"+usuarios[i].endereco+"</td>";
            dados += "<td>"+usuarios[i].sexo+"</td>";
            dados += "<td>"+usuarios[i].senha+"</td>";
            dados+= "<td><input type='button' value='Editar' onclick='uc.aoClicarEditar("+i+")'></td>";
            dados+= "<td><input type='button' value='Excluir' onclick='uc.aoClicarExcluir("+i+")'></td>";
            dados += "</tr>";
        }

        document.getElementById("tbUsuariosBody").innerHTML = dados;
    }


    








    
   



}