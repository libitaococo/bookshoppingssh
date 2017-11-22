<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<iframe src="${pageContext.request.contextPath}/Home/top.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="130" scrolling="no" ></iframe>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh" align="center">
  <tr>
    <td height="17"><a href="index_list.action">主页</a> &raquo; 订单详细信息&nbsp;&nbsp;&nbsp;&nbsp;<a href="order_list.action">返回</a></td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main" align="center">
<tr valign="top">
<td><form action="" method="post" enctype="multipart/form-data" name="form1">
  <table width="100%" border="0" cellpadding="2" cellspacing="1" class="inputTable">
 
    <tr>
      <td class="inputTitle">商品信息</td>
    </tr>
    <tr>
      <td><table width="100%" border="0" cellpadding="0" cellspacing="1" class="inputbox">
        <tr>
         <td width="20%" align="center" class="inputHeader">订单号</td>
			<td width="10%" align="center" class="inputHeader">&nbsp;商品号</td>
			<td width="30%" align="center" class="inputHeader">&nbsp;商品名称</td>
			<td width="10%" align="center" class="inputHeader">&nbsp;市场价格</td>
			<td width="10%" align="center" class="inputHeader">&nbsp;会员价格</td>
		    <td width="10%" align="center" class="inputHeader">&nbsp;商品数量</td>
		    <td width="10%" align="center" class="inputHeader">&nbsp;商品总价 </td>
        </tr>
        
         <s:iterator value="#list" var="od">
        <tr>
           <td width="20%" align="center" class="inputHeader"><s:property value="#od.oid"/></td>
			<td width="10%" align="center" class="inputHeader">&nbsp;<s:property value="#od.pro.pid"/></td>
			<td width="30%" align="center" class="inputHeader">&nbsp;<s:property value="#od.pro.pname"/></td>
			<td width="10%" align="center" class="inputHeader">&nbsp;<s:property value="#od.pro.mprice"/></td>
			<td width="10%" align="center" class="inputHeader">&nbsp;<s:property value="#od.pro.vprice"/></td>
		    <td width="10%" align="center" class="inputHeader">&nbsp;<s:property value="#od.sum"/></td>
		    <td width="10%" align="center" class="inputHeader">&nbsp;<s:property value="#od.sum*#od.pro.vprice"/></td>
        </tr>
        </s:iterator>

    
        <tr>
          <td class="inputHeader">&nbsp;</td>
          <td class="inputHeader">&nbsp;</td>
          <td class="inputContent">&nbsp;</td>
          <td colspan="2" class="inputContent">&nbsp;</td>
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
<iframe src="${pageContext.request.contextPath}/Home/bottom.html" frameborder="0" marginheight="0" marginwidth="0" width="770" height="130" scrolling="no"></iframe>
<!-- #EndLibraryItem --></body>
</html>