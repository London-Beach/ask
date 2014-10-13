var WEB_SOCKET_URL = 'ws://' + window.location.hostname + ':' + window.location.port + '/api/presenter';

$(function () {
    var webSocket = new WebSocket(WEB_SOCKET_URL);
    console.log("starting the connection process");

    webSocket.onopen = function () {
        console.log("Connected successfully!");
    };

    webSocket.onerror = function () {
        console.log("Could not connect!");
    };

    webSocket.onmessage = function (event) {
        console.log("Message received: " + event.data);
    };


    var canvas = $(".canvas")[0];
    var context = canvas.getContext("2d");
    context.canvas.width  = window.innerWidth;
    context.canvas.height = window.innerHeight;
});
