//获取当前时间的函数
function getNowFormatDate(obj) {
    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();
    var currentdate3= "S"+((date.getFullYear()-2017)*365*24*60*60+month*31*24*60*60 + strDate*24*60*60 + hour*60*60 + minute*60 + second);
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if (hour >= 0 && hour <= 9) {
    	hour = "0" + hour;
    }
    if (minute >= 0 && minute <= 9) {
    	minute = "0" + minute;
    }
    if (second >= 0 && second <= 9) {
    	second = "0" + second;
    }
    var currentdate1 = "V"+date.getFullYear()+month + strDate + hour + minute + second;
    var currentdate2 = date.getFullYear() +"-"+ month +"-"+ strDate ;
    
  
    
    if(obj==1){
    	return currentdate1;
    }if(obj==2){
    	return currentdate2;
    }if(obj==3){
    	return currentdate3;
    }
    
}
function setSelect(){
	
	var zxbj=$("#zxbj").val();
	if(zxbj!=""){
			$("select[name='zxbj'] option[value='"+zxbj+"']").prop("selected",true);
	}
}
$(function(){
	if($("input[name='station_Code']").val()=="")$("input[name='station_Code']").val(getNowFormatDate(3));
	$("input[name='create_Time']").val(getNowFormatDate(2));
	setSelect();
}) 
var index=-1;
function addPile(){
	index++;
	date=getNowFormatDate(2);
	var table=$("#mainTable");
	table.append(



			"<tr>\
			<td ><input class='my-middle-input' name='piles["+index+"].pile_Code'  type='text' value='P"+index+"'/></td>\
			<td ><input class='my-small-input' name='piles["+index+"].vender_Id' type='text' value='123'/></td>\
			<td ><select name='piles["+index+"].status'>\
			<option value='2'> 无车</option>\
			<option value='1'> 有车</option>\
			<option value='9'> 报废</option>\
			</select></td>\
			<td ><input class='my-middle-input' name='piles["+index+"].install_Time' type='date' value=''/></td>\
			<td ><input class='my-middle-input' name='piles["+index+"].disassembly_Time' type='date' value=''/></td>\
			<td ><input class='my-small-input' name='piles["+index+"].user_Id'  type='text' value='"+$("input[name='user_Id']").val()+"'/></td>\
			<td ><input class='my-middle-input' name='piles["+index+"].operator_Time' type='date' value='"+date+"'/></td>\
			<td ><input class='my-small-input' name='piles["+index+"].bicycle_Id' type='text' value='0'/></td>\
			<td ><input class='my-small-input' name='piles["+index+"].remark' type='text' value='无'/></td>\
			<td ><input type='button' value='删除' onclick='removePile(this)'/></td>\
		</tr>"	
	
	)
	$("input[name='bicycle_Pile_Num']").val($("#mainTable").children().eq(0).children().size()-1);
	
}
function removePile(obj){
	$(obj).parent().parent().remove();
	
	
}

