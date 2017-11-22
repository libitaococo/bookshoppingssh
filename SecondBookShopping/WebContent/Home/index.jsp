<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>二手书商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/Home/style/style.css" rel="stylesheet" type="text/css">
<script language="javascript">
function clear(){

document.form1.webUserEntity.name="";
document.form1.webUserEntity.address="";
document.form1.webUserEntity.postcode="";
document.form1.webUserEntity.phone="";
}
</script>

</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

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
<a href="${pageContext.request.contextPath}/Home/login.jsp" target="_parent">登录&nbsp;]</a>|
<a href="${pageContext.request.contextPath}/Home/register.jsp" target="_parent">注册&nbsp;</a> | 
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
				  <s:iterator value="#list" var="c">
				  <option value="<s:property value="#c.cid"/>"/><s:property value="#c.cname"/></option>
			     </s:iterator>
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
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="3" background="${pageContext.request.contextPath}/Home/graphics/whole_line.gif"><img src="${pageContext.request.contextPath}/Home/graphics/space.gif" width="1" height="1"></td>
          </tr>
  </table>
  </td>
</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh" align="center">
  <tr>
    <td height="17"><a href="index_list.action"></a> 首页</td>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main" align="center">
<tr valign="top">
<td><form action="index_list.action" method="post" enctype="multipart/form-data" name="form1">
  <table width="100%" border="0" cellpadding="2" cellspacing="1" class="inputTable" align="center" >
  <s:iterator value="#list" var="c" begin="0" end="2">
   <!-- 隐藏域 -->
      <input name="cid" type="hidden"  value="<s:property value="#c.cid"/>"/>
    <tr>
      <td colspan="6" class="inputTitle"><s:property value="#c.cname"/></td>
    </tr>
    <tr>
      <td colspan="6">
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox" align="center"  >
           <tr>
             <%for(int i=0;i<5;){%>
            <s:iterator value="#lists" var="p" >
             <!-- 隐藏域-->
             <input name="pid" type="hidden"  value="<s:property value="#p.pid"/>"/>
            <!-- 隐藏域 -->
            <input name="cid" type="hidden"  value="<s:property value="#p.cid"/>"/>
           	        <s:if test="#p.cate.cid==#c.cid">
           	    	<td align="center" class="inputHeader">
           	    	<a href="pro_detailPro.action?pid=<s:property value="#p.pid"/>&cid=<s:property value="#p.cate.cid"/> ">
                    <img src="<s:property value="#p.image"/>"  width="137" height="200"></a></td>
                     <%i++;%>
           	     </s:if>
           	     <s:else><%i=i;%></s:else>
	            </s:iterator>
	            <%i=i;%>
			</tr> 
       <%} %>
          <tr> 
          <%for(int i=0;i<5;){%>
           <s:iterator value="#lists" var="p" >
           <s:if test="#p.cate.cid==#c.cid"> 
	       			<td width="25%" align="center" class="titlegrey">
					      <s:property value="#p.pname"/>
					</td>
					<%i++;%>
		   </s:if> 
		   <s:else><%i=i;%></s:else>
	       </s:iterator>
	       <%i=i;%>
	        </tr> 
	        <%} %>   
       </table>
       </td>
       </tr>
       </s:iterator>
       </table>
       </form>
       </td>
       </tr>
</table>
<!-- #BeginLibraryItem "/Library/footer.lbi" -->

<table width="770" border="0" cellspacing="0" cellpadding="0" class="pagefoot" align="center">
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
