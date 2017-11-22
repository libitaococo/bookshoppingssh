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
                            
                        </div>
                        <div class="fr">
                            <div class="text">
                                <span>订单价格：</span>
                                <div class="bui_select">
                                    <select id="" class="select" onchange="change(this.value)">
                                    	<option>-请选择-</option>
                                        <option value="vprice asc" >由低到高</option>
                                        <option value="vprice desc">由高到底</option>
                                    </select>
                                </div>
                            </div>
                            <div class="text">
                                <span>创建时间：</span>
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
                                
                                <th width="20%">订单号</th>
                                <th width="10%">订单价格</th>
                                <th width="10%">商品数量</th>
                                <th width="20%">客户名</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="#list" var="o">
                            <tr>
                                <!--这里的id和for里面的c1 需要循环出来-->
                               
                                <td><s:property value="#o.oid"/></td>
                                <td><s:property value="#o.oprice"/></td>
                                <td><s:property value="#o.onum"/></td>  
                                 <td><s:property value="#o.user.user"/></td>
                                <td align="center">
                               <a href="orderdata_listByPage.action?oid=<s:property value="#o.oid"/>&index=<s:property value="1"/>" >详情</a>
                                <a href="order_delete1.action?oid=<s:property value="#o.oid"/>"  onClick="if(window.confirm('确定删除？'));else return false">删除</a>
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
                   <a href="${pageContext.request.contextPath}/order_listByPage.action?index=<s:property value="1"/>">[首页]</a>&nbsp;&nbsp;
                   <a href="${pageContext.request.contextPath}/order_listByPage.action?index=<s:property value="#index-1"/> ">[上一页]</a>&nbsp;&nbsp;
                   </s:if>
                   <s:if test="#index!=#totalpage">
                   <a href="${pageContext.request.contextPath}/order_listByPage.action?index=<s:property value="#index+1"/> ">[下一页]</a>&nbsp;&nbsp;
                   <a href="${pageContext.request.contextPath}/order_listByPage.action?index=<s:property value="#totalpage"/> ">[尾页]</a>&nbsp;&nbsp;
                   </s:if>
                   </td>                
                   </tr>              
                  </table>
			</div>

</body>
</html>