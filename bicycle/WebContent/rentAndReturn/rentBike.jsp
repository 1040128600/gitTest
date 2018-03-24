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
	<script type="text/javascript" src="rentAndReturn/rentAndReturn.js"></script>
	<script type="text/javascript" src="js/showReturnMsg.js"></script>
	<style type="text/css">
.redDiv{background:red}
.greenDiv{}
.grayDiv{background:gray}
.pile{width:70px;height:40px;margin:5px;display: inline-block;background-image:url(images/bike.jpg);background-size:cover}
.pile0{width:70px;height:40px;margin:5px;display: inline-block;background-image:url(images/blank.jpg);background-size:cover}
.station{width:320px;height:200px;margin:5px;display: inline-block;}
#optionDiv{width:320px;height:200px;background:yellow;position: fixed;left:500px;top:200px;}
#mianDiv{width:100%;}
.detail{width:100px;background:lightgray;z-index:99;visibility:hidden}
.stationName{display:inline-block;width:100%;text-align: center;font-size:1.3em;font-style: bold}
</style>
</head>
<body marginwidth="0" marginheight="0">
<input id="returnMsg" type="hidden" value="${returnMsg}" />
	<div class="container">

		<div class="public-nav">您当前的位置：<a href="stationManager.jsp">借车-还车</a></a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3>借车-还车</h3>
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
				<div id="optionDiv" hidden>
					请输入卡号：<input id="card_Code" type="text"><br/>
					<input type="button" value="租车" onclick="rentBike()">
					<input type="button" value="还车" onclick="returnBike()">
					<input type="button" value="关闭" onclick="hideOptionDiv()">
				</div>
				<div id="mainDiv">
				
				</div>
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