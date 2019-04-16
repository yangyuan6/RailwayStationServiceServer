<%--
  Created by IntelliJ IDEA.
  User: yangy
  Date: 2018/1/20
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <style tpe="text/css">

        body {
            /* background: #000;*/
            width: 100%;
            height: 100%;

        }

        .none {
            display: none;
        }

        .layout-root {
            position: fixed;
            background: url("${basePath}static/images/bg.gif") no-repeat;
            background-size: 100% 100%;
            /* background: #E74C3C;*/
            height: 100%;
            width: 100%;
            z-index: 1000;
            top: 0;
            left: 0;
        }

        .layout-content {
            line-height: 44px;
            font-weight: 300;
            font-size: 1em;
            color: #fff;
            text-indent: 10px;
        }

        .layout-content .code {
            line-height: 22px;
            text-align: center;
        }

        p {
            display: block;
            -webkit-margin-before: 1em;
            -webkit-margin-after: 1em;
            -webkit-margin-start: 0px;
            -webkit-margin-end: 0px;
        }

        a, button {
            outline: none;
        }

        button {
            float: left;
            border: none;
            margin: 0px 0px 0px 0px;
            padding: 0.6em 0.6em;
            background: #92c9a6;
            color: #0a0a0a;
            font-size: 1em;
            cursor: pointer;
            display: block;
            border-radius: 5px;
        }

        button:hover, button:active, button:focus {
            border: none;
        }

        .dialog-face {
            position: fixed;
            /* background: #e4e5ee;*/
            background: url("${basePath}static/images/bg.gif") no-repeat;
            background-size: 100% 100%;
            height: 100%;
            width: 100%;
            z-index: 1000;
            top: 0;
            left: 0;

            -webkit-animation-duration: 500ms;
            -moz-animation-duration: 500ms;
            -o-animation-duration: 500ms;
            animation-duration: 500ms;
        }

        .dialog-face.slipBottom[opacity="0"] {
            display: none;
        }

        .dialog-face.slipUp {
            opacity: 0.7;
            -webkit-animation-name: dialogFaceSlipToUp;
            -moz-animation-name: dialogFaceSlipToUp;
            -o-animation-name: dialogFaceSlipToUp;
            animation-name: dialogFaceSlipToUp;
        }

        .dialog-face.slipBottom {
            opacity: 0;
            visibility: hidden;
            -webkit-animation-name: dialogFaceSlipToBottom;
            -moz-animation-name: dialogFaceSlipToBottom;
            -o-animation-name: dialogFaceSlipToBottom;
            animation-name: dialogFaceSlipToBottom;
        }

        .dialog-root {
            position: fixed;
            z-index: 2000;
            left: 50%;

            -webkit-animation-duration: 500ms;
            -moz-animation-duration: 500ms;
            -o-animation-duration: 500ms;
            animation-duration: 500ms;
            -webkit-perspective: 1300px;
            -moz-perspective: 1300px;
            perspective: 1300px;
        }

        .dialog-root.slipUp {
            top: 50%;
            /*opacity: 0.7;*/

            -webkit-animation-name: dialogSlipToUp;
            -moz-animation-name: dialogSlipToUp;
            -o-animation-name: dialogSlipToUp;
            animation-name: dialogSlipToUp;
            -webkit-transform: translate(-50%, -50%);
            -o-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }

        .dialog-root.slipBottom {
            top: 100%;
            opacity: 0.3;
            -webkit-animation-duration: 500ms;
            -moz-animation-duration: 500ms;
            -o-animation-duration: 500ms;
            animation-duration: 500ms;
            -webkit-animation-name: dialogSlipToBottom;
            -moz-animation-name: dialogSlipToBottom;
            -o-animation-name: dialogSlipToBottom;
            animation-name: dialogSlipToBottom;
            -webkit-transform: translate(-50%, 0);
            -o-transform: translate(-50%, 0);
            -moz-transform: translate(-50%, 0);
            -ms-transform: translate(-50%, 0);
            transform: translate(-50%, 0);
        }

        .dialog-wrapper {
            background: #fcfcf2;
            width: 690px;
            height: 425px;
            overflow: hidden;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;

            -webkit-animation-duration: 500ms;
            -moz-animation-duration: 500ms;
            -o-animation-duration: 500ms;
            animation-duration: 500ms;
            -webkit-transform-origin: 50% 100%;
            -moz-transform-origin: 50% 100%;
            -ms-transform-origin: 50% 100%;
            -o-transform-origin: 50% 100%;
            transform-origin: 50% 100%;
            position: relative;
        }

        .dialog-wrapper.slipUp {
            -webkit-transform: rotateX(0deg);
            -moz-transform: rotateX(0deg);
            -ms-transform: rotateX(0deg);
            -o-transform: rotateX(0deg);
            transform: rotateX(0deg);
            -webkit-animation-name: contentSlipToUp;
            -moz-animation-name: contentSlipToUp;
            -o-animation-name: contentSlipToUp;
            animation-name: contentSlipToUp;
        }

        .dialog-wrapper.slipBottom {
            -webkit-transform: rotateX(90deg);
            -moz-transform: rotateX(90deg);
            -ms-transform: rotateX(90deg);
            -o-transform: rotateX(90deg);
            transform: rotateX(90deg);
            -webkit-animation-name: contentSlipToBottom;
            -moz-animation-name: contentSlipToBottom;
            -o-animation-name: contentSlipToBottom;
            animation-name: contentSlipToBottom;
        }

        .dialog-header {
            width: 75px;
            height: 100%;
            background: #009fb8;
            text-align: center;
        }

        .dialog-header span {
            font-size: 28px;
            line-height: 75px;
            color: #ffffff;
        }

        .dialog-content {

            font-weight: 300;
            font-size: 1em;
            text-align: left;
            line-height: 1.1em;
            color: #000000;
            padding: 15px 40px 20px 40px;
            margin: 0;
        }

        .dialog-content p {
            margin: 0;
            padding: 10px 15px;
        }

        .dialog-footer {
            height: 100%;
            width: 60px;
            position: absolute;
            top:0px;
            right: 5px;
        }

        @keyframes dialogFaceSlipToUp {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 0.7;
            }
        }

        @keyframes dialogFaceSlipToBottom {
            0% {
                opacity: 0.7;
                visibility: visible;
            }
            100% {
                visibility: hidden;
                opacity: 0;
            }
        }

        @keyframes dialogSlipToUp {
            0% {
                top: 100%;
                opacity: 0.3;
            }
            100% {
                top: 50%;
                opacity: 1;
            }
        }

        @keyframes dialogSlipToBottom {
            0% {
                top: 50%;
                opacity: 1;
                -webkit-transform: translate(-50%, -50%);
                -moz-transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
                -o-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
            }
            100% {
                top: 100%;
                opacity: 0.3;
                -webkit-transform: translate(-50%, 0);
                -moz-transform: translate(-50%, 0);
                -ms-transform: translate(-50%, 0);
                -o-transform: translate(-50%, 0);
                transform: translate(-50%, 0);
            }
        }

        @keyframes contentSlipToUp {
            0% {
                -webkit-transform: rotateX(90deg);
                -moz-transform: rotateX(90deg);
                -ms-transform: rotateX(90deg);
                -o-transform: rotateX(90deg);
                transform: rotateX(90deg);
            }
            100% {
                -webkit-transform: rotateX(0deg);
                -moz-transform: rotateX(0deg);
                -ms-transform: rotateX(0deg);
                -o-transform: rotateX(0deg);
                transform: rotateX(0deg);
            }
        }

        @keyframes contentSlipToBottom {
            0% {
                -webkit-transform: rotateX(0deg);
                -moz-transform: rotateX(0deg);
                -ms-transform: rotateX(0deg);
                -o-transform: rotateX(0deg);
                transform: rotateX(0deg);
            }
            60% {
                -webkit-transform: rotateX(60deg);
                -moz-transform: rotateX(60deg);
                -ms-transform: rotateX(60deg);
                -o-transform: rotateX(60deg);
                transform: rotateX(60deg);
            }
            100% {
                -webkit-transform: rotateX(90deg);
                -moz-transform: rotateX(90deg);
                -ms-transform: rotateX(90deg);
                -o-transform: rotateX(90deg);
                transform: rotateX(90deg);
            }
        }
        #btn_close{
            position: absolute;
            bottom:10%;
            right: 20px;
            width:40px;
            height: 150px;
            margin-left: -62px;
            border-radius: 25px;
            background-color: #c9f3c6;
            box-shadow:0px 0px 12px #73ff6f;
            line-height: 40px;
            font-size: 1em;
            text-align: center;
            cursor:pointer;
            cursor:pointer;
        }
        #btn_play{
            position: absolute;
            top:10%;
            right: 20px;
            width:50px;
            height: 150px;
            margin-left: -62px;
            border-radius: 25px;
            background-color: #c9f3c6;
            box-shadow:0px 0px 12px #73ff6f;
            line-height: 45px;
            font-size: 1em;
            text-align: center;
            cursor:pointer;
        }

        @font-face {
            font-family: 'OyunQaganTig';
            src: url('/static/font/OyunQaganTig.eot'); /* IE9 Compat Modes */
            src: url('/static/font/OyunQaganTig.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
            url('/static/font/OyunQaganTig.woff') format('woff'), /* Modern Browsers */
            url('/static/font/OyunQaganTig.ttf')  format('truetype'), /* Safari, Android, iOS */
            url('/static/font/OyunQaganTig.svg#OyunQaganTig') format('svg'); /* Legacy iOS */
        }

        .oldMongolContent{
            overflow:auto;
            display: inline-block;
            -moz-writing-mode: vertical-lr;
            writing-mode: vertical-lr;
            -webkit-writing-mode: vertical-lr;
            -o-writing-mode: vertical-lr;
            -ms-writing-mode: tb-lr;
            writing-mode: tb-lr;
            -webkit-text-orientation:sideways-right;
            FONT-SIZE: 22px;
            FONT-FAMILY: OyunQaganTig;
            color:#000000;
        }

        .runsection {
            color: #19ef9e;
        }

        .daoDian {
            color: #0dccd2;
        }

        .kaidian {
            color: #86fa1a;
        }
    </style>
</head>
<body>
<div class="fixed layout-root">
    <div class="layout-content">

    </div>
</div>
<div id="dialog-face" class="none">
</div>
<div id="dialog" class="none">
    <div id="dialog-wrapper">
        <div class="dialog-header oldMongolContent">
            <span>ᠲᠡᠷᠭᠡᠨ ᠳᠦᠭᠡᠷ ᠦᠨ ᠮᠡᠳᠡᠭᠡᠯᠡᠯ</span>
        </div>
        <div class="dialog-content oldMongolContent">
            <c:choose>
                <c:when test="${msg.state== 2}">
                    <p><b>${ trainInfo.trainNumber}</b> </p>

                    <p><b class="runsection">ᠠᠶᠠᠯᠠᠬᠤ ᠬᠦᠷᠢᠶ᠎ᠡ：${ trainInfo.startStationMo}-->${ trainInfo.terminusMo}</b></p>
                    <p><b class="kaidian">ᠲᠡᠷᠭᠡ  ᠬᠥᠳᠡᠯᠬᠦ ᠴᠠᠭ：${ trainInfo.kaiDian}</b></p>
                    <p><b class="daoDian">ᠲᠡᠷᠭᠡ  ᠬᠦᠷᠬᠦ  ᠴᠠᠭ：${ trainInfo.daoDian}</b></p>
                    <p>ᠲᠡᠷᠭᠡᠨ ᠳᠦ ᠰᠠᠭᠤᠬᠤ ᠭᠠᠵᠠᠷ：${trainInfo.trainStationNameMo}</p>
                    <p>ᠲᠡᠷᠭᠡ ᠬᠦᠯᠢᠶᠡᠬᠦ ᠣᠷᠣᠨ：${ trainInfo.waitingRoomMo}</p>
                    <p>ᠪᠢᠯᠧᠲ ᠪᠠᠢᠴᠠᠭᠠᠬᠤ ᠡᠭᠦᠳᠡ：${ trainInfo.jianPiaoKou}</p>
                    <p>ᠵᠣᠭᠰᠣᠭᠠᠯ：${ trainInfo.station}</p>
                </c:when>
                <c:otherwise>
                    <p>${msg.msg}</p>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="dialog-footer">
           <%-- <div id="btn_play" class="oldMongolContent" onclick="media()">ᠨᠡᠪᠲᠡᠷᠡᠭᠦᠯᠬᠦ</div>--%>
            <div id="btn_close" class="oldMongolContent"  onclick="toTagetUrl(${msg.state},'${msg.url}')">ᠬᠠᠭᠠᠬᠤ</div>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.onload = function () {
        toggleDialog(true);
    }
    function toggleDialog(show) {
        var animationClass = show ? "slipUp" : "slipBottom";
        var animation = function () {
            var ele = document.getElementById("dialog-face");
            ele.className = "dialog-face " + animationClass;
            ele = document.getElementById("dialog");
            ele.className = "dialog-root " + animationClass;
            ele = document.getElementById("dialog-wrapper");
            ele.className = "dialog-wrapper " + animationClass;
        };

        setTimeout(animation, 100);
    }
    function toTagetUrl(state, url) {
        if (state == 1 ) {
            window.location.href = "${basePath}/" + url;
        } else {
            history.go(-1);
        }

    }
    var playVoice=function () {
        var flag=false;
        return function () {
            var audio=document.getElementById("audio");
            if (flag==false){
                console.log("play");
                audio.play();
                flag=true;
            }else
            {
                console.log("pause")
                audio.pause();
                flag=false;
            }
        };
    }();
    var media=function () {
        var flag1=false;
        var flag2=false;
        var audio2pauseFlag=false;
        var timerflag=false;
        return function () {
            var audio1=document.getElementById("audio");
            var audio2=document.getElementById("audio1");
            if (flag1==false&&flag2==false){
                audio1.play();
                flag1=true;
                if(!timerflag){
                    timerflag=true;
                    var timer=setInterval(function () {
                        if(audio1.ended &&flag2==false){
                            flag2=true;
                            audio2.play();
                        }else if(audio2.ended&&flag2==true){
                            clearInterval(timer);
                            flag2=false;
                            timerflag=false;
                            flag1=false;
                        }

                    },500);
                }
            }else if(!audio1.ended)
            {
                audio1.pause();
                flag1=false;
            }else if(!audio2.ended&&!audio2pauseFlag){
                audio2.pause();
                audio2pauseFlag=true;

            }else if(audio2pauseFlag){
                audio2pauseFlag=false;
                audio2.play();
            }else{
                flag1=false;
            }
        };
    }();

</script>
</body>
</html>
