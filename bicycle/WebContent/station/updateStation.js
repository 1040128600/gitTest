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

var n;
function addPile(){

	n++;
	var date=getNowFormatDate(2)
	var table=$("#mainTable");
	table.append(
			"<tr>\
			<td ><input class='my-small-input' name='piles["+n+"].pile_Id'  type='text' value='0' hidden/>" +
					"<input class='my-small-input'  type='text' value='自动生成' readonly/></td>\
			<td ><input class='my-middle-input' name='piles["+n+"].pile_Code'  type='text' value='P"+n+"'/></td>\
			<td ><input class='my-small-input' name='piles["+n+"].vender_Id' type='text' value='123'/></td>\
			<td ><input class='my-small-input' name='piles["+n+"].station_Id' type='text' value='"+$("input[name='station_Id']").val()+"'/></td>\
			<td ><select name='piles["+n+"].status'>\
			<option value='2'> 无车</option>\
			<option value='1'> 有车</option>\
			<option value='9'> 报废</option>\
			</select></td>\
			<td ><input class='my-middle-input' name='piles["+n+"].install_Time' type='date' value='2018-01-10'/></td>\
			<td ><input class='my-middle-input' name='piles["+n+"].disassembly_Time' type='date' value=''/></td>\
			<td ><input class='my-small-input' name='piles["+n+"].user_Id'  type='text' value='"+$("input[name='user_Id']").val()+"'/></td>\
			<td ><input class='my-middle-input' name='piles["+n+"].operator_Time' type='date' value='"+date+"'/></td>\
			<td ><input class='my-small-input' name='piles["+n+"].bicycle_Id' type='text' value='0'/></td>\
			<td ><input class='my-small-input' name='piles["+n+"].remark' type='text' value='无'/></td>\
			<td ><input type='button' value='删除' onclick='removePile(this)'/></td>\
		</tr>"
	
	)
	
	$("input[name='bicycle_Pile_Num']").val($("#mainTable").children().eq(0).children().size()-1);
}
function cancelPile(obj){
	var ops=$(obj).parent().parent().children().eq(4).children().eq(0).children();
	
	ops.eq(0).prop("selected",false);
	ops.eq(1).prop("selected",false);
	ops.eq(2).prop("selected",true);
}
function removePile(obj){
	$(obj).parent().parent().remove();	
}

$(function(){
	setSelect();
	n=parseInt($("#pileNum").val())-1
})