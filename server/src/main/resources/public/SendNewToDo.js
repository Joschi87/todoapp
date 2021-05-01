data = {
    title: null,
    date: null,
    time: null,
    priority: null,
    text: null
}

function sendNewToDo(){

    data.title = $('#titleOfToDo').val();
    data.date = $('#dateOfToDo').val();
    data.time = $('#timeOfToDo').val();
    data.priority = $('#priorityOfToDo').val();
    data.text = $('#textOfToDo').val();

    $.post('/newToDo', data).done(
       function alertSuccessful(){
        alert("ToDo are created!");
       }
    ).fail(
        function alertFail(){
            alert("ToDo can not created");
        }
    )
}