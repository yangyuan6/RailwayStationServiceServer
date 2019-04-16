<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>

        html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, dl, dt, dd, ol, nav ul, nav li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            font: inherit;
            vertical-align: baseline;
        }

        ol, ul {
            list-style: none;
            margin: 0px;
            padding: 0px;
        }

        #head {
            /*background: #e3e3e3;*/
            /*min-height: 600px;*/
            padding: 0;
            margin: 0;
            width: 150px;
            position: absolute;
            left: 180px;
            top:60px;
            font-size: 12px;
            height: 500px;
            padding: 50px 0;
            border-radius: 10px;
        }

        body {
            color: #333;
            background: #fff;
            margin: 0;
            position: relative;
            min-width: 900px;
            height: 100%;
        }

        html, body {
            overflow-x: hidden;
            height: 100%;
        }

        #wrapper {
            height: 100%;
            width: 150px;
        }

        #container {
            position: absolute;
            left: 305px;
            top: 10px;
            word-break: break-all;
            word-wrap: break-word;
            height: 100%;
            /* overflow-x: auto;*/
            overflow-scrolling: touch;
            /* width: 1212px;*/
        }

        .c-container {
            font-size: 13px;
            line-height: 1.54;
            word-wrap: break-word;
            word-break: break-word;
            table-layout: fixed;
            position: relative;
            display: inline-block;
            width: 140px;
            float: left;
            margin-left: 10px;
            padding: 2px 12px 10px;
            margin-top: 10px;
            margin-bottom: 10px;
            border-radius: 3px;
            background-color: #fefefe;
            box-sizing: border-box;
            /* -moz-box-shadow: 0px 0px 3px #cecece; */
            box-shadow: 0 1px 10px rgba(0, 0, 0, 0.12);
            -webkit-box-shadow: 0 1px 10px rgba(0, 0, 0, 0.12);
            -moz-box-shadow: 0 1px 10px rgba(0, 0, 0, 0.12);
            height: 700px;
        }

        a {
            text-decoration: none;
            color: #2866bd;
            font-weight: bold;
        }

        a:visited em {
            color: #660099;
        }

        /*a:-webkit-any-link {
          color: -webkit-link;
          cursor: auto;
          text-decoration: underline;
        }*/
        a:visited:after {
            content: "";
            position: absolute;
            border-bottom: 2px solid;
            bottom: -2px;
            left: 100%;
            width: 0;
            -webkit-transition: width 350ms, left 350ms;
            -moz-transition: width 350ms, left 350ms;
            transition: width 350ms, left 350ms;
        }

        .t {
            font-weight: 400;
            font-size: medium;
            margin-bottom: 1px;
            position: absolute;
            width: 40px;
            height: 100%;
        }

        .c-container h3 {
            margin: 0px -15px 10px;
            padding: 8px 5px 5px;
            border-radius: 3px 3px 0px 0px;

            box-shadow: 0 1px 0px 0px rgba(0, 0, 0, .05);
            -webkit-box-shadow: 0 1px 0px 0px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 0px 0px rgba(0, 0, 0, .05);

        }

        /*     */
        #page {
            position: absolute;
            top: 10%;
            right: 150px;
            font: 14px arial;
            white-space: nowrap;
            display: block;
            min-width: 40px;
            width: 50px;
            height: 710px;
            line-height: 40px;
            padding: 5px 10px;
            margin: 0px 0px 50px 80px;
            text-align: center;
            white-space: nowrap;
        }

        #page a, #page strong {
            display: block;
            vertical-align: text-bottom;
            text-align: center;
            line-height: 34px;
            text-decoration: none;
            overflow: hidden;
            margin-right: 9px;
            background: #fff;
            cursor: pointer;
            color: #2866bd;
            height: auto;
            border-radius: 3px;
        }

        #page .n {
            width: 34px;
            height: 98px;
            padding: 18px 0px;
            border: 1px solid #e1e2e3;

        }

        #page a, #page strong, #page strong .pc {
            width: 36px;
            box-shadow: 0 1px 10px rgba(0, 0, 0, 0.1);
            -webkit-box-shadow: 0 1px 10px rgba(0, 0, 0, 0.1);
            -moz-box-shadow: 0 1px 10px rgba(0, 0, 0, 0.1);
        }

        #page .pc {
            width: 34px;
            height: 34px;
            border: 1px solid #e1e2e3;
            cursor: pointer;
            margin: 3px 0;
        }

        #page span {
            display: block;
        }

        @font-face {
            font-family: 'OyunQaganTig';
            src: url('.static/font/OyunQaganTig.eot'); /* IE9 Compat Modes */
            src: url('static/font/OyunQaganTig.eot?#iefix') format('embedded-opentype'),
                /* IE6-IE8 */ url('static/font/OyunQaganTig.woff') format('woff'),
                /* Modern Browsers */ url('static/font/OyunQaganTig.ttf') format('truetype'),
                /* Safari, Android, iOS */ url('static/font/OyunQaganTig.svg#OyunQaganTig') format('svg'); /* Legacy iOS */
        }

        .oldMongolContent {
            overflow: auto;
            display: inline-block;
            -moz-writing-mode: vertical-lr;
            writing-mode: vertical-lr;
            -webkit-writing-mode: vertical-lr;
            -o-writing-mode: vertical-lr;
            -ms-writing-mode: tb-lr;
            writing-mode: tb-lr;
            -webkit-text-orientation: sideways-right;
            FONT-FAMILY: OyunQaganTig;
            font-size: 24px;

        }
        .oldMongolContent1 {
            overflow: auto;
            display: inline-block;
            -moz-writing-mode: vertical-lr;
            writing-mode: vertical-lr;
            -webkit-writing-mode: vertical-lr;
            -o-writing-mode: vertical-lr;
            -ms-writing-mode: tb-lr;
            writing-mode: tb-lr;
            -webkit-text-orientation: sideways-right;
            FONT-FAMILY: OyunQaganTig;
            font-size: 18px;
        }


        .c-row {
            position: relative;
            left: 45px;
        }

        .wm {
            text-orientation: sideways-right;
            -webkit-text-orientation: sideways-right;
        }

        #inputVertical {

            font-family: 'OyunQaganTig', "Times New Roman", Times, serif;
            -webkit-writing-mode: vertical-rl;
            -moz-writing-mode: vertical-rl;
            -ms-writing-mode: tb-rl;
            writing-mode: vertical-rl;
            user-modify: read-write-plaintext-only;
            -moz-user-modify: read-write-plaintext-only;
            -webkit-user-modify: read-write-plaintext-only;
            width: 40px;
            font-size: 22px;
            outline: none;
            height: 600px;
            padding: 8px;
            white-space: nowrap;
            float: left;
            margin-left: 1em;
            display: inline-block;
            border: 1px solid #ccc;
            box-shadow: inset 0 1px 3px #ddd;
            border-radius: 4px;
            vertical-align: middle;
            box-sizing: border-box;
            -ms-box-sizing: border-box;
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -webkit-rtl-ordering: logical;
            -webkit-user-select: text;
        }

        #buttonVertical {

            -webkit-writing-mode: vertical-rl;
            -moz-writing-mode: vertical-rl;
            -ms-writing-mode: tb-rl;
            writing-mode: vertical-rl;
            display: block;
            background: rgb(0, 120, 231);
            color: #fff;
            float: left;
            height: 600px;
            width: 36px;
            padding: 8px;
            font-size: 18px;
            box-sizing: border-box;
            -ms-box-sizing: border-box;
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
            text-align: center;
            border-radius: 4px;
            margin-left: 0.1em;
            cursor: pointer;
        }

        #return {
            z-index: 300;
            position: fixed;
            width: 36px;
            height: 150px;
            border-radius: 25px;
            bottom: 80px;
            right: 80px;
            background-color: #c9f3c6;
            box-shadow: 0px 0px 12px #73ff6f;
            line-height: 36px;
            font-size: 22px;
            text-align: center;
            cursor: pointer;
            text-decoration: none;
            color: #000000;

        }

        #return a {
            display: block;
            text-decoration: none;
            width: 36px;
            height: 150px;
        }

        #inputVertical:focus {
            border-color: #129FEA;
        }

        #page strong .pc {
            background: #5d71ce;
            color: white;
            border-radius: 3px;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <img src="static/images/llogo.gif" alt="" style="height: 600px">
    <div id="head">
        <c:choose>
            <c:when test="${empty question}">
                <div id="inputVertical" class="wm" contenteditable="true" spellcheck="false" onfocus="checkInput()" onkeydown="checkEnter(event)">ᠬᠠᠢᠬᠤ ᠵᠠᠩᠭᠢᠯᠠᠭ᠎ᠠ ᠶᠢᠨ ᠦᠭᠡᠰ ᠢᠶᠡᠨ ᠪᠢᠴᠢᠭᠡᠷᠡᠢ</div>
            </c:when>
            <c:otherwise>
                <div id="inputVertical" class="wm" contenteditable="true" spellcheck="false"
                     onfocus="checkInput()" onkeydown="checkEnter(event)">${question}</div>
            </c:otherwise>
        </c:choose>

        <div id="buttonVertical" onkeydown="checkEnter(event)" onclick="submit()">ᠬᠠᠢᠬᠤ</div>
    </div>
