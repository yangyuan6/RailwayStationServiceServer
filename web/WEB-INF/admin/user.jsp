<%--
  Created by IntelliJ IDEA.
  User: yangy
  Date: 2018/2/5
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder">用户管理</strong></div>
        <div class="padding border-bottom">
            <button type="button" class="button border-yellow" onclick="window.location.href='addUser.php'"><span class="icon-plus-square-o"></span>添加用户</button>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="120">ID</th>
                <th width="25%">用户名</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.beanList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td> ${user.userName }</td>
                <td>
                    <div class="button-group">
                    <a class="button border-red" href="javascript:void(0)" onclick="return del(${user.id})"><span class="icon-trash-o"></span> 删除</a>
                    <a class="button border-green" href="javascript:void(0)" onclick="window.location.href='${basePath}updateUser.php?id=${user.id}';"><span class="icon-trash-o"></span> 编辑</a>
                </div>
                </td>
            </tr>
            </c:forEach>


            <tr>
                <td colspan="8"><div class="pagelist">
                    <c:if test="${pb.tp>1 }">
                        <a
                                href="${basePath}userQuery.php?pc=1"
                                class="n">首页</a>
                    </c:if>
                    <c:if test="${pb.pc > 1 }">
                        <a href="${basePath}userQuery.php?pc=${pb.pc-1}">&lt;上一页</a>
                    </c:if>
                    <c:choose>
                        <c:when test="${pb.tp <= 6 }">
                            <c:set var="begin" value="1" />
                            <c:set var="end" value="${pb.tp }" />
                        </c:when>
                        <c:otherwise>
                            <c:set var="begin" value="${pb.pc-3 }" />
                            <c:set var="end" value="${pb.pc+2 }" />
                            <c:if test="${begin < 1 }">
                                <c:set var="begin" value="1" />
                                <c:set var="end" value="6" />
                            </c:if>
                            <c:if test="${end > pb.tp }">
                                <c:set var="begin" value="${pb.tp - 5 }" />
                                <c:set var="end" value="${pb.tp }" />
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach var="i" begin="${begin }" end="${end }">
                        <c:choose>
                            <c:when test="${i eq pb.pc }">
                                <span class="current">${i}</span>
                            </c:when>
                            <c:otherwise>
                                <a href="${basePath}userQuery.php?pc=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                    <c:if test="${pb.pc < pb.tp }">
                        <a
                                href="${basePath}userQuery.php?pc=${pb.pc+1}"
                                >下一页&gt;</a>
                    </c:if>
                    <c:if test="${pb.tp>1 }">
                        <a href="${basePath}userQuery.php?pc=${pb.tp}">尾页</a>
                    </c:if>
                </div>
                </td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">

    function del(id){
        if (confirm("您确定要删除吗?")) {
            window.location.href="${basePath}userDelete.php?id="+id;
        }
    }

    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    function DelSelect(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>
</body></html>
