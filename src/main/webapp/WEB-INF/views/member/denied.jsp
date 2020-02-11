<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Sejong Track</title>

    <style>
        @font-face {
            font-family:'project';
            src: url(../resources/fonts/project.ttf)
        }
        html,
        body {
            height: 100%;
            width: 100%;
            padding: 0px;
            margin: 0px;
        }

        html {
            background: #eee;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .box {
            width: 100%;
            height: 100%;
            border-radius: 5px;
            box-shadow: 0 2px 30px rgba(black, .2);
            background: lighten(#f0f4c3, 10%);
            position: relative;
            overflow: hidden;
            transform: translate3d(0, 0, 0);
        }

        .wave {
            opacity: .4;
            position: absolute;
            top: 3%;
            left: 50%;
            background: #0af;
            width: 500px;
        ;
            height: 500px;
            margin-left: -250px;
            margin-top: 30px;
            transform-origin: 50% 48%;
            border-radius: 43%;
            animation: drift 3000ms infinite linear;
        }

        .wave.-three {
            animation: drift 5000ms infinite linear;
        }

        .wave.-two {
            animation: drift 7000ms infinite linear;
            opacity: .1;
            background: yellow;
        }

        .box:after {
            content: '';
            display: block;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background: linear-gradient(to bottom, rgba(#e8a, 1), rgba(#def, 0) 80%, rgba(white, .5));
            z-index: 11;
            transform: translate3d(0, 0, 0);
        }

        .errorTitle1 {
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            z-index: 1;
            line-height: 550px;
            text-align: center;
            transform: translate3d(0, 0, 0);
            color: white;
            font-family: project;
            text-transform: uppercase;
            letter-spacing: .4em;
            text-indent: .3em;
        }

        .errorTitle2 {
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            z-index: 1;
            line-height: 750px;
            text-align: center;
            transform: translate3d(0, 0, 0);
            color: white;
            font-family: project;
            text-indent: .3em;
        }

        .errorBtn {
            position: absolute;
            left: 0;
            top: 630px;
            width: 100%;
            z-index: 5;
            text-align: center;
            transform: translate3d(0, 0, 0);
            text-indent: .3em;
        }

        #hover-img:hover{
            filter:brightness(150%);
        }

        @keyframes drift {
            from {
                transform: rotate(0deg);
            }

            from {
                transform: rotate(360deg);
            }
        }

    </style>
</head>

<body>
<div class='box'>
    <div class='wave -one'></div>
    <div class='wave -two'></div>
    <div class='wave -three'></div>
    <div class='errorTitle1'>
        <b style="font-size:150px;font-weight:normal">403</b>
    </div>
    <div class='errorTitle2'>
        <b style="font-size:50px;font-weight:normal">Forbidden</b>
    </div>
    <div class="errorBtn">
        <a href="${path}/"><img src="../resources/img/brand/sejongtrack_blue.png" width="200" id="hover-img"></a>
    </div>
</div>
</body>

</html>
