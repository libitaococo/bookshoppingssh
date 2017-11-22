<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>二手书商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/Home/style/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="${pageContext.request.contextPath}/Home/js/checkform.js">
</script>
<script type="text/javascript">

</script>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
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
                <td width="76" class="menuLinkbg"><a href="cart_listcart.action?uid=<s:property value="#session.existUser.uid"/>" class="menuLink" target="_parent">我的购物车</a></td>
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
<a href="{:U('Index/send_notes')}" target="_parent" class="menuLink">说明</a></td>
  
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
            <td height="3" background="${pageContext.request.contextPath}/Home/graphics/whole_line.gif"><img src="__PUBLIC__/Home/graphics/space.gif" width="1" height="1"></td>
          </tr>
  </table></td>
</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh" align="center"
>
  <tr>
    <td height="17"><a href="index_list.action">主页</a> &raquo;购物车</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main" align="center">
<tr valign="top">
<td><form action="order_add" method="post" enctype="multipart/form-data" name="form1">
  <table width="100%" border="0" cellpadding="2" cellspacing="1" class="inputTable" align="center">
    <tr>
      <td class="inputTitle">购物车内的商品</td>
    </tr>
    <tr>
      <td class="inputHeader">
	   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
	     <tr>
	       <td align="center" class="titlegrey">操作</td>
	       <td width="36%" align="center" class="titlegrey">商品名</td>
	       <td width="12%" align="center" class="titlegrey">市场价</td>
	       <td width="10%" align="center" class="titlegrey">会员价</td>
	       <td width="9%" align="center" class="titlegrey">数量</td>
	       <td width="9%" align="center" class="titlegrey">价格</td>
	     </tr>
	     <s:iterator value="#u" var="ct">
          <tr>
          <!-- 隐藏域 -->
            <input name="ctid" type="hidden"  value="<s:property value="#ct.ctid"/>"/>
            <td width="20%" align="center" class="inputHeader"><p><a href="favorite.htm"><img src="${pageContext.request.contextPath}/Home/graphics/collection.gif" alt="移入收藏夹" width="80" height="17" border="0">
            </a>&nbsp;&nbsp;<a href="cart_delete.action?ctid=<s:property value="#ct.ctid"/>&uid=<s:property value="#session.existUser.uid"/>" onClick="if(window.confirm('确定删除？'));else return false">
            <img src="${pageContext.request.contextPath}/Home/graphics/delete_item.gif" alt="删除" width="45" height="17" border="0"></a></p> 
            </td>
			<td align="center" class="inputHeader"><a href="item_info.htm"><font color="#CC0000"><b><s:property value="#ct.pro.pname"/></b></font></a></td>
			<td align="center" class="inputHeader">￥<s:property value="#ct.pro.mprice"/></td>
			<td align="center" class="inputHeader">￥<s:property value="#ct.pro.vprice"/></td>
			<td align="center" class="inputHeader"><s:property value="#ct.cnum"/></td>
			<td align="center" class="inputHeader">￥<s:property value="#ct.pro.vprice*#ct.cnum"/></td>    
            </tr>
            </s:iterator>
          
          <tr>
          <td colspan="7" align="right" class="inputHeader">商品总数量 <s:property value="onum"/>件</td>
          <!-- 隐藏域 -->
           <input name="oprice" type="hidden" value="<s:property value="oprice"/>">
           <input name="onum" type="hidden" value="<s:property value="onum"/>">
           <input name="uid" type="hidden" value="<s:property value="#session.existUser.uid"/>">
         </tr>
         
          <tr>
          <td colspan="7" align="right" class="inputHeader">购物金额小计 ￥<s:property value="oprice"/>元</td>
          </tr>
          
		   <tr>
		     <td colspan="7" align="right" class="inputHeader"><input type="button" name="continue" value="继续购物"  onClick="javascript:window.location.href='index_list.action'">&nbsp;&nbsp;
		     <input type="button" name="edit2" value="更新" onClick="checkitemno()"></td>
		     </tr>
		   <tr>
             <td colspan="7" align="right" class="inputHeader">
             <font color="#CC0000"><a href="order_info.htm"></a></font> 
             <input type="submit" style="background-image:url(${pageContext.request.contextPath}/Home/graphics/check_account.gif ); width:116px; height:22px;" value="">
             </td>
             </tr>
        </table>
        
	  </td>
    </tr>
   
   
  </table>
  </form>  
</td>
</tr>
</table>
<!-- #BeginLibraryItem "/Library/footer.lbi" -->
<table width="770" border="0" cellspacing="0" cellpadding="0" class="pagefoot" align="center"  >
<tr>
<td>  <table width="100%" border="0" cellpadding="0" cellspacing="0">
   
<tr>
	  
<td colspan="2" class="pagefootTl"><img src="${pageContext.request.contextPath}/Home/graphics/space.gif" width="1" height="1"></td>
</tr>
   
<tr>
	  
<td height="22" class="pagefoot"><img src="${pageContext.request.contextPath}/Home/graphics/space.gif" width="15" height="8"> <a href="#" class="menuLinkf" target="_parent">隐私权 | &copy; 版权</a> | <a href="#" class="menuLinkf" target="_parent">法律声明</a> | 电子邮件：<a href="#" target="_parent">admin@163.com</a>&nbsp;</td>
  <td align="right" class="pagefoot"><font face="Arial, Helvetica, sans-serif"><a href="home.html" target="_parent">二手书商城</a>&nbsp; Power by IBM </font>&nbsp;</td>
</tr>
</table>
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td height="5"><img src="${pageContext.request.contextPath}/Home/graphics/space.gif" width="1" height="1"></td>
    </tr>
</table></td></tr>
</table>
<!-- #EndLibraryItem --></body>
</html>
