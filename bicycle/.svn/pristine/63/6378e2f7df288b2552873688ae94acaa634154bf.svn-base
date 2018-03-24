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

	


	$(".mainTr").remove();
	for(i=0;i<stationList.length;i++){
	$("#mainTable").append(//-------------插入表格内容-------------
			 '<tr class="mainTr">\
		    <td > <a  href="/bicycle/station/getOneStation?station_Id='+stationList[i].station_Id+'&readonly=1" target="_self">'+stationList[i].station_Id+'</a></td>\
			<td >'+stationList[i].station_Code+'</td>\
			<td >'+stationList[i].station_Name+'</td>\
			<td >'+stationList[i].address+'</td>\
		    <td >'+stationList[i].bicycle_Pile_Num+'</td>\
		    <td >'+stationList[i].build_Time+'</td>\
		    <td >'+stationList[i].zxbj+'</td>\
		    <td >\
		    <div class="table-fun">\
		    <a  href="/bicycle/station/getOneStation?station_Id='+stationList[i].station_Id+'" target="_self">修改</a>\
		    <a  href="/bicycle/station/deleteOneStation?station_Id='+stationList[i].station_Id+'" target="_self">注销</a> \
		    </div>\
			</tr>'
		  
  )
	}
	$("#targetPage").val(page.currentPage);
	$("#currentPage").html(page.currentPage);
	$("#pageCount").html(page.pageCount);
},"json")
}
$(function (){
	queryStation();
})