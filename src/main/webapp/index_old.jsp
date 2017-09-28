<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="resources/globle.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
</head>
<body>
    <button type="button" class="btn btn-success">Button</button>
    <h1>Welcome WebSocket World!</h1>
    <hr>
    <label for="text"></label><input id="text" type="text"/>
    <button onclick="send();">发送消息</button>
    <hr/>
    <button onclick="closeWebSocket();">关闭WebSocket连接</button>
    <hr/>
    <div id="message">

    </div>
    <script type="application/javascript">
        var websocket = null;
        if ('WebSocket' in window){
            websocket = new WebSocket("ws://localhost:8080/ssm_crud/websocket");
        }else {
            alert('当前浏览器不支持WebSocket！');
        }

        websocket.onopen = function () {
            setMessageInnerHtml('WebSocket连接成功！');
        };

        websocket.onclose = function () {
            setMessageInnerHtml('WebSocket已关闭！');
        };

        websocket.onerror = function () {
            setMessageInnerHtml('WebSocket连接发生错误！');
        };

        websocket.onmessage = function (event) {
            setMessageInnerHtml(event.data);
        };

        window.onbeforeunload = function () {
            alert('确定要关闭窗口，同时关闭WebSocket连接吗？')
            closeWebSocket();
        };

        function closeWebSocket() {
            websocket.close();
        }

        function setMessageInnerHtml(msg) {
            var $message = $("#message");
            $message.html($message.html() + msg + '<br>');
        }

        function send() {
            websocket.send($('#text').val());
        }
    </script>
</body>
</html>