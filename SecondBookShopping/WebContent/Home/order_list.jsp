<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>二手书商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/Home/style/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/Home/js/jquery.min.js"></script>
<script language="javascript">
function clear(){

document.form1.webUserEntity.name="";
document.form1.webUserEntity.address="";
document.form1.webUserEntity.postcode="";
document.form1.webUserEntity.phone="";
}
</script>

</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<iframe src="${pageContext.request.contextPath}/Home/top.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="130" scrolling="no"></iframe>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh" align="center">
  <tr>
    <td height="17"><a href="index_list.action">主页</a> &raquo;历史交易查询</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main" align="center">
<tr valign="top">
<td><form action="" method="post" enctype="multipart/form-data" name="form1">
  <table width="100%" border="0" cellpadding="2" cellspacing="1" class="inputTable" align="center">
    <tr>
      <td class="inputTitle">查询结果</td>
    </tr>
    <tr>
      <td class="inputHeader">
	   <table width="100%" border="0" cellpadding="0" cellspacing="1" class="inputbox">
          <tr>
            <td width="25%" align="center" class="inputHeader">订单号</td>
            <td width="20%" align="center" class="inputHeader">&nbsp;客户名</td>
			<td width="10%" align="center" class="inputHeader">&nbsp;商品总价</td>
			<td width="10%" align="center" class="inputHeader">&nbsp;商品数量</td>
			<td width="20%" align="center" class="inputHeader">&nbsp;订单状态</td>
            <td width="15%" align="center" class="inputContent">详情</td>
            <td width="15%" align="center" class="inputContent">删除</td>
          </tr>
          
		  <s:iterator value="#list" var="o">
          <tr>
         
             <td width="25%" align="center" class="inputHeader"><s:property value="#o.oid"/></td>
            <td width="20%" align="center" class="inputHeader"><s:property value="#o.user.user"/></td>
			<td width="10%" align="center" class="inputHeader"><s:property value="#o.oprice"/></td>
			<td width="10%" align="center" class="inputHeader"><s:property value="#o.onum"/></td>
			<td width="20%" align="center" class="inputHeader">已支付</td>
            <td width="15%" align="center" class="inputContent"><font color="#CC0000"><a href="orderdata_list.action?oid=<s:property value="#o.oid"/>"><img src="${pageContext.request.contextPath}/Home/graphics/xq.gif" alt="详情" width="37" height="22" border="0"></a></font> </td>
             <td width="15%" align="center" class="inputContent"><font color="#CC0000"><a href="order_delete.action?oid=<s:property value="#o.oid"/>" onClick="if(window.confirm('确定删除？'));else return false"><img src="${pageContext.request.contextPath}/Home/graphics/delete_item.gif" alt="删除" width="37" height="22" border="0"></a></font> </td>
          </tr>
          	<tr class="details-sub" name=""  id="detail-{$s['oname']}" style="display:none;">
						<td colspan="11" >
						
						</td>
			</tr>
     </s:iterator>
	
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
<!-- #EndLibraryItem -->
</body>
</html>
