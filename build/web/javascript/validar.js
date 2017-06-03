
function validarFormCliente(){
    console.log("llegue");
    var nombre, telefono, email, pass, vPass, expRegular;
    nombre = document.getElementById("nombre").value;
    telefono = document.getElementById("telefono").value;
    email = document.getElementById("email").value;
    pass  = document.getElementById("pass").value;
    vPass = document.getElementById("vPass").value;
    expRegular = /\w+@\w+\.+[a-z]/;
    if(nombre.length > 20){
        alert("el nombre de la empresa es demasiado largo");
        return false;
    }else
    if(isNaN(telefono)){
        alert("el telefono solo debe contener numeros");
        return false;
    }else
    if(telefono.length !== 8 ){
        alert("el telefono de la empresa debe tener 8 digitos");
        return false;
    }else
    if(!expRegular.test(email)){
        alert("asegurate de que el correo cumpla con el formato: ejemplo1@ejemplo2.ejemplo3");
        return false;
    }else
    if(pass !== vPass){
        alert("La contrasenas no son iguales, verifica de nuevo");
        return false;
    }
    
    
}

function validarFormEditarCliente(){
    var nombre, telefono, email, expRegular;
    nombre = document.getElementById("nombre").value;
    telefono = document.getElementById("telefono").value;
    email = document.getElementById("email").value;
    expRegular = /\w+@\w+\.+[a-z]/;
    if(nombre.length > 20){
        alert("el nombre de la empresa es demasiado largo");
        return false;
    }else
    if(nombre.length < 3){
        alert("el nombre de la empresa es demasiado corto");
        return false;
    }else
    if(isNaN(telefono)){
        alert("el telefono solo debe contener numeros");
        return false;
    }else
    if(telefono.length !== 8 ){
        alert("el telefono de la empresa debe tener 8 digitos");
        return false;
    }else
    if(!expRegular.test(email)){
        alert("asegurate de que el correo cumpla con el formato: ejemplo1@ejemplo2.ejemplo3");
        return false;
    }

    
    
}

