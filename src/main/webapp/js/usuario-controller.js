usuarioController = function () {

    this.us = new usuarioService();
    this.autenticador = new autenticacao();




    this.aoClicarSalvar = function () {


        usuario = this.pegaDadosForm();

        if (this.autenticador.valida()) {

            if (!this.modoEdicao) {
                this.us.adicionar(usuario, function(){
                    window.alert("Salvo com sucesso!");
                }, function(){
                    window.alert("Erro ao salvar.");
                });
            } else {

                this.us.alterar(usuario.id, usuario, function(){
                    window.alert("Sucesso");
                }, function(){
                    window.alert("Erro");
                });
            }


        } else {
            window.alert("Campos obrigatorios devem ser preenchidos");
        }
        this.sairModoEdicao();
        this.limparForm();
        this.aoClicarListar();
    }


    this.aoClicarListar = function () {

        
        var self = this;
        usuarios = this.us.buscarTodos(function(usuarios){
            self.renderizarTabela(usuarios.lista);

        });
    }


    this.aoClicarEditar = function (id) {
        this.entrarModoEdicao();
        this.indice = id;
        usuario = this.us.buscarPorId(id, function(usuario){

            document.getElementById("inpNome").value = usuario.nome;
            document.getElementById("inpEmail").value = usuario.email;
            document.getElementById("inpEndereco").value = usuario.endereco;
            document.getElementById("inpSexo").value = usuario.sexo;
            document.getElementById("inpSenha").value = usuario.senha;
        });


        //usuario = this.pegaDadosForm();
        //this.us.alterar(id, usuario);

    }

    this.aoClicarExcluir = function (id) {
        this.us.excluir(id, function(){
            window.alert("Excluido!");            
        }, function(){
            window.alert("Erro ao excluir");
        });
        this.aoClicarListar();
        this.limparForm();

    }

    this.aoClicarCancelar = function () {
        this.limparForm();
    }


    this.pegaDadosForm = function () {
        nomeUsuario = document.getElementById("inpNome").value;
        emailUsuario = document.getElementById("inpEmail").value;
        enderecoUsuario = document.getElementById("inpEndereco").value;
        sexoUsuario = document.getElementById("inpSexo").value;
        senhaUsuario = document.getElementById("inpSenha").value;

        if(!this.modoEdicao){
        usuario = { nome: nomeUsuario, email: emailUsuario, endereco: enderecoUsuario, sexo: sexoUsuario, senha: senhaUsuario };
        }else{
            usuario = { nome: nomeUsuario, email: emailUsuario, endereco: enderecoUsuario, sexo: sexoUsuario, senha: senhaUsuario, id: this.indice };
        }
        return usuario;
    }



    this.modoEdicao = false;
    this.entrarModoEdicao = function () {
        this.modoEdicao = true;
    }
    this.sairModoEdicao = function () {
        this.modoEdicao = false;
    }


    this.limparForm = function () {
        document.getElementById("inpNome").value = "";
        document.getElementById("inpEmail").value = "";
        document.getElementById("inpEndereco").value = "";
        document.getElementById("inpSexo").value = "";
        document.getElementById("inpSenha").value = "";
    }

    this.renderizarTabela = function (usuarios) {
        

        headers = "<tr>"+
        "<th>Nome</th>"+
        "<th>Email</th>"+
        "<th>Endereco</th>"+
        "<th>Sexo</th>"+
        "<th>Senha</th>"+
        "</tr>";

        document.getElementById("tbUsuariosHead").innerHTML = headers;

        dados = "";
        for (i = 0; i < usuarios.length; i++) {
            dados += "<tr>";
            dados += "<td>" + usuarios[i].nome + "</td>";
            dados += "<td>" + usuarios[i].email + "</td>";
            dados += "<td>" + usuarios[i].endereco + "</td>";
            dados += "<td>" + usuarios[i].sexo + "</td>";
            dados += "<td>" + usuarios[i].senha + "</td>";
            dados += "<td><input type='button' value='Editar' onclick='uc.aoClicarEditar(" + usuarios[i].id + ")'></td>";
            dados += "<td><input type='button' value='Excluir' onclick='uc.aoClicarExcluir(" + usuarios[i].id + ")'></td>";
            dados += "</tr>";
        }

        document.getElementById("tbUsuariosBody").innerHTML = dados;
    }
















}