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
	<script type="text/javascript" src="statistics/bicycleFee.js"></script>
	<script type="text/javascript" src="js/showReturnMsg.js"></script>
	<style type="text/css">
	#bicycleDetail{width:300px;height:300px;position:fixed;left:600px;top:200px;background-color: lightblue;}
	.width100%{width:100%}
	.closeIcon{position:relative;float:right;background-color: pink;font-size:1.5em}
	</style>
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
			<h3>---月度统计---</h3><br>
			<label>年份</label><select class="my-input-select" id="year">
							<option value="2014">2014</option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018" selected>2018</option>
							</select> 
			<label>月份</label><select class="my-input-select" id="month">
							<option value="01" >一月</option>
							<option value="02" selected>二月</option>
							<option value="03">三月</option>
							<option value="04">四月</option>
							<option value="05">五月</option>
							<option value="06">六月</option>
							<option value="07">七月</option>
							<option value="08">八月</option>
							<option value="09">九月</option>
							<option value="10">十月</option>
							<option value="11">十一月</option>
							<option value="12">十二月</option>
							</select> 
				<input class="sub-btn" type="button" value="查询" onclick="queryByMonth()"/>
				<br><br>
				<table class="public-cont-table" id="mainTable1">
					<tr>
						<th style="width:10%">车辆数量</th>
						<th style="width:10%">借还次数</th>
						<th style="width:10%">修理次数</th>
						<th style="width:10%">平均借还时间</th>
						<th style="width:10%">总借还时间</th>
						<th style="width:15%">平均借车收入费用</th>
						<th style="width:15%">总借车收入费用</th>
						<th style="width:10%">平均修理费用</th>
						<th style="width:10%">总修理费用</th>
					</tr>
					<tr class="mainTr1">
					
					</tr>
				</table>
				<br><br>
				<h3>---车辆统计---</h3><br>
				<label>车辆编号</label><input class="my-input-text" id="bicycle_Code" type="text"/>
				<label>创建时间</label><input class="my-input-text" id="operator_Time" type="text"/>
				<label>车辆状态</label><select class="my-input-select" id="status">
										<option value=""></option>
										<option value="1">购入未入桩</option>
										<option value="2">借出</option>	
										<option value="3">在桩</option>
										<option value="4">普通调出</option>
										<option value="5">维修调出</option>
										<option value="6">报废</option>
										
										</select>
				 
				<input class="sub-btn" type="button" value="查询" onclick="queryBicycle()"/>
					<br><br>
							<table class="public-cont-table" id="mainTable2">
					<tr>
						<th style="width:20%">车辆ID</th>
						<th style="width:20%">车辆编号</th>
						<th style="width:20%">车辆状态</th>
						<th style="width:20%">当前所在车点</th>
						<th style="width:20%">查看</th>
					</tr>
					<tr class="mainTr2"></tr>
				</table>
				<div id="bicycleDetail" hidden>
					<div class="width100%"><div class="closeIcon" onclick="hideDetail()"><label>×</label></div></div>
					<br/><br/>
					<label>使用时间</label> <label id="useTime"></label><br/><br/>
					<label>借还次数</label>	<label id="rentTimes"></label><br/><br/>
					<label>修理次数</label>	<label id="repairTimes"></label><br/><br/>
					<label>调度次数</label>	<label id="deployTimes"></label><br/><br/>
					
					<label>总借还时间</label> <label id="sumRentTime"></label><br/><br/>
					<label>平均借还时间</label> <label id="avgRentTime"></label><br/><br/>
					<label>总借车收入</label> <label id="sumIncomeFee"></label><br/><br/>
					<label>平均借车收入</label>	<label id="avgIncomeFee"></label><br/><br/>
					<label>总修理费用</label>	 <label id="sumRepairFee"></label><br/><br/>
					<label>平均修理费用</label>	<label id="avgRepairFee"></label><br/>
					
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