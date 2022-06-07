<%@ page language="java" contentType="text/html; charset=utf-8" import="com.model.Gonggao"
	pageEncoding="utf-8"%>

<%
	Gonggao gonggao = (Gonggao) session.getAttribute("gonggao");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>公告内容</title>
</head>
<body>

<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0" style="margin:10px auto;">
  <tr>
    <td width="10" valign="top">&nbsp;</td>
    <td valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
		<%if(gonggao!=null) {%>
        <td height="" valign="top" bgcolor="#FFFFFF" style="border:1px solid #e0e0e0; padding:10px; line-height:25px;">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="30" align="center" class="line"><%=gonggao.getGonggaoName()%></td>
                  </tr>
                  <tr>
                    <td height="30" align="center" class="line"><%=gonggao.getGonggaoDate()%> || 发布者:管理员 || <%=gonggao.getGgtypeName()%></td>
                  </tr>
                  <tr>
                    <td align="left"><div style="margin:20px; line-height:23px;"><%=gonggao.getGonggaoMark()%></div></td>
                  </tr>
			</table>
        </td>
		<%}else{ %>
		<td>没有选择公告</td>
		<%} %>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>