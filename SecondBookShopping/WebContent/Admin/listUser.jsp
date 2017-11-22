<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>-.-</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/styles/backstage.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/styles/page.css">
</head>

<body>
<div class="details">

                    <!--表格-->
                    <table class="table" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th width="15%">编号</th>
                                <th width="20%">用户名称</th>
                                <th width="20%">用户邮箱</th>
                                <th width="20%">用户密码</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                       <s:iterator value="#list" var="u">
                            <tr>
                                <!--这里的id和for里面的c1 需要循环出来-->
                                <td><input type="checkbox" id="c1" class="check"><label for="c1" class="label"><s:property value="#u.uid"/></label></td>
                                <td><s:property value="#u.user"/></td>
                                <td><s:property value="#u.email"/></td>
                                <td><s:property value="#u.password"/></td>
                                <td align="center"> 
                                <a href="user_edit.action?uid=<s:property value="#u.uid"/>" >修改</a>
                                <a href="user_delete.action?uid=<s:property value="#u.uid"/>" onClick="if(window.confirm('确定删除？'));else return false">删除</a></td>
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
                   <a href="${pageContext.request.contextPath}/user_listByPage.action?index=<s:property value="1"/>">[首页]</a>&nbsp;&nbsp;
                   <a href="${pageContext.request.contextPath}/user_listByPage.action?index=<s:property value="#index-1"/> ">[上一页]</a>&nbsp;&nbsp;
                   </s:if>
                   <s:if test="#index!=#totalpage">
                   <a href="${pageContext.request.contextPath}/user_listByPage.action?index=<s:property value="#index+1"/> ">[下一页]</a>&nbsp;&nbsp;
                   <a href="${pageContext.request.contextPath}/user_listByPage.action?index=<s:property value="#totalpage"/> ">[尾页]</a>&nbsp;&nbsp;
                   </s:if>
                   </td>                
                   </tr>              
                  </table>
			</div>
</body>
</html>