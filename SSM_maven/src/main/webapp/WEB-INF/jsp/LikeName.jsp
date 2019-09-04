<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
      table{
        width:460px;
        border:3px solid #ccc;
        border-collapse: collapse;/*表格内部单元格合并*/
        margin: auto; /*表格居中*/
        margin-top: 20px;
     }
     
     table th,table td{
          border:1px solid #ccc;
       } 
       
       span{
          width:20px;
          height:20px;
          display: inline-block;
          border:1px solid #ff6633;
          margin-left:5px;
       }
       
       span a{
           width:20px;
           height:20px;
           display: inline-block;
           text-decoration: none;
           font-size: 12px;
           text-align: center;
           line-height: 20px;
       }
       
       .on{
           background: #ccc;
           font-size: 14px;
           font-weight: 900;
       }
     
</style>
</head>
<body>
     <h2 align="center">员工列表</h2>
      <h3 align="center">
            <a href="#">添加员工</a>
     </h3>
     <div align="center">
         <form name="searchForm"  action="${pageContext.request.contextPath}/emp/Likename" method="POST">
                 <input name="pageNo" type="hidden" value="1"/>
                  <input name="ename"  value="${ename}"/>
                  <input type="submit" value="搜索"/>
        </form>
     </div>
      <table>
             <tr>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>薪资</th>
                    <th>部门名称</th>
                    <th>部门编号</th>
                    <th>办公地点</th>
                    <th>经理名称</th>
                    <th>经理编号</th>
                    <th>操作</th>        
              </tr>
              <c:forEach items="${pageBean.list }" var="e">
                     <tr>
                            <td>${e.ename}</td>
                            <td>${e.esex}</td>
                            <td>${e.eage}</td>
                            <td>${e.esalary}</td>
                            <td>${e.dept.dname }</td>
                            <td>${e.dept.deptno }</td>
                            <td>${e.dept.location }</td>
                            <td>${e.mgr.ename }</td>
                             <td>${e.mgr.empno }</td>
                             <th>
                                <a href="javascript:del('${e.empno}');">删除</a>
                                <a href="${pageContext.request.contextPath}/emp/toupdata?empno=${e.empno}">修改</a>
                           </th>
                     </tr>
              </c:forEach>
      </table>
   <p align="center">
                  <c:forEach begin="1" end="${pageBean.last }" var="no">
                         <c:choose>
                              <c:when test="${pageBean.pageNo==no}">
                                  <span class="on">
                                      <a href="javascript:changePage(${no});">${no}</a>
                                  </span>
                              </c:when>
                              <c:when test="${pageBean.pageNo!=no}">
                                     <a href="javascript:changePage(${no});">${no}</a>
                              </c:when>
                         </c:choose>
                  </c:forEach>
              </p>
              

<script type="text/javascript">
  function changePage(no){

	 //修改发送的页码
	 document.searchForm.pageNo.value=no;
	 //发送请求
	 document.searchForm.submit();
        }
</script>

</body>
</html>