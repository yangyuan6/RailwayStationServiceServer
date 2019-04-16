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
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>更新火车信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${basePath}trainInfoUpdate.php">
            <input type="hidden" value="${trainInfo.id}" name="id">
            <div class="form-group">
                <div class="label">
                    <label>车次：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.trainNumber}" name="trainNumber" data-validate="required:请输入车次" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>始发站(中文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.startStation}" name="startStation" data-validate="required:请输入中文始发站" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>始发站(蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.startStationMo}" name="startStationMo" data-validate="required:请输入蒙文始发站" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>始发站(新蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.startStationNewMo}" name="startStationNewMo" data-validate="required:请输入新蒙文始发站" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>始发站(英文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.startStationEn}" name="startStationEn" data-validate="required:请输入英文始发站" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>终点站(中文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.terminus}" name="terminus" data-validate="required:请输入中文终点站" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>终点站(蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.terminusMo}" name="terminusMo" data-validate="required:请输入蒙文终点站" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>终点站(新蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.terminusNewMo}" name="terminusNewMo" data-validate="required:请输入新蒙文终点站" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>终点站(英文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.terminusEn}" name="terminusEn" data-validate="required:请输入英文的终点站" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>开点：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.kaiDian}" name="kaiDian" data-validate="required:请输入开点" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>到点：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.daoDian}" name="daoDian" data-validate="required:请输入到点" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>站台：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.station}" name="station" data-validate="required:请输入站台" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>检票口：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.jianPiaoKou}" name="jianPiaoKou" data-validate="required:请输入站台" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>火车站站名(中文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.trainStationName}" name="trainStationName" data-validate="required:请输入中文火车站站名" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>火车站站名(蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.trainStationNameMo}" name="trainStationNameMo" data-validate="required:请输入蒙文火车站站名" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>火车站站名(新蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.trainStationNameNewMo}" name="trainStationNameNewMo" data-validate="required:请输入新蒙文火车站站名" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>火车站站名(英文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.trainStationNameEn}" name="trainStationNameEn" data-validate="required:请输入英文火车站站名" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>火车类型：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.trainType}" name="trainType" data-validate="required:请输入火车类型" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>候车室(中文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.waitingRoom}" name="waitingRoom" data-validate="required:请输入中文候车室" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>候车室(扫一扫蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.waitingRoomSaoMo}" name="waitingRoomSaoMo" data-validate="required:请输入扫一扫蒙文候车室" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>候车室(扫一扫新蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.waitingRoomSaoNewMo}" name="waitingRoomSaoNewMo" data-validate="required:请输入扫一扫新蒙文候车室" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>候车室(蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.waitingRoomMo}" name="waitingRoomMo" data-validate="required:请输入蒙文候车室" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>候车室(新蒙文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.waitingRoomNewMo}" name="waitingRoomNewMo" data-validate="required:请输入新蒙文候车室" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>候车室(英文)：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${trainInfo.waitingRoomEn}" name="waitingRoomEn" data-validate="required:请输入英文候车室" />
                    <div class="tips"></div>
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