function registerUser(){
    request = null;
    if(window.XMLHttpRequest){
        request = new XMLHttpRequest;
    }
    else if(window.ActiveXObject){
		try{
			request = new ActiveXObject('Msxml2.XMLHTTP');
		}
		catch(e1){
			try{
				request = new ActiveXObject('Microsoft.XMLHTTP');
			}
			catch(e2){
				document.getElementById('status').innerHTML = 
				"Request nicht möglich.";
			}
		}		
    }
    if(request != null){
        var username = window.getElementById('usernameInput').value;
        var password = window.getElementById('passwordInput').value;

        request.open('POST', '/register', true);
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        request.send('username='+username+'&password='+password);
    }
}