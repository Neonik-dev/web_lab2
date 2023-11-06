<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
    <link rel="shortcut icon" href="images/biscuit.png" type="image/x-icon"/>
</head>
<body>
<div class="container">
    <jsp:include page="static/header.html"/>
    <div class="content">
        <div class="main">
            <form action="<c:url value="/table" />" method="GET" id="form">
                <p>
                    X
                    <select name="param_x">
                        <option>-4</option>
                        <option>-3</option>
                        <option>-2</option>
                        <option>-1</option>
                        <option>0</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                    </select>
                </p>
                <p>
                    Y (3;3)
                    <input type="text" id="input_y" name="param_y">
                </p>
                <p>
                    R
                    <select name="param_r">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </p>
                <p id="error-message"></p>
                <p>
                    <input type="submit" value="Отправить форму">
                </p>

            </form>
        </div>
        <div class="sidebar">
            <canvas id="canvas" width="450px" height="450px">

            </canvas>
        </div>
    </div>
</div>

<script src="<c:url value="/js/validate.js"/>"></script>

<script src="<c:url value="/js/draw.js"/>"></script>
</body>
</html>
