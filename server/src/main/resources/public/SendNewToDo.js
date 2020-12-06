function sendNewToDo(){
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
        var titleOfToDo = window.getElementById('titleOfToDo').value;
        var dateOfToDo = window.getElementById('dateOfToDo').value;
        var timeOfToDo = window.getElementById('timeOfToDo').value;
        var priorityOfToDo = window.getElementById('priorityOfToDo').value;
        var textForToDo = window.getElementById('textForToDo').value;

        request.open('POST', '/newToDo', true);
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        request.send('titleOfToDo='+titleOfToDo+'&dateOfToDo='+dateOfToDo+'&timeofToDo='+timeOfToDo+'&priorityOfToDo='+priorityOfToDo+'&textForToDo='+textForToDo);
    }
}