<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>编辑用户</h3>
<form action="user_save" method="post">
<table width="70%" border="1" cellpadding="5" cellspacing="0" bgcolor="#cccccc">
     <!-- 隐藏域 -->
      <input name="uid" type="hidden"  id="uid" value="<s:property value="#u.uid"/>"/>
	 <tr>
		<td align="right">用户名称</td>
		<td><input type="text" name="user" value="<s:property value="#u.user"/>"/></td>
	</tr>
	<tr>
		<td align="right">用户邮箱</td>
		<td><input type="text" name="email" value="<s:property value="#u.email"/>" /></td>
	</tr>
	<tr>
		<td align="right">用户密码</td>
		<td><input type="password" name="password" value="<s:property value="#u.password"/>" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit"  value="编辑用户"/></td>
	</tr>

</table>
</form>
</body>
</html>