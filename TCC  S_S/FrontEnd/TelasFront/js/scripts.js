class Validator {

  constructor() {
    this.validations = [
      'data-min-length',
      'data-max-length',
      'data-only-letters',
      'data-email-validate',
      'data-required',
      'data-equal',
      'data-password-validate',
    ]
  }

  // inicia a validação de todos os campos
  validate(form) {

    // limpa todas as validações antigas
    let currentValidations = document.querySelectorAll('form .error-validation');

    if(currentValidations.length) {
      this.cleanValidations(currentValidations);
    }

    // pegar todos inputs
    let inputs = form.getElementsByTagName('input');
    // transformar HTMLCollection em arr
    let inputsArray = [...inputs];

    // loop nos inputs e validação mediante aos atributos encontrados
    inputsArray.forEach(function(input, obj) {

      // fazer validação de acordo com o atributo do input
      for(let i = 0; this.validations.length > i; i++) {
        if(input.getAttribute(this.validations[i]) != null) {

          // limpa string para saber o método
          let method = this.validations[i].replace("data-", "").replace("-", "");

          // valor do input
          let value = input.getAttribute(this.validations[i])

          // invoca o método
          this[method](input,value);

        }
      }

    }, this);

  }

  // método para validar se tem um mínimo de caracteres
  minlength(input, minValue) {

    let inputLength = input.value.length;

    let errorMessage = `O campo precisa ter pelo menos ${minValue} caracteres`;

    if(inputLength < minValue) {
      this.printMessage(input, errorMessage);
    }

  }

  // método para validar se passou do máximo de caracteres
  maxlength(input, maxValue) {

    let inputLength = input.value.length;

    let errorMessage = `O campo precisa ter menos que ${maxValue} caracteres`;

    if(inputLength > maxValue) {
      this.printMessage(input, errorMessage);
    }

  }

  // método para validar strings que só contem letras
  onlyletters(input) {

    let re = /^[A-Za-z]+$/;;

    let inputValue = input.value;

    let errorMessage = `Este campo não aceita números nem caracteres especiais`;

    if(!re.test(inputValue)) {
      this.printMessage(input, errorMessage);
    }

  }

  // método para validar e-mail
  emailvalidate(input) {
    let re = /\S+@\S+\.\S+/;

    let email = input.value;

    let errorMessage = `Insira um e-mail no padrão matheus@email.com`;

    if(!re.test(email)) {
      this.printMessage(input, errorMessage);
    }

  }

  // verificar se um campo está igual o outro
  equal(input, inputName) {

    let inputToCompare = document.getElementsByName(inputName)[0];

    let errorMessage = `Este campo precisa estar igual ao ${inputName}`;

    if(input.value != inputToCompare.value) {
      this.printMessage(input, errorMessage);
    }
  }
  
  // método para exibir inputs que são necessários
  required(input) {

    let inputValue = input.value;

    if(inputValue === '') {
      let errorMessage = `Este campo é obrigatório`;

      this.printMessage(input, errorMessage);
    }

  }

  // validando o campo de senha
  passwordvalidate(input) {

    // explodir string em array
    let charArr = input.value.split("");

    let uppercases = 0;
    let numbers = 0;

    for(let i = 0; charArr.length > i; i++) {
      if(charArr[i] === charArr[i].toUpperCase() && isNaN(parseInt(charArr[i]))) {
        uppercases++;
      } else if(!isNaN(parseInt(charArr[i]))) {
        numbers++;
      }
    }

    if(uppercases === 0 || numbers === 0) {
      let errorMessage = `A senha precisa um caractere maiúsculo e um número`;

      this.printMessage(input, errorMessage);
    }

  }

  // método para imprimir mensagens de erro
  printMessage(input, msg) {
  
    // checa os erros presentes no input
    let errorsQty = input.parentNode.querySelector('.error-validation');

    // imprimir erro só se não tiver erros
    if(errorsQty === null) {
      let template = document.querySelector('.error-validation').cloneNode(true);

      template.textContent = msg;
  
      let inputParent = input.parentNode;
  
      template.classList.remove('template');
  
      inputParent.appendChild(template);
    }

  }

  // remove todas as validações para fazer a checagem novamente
  cleanValidations(validations) {
    validations.forEach(el => el.remove());
  }

}

let form = document.getElementById('register-form');
let submit = document.getElementById('btn-submit');

let validator = new Validator();

// evento de envio do form, que valida os inputs
submit.addEventListener('click', function(e) {
  e.preventDefault();

  validator.validate(form);


  var cpf = document.querySelector("#cpf");

  cpf.addEventListener("blur", function(){
     if(cpf.value) cpf.value = cpf.value.match(/.{1,3}/g).join(".").replace(/\.(?=[^.]*$)/,"-");
  });
  function mascara(i){
   
    var v = i.value;
    
    if(isNaN(v[v.length-1])){ // impede entrar outro caractere que não seja número
       i.value = v.substring(0, v.length-1);
       return;
    }
    
    i.setAttribute("maxlength", "14");
    if (v.length == 3 || v.length == 7) i.value += ".";
    if (v.length == 11) i.value += "-";
 
 }

//modificar para ver o nome da tela correta
 function inserir() {
     var url = "http://localhost:8080/users";

     var usuario = {};
     usuario.userId    = document.getElementById("idUserId").value;
     usuario.senha     = document.getElementById("idSenha").value;
     usuario.nome      = document.getElementById("idNome").value;
     usuario.cpf       = document.getElementById("idCpf").value;

     var json = JSON.stringify(usuario);

     var xhr = new XMLHttpRequest();
     xhr.open("POST", url, true);
     xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
     xhr.onload = function () {
         var users = JSON.parse(xhr.responseText);
         if (xhr.readyState == 4 && xhr.status == "201") {
             console.table(users);
         } else {
             console.error(users);
         }
     }
     xhr.send(json);
 }



});

