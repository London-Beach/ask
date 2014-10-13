var WEB_SOCKET_URL = 'ws://' + window.location.hostname + ':' + window.location.port + '/api/presenter';

var growCanvasToParent = function () {
    $('canvas').each(function () {
        var $this = $(this);
        var $parent = $this.parent();

        $this.css("width", $parent.width());
        $this.css("height", $parent.height());
    });
};

$(function () {
    var webSocket = new WebSocket(WEB_SOCKET_URL);

    webSocket.onopen = function () {
        console.log("Connected successfully!");
    };

    webSocket.onerror = function () {
        console.log("Could not connect!");
    };

    webSocket.onmessage = function (event) {
        console.log("Message received: " + event.data);
    };

    $(window).resize(function() {
        growCanvasToParent();
    });

    growCanvasToParent();
});
