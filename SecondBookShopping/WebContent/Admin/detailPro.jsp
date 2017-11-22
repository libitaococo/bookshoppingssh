<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>-.-</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/styles/backstage.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/scripts/jquery-ui/css/ui-lightness/jquery-ui-1.10.4.custom.css" />
<script src="${pageContext.request.contextPath}/Admin/scripts/jquery-ui/js/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/Admin/scripts/jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
<script src="${pageContext.request.contextPath}/Admin/scripts/jquery-ui/js/jquery-ui-1.10.4.custom.min.js"></script>
</head>

<body>
<div id="showDetail"  style="display:none;">

</div>
<div class="details">
       <div class="details_operation clearfix">
           <div class="bui_select">
               <input type="button" value="返&nbsp;&nbsp;回" class="add" onclick="rePro()">
       </div>
        <div id="showDetail">
         <!--表格-->
                           
      	<table class="table" cellspacing="0" cellpadding="0">
      		<tr>
      			<td width="20%" align="right">商品名称</td>
      			<td><s:property value="#p.pname"/></td>
      		</tr>
      		<tr>
      			<td width="20%"  align="right">商品类别</td>
      			<td><s:property value="#p.cate.cname"/></td>	
      		</tr>
      		<tr>
      			<td width="20%"  align="right">商品货号</td>
      			<td><s:property value="#p.psn"/></td>
      		</tr>
      		<tr>
      			<td width="20%"  align="right">商品数量</td>
      			<td><s:property value="#p.pnum"/></td>
      		</tr>
      		<tr>
      			<td  width="20%"  align="right">商品价格</td>
      			<td><s:property value="#p.mprice"/></td>
      		</tr>
      		<tr>
      			<td  width="20%"  align="right">会员价格</td>
      			<td><s:property value="#p.vprice"/></td>
      		</tr>
      		<tr>
      			<td width="20%"  align="right">商品图片</td>
      			<td>
      			<img width="200" height="250" src="<s:property value="#p.image"/>" /> 
      			</td>
      		</tr>
      		<tr>
      		<td  width="20%"   height=" 150" align="right">商品描述</td>
      		<td><s:property value="#p.pdesc"/></td>
      		</tr>
      	</table>
            	</div>
            </div>
         </div>
		<script type="text/javascript">
			function rePro(){
				window.location='pro_listByPage.action?index=<s:property value="1"/>';
			}
		
		</script>
		</body>
		</html>