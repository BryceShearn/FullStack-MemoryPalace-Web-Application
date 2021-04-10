window.addEventListener('load', function (evt) {
    console.log('script.js loaded');
    init();
});

function init() {
    loadRooms();
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
                displayError('Error retrieving rooms: ' + xhr.status);
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