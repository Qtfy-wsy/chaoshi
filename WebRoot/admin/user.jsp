<%@ page language="java" import="com.model.User"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工信息管理</title>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var url;
	function searchUser(){
		$('#dg').datagrid('load',{
			userXingming:$('#s_userXingming').val(),
			userName:$('#s_userName').val(),
			userSex:$('#s_userSex').combobox("getValue"),
			bumenId:$('#s_bumenId').combobox("getValue")
		});
	}
	
	function saveUser(){
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
	
	function openUserAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加员工信息");
		url="../addUser";
	}
	
	function resetValue(){
	}
	
	function deleteUser(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].userId);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("../deleteUser",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].userName+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
	}
	
	function closeUserDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openUserModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑员工信息");
		$("#fm").form("load",row);
		url="../addUser?userId="+row.userId;
	}
	
	function formatSex(shujuSex, row) {  
		if(shujuSex==0){
			return "男";
		}
		if(shujuSex==1){
			return "女";
		}
	}
	
	function formatType1(shujuType1, row) {  
		if(shujuType1==0){
			return "零";
		}
		if(shujuType1==1){
			return "一";
		}
	}
	
	function formatType2(shujuType2, row) {  
		if(shujuType2==0){
			return "0";
		}
		if(shujuType2==1){
			return "1";
		}
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
	
	function daochuUser(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要导出的数据！");
			return;
		}
		var userIds=[];
		for(var i=0;i<selectedRows.length;i++){
			userIds.push(selectedRows[i].userId);
		}
		var ids=userIds.join(",");
		$.messager.confirm("系统提示","您确认要导出数据吗？",function(r){
			if(r){
				$.post("../daochuUser",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功导出数据：D:！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].userName+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
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
	
	function daoruUsers(){
		$("#daoru").dialog("open").dialog("setTitle","导入员工信息");
		daoruurl="../daoruUser";
	}
	
	function closeDaoruUser(){
		$("#daoru").dialog("close");
		resetValue();
	}
	
	function saveDaoruUser(){
		$("#drfm").form("submit",{
			url:daoruurl,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
			
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#daoru").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function shangchuanUser(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#shangchuan").dialog("open").dialog("setTitle","上传员工信息");
		$("#shchfm").form("load",row);
		shchurl="../shangchuanUser?userId="+row.userId;
	}
	
	function closeShangchuanUser(){
		$("#shangchuan").dialog("close");
		resetValue();
	}
	
	function saveShangchuanUser(){
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
</script>
</head>
<body style="margin: 5px;">
<!--startprint-->
	<table id="dg" title="员工信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" url="../getUsers" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="userId" width="20">编号</th>
				<th field="userName" width="40">登录名</th>
				<th field="userPassword" width="50" hidden="true">密码</th>
				<th field="userXingming" width="40">姓名</th>
				<th field="userSex" width="20" formatter="formatSex">性别</th>
				<th field="userAge" width="20">年龄</th>
				<th field="userPhone" width="40">电话</th>
				<th field="userMark1" width="40">备注</th>
				<th field="bumenId" width="20" hidden="true">部门ID</th>
				<th field="bumenName" width="40">部门</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openUserModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
		&nbsp;用户名：&nbsp;<input type="text" name="s_userName" id="s_userName" size="10"/>
		&nbsp;姓名：&nbsp;<input type="text" name="s_userXingming" id="s_userXingming" size="10"/>
		&nbsp;性别：&nbsp;<select class="easyui-combobox" id="s_userSex" name="s_userSex" editable="false" panelHeight="auto">
		    <option value="">请选择...</option>
			<option value="0">男</option>
			<option value="1">女</option>
		</select>
		&nbsp;部门：&nbsp;<input class="easyui-combobox" id="s_bumenId" name="s_bumenId"  data-options="panelHeight:'auto',editable:false,valueField:'bumenId',textField:'bumenName',url:'../bumenComboList'"/>
		<a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
<!--endprint-->
	<div id="dlg" class="easyui-dialog" style="width: 540px;height: 240px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>登录名：</td>
					<td><input type="text" name="userName" id="userName" class="easyui-validatebox" required="true"/></td>
					<td>密码：</td>
					<td><input type="password" name="userPassword" id="userPassword" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="userXingming" id="userXingming" class="easyui-validatebox" required="true"/></td>
					<td>年龄：</td>
					<td><input type="text" name="userAge" id="userAge" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><select class="easyui-combobox" id="userSex" name="userSex" editable="false" panelHeight="auto" style="width: 155px">
					    <option value="">请选择...</option>
						<option value="0">男</option>
						<option value="1">女</option>
					</select></td>
					<td>电话：</td>
					<td><input type="text" name="userPhone" id="userPhone" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>备注：</td>
					<td><input type="text" name="userMark1" id="userMark1" class="easyui-validatebox" required="true"/></td>
					<td>部门：</td>
					<td><input class="easyui-combobox" id="bumenId" name="bumenId"  data-options="panelHeight:'auto',editable:false,valueField:'bumenId',textField:'bumenName',url:'../bumenComboList'"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
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
		<a href="javascript:saveShangchuanUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeShangchuanUser()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
<!--导入-->	
	<div id="daoru" class="easyui-dialog" style="width: 320px;height: 140px;padding: 10px 20px"
		closed="true" buttons="#daoru-buttons">
		<form id="drfm" method="post" enctype="multipart/form-data">
			<table cellspacing="5px;">
				<tr>
					<td><input type="file" name="uploadFile" id="uploadFile" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="daoru-buttons">
		<a href="javascript:saveDaoruUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeDaoruUser()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	
</body>
</html>