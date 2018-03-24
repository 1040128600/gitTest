	//----ajax查询------
var bicycleStatus=new Array("","gouru为入桩","借出","在桩","普通调出","维修调出","","","","报废")
		//---------------------分页----

function checkNum(){
	if($("#targetPage").val()<1) $("#targetPage").val("1");
		if($("#targetPage").val()>$("#pageCount").html()) $("#targetPage").val($("#pageCount").html());
}
function goFirstPage(){
	$("#targetPage").val("1")
	changePage();
}
function goPrePage(){
	if($("#targetPage").val()>1){
		
	$("#targetPage").val($("#targetPage").val()-1)
	changePage();
	}
}
function goSpecifiedPage(){

	changePage()
}
function goNextPage(){
	if($("#targetPage").val()<$("#pageCount").html()){
		
		$("#targetPage").val(parseInt($("#targetPage").val())+1);
		changePage()
	}
	
}
function goEndPage(){
	$("#targetPage").val($("#pageCount").html())
	changePage()
}
var bicycle_Code="";
var operator_Time="";
var status="0";
function queryBicycle(){
	bicycle_Code=$("#bicycle_Code").val();
	operator_Time=$("#operator_Time").val();
	status=$("#status option:selected").val();
	goFirstPage();
}
function changePage(){
	targetPage=$("#targetPage").val();
	
$.post("/bicycle/station/getOnePageBicycle",{bicycle_Code:bicycle_Code,operator_Time:operator_Time,status:status,targetPage:targetPage},function(data){
		
		
	var page=data;
	var bicycleList=page.list;

	


	$(".mainTr2").remove();
	for(i=0;i<bicycleList.length;i++){
	$("#mainTable2").append(//-------------插入表格内容-------------
			 '<tr class="mainTr2">\
		    <td >'+bicycleList[i].bicycle_Id+'</td>\
			<td >'+bicycleList[i].bicycle_Code+'</td>\
			<td >'+bicycleStatus[bicycleList[i].status]+'</td>\
			<td >'+transStationName(bicycleList[i].station_Name)+'</td>\
		    <td ><input type="button" value="查看" onclick="getOneBicycleStatistic('+bicycleList[i].bicycle_Id+')" /></td>\
			</tr>'
		  
  )
	}
	$("#targetPage").val(page.currentPage);
	$("#currentPage").html(page.currentPage);
	$("#pageCount").html(page.pageCount);
},"json")
}
function getOneBicycleStatistic(bicycle_Id){
	$.post("/bicycle/BicycleFeeStatistic/getStatisticByBicycleId",
			{bicycle_Id:bicycle_Id},
			function (data){
				$("#useTime").html(transToDateStr(data.useTime));
				$("#rentTimes").html(data.rentTimes)
				$("#repairTimes").html(data.repairTimes)
				$("#deployTimes").html(data.deployTimes)
				$("#sumRentTime").html(transToDateStr(data.sumRentTime))
				$("#avgRentTime").html(transToDateStr(data.avgRentTime))
				$("#sumIncomeFee").html(data.sumIncomeFee)
				$("#avgIncomeFee").html(data.avgIncomeFee)
				$("#sumRepairFee").html(data.sumRepairFee)
				$("#avgRepairFee").html(data.avgRepairFee)
				$("#bicycleDetail").prop("hidden",false);
			},
			"json")
}
function hideDetail(){
	$("#bicycleDetail").prop("hidden",true);
}
function queryByMonth(){
	
	$.post("/bicycle/BicycleFeeStatistic/getStatisticByMonth",
			{year:$("#year option:selected").val(),month:$("#month option:selected").val()},
			function(data){
		
		$(".mainTr1").remove();
		$("#mainTable1").append(
				"<tr class='mainTr1'>\
				 	<td >"+data.bicycleNum+"辆</td>\
						<td >"+data.rentTimes+"</td>\
						<td >"+data.repairTimes+"</td>\
						<td >"+transToDateStr(data.avgRentTime)+"</td>\
						<td >"+transToDateStr(data.sumRentTime)+"</td>\
						<td >"+formatFloat(data.avgIncomeFee,2)+"</td>\
						<td >"+formatFloat(data.sumIncomeFee,2)+"</td>\
						<td >"+formatFloat(data.avgRepairFee,2)+"</td>\
						<td >"+formatFloat(data.sumRepairFee,2)+"</td>\
				</tr>"
				
				)
		
	},"json")
}
function transToDateStr(num){
	var dateStr="";
	var day=parseInt(num/(24*60*60));
	var hour=parseInt(num%(24*60*60)/(60*60));
	var mi=parseInt(num%(60*60)/60)
	var sec=formatFloat(num%60,2)
	if(day!=0)dateStr+=(day+"天 ")
	if(hour!=0)dateStr+=(hour+"小时 ")
	if(mi!=0)dateStr+=(mi+"分钟 ")
	if(sec!=0)dateStr+=(sec+"秒")
	if(dateStr=="")return "0";
	else return dateStr;
}
function transStationName(str){
	if(str==undefined){
		return "不在车点"
	}
	return str;
}
function formatFloat(num,pos){
	return Math.round(num*Math.pow(10,pos))/Math.pow(10,pos)
}

$(function (){
	queryByMonth();
	queryBicycle();
})