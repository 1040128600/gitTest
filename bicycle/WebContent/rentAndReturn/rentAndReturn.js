
var pile_Id=""
var bicycle_Id=""
function showOptionDiv(obj){
	
	$("#optionDiv").prop("hidden",false);
	pile_Id=$(obj).children().eq(0).children().eq(0).html().split(" 车桩ID：   ")[1]
	bicycle_Id=$(obj).children().eq(0).children().eq(2).html().split(" 自行车ID：")[1]
	
}
function rentBike(){
	$("#optionDiv").prop("hidden",true);
	card_Code=$("#card_Code").val()
	$.post("/bicycle/rentAndReturn/rent",{card_Code:card_Code,bicycle_Id:bicycle_Id,pile_Id:pile_Id},function(data){
		alert(data)
		changePage()
	},"json")
	
}
function returnBike(){
	$("#optionDiv").prop("hidden",true);
	card_Code=$("#card_Code").val()
	$.post("/bicycle/rentAndReturn/return",{card_Code:card_Code,pile_Id:pile_Id},function(data){
		alert(data)
		changePage()
	},"json")
}
function hideOptionDiv(){
	$("#optionDiv").prop("hidden",true);
}

//----ajax查询------

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
var station_Code="";
var station_Name="";

var address="";
var zxbj="0";
function queryStation(){
station_Code=$("#station_Code").val();
station_Name=$("#station_Name").val();
address=$("#address").val();

zxbj=$("#zxbj option:selected").val();
goFirstPage();
}
function changePage(){
targetPage=$("#targetPage").val();

/*	alert(""+ bookCode+
bookName+
author+
status)*/
$.post("/bicycle/station/getOnePage",{station_Code:station_Code,station_Name:station_Name,address:address,zxbj:zxbj,targetPage:targetPage},function(data){


	var page=data;
	var stationList=page.list;




	$("#mainDiv").html("");
	for(i=0;i<stationList.length;i++){
		$("#mainDiv").append(//--------------------------
		"<div class='grayDiv station'>"+
		"<label class='stationName'>车点名称："+stationList[i].station_Name+"</label><br>"+
		
		makePiles(stationList[i].piles)+"</div>"
		
		)


}

$("#targetPage").val(page.currentPage);
$("#currentPage").html(page.currentPage);
$("#pageCount").html(page.pageCount);
},"json")
}
function makePiles(piles){
	var str=" ";
	if(piles==null || piles.length==0){
	
		return "<div class='pile' style='background:gray'>"+
		"<div class='detail' >" +
		"<label > 车桩ID：   </label><br>"+
		"<label > 自行车ID：</label><br>"+
		"</div>"
		"</div>";
	}
	for(var j=0;j<piles.length;j++){
		if(piles[j].bicycle_Id==0){
			str+="<div class='pile0'"
		}else{
			str+="<div class='pile'"
		}
		str+=" onmouseover='showDetail(this)' onmouseout='hideDetail(this)' onclick='showOptionDiv(this)'>\
		<div class='detail' >\
		<label > 车桩ID：   "+piles[j].pile_Id+"</label><br>\
		<label > 自行车ID："+piles[j].bicycle_Id+"</label><br>\
		</div>\
		</div>";
	
	}
	return str;
}
function showDetail(obj){
	$(obj).children().eq(0).css("visibility","visible")
}
function hideDetail(obj){
	$(obj).children().eq(0).css("visibility","hidden")
}
$(function (){
queryStation();
})