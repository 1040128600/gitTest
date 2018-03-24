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
	<script type="text/javascript" src="station/updateStation.js"></script>
	<style type="text/css">
	#mainDiv{width:400px;height:400px;margin:auto}
	</style>
<title>修改车点</title>
</head>
<body marginwidth="0" marginheight="0">
<input id="returnMsg" type="hidden" value="${returnMsg}" />
<input id="pileNum" type="hidden" value="${pileNum}"/>
<div class="container">
<div class="public-nav">您当前的位置：<a href="station/stationManager.jsp">车点管理</a>><label>修改</label></div>
<div class="public-content" >
	
	<div class="public-content-header">
				<h3>-----修改车点-----<br><br></h3>
			</div>
	<div class="public-content" >
	<form action="station/updateOneStation" method="post">
		<div class="form-group">
		<label for="">ID</label>
		<input   class="form-input-txt"  type="text" name="station_Id"  value="${station0.station_Id}" readonly>
	</div>
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
		<input   class="form-input-txt"  type="text" name="longitude"  value="${station0.longitude}" >
	</div>
		<div class="form-group">
		<label for="">纬度</label>
		<input   class="form-input-txt"  type="text" name="latitude"  value="${station0.latitude}" >
	</div>
		<div class="form-group">
		<label for="">车桩数量</label>
		<input   class="form-input-txt"  type="text" name="bicycle_Pile_Num"  value="${station0.bicycle_Pile_Num}" readonly>
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
		<input   class="form-input-txt"  type="text" name="user_Id"  value="${station0.user_Id}" >
	</div>
		<div class="form-group">
		<label for="">创建时间</label>
		<input   class="form-input-txt"  type="date" name="create_Time"  value="${station0.create_Time}" >
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
						<th style="width:5%">车桩ID</th>
						<th style="width:10%">车桩编号</th>
						<th style="width:5%">供应商ID</th>
						<th style="width:10%">所属车点</th>
						<th style="width:5%">状态</th>
						<th style="width:10%">安装日期</th>
						<th style="width:10%">拆卸日期</th>
						<th style="width:10%">操作人</th>
						<th style="width:10%">操作时间</th>
						<th style="width:10%">所存车辆</th>
						<th style="width:10%">备注</th>
						<th style="width:5%">操作</th>
					</tr>
					<c:forEach items="${station0.piles}" var="pile" varStatus="status">
					
					<tr>
			<td ><input class='my-small-input' name='piles[${status.index}].pile_Id'  type='text' value='${pile.pile_Id}'/></td>
			<td ><input class='my-middle-input' name='piles[${status.index}].pile_Code'  type='text' value='${pile.pile_Code}'/></td>
			<td ><input class='my-small-input' name='piles[${status.index}].vender_Id' type='text' value='${pile.vender_Id}'/></td>
			<td ><input class='my-small-input' name='piles[${status.index}].station_Id' type='text' value='${pile.station_Id}'/></td>
			<td ><select name="piles[${status.index}].status" >
			<option value='1' <c:if test="${pile.status=='1'}">selected</c:if>> 有车</option>
			<option value='2' <c:if test="${pile.status=='2'}">selected</c:if>> 无车</option>
			<option value='9' <c:if test="${pile.status=='9'}">selected</c:if>> 报废</option>
			</select></td>
			<td ><input class='my-middle-input' name='piles[${status.index}].install_Time' type='date' value='${pile.install_Time}'/></td>
			<td ><input class='my-middle-input' name='piles[${status.index}].disassembly_Time' type='date' value='${pile.disassembly_Time}'/></td>
			<td ><input class='my-small-input' name='piles[${status.index}].user_Id'  type='text' value='${pile.user_Id}'/></td>
			<td ><input class='my-middle-input' name='piles[${status.index}].operator_Time' type='date' value='${pile.operator_Time}'/></td>
			<td ><input class='my-small-input' name='piles[${status.index}].bicycle_Id' type='text' value='${pile.bicycle_Id}'/></td>
			<td ><input class='my-small-input' name='piles[${status.index}].remark' type='text' value='${pile.remark}'/></td>
			<td ><input type='button' value='报废' onclick='cancelPile(this)'/></td>
					</tr>
					</c:forEach>
				<!-- 	<tr class="mainTr"></tr> -->
				</table>
			</div>

	
	
	
	<div class="form-group" style="margin-left:150px;">
	<input class="sub-btn" type="submit" value="确认修改车点">
	<input class="sub-btn" type="button" value="返回" onclick="history.back()">
	<br><br><br><br><br><br><br><br>
	</div>
	</form>
	</div>
	
	</div>
	</div>
</body>

</html>