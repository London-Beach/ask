var WEB_SOCKET_URL = 'ws://' + window.location.hostname + ':' + window.location.port + '/api/audience';

$(function () {
    var webSocket = new WebSocket(WEB_SOCKET_URL);

    webSocket.onopen = function () {
        console.log("Connected successfully!");
    };

    webSocket.onerror = function () {
        console.log("Could not connect!");
    };

    $('#example').on('click', function () {
        console.log("Message sent!");
        webSocket.send("Some message");
    });
});