</div>
<div id="container">


    <c:forEach items="${pb.beanList}" var="question">
        <div class="c-container ">
            <h3 class="t c-gap-bottom-small">
                <a class="oldMongolContent "
                   href="${basePath}questionDetailMo.php?questionId=${question.id}"
                >${question.questionMo }</a>
            </h3>
                <%-- <div class="c-row oldMongolContent" >
                         ${question.answerMo }
                 </div>--%>
        </div>
    </c:forEach>

</div>
<div id="page">


    <c:if test="${pb.tp>1 }">
        <a
                href="${basePath}questionQueryMo.php?question=${question}&pc=1"
                class="n oldMongolContent1">ᠲᠡᠷᠢᠭᠦᠨ ᠨᠢᠭᠤᠷ</a>
    </c:if>

    <c:if test="${pb.pc > 1 }">
        <a href="${basePath}questionQueryMo.php?question=${question}&pc=${pb.pc-1}" class="n oldMongolContent1">&lt;
            ᠳᠡᠭᠡᠷ᠎ᠡ ᠨᠢᠭᠤᠷ</a>
    </c:if>
    <c:choose>
        <c:when test="${pb.tp <= 6 }">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${pb.tp }"/>
        </c:when>
        <c:otherwise>
            <c:set var="begin" value="${pb.pc-3 }"/>
            <c:set var="end" value="${pb.pc+2 }"/>
            <c:if test="${begin < 1 }">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="6"/>
            </c:if>
            <c:if test="${end > pb.tp }">
                <c:set var="begin" value="${pb.tp - 5 }"/>
                <c:set var="end" value="${pb.tp }"/>
            </c:if>
        </c:otherwise>
    </c:choose>
    <c:forEach var="i" begin="${begin }" end="${end }">
        <c:choose>
            <c:when test="${i eq pb.pc }">
                <strong><span class="fk fk_cur"><i
                        class="c-icon c-icon-bear-p"></i></span><span class="pc oldMongolContent1">${i }</span></strong>
            </c:when>
            <c:otherwise>
                <a
                        href="${basePath}questionQueryMo.php?question=${question}&pc=${i}"><span
                        class="fk fkd"><i class="c-icon c-icon-bear-pn"></i></span><span
                        class="pc oldMongolContent1">${i }</span></a>
            </c:otherwise>
        </c:choose>

    </c:forEach>
    <c:if test="${pb.pc < pb.tp }">
        <a
                href="${basePath}questionQueryMo.php?question=${question}&pc=${pb.pc+1}"
                class="n oldMongolContent1">ᠳᠠᠷᠠᠭᠠᠴᠢ  ᠶᠢᠨ ᠨᠢᠭᠤᠷ&gt;</a>
    </c:if>
    <c:if test="${pb.tp>1 }">
        <a href="${basePath}questionQueryMo.php?question=${question}&pc=${pb.tp}" class="n oldMongolContent1">ᠡᠴᠦᠰ
            ᠨᠢᠭᠤᠷ</a>
    </c:if>
