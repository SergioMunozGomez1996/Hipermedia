//Funciones ejercicio 1

function suma(){
  var o1 = parseFloat(document.getElementById("o1").value);
  var o2 = parseFloat(document.getElementById("o2").value);

  if( isNaN(o1) || isNaN(o2)){
    alert("Los operadores son requeridos");
  }else {
    var result = o1 + o2;
    document.getElementById("resultado").innerHTML = result;
  }

}

function resta(){
  var o1 = parseFloat(document.getElementById("o1").value);
  var o2 = parseFloat(document.getElementById("o2").value);

  if( isNaN(o1) || isNaN(o2)){
    alert("Los operadores son requeridos");
  }else {
    var result = o1 - o2;
    document.getElementById("resultado").innerHTML = result;
  }

}

function multi(){
  var o1 = parseFloat(document.getElementById("o1").value);
  var o2 = parseFloat(document.getElementById("o2").value);

  if( isNaN(o1) || isNaN(o2)){
    alert("Los operadores son requeridos");
  }else {
    var result = o1 * o2;
    document.getElementById("resultado").innerHTML = result;
  }

}

function divi(){
  var o1 = parseFloat(document.getElementById("o1").value);
  var o2 = parseFloat(document.getElementById("o2").value);
  var  result = o1 / o2;

  if( isNaN(o1) || isNaN(o2)){
    alert("Los operadores son requeridos");
  }if( isNaN(result) ||  !isFinite(result) ){
    alert("El resultado es erroneo");
  }
  else {

    document.getElementById("resultado").innerHTML = result;
  }

}


//Funciones ejercicio 2

function limpiar(){
  document.getElementById("pantalla").innerHTML = "";
}

function setValue(valor){
  if(document.getElementById("pantalla").innerHTML == "ERROR"){
    document.getElementById("pantalla").innerHTML = valor;
  }else {
    document.getElementById("pantalla").innerHTML = document.getElementById("pantalla").innerHTML + valor;
  }
}

function calcular(){
  var expr = document.getElementById("pantalla").innerHTML;

  try {
    var result = eval( expr );
    if (!isFinite(result)){
    document.getElementById("pantalla").innerHTML = "ERROR";
    return;
  }
      document.getElementById("pantalla").innerHTML = result;
  } catch (e) {
      // error
      document.getElementById("pantalla").innerHTML = "ERROR";
  }
}

//Funciones ejercicio 3
function validar(){
  var user = document.getElementById("usuario").value;
  var password = document.getElementById("password").value;

  if(user === ''){
    document.getElementById("userError").style.display = 'block';
    document.getElementById("userError").innerHTML = "El campo del usuario es requerido";
  }else if (user.length<3) {
    document.getElementById("userError").style.display = 'block';
    document.getElementById("userError").innerHTML = "El campo del usuario debe tener al menos 3 caracteres"
  }else {
    document.getElementById("userError").style.display = 'block';
    document.getElementById("userError").innerHTML = "¡Validacion correcta!"
  }

  if(password === ''){
    document.getElementById("passwordError").style.display = 'block';
    document.getElementById("passwordError").innerHTML = "El password es requerido";
  }else if (password.length<3) {
    document.getElementById("passwordError").style.display = 'block';
    document.getElementById("passwordError").innerHTML = "El password debe tener al menos 3 caracteres"
  }else {
    document.getElementById("passwordError").style.display = 'block';
    document.getElementById("passwordError").innerHTML = "¡Validacion correcta!"
  }
}
