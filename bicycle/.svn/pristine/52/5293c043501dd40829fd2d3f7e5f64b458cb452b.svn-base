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
var vender_code="";
var vender_name="";

var vender_type="";
var zxbj="";
function queryVender(){
	vender_code=$("#vender_code").val();
	vender_name=$("#vender_name").val();
	vender_type=$("#vender_type option:selected").val();

	zxbj=$("#zxbj option:selected").val();
	goFirstPage();
}
function changePage(){
	targetPage=$("#targetPage").val();
	
/*	alert(""+ bookCode+
	bookName+
	author+
	status)*/
$.post("/bicycle/vender/getOnePage",{vender_Code:vender_code,vender_Name:vender_name,vender_Type:vender_type,zxbj:zxbj,targetPage:targetPage},function(data){
		
		
	var page=data;
	var venderList=page.list;

	


	$(".mainTr").remove();
	for(i=0;i<venderList.length;i++){
	$("#mainTable").append(//-------------插入表格内容-------------
			 '<tr class="mainTr">\
		    <td > <a  href="/bicycle/vender/getOneVender?vender_Id='+venderList[i].vender_Id+'&readonly=1" target="_self">'+venderList[i].vender_Id+'</a></td>\
			<td >'+venderList[i].vender_Code+'</td>\
			<td >'+venderList[i].vender_Name+'</td>\
			<td >'+venderList[i].vender_Type+'</td>\
		    <td >'+venderList[i].zxbj+'</td>\
		    <td >'+venderList[i].telphone+'</td>\
		    <td >\
		    <div class="table-fun">\
		    <a  href="/bicycle/vender/getOneVender?vender_Id='+venderList[i].vender_Id+'" target="_self">修改</a>\
		    <a  href="/bicycle/vender/deleteOneVender?vender_Id='+venderList[i].vender_Id+'" target="_self">注销</a> \
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
	queryVender();
})