</div>
<div id="return" class="oldMongolContent1"><a href="${basePath}secondMo.html">ᠪᠣᠴᠠᠬᠤ</a></div>
</body>
<script>
    var checkInput = function () {
        var flag = false;
        var input = document.getElementById('inputVertical');
        return function () {
            if (flag == false) {
                input.innerText = "";
            }
            flag = true;
        };
    }();
    function checkEnter(e) {
        var et = e || window.event;
        var keycode = et.charCode || et.keyCode;
        if (keycode == 13) {
            submit();
            if (window.event)
                window.event.returnValue = false;
            else
                e.preventDefault();//for firefox
        }
    }
    function submit() {
        var input = document.getElementById('inputVertical');
        var inputText = input.innerText;
        /*        if(inputText==""){
         alert("请输入关键词进行查询");
         return;
         }*/
        if(inputText=="ᠬᠠᠢᠬᠤ ᠵᠠᠩᠭᠢᠯᠠᠭ᠎ᠠ ᠶᠢᠨ ᠦᠭᠡᠰ ᠢᠶᠡᠨ ᠪᠢᠴᠢᠭᠡᠷᠡᠢ"){
            input.innerText="";
            input.focus();
            return;
        }
        var sfForm = document.createElement("form");
        document.body.appendChild(sfForm);
        var tmpInput = document.createElement("input");
        tmpInput.type = "hidden";
        tmpInput.name = "question";
        tmpInput.value = inputText;
        sfForm.appendChild(tmpInput);
        sfForm.method = "post";
        sfForm.action = "${basePath}questionQueryMo.php";
        sfForm.submit();
    }

</script>
</html>