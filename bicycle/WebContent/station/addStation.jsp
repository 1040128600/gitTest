<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	String path = request.getContextPath();
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath %>"/>
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/content.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/showReturnMsg.js"></script>
	<script type="text/javascript" src="station/addStation.js"></script>
	<style type="text/css">
	#mainDiv{width:400px;height:400px;margin:auto}
	</style>
<title>新增车点</title>
</head>
<body marginwidth="0" marginheight="0">
<input id="returnMsg" type="hidden" value="${returnMsg}" />

<div class="container">
<div class="public-nav">您当前的位置：<a href="station/stationManager.jsp">车点管理</a>><label>新增</label></div>
<div class="public-content" >
	
	<div class="public-content-header">
				<h3>-----新增车点-----<br><br></h3>
			</div>
	<div class="public-content" >
	<form action="station/addStation" method="post">
	<div class="form-group">
		<label for="">编号</label>
		<input   class="form-input-txt"  type="text" name="station_Code"  value="${station0.station_Code}" readonly>
	</div>
	<div class="form-group">
		<label for="">名称</label>
		<input   class="form-input-txt"  type="text" name="station_Name"  value="${station0.station_Name}" >
	</div>
	<div class="form-group">
		<label for="">经度</label>
		<input   class="form-input-txt"  type="number" name="longitude"  value="${station0.longitude}" >
	</div>
		<div class="form-group">
		<label for="">纬度</label>
		<input   class="form-input-txt"  type="number" name="latitude"  value="${station0.latitude}" >
	</div>
		<div class="form-group">
		<label for="">车桩数量</label>
		<input   class="form-input-txt"  type="number" name="bicycle_Pile_Num"  value="${station0.bicycle_Pile_Num}" readonly >
	</div>
		<div class="form-group">
		<label for="">地址</label>
		<input   class="form-input-txt"  type="text" name="address"  value="${station0.address}" >
	</div>
		<div class="form-group">
		<label for="">负责人</label>
		<input   class="form-input-txt"  type="text" name="person_In_Charge"  value="${station0.person_In_Charge}" >
	</div>
		<div class="form-group">
		<label for="">新建日期</label>
		<input   class="form-input-txt"  type="date" name="build_Time"  value="${station0.build_Time}" >
	</div>
		<div class="form-group">
		<label for="">运行日期</label>
		<input   class="form-input-txt"  type="date" name="run_Time"  value="${station0.run_Time}" >
	</div>
		<div class="form-group">
		<label for="">操作人ID</label>
		<input   class="form-input-txt"  type="text" name="user_Id"  value="${loginUser.user_Id}" >
	</div>
		<div class="form-group">
		<label for="">创建时间</label>
		<input   class="form-input-txt"  type="date" name="create_Time"  value="" >
	</div>
		
		<div class="form-group">
	<label for="">注销标记</label>
			<select class="my-input-select" name="zxbj">
							
							<option value="0" <c:if test="${station0.zxbj=='0'}">selected</c:if>>正常</option>
							<option value="1" <c:if test="${station0.zxbj=='1'}">selected</c:if>>已注销</option>
						</select> 
	</div>
		<div class="form-group">
	<label for="">备注</label>
	<input   class="form-input-txt"  type="text" name="remark" placeholder="" value="${station0.remark}">
	</div>
	<br><br>
	<div class="form-group" style="margin-left:150px;">
	<input class="sub-btn" type="button" value="添加车桩" onclick="addPile()">

	</div>
			<div class="public-content-cont">
					<table class="public-cont-table" id="mainTable">
					<tr>
						
						<th style="width:25%">车桩编号</th>
						<th style="width:5%">供应商ID</th>
						<th style="width:5%">状态</th>
						<th style="width:10%">安装日期</th>
						<th style="width:10%">拆卸日期</th>
						<th style="width:10%">操作人</th>
						<th style="width:10%">操作时间</th>
						<th style="width:10%">所存车辆</th>
						<th style="width:10%">备注</th>
						<th style="width:5%">操作</th>
					</tr>
				<!-- 	<tr class="mainTr"></tr> -->
				</table>
			</div>

	
	
	
	<div class="form-group" style="margin-left:150px;">
	<input class="sub-btn" type="submit" value="确认添加车点">
	<input class="sub-btn" type="button" value="返回" onclick="history.back()">
	<br><br><br><br><br><br><br><br>
	</div>
	</form>
	</div>
	
	</div>
	</div>
</body>

</html>