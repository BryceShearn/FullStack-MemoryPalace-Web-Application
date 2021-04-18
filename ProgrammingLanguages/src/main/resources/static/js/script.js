window.addEventListener('load', function (evt) {
    console.log('script.js loaded');
    init();
}   );

function init() {
    loadRooms();
        let getRooms = document.getElementById('getId');
            getRooms.addEventListener('click', function(e) {

            e.preventDefault
            console.log(document.getElementsByName('id').value);
            loadRoom(document.getElementsByName('id').value) 
        }   )
}

function loadRooms() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'api/rooms');
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let rooms = JSON.parse(xhr.responseText);
                displayRooms(rooms);
            }
            else {
                displayError('Error retrieving Rooms: ' + xhr.status);
            }
        }
    };
    xhr.send();
}

function loadRoom(id){
    let xhr = new XMLHttpRequest();
    xhr.open('get', `api/rooms/${id}`);
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 200){
                let rooms = JSON.parse(xhr.responseText);
                console.log(rooms);
                displayRooms(rooms);
            } 
            else {
                displayError('Error Retrieving Room: '  + xhr.status)
            }
        }
    };
    xhr.send();
}

function createRoom(id){
    let xhr = new XMLHttpRequest();
    xhr.open('post', `api/rooms/${id}`);
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 200 || xhr.status === 204){
                let rooms = JSON.parse(xhr.responseText);
                console.log(rooms);
                displayRooms(rooms);
            } 
            else {
                displayError('Error Creating Room: '  + xhr.status)
            }
        }
    };
    xhr.send();
}

function updateRoom(id){
    let xhr = new XMLHttpRequest();
    xhr.open('put', `api/rooms/${id}`);
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 200 || xhr.status === 204){
                let rooms = JSON.parse(xhr.responseText);
                console.log(rooms);
                displayRooms(rooms);
            }  
            else {
                displayError('Error Updating RoomL '  + xhr.status)
            }
        }
    };
    xhr.send();
}

function deleteRoom(id){
    let xhr = new XMLHttpRequest();
    xhr.open('delete', `api/rooms/${id}`);
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 200 || xhr.status === 204){
                let rooms = JSON.parse(xhr.responseText);
                console.log(rooms);
                displayRooms(rooms);
            } 
            else {
                displayError('Error Deleting Room: '  + xhr.status)
            }
        }
    };
    xhr.send();
}


function displayError(msg) {
    //TODO
    let div = document.getElementById('errors');
    let h1 = document.createElement('h3');
    h1.textContent = msg;
    div.appendChild(h1);
}

function displayRooms(rooms) {
    //TODO
    let div = document.getElementById('roomTable');

    for (const room of rooms) {
        let li = document.createElement('li');
        li.textContent = room.name;
        div.appendChild(li);
    }
}