var ws;

function connect() {
    var username = document.getElementById("username").value;

    var host = document.location.host;
    var pathname = document.location.pathname;

    // ws = new WebSocket("ws://" +host  + pathname + "chat/" + username);
    ws = new WebSocket("ws://" +host  + pathname + "serverEndpoint");
    alert(uuidv1())
    ws.id = uuidv1()
    console.log(ws)

    ws.onmessage = function(event) {
        ws.id = 'gen_a_uuid'
        var log = document.getElementById("log");
        console.log(event.data);
        var message = JSON.parse(event.data);
        log.innerHTML += message.from + " : " + message.content + "\n";
    };
}

function send() {
    // var content = document.getElementById("msg").value;

    var json = JSON.stringify({
        "qrCodeId":"1234"
    });

    ws.send(json);
}