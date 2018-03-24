<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	String path = request.getContextPath();
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath %>"/>
	<meta charset="UTF-8">
	<title>后台欢迎页</title>
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/content.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="station/stationManager.js"></script>
	<script type="text/javascript" src="js/showReturnMsg.js"></script>
</head>
<body marginwidth="0" marginheight="0">
<input id="returnMsg" type="hidden" value="${returnMsg}" />
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="stationManager.jsp">车点车桩管理</a></a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3>车点管理</h3>
			</div>
			<div class="public-content-cont">
			<label>车点编号</label><input class="my-input-text" id="station_Code" type="text"/> 
			<label>车点名称</label><input class="my-input-text" id="station_Name" type="text"/> 
			<label>车点地址</label><input class="my-input-text" id="address" type="text"/> 
			<label>车点状态</label><select class="my-input-select" id="zxbj">
							<option value=""> </option>
							<option value="0" selected>正常</option>
							<option value="1">已注销</option>
						</select> 
				<input class="sub-btn" type="button" value="查询" onclick="queryStation()"/>
				<input class="sub-btn" type="button" value="新增" onclick="window.location.href='/bicycle/station/addStation.jsp'"/>
				
			
				<br><br>
				<table class="public-cont-table" id="mainTable">
					<tr>
						<th style="width:10%">车点ID</th>
						<th style="width:15%">车点编号</th>
						<th style="width:10%">车点名称</th>
						<th style="width:10%">车点地址</th>
						<th style="width:15%">车桩数量</th>
						<th style="width:15%">建立时间</th>
						<th style="width:10%">车点状态</th>
						<th style="width:15%">操作</th>
					</tr>
					<tr class="mainTr"></tr>
				</table>
<div class="page">
<input class="page-btn"  type="button" value="首页" onclick="goFirstPage()" />
<input class="page-btn" type="button" value="上页" onclick="goPrePage()" />
<input class="page-btn" type="button" value="跳转" onclick="goSpecifiedPage()" />
<input class="page-input" id="targetPage"   style="width:30px" type="number" value="1" onchange="checkNum()" />页
<input class="page-btn" type="button" value="下页" onclick="goNextPage()" />
<input class="page-btn" type="button" value="末页" onclick="goEndPage()" />
<label>第<label style="color:red;font-weight:600" id="currentPage">1</label>页 / 共<label style="color:red;font-weight:600" id="pageCount">1</label>页</label>
</div>
			</div>
		</div>
	</div>
</body>
</html>