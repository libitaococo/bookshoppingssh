<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>二手书商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/Home/style/style.css" rel="stylesheet" type="text/css">


</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" align="center">
<table width="770" border="0" cellpadding="0" cellspacing="0" class="pagetop" align="center">
<tr>
<td><table width="100%" border="0" cellspacing="0" cellpadding="0" class="pagetopLine"align="center">
  <tr>
    <td><img src="${pageContext.request.contextPath}/Home/graphics/space.gif" width="1" height="1"></td>
  </tr>
</table><table width="100%" border="0" cellpadding="0" cellspacing="0" class="pagetop"align="center">
 
<tr>
	
<td width="124"><img src="${pageContext.request.contextPath}/Home/graphics/3.png"></td>
<td align="right" valign="top" class="help">&nbsp;</td>
<td align="right" valign="top" class="help">[&nbsp;
<a href="login.jsp" target="_parent">登录&nbsp;</a>|
<a href="register.jsp" target="_parent">注册&nbsp;</a> | 
<s:property value="#session.existUser.user"/>会员 您好！ | <a href="user_logout.action" target="_parent" onclick="if (confirm('确定要退出登录吗？')) return true; else return false;">退出</a></td>
</tr>

</table>
  <table width="100%" border="0" cellpadding="0" cellspacing="0"align="center">
    <tr>
      <td height="25" class="menuMain">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td class="menuMain1"><table width="767" height="16" border="0" cellpadding="0" cellspacing="0">
              <tr align="center">
                <td width="45" class="menuLinkbgSel"><a href="index_list.action" class="menuLinkSel" target="_parent">首页</a></td>
                <td width="2"><img src="${pageContext.request.contextPath}/Home/graphics/menu_l.gif" width="2" height="23"></td>
                <td width="65" class="menuLinkbg"><a href="order_list.action" class="menuLink" target="_parent">订单查询</a></td>
                <td width="2"><img src="${pageContext.request.contextPath}/Home/graphics/menu_l.gif" width="2" height="23"></td>
                <td width="65" class="menuLinkbg"><a href="#" class="menuLink" target="_parent">商品搜索</a></td>
                <td width="2"><img src="${pageContext.request.contextPath}/Home/graphics/menu_l.gif" width="2" height="23"></td>
                <td width="76" class="menuLinkbg"><a href="cart_listcart.action" class="menuLink" target="_parent">我的购物车</a></td>
                <td width="2"><img src="${pageContext.request.contextPath}/Home/graphics/menu_l.gif" width="2" height="23"></td>
                <td width="50" class="menuLinkbg"><a href="collection.html" class="menuLink" target="_parent">收藏夹</a></td>
                <td width="2"><img src="${pageContext.request.contextPath}/Home/graphics/menu_l.gif" width="2" height="23"></td>
				 <td align="left" class="menuLinkbg">
				  <select name="category">
				   <option value="5">所有类别</option>
                  <option value="1">经典图书</option>
                   <option value="2">数据库</option>
                   <option value="3">物理学</option>
                   <option value="4">热门小说</option>
              </select>


<input type="text" name="textfield"n size="15">
<input type="button" name="Submit" value="搜索" onClick="javascript:window.open('item_search_list.html','_parent','')">
<a href="send_notes.html" target="_parent" class="menuLink">说明</a></td>
  
                 </tr>
            </table>            
            </td>
          </tr>
    </table></td>
    </tr>
</table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td><img src="${pageContext.request.contextPath}/Home/graphics/whole.jpg"></td>
    </tr>
  </table><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="3" background="${pageContext.request.contextPath}/Home/graphics/whole_line.gif"><img src="${pageContext.request.contextPath}/Home/graphics/space.gif" width="1" height="1"></td>
          </tr>
  </table></td>
</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh" align="center">
  <tr>
    <td height="17"><a href="index_list.action">主页</a> &raquo; 登陆</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main" align="center">
<tr valign="top">
<td><form action="user_login" method="post" namespace="/" enctype="multipart/form-data" name="form1">
  <table width="100%" border="0" cellpadding="2" cellspacing="1" class="inputTable" align="center">
    <tr>
      <td class="inputTitle">登陆<s:actionerror/></td>
    </tr>
    <tr>
      <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="inputbox">
          <tr>
            <td width="4%" class="inputHeader">&nbsp;</td>
            <td width="17%" class="inputHeader">用户名</td>
            <td width="38%" class="inputContent">
               <input type="text" class="text width100" name="user" maxlength="25">
              
            </td>
            <td width="41%" class="inputContent">&nbsp;<font color="#CC0000">*&nbsp;必输项</font></td>
          </tr>
          
          <tr>
            <td class="inputHeader">&nbsp;</td>
            <td class="inputHeader">登录密码：</td>
            <td class="inputContent">
              <input type="Password" class="text width100" name="password"  value="" maxlength="25">
            </td>
            <td class="inputContent">&nbsp;<font color="#CC0000">*&nbsp;必输项</font></td>
          </tr>
          
          <tr>若无账户，请点击 <a href="${pageContext.request.contextPath}/Home/register.jsp">注册</a></tr>
          
        </table>
        <table width="100%" border="0" cellspacing="1" cellpadding="0">
          <tr>
            <td width="4%" class="inputContent">&nbsp;</td>
            <td width="17%" class="inputHeader">&nbsp;</td>
            <td width="39%" class="inputContent">

&nbsp;&nbsp;
&nbsp;&nbsp;
&nbsp;&nbsp;
<input type="Reset" class="bt2" name="button1" value="重填" onClick="clear()">
&nbsp;&nbsp;
&nbsp;

<input type="submit" class="bt2" name="button2" value="提交" onClick="checkregform()">
&nbsp;
&nbsp;
&nbsp;
<input type="Button" class="bt2" name="button3" value="返回" onClick="javascript:window.location.href='index.jsp'">
            </td>
            <td width="40%" class="inputContent">&nbsp;</td>
          </tr>
        </table>
</td>
    </tr>
  </table>
  </form>  
</td>
</tr>
</table>

<iframe src="${pageContext.request.contextPath}/Home/bottom.html" frameborder="0" marginheight="0" marginwidth="0" width="770" height="130" scrolling="no"></iframe>
</body>
</html>