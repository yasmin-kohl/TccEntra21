function login (){
    var email = document.getElementById("email_login").value; 
    var senha = document.getElementById("senha_login").value;
    var url = 'http://localhost:8080/usuario/logar?email=' + email + '&senha=' + senha;

    var request = new XMLHttpRequest();
    request.open('GET', url, true);

    request.onload = function () {
        // Deu certo:
        if(this.status == 200) {

            var resp = JSON.parse(this.responseText);

            alert('Usuário ' + resp['nomeUsuario'] + ' logado com sucesso!');

            window.location.replace("./telas/TelaPrincipalUsuario.html");
        } else { // Se deu errado:
            alert('Um erro ocorreu no backend');
        }
    }
    
    request.send();
}


function atualiza (){
   
    var url = 'http://localhost:8080/produto/1/';

    var request = new XMLHttpRequest();
    request.open('GET', url, true);

    request.onload = function () {
        // Deu certo:
        if(this.status == 200) {

            var resp = JSON.parse(this.responseText);


            window.location.replace("./telas/TelaPrincipalUsuario.html");
        } else { // Se deu errado:
            alert('Email ou senha invalido');
        }
    }
    
    request.send('{"idUsuario":1,"nomeUsuario":"Victor","email":"Victor@gmail.com","cpf":"761.964.120-35"}');
}