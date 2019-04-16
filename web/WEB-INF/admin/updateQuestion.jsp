<%--
  Created by IntelliJ IDEA.
  User: yangy
  Date: 2018/2/25
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加问题</strong></div>
    <div class="body-content">
        <form method="post" class="form-x"  enctype="multipart/form-data" action="${basePath}questionUpdate.php">
            <input type="hidden" value="${question.id}" name="id">
            <div class="form-group">
                <div class="label">
                    <label>问题(中文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w65" value="${question.question}" name="question" data-validate="required:请输入中文问题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>问题(蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w65" value="${question.questionMo}" name="questionMo" data-validate="required:请输入蒙文问题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>问题(新蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w65" value="${question.questionNewMo}" name="questionNewMo" data-validate="required:请输入新蒙文问题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>问题(英文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w65" value="${question.questionEn}" name="questionEn" data-validate="required:请输入英文问题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>答案(中文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w65" value="${question.answer}" name="answer" data-validate="required:请输入中文答案" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>答案(蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w65" value="${question.answerMo}" name="answerMo" data-validate="required:请输入蒙文答案" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>答案(新蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w65" value="${question.answerNewMo}" name="answerNewMo" data-validate="required:请输入新蒙文答案" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>答案(英文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w65" value="${question.answerEn}" name="answerEn" data-validate="required:请输入英文答案" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>语音(中文)：</label>
                </div>
                <div class="field">
                    <input type="file" class="input w65" name="voice" placeholder="请选择中文的wav格式的音频文件" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>语音(蒙文和新蒙文)：</label>
                </div>
                <div class="field">
                    <input type="file" class="input w65"  name="voiceMo" placeholder="请选择蒙文和新蒙文的wav格式的音频文件" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>语音(英文)：</label>
                </div>
                <div class="field">
                    <input type="file" class="input w65" value="" name="voiceEn" placeholder="请选择英文的wav格式的音频文件！"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body></html>