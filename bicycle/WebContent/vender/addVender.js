//获取当前时间的函数
function getNowFormatDate(obj) {
    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();
    var currentdate3= "V"+((date.getFullYear()-2017)*365*24*60*60+month*31*24*60*60 + strDate*24*60*60 + hour*60*60 + minute*60 + second);
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

$(function(){
	if($("input[name='vender_Code']").val()=="")$("input[name='vender_Code']").val(getNowFormatDate(3));
	$("input[name='create_Time']").val(getNowFormatDate(2));
}) 

