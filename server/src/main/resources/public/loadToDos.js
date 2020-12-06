function httpGet(){
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "/allToDoAsList", true);
    xmlHttp.send(null);
    return xmlHttp.responseText;
}

function loadToDos() {
    var jsonObjFromServer = httpGet();
    console.log(jsonObjFromServer);
    document.getElementById("test").innerHTML = jsonObjFromServer;
}