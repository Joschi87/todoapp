function checkPassword(){

    var passwordInput1 = document.getElementById("passwordInput").value;
    var passwordInput2 = document.getElementById("passwordInput2").value;

    if(passwordInput1 == passwordInput2){
        document.getElementById("returnCheckPassword").innerHTML = "Passwords are equal";
    }else{
        document.getElementById("returnCheckPassword").innerHTML = "Passwords are <b>NOT</b> equal";
    }

}