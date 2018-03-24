<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<script type="text/javascript" src="vender/updateVender.js"></script>
	<style type="text/css">
	#mainDiv{width:400px;height:400px;margin:auto}
	</style>
<title>修改供应商</title>
</head>
<body marginwidth="0" marginheight="0">
<input id="returnMsg" type="hidden" value="${returnMsg}" />
<input id="vender_Type" type="hidden" value="${vender0.vender_Type}" />
<input id="zxbj" type="hidden" value="${vender0.zxbj}">
<div class="container">
<div class="public-nav">您当前的位置：<a href="venderManager.jsp">供应商管理</a>><label>修改</label></div>
<div class="public-content" >
	
	<div class="public-content-header">
				<h3>-----修改供应商-----<br><br></h3>
			</div>
	<div class="public-content" >
	<form action="vender/updateOneVender" method="post">
		<div class="form-group">
	<label for="">ID</label>
	<input   class="form-input-txt"  type="text" name="vender_Id" placeholder="" value="${vender0.vender_Id}" readonly>
	</div>
	<div class="form-group">
	<label for="">编号</label>
	<input   class="form-input-txt"  type="text" name="vender_Code" placeholder="" value="${vender0.vender_Code}" readonly>
	</div>
		<div class="form-group">
	<label for="">类型</label>
	
						<select class="my-input-select" name="vender_Type">
							
							<option value="1">生产商</option>
							<option value="2">供应商</option>
						</select>
	
<%-- 	<input   class="form-input-txt"  type="text" name="vender_Type" placeholder="" value="${vender.vender_Type}">
 --%>	</div>
		<div class="form-group">
	<label for="">名称</label>
	<input   class="form-input-txt"  type="text" name="vender_Name" placeholder="" value="${vender0.vender_Name}">
	</div>
		<div class="form-group">
	<label for="">地址</label>
	<input   class="form-input-txt"  type="text" name="address" placeholder="" value="${vender0.address}">
	</div>
		<div class="form-group">
	<label for="">电话</label>
	<input   class="form-input-txt"  type="text" name="telphone" placeholder="" value="${vender0.telphone}">
	</div>
		<div class="form-group">
	<label for="">联系人</label>
	<input   class="form-input-txt"  type="text" name="contacts" placeholder="" value="${vender0.contacts}">
	</div>
		<div class="form-group">
	<label for="">生产许可证</label>
	<input   class="form-input-txt"  type="text" name="product_License" placeholder="" value="${vender0.product_License}">
	</div>
		<div class="form-group">
	<label for="">工商注册号</label>
	<input   class="form-input-txt"  type="text" name="bussiness_Registration_No" placeholder="" value="${vender0.bussiness_Registration_No}">
	</div>
		<div class="form-group">
	<label for="">注册资金</label>
	<input  class="form-input-txt"  type="text" name="registered_Capital" placeholder="" value="${vender0.registered_Capital}">
	</div>
		<div class="form-group">
	<label for="">操作人ID</label>
	<input  class="form-input-txt"  type="text" name="user_Id" placeholder="" value="${vender0.user_Id}" readonly>
	</div>
		<div class="form-group">
	<label for="">创建日期</label>
	<input  class="form-input-txt"  type="text" name="create_Time" placeholder="" value="${vender0.create_Time}" readonly>
	</div>
		<div class="form-group">
	<label for="">注销标记</label>
			<select class="my-input-select" name="zxbj">
							
							<option value="0">正常</option>
							<option value="1">已注销</option>
						</select> 
<%-- 	<input   class="form-input-txt"  type="text" name="zxbj" placeholder="" value="${vender.zxbj}">
 --%>	</div>
		<div class="form-group">
	<label for="">备注</label>
	<input   class="form-input-txt"  type="text" name="remark" placeholder="" value="${vender0.remark}">
	</div>
	<br><br>
	<div class="form-group" style="margin-left:150px;">
	<input class="sub-btn" type="submit" value="确认">
	<input class="sub-btn" type="reset" value="清除">
	</div>
	</form>
	</div>
	
	</div>
	</div>
</body>

</html>