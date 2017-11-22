<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>-.-</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/styles/backstage.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/styles/page.css">
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
                            <input type="button" value="添&nbsp;&nbsp;加" class="add" onclick="addPro()">
                        </div>
                        <div class="fr">
                            <div class="text">
                                <span>商品价格：</span>
                                <div class="bui_select">
                                    <select id="" class="select" onchange="change(this.value)">
                                    	<option>-请选择-</option>
                                        <option value="vprice asc" >由低到高</option>
                                        <option value="vprice desc">由高到底</option>
                                    </select>
                                </div>
                            </div>
                            <div class="text">
                                <span>上架时间：</span>
                                <div class="bui_select">
                                 <select id="" class="select" onchange="change(this.value)">
                                 	<option>-请选择-</option>
                                        <option value="pubtime desc" >最新发布</option>
                                        <option value="pubtime asc">历史发布</option>
                                    </select>
                                </div>
                            </div>
                            <div class="text">
                                <span>搜索</span>
                                <input type="text" value="" class="search"  id="search" onkeypress="search()" >
                            </div>
                        </div>
                    </div>
                    <!--表格-->
                    <table class="table" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th width="10%">编号</th>
                                <th width="20%">商品名称</th>
                                <th width="10%">商品分类</th>
                                <th width="20%">商品货号</th>
                                <th width="15%">上架时间</th>
                                <th width="10%">商品价格</th>
                                <th width="10%">会员价格</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="#list" var="p">
                            <tr>
                                <!--这里的id和for里面的c1 需要循环出来-->
                                <td><input type="checkbox" id="c1" class="check" ><label for="c1" class="label"><s:property value="#p.pid"/></label></td>
                                <td><s:property value="#p.pname"/></td>
                                <td><s:property value="#p.cate.cname"/></td>
                                <td><s:property value="#p.psn"/></td>  
                                 <td><s:property value="#p.pubtime"/></td>
                                 <td><s:property value="#p.mprice"/>元</td>
                                 <td><s:property value="#p.vprice"/>元</td>
                                <td align="center">
                               <a href="pro_detail.action?pid=<s:property value="#p.pid"/>" >详情</a>
                                <a href="pro_edit.action?pid=<s:property value="#p.pid"/>" >修改</a>
                                <a href="pro_delete.action?pid=<s:property value="#p.pid"/>"  onClick="if(window.confirm('确定删除？'));else return false">删除</a>
                                </td>
                            </tr>
                           </s:iterator>
                        </tbody>
                    </table>
                </div>
               
                   <div class="yahoo2">
                  <table>
                   <tr>
                   <td>
                   <span>第<s:property value="#index"/>/<s:property value="#totalpage"/>页</span>&nbsp;&nbsp;
                   <span>总记录数：<s:property value="#lists.total"/>&nbsp;&nbsp;每页显示：<s:property value="#lists.size"/></span>
                   <s:if test="#index!=1">
                   <a href="${pageContext.request.contextPath}/pro_listByPage.action?index=<s:property value="1"/>">[首页]</a>&nbsp;&nbsp;
                   <a href="${pageContext.request.contextPath}/pro_listByPage.action?index=<s:property value="#index-1"/> ">[上一页]</a>&nbsp;&nbsp;
                   </s:if>
                   <s:if test="#index!=#totalpage">
                   <a href="${pageContext.request.contextPath}/pro_listByPage.action?index=<s:property value="#index+1"/> ">[下一页]</a>&nbsp;&nbsp;
                   <a href="${pageContext.request.contextPath}/pro_listByPage.action?index=<s:property value="#totalpage"/> ">[尾页]</a>&nbsp;&nbsp;
                   </s:if>
                   </td>                
                   </tr>              
                  </table>
                  
			</div>
			
<script type="text/javascript">
	function addPro(){
		window.location='pro_listCate.action';
	}
</script>
</body>
</html>