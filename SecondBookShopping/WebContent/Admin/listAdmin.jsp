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
     <div class="details_operation clearfix">
           <div class="bui_select">
                 <input type="button" value="添&nbsp;&nbsp;加" class="add"  onclick="addAdmin()">
            </div>
                            
       </div>
       <!--表格-->
       <table class="table" cellspacing="0" cellpadding="0">
              <thead>
                    <tr>
                        <th width="15%">编号</th>
                        <th width="25%">管理员名称</th>
                        <th width="30%">管理员密码</th>
                        <th>操作</th>
                     </tr>
               </thead>
                <tbody>
                       <s:iterator value="#list" var="a">
                            <tr>
                                <!--这里的id和for里面的c1 需要循环出来-->
                                <td><input type="checkbox" id="c1" class="check"><label for="c1" class="label"><s:property value="#a.id"/></label></td>
                                <td><s:property value="#a.adminname"/></td>
                                <td><s:property value="#a.adminpassword"/></td>
                                <td align="center">
                                <a href="admin_edit.action?id=<s:property value="#a.id"/>" >修改</a>
                                <a href="admin_delete.action?id=<s:property value="#a.id"/>" onClick="if(window.confirm('确定删除？'));else return false">删除</a>
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
                   <a href="${pageContext.request.contextPath}/admin_listByPage.action?index=<s:property value="1"/>">[首页]</a>&nbsp;&nbsp;
                   <a href="${pageContext.request.contextPath}/admin_listByPage.action?index=<s:property value="#index-1"/> ">[上一页]</a>&nbsp;&nbsp;
                   </s:if>
                   <s:if test="#index!=#totalpage">
                   <a href="${pageContext.request.contextPath}/admin_listByPage.action?index=<s:property value="#index+1"/> ">[下一页]</a>&nbsp;&nbsp;
                   <a href="${pageContext.request.contextPath}/admin_listByPage.action?index=<s:property value="#totalpage"/> ">[尾页]</a>&nbsp;&nbsp;
                   </s:if>
                   </td>                
                   </tr>              
                  </table>
			</div>
</body>
<script type="text/javascript">

	function addAdmin(){
		window.location="${pageContext.request.contextPath}/Admin/addAdmin.jsp";	
	}
	/* function editAdmin(id){
		window.location="{:U('Admin/editAdmin',array('id'=>id))}";
    }  */
	/*function delete(id){
			if(window.confirm("您确定要删除吗？删除之后不可以恢复哦！！！")){
				window.location="{:U('Admin/delAdmin',array('id'=>id))}";     
			}
	}*/
</script>
</html>