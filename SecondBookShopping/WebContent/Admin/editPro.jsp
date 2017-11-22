<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>-.-</title>
<link href="styles/global.css"  rel="stylesheet"  type="${pageContext.request.contextPath}/Admin/text/css" media="all" />
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/Admin/plugins/kindeditor/kindeditor.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/Admin/plugins/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/scripts/jquery-1.6.4.js"></script>
<script>
KindEditor.ready(function(K) {
    window.editor = K.create('#editor_id');
});
$(document).ready(function(){
$("#selectFileBtn").click(function(){
	$fileField = $('<input type="file" name="thumbs[]"/>');
	$fileField.hide();
	$("#attachList").append($fileField);
	$fileField.trigger("click");
	$fileField.change(function(){
	$path = $(this).val();
	$filename = $path.substring($path.lastIndexOf("\\")+1);
	$attachItem = $('<div class="attachItem"><div class="left">a.gif</div><div class="right"><a href="#" title="删除附件">删除</a></div></div>');
	$attachItem.find(".left").html($filename);
	$("#attachList").append($attachItem);		
	});
});
$("#attachList>.attachItem").find('a').live('click',function(obj,i){
	$(this).parents('.attachItem').prev('input').remove();
	$(this).parents('.attachItem').remove();
});
});
        
</script>

</head>
<body>
<h3>编辑商品</h3>
<form action="pro_save"  method="post" enctype="multipart/form-data">
<table width="70%"  border="1" cellpadding="5" cellspacing="0" bgcolor="#cccccc">
	  <!-- 隐藏域 -->
      <input name="pid" type="hidden"  value="<s:property value="#p.pid"/>"/>
	<tr>
		<td align="right">商品名称</td>
		<td><input type="text" name="pname"  value="<s:property value="#p.pname"/>"/></td>
	</tr>
	<tr>
		<td align="right">商品分类</td>
		<td>
		<select name="cid" id="cid">
			<s:iterator value="#list" var="c">
			<s:if test="#p.cate.cid==#c.cid">
			<option value="<s:property value="#c.cid"/>" selected="selected" ><s:property value="#c.cname"/></option>
			</s:if>
			<s:else>
				<option value="<s:property value="#c.cid"/>"><s:property value="#c.cname"/></option>
			</s:else>
			</s:iterator>
		</select>
		</td>
	</tr>
	<tr>
		<td align="right">商品货号</td>
		<td><input type="text" name="psn"  value="<s:property value="#p.psn"/>"/></td>
	</tr>
	<tr>
		<td align=" right">商品数量</td>
		<td><input type="text" name="pnum"  value="<s:property value="#p.pnum"/>"/></td>
	</tr>
	<tr>
		<td align="right">商品市场价</td>
		<td><input type="text" name="mprice"  value="<s:property value="#p.mprice"/>"/></td>
	</tr>
	<tr>
		<td align="right">商品会员价</td>
		<td><input type="text" name="vprice"  value="<s:property value="#p.vprice"/>"/></td>
	</tr>
	<tr>
		<td align="right">商品描述</td>
		<td>
			<textarea name="pdesc" id="editor_id" style="width:100%;height:150px;"><s:property value="#p.pdesc"/></textarea>
		</td>
	</tr>
	<tr>
		<td align="right">商品图像</td>
		<td>
			<input type="file"  name="upload"  id="ipload" />
			<div id="attachList" class="clear"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit"  value="编辑商品"/></td>
	</tr>
</table>
</form>
</body>
</html>