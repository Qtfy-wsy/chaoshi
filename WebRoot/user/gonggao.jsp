<%@ page language="java" import="com.model.Gonggao"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公告信息管理</title>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="../fuwenben/themes/default/default.css" />
<link rel="stylesheet" href="../fuwenben/plugins/code/prettify.css" />
<script charset="utf-8" src="../fuwenben/kindeditor-all.js"></script>
<script charset="utf-8" src="../fuwenben/lang/zh-CN.js"></script>
<script charset="utf-8" src="../fuwenben/plugins/code/prettify.js"></script>

	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="gonggaoMark"]', {
				cssPath : '../fuwenben/plugins/code/prettify.css',
				uploadJson : '../fuwenben/jsp/upload_json.jsp',
				fileManagerJson : '../fuwenben/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				},
				afterBlur: function(){this.sync();}
			});
			prettyPrint();
		});
	</script>
<script type="text/javascript">
var url;
	function searchGonggao(){
		$('#dg').datagrid('load',{
			gonggaoName:$('#s_gonggaoName').val(),
			ggtypeId:$('#s_ggtypeId').combobox("getValue"),
			sdate:$('#s_sdate').datebox("getValue"),
			edate:$('#s_edate').datebox("getValue")
		});
	}
	
	function saveGonggao(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
			
				var s=result;
				var result = eval('(' + result + ')');
			
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function openGonggaoAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加gonggao信息");
		url="../addGonggao";
	}
	
	function resetValue(){
	}
	
	function deleteGonggao(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].gonggaoId);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("../deleteGonggao",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].gonggaoName+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
	}
	
	function closeGonggaoDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openGonggaoModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑gonggao信息");
		$("#fm").form("load",row);
		url="../addGonggao?gonggaoId="+row.gonggaoId;
	}
	
	function formatChakan(shujuImg, row) {
		if(shujuImg){
			return '<a target="_blank" style="color:red;" href="../' + shujuImg + '">查看' + '</a>'; 
		}else {
			return "未上传";
		}
	}
	
	function formatXiazai(shujuImgName, row) {
		if(shujuImgName){
			return '<a target="_blank" style="color:red;" href="../downFile?filename=' + shujuImgName + '">下载' + '</a>'; 
		}else {
			return "未上传";
		}
	}
	
	function datetostr(dateTime, row) {
		if(dateTime){
			var JsonDateValue = new Date(dateTime.time);
			var text = JsonDateValue.toLocaleString();
			return text;
		}else{
			return "未填写";
		}
	}
	
	function doPrint() {      
        bdhtml=window.document.body.innerHTML;      
        sprnstr="<!--startprint-->";      
        eprnstr="<!--endprint-->";      
        prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);      
        prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));      
        window.document.body.innerHTML=prnhtml;   
        window.print();      
	}
	
	function shangchuanGonggao(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#shangchuan").dialog("open").dialog("setTitle","上传gonggao信息");
		$("#shchfm").form("load",row);
		shchurl="../shangchuanGonggao?gonggaoId="+row.gonggaoId;
	}
	
	function closeShangchuanGonggao(){
		$("#shangchuan").dialog("close");
		resetValue();
	}
	
	function saveShangchuanGonggao(){
		$("#shchfm").form("submit",{
			url:shchurl,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
			
				var s=result;
				var result = eval('(' + result + ')');
			
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#shangchuan").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function chakanNeirong(shujuImg, row) {
		return '<a style="color:red;"target="_blank" href="../neirongGonggao?gonggaoId=' + shujuImg + '">查看' + '</a>';  
	}
</script>
</head>
<body style="margin: 5px;">
<!--startprint-->
	<table id="dg" title="公告信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" url="../getGonggaos" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="gonggaoId" width="20" formatter="chakanNeirong">查看</th>
				<th field="gonggaoName" width="80">标题</th>
				<th field="gonggaoDate" width="40" formatter="datetostr">时间</th>
				<th field="ggtypeId" width="20" hidden="true">类型ID</th>
				<th field="ggtypeName" width="40">类型</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
		&nbsp;名称：&nbsp;<input type="text" name="s_gonggaoName" id="s_gonggaoName" size="10"/>
		&nbsp;时间：&nbsp;<input class="easyui-datebox" name="s_sdate" id="s_sdate" editable="false" size="10"/>->
		<input class="easyui-datebox" name="s_edate" id="s_edate" editable="false" size="10"/>
		&nbsp;类型：&nbsp;<input class="easyui-combobox" id="s_ggtypeId" name="s_ggtypeId"  data-options="panelHeight:'auto',editable:false,valueField:'ggtypeId',textField:'ggtypeName',url:'../ggtypeComboList'"/>
		<a href="javascript:searchGonggao()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
<!--endprint-->
	
	<div id="dlg" class="easyui-dialog" style="width: 850px;height: 380px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form name="fm" id="fm" method="post">
			<table>
				<tr>
					<td>名称：</td>
					<td><input type="text" name="gonggaoName" id="gonggaoName" class="easyui-validatebox" required="true"/></td>
					<td>类型：</td>
					<td><input class="easyui-combobox" id="ggtypeId" name="ggtypeId"  data-options="panelHeight:'auto',editable:false,valueField:'ggtypeId',textField:'ggtypeName',url:'../ggtypeComboList'"/></td>
				</tr>
				<tr>
					<td valign="top">公告描述：</td>
					<td colspan="4"><textarea name="gonggaoMark" id="gonggaoMark" cols="100" rows="12" style="width:700px;height:250px;visibility:hidden;"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveGonggao()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeGonggaoDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
<!--上传-->	
	<div id="shangchuan" class="easyui-dialog" style="width: 320px;height: 140px;padding: 10px 20px"
		closed="true" buttons="#shangchuan-buttons">
		<form id="shchfm" method="post" enctype="multipart/form-data">
			<table cellspacing="5px;">
				<tr>
					<td><input type="file" name="uploadFile" id="uploadFile" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="shangchuan-buttons">
		<a href="javascript:saveShangchuanGonggao()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeShangchuanGonggao()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>