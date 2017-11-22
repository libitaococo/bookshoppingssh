<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>修改分类</h3>
<foreach name="select" item="s">
<form action="cate_save" method="post">
<table width="70%" border="1" cellpadding="5" cellspacing="0" bgcolor="#cccccc">
	<!-- 隐藏域 -->
      <input name="cid" type="hidden" id="cid"  value="<s:property value="#c.cid"/>"/>
	<tr>
		<td align="right">分类名称</td>
		<td><input type="text" name="cname" value="<s:property value="#c.cname"/>"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit"  value="修改分类"/></td>
	</tr>

</table>
</form>
</foreach>
