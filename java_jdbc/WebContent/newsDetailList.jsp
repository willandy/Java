<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.News"%>
<%@page import="java.util.List"%>
<%@page import="Dao.NewsDao"%>
<%@page import="Dao.NewsDaoImpl"%>
<%@page import="service.NewsServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 静态包含 -->
    <%@include file="css/common.jsp" %>
    <!-- jsp动作标签 -->
<%-- <jsp:useBean id="newsServiceImpl" class="service.NewsServiceImpl" scope="page"></jsp:useBean> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
     function addNews(){
    	 window.location="jsp/newsDetailCreateSimple.jsp";
     }
</script>
</head>
<body>
   <div class="main-content-right">
        <!--即时新闻-->
        <div class="main-text-box">
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <form name ="searchForm" id="searchForm" action="/news/jsp/admin/newsDetailList.jsp" method="post">
		 	          <div>
		 				新闻分类：
		 					<select name="categoryId">
		 						<option value="0">全部</option>
			        			
			        				<option value='1' >国内</option>
			        			
			        				<option value='2' >国际</option>
			        			
			        				<option value='3' >娱乐</option>
			        			
			        				<option value='4' >军事</option>
			        			
			        				<option value='5' >财经</option>
			        			
			        				<option value='6' >天气</option>
			        			
	        				</select>
		 				新闻标题<input type="text" name="title" id="title" value=''/>
		 					<button type="submit" class="page-btn">GO</button>
		 					<button type="button" onclick="addNews();" class="page-btn">增加</button>
		 					<input type="hidden" name="currentPageNo" value="1"/>
		 					<input type="hidden" name="pageSize" value="10"/>
		 					<input type="hidden" name="totalPageCount" value="2"/>
		 	</div>
		 	</form>
			<table cellpadding="1" cellspacing="1" class="admin-list">
				<thead >
					<tr class="admin-list-head">
						<th>新闻标题</th>
                        <th>作者</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                
                	<tr >
                		<td><a href='adminNewsView.jsp?id=2'>谈北京精神</a></td>
                		<td>admin</td>
                		<td>2012-6-12</td>
                		<td><a href='adminNewsCreate.jsp?id=2'>修改</a>
                			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=2'">删除</a>
                		</td>
                	</tr> 
                
                
                     <%
                      /*  NewsServiceImpl newsServiceImpl = new NewsServiceImpl();  */
                       List<News> newsList=newsServiceImpl.getNewsList();
                       int i=0;
                       for(News news:newsList){
                    	   i++;
                     %>
                
                	<tr <%if(i%2==0) {%>class="admin-list-td-h2"<%} %>>
                		<td><a href='adminNewsView.jsp?id=3'><%=news.getTitle()%></a></td>
                		<td><%=news.getAuthor() %></td>
                		<td><%=new SimpleDateFormat("yyyy-MM-dd").format(news.getCreateDate()) %></td>
                		<td><a href='adminNewsCreate.jsp?id=3'>修改</a>
                			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=3'">删除</a>
                		</td>
                	</tr> 
                      <%}
                       %>
                
                
                
                
                	<tr >
                		<td><a href='adminNewsView.jsp?id=4'>85岁老人扭秧歌</a></td>
                		<td>admin</td>
                		<td>2012-6-12</td>
                		<td><a href='adminNewsCreate.jsp?id=4'>修改</a>
                			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=4'">删除</a>
                		</td>
                	</tr> 
                
                	<tr class="admin-list-td-h2">
                		<td><a href='adminNewsView.jsp?id=5'>云计算现状</a></td>
                		<td>admin</td>
                		<td>2012-6-12</td>
                		<td><a href='adminNewsCreate.jsp?id=5'>修改</a>
                			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=5'">删除</a>
                		</td>
                	</tr> 
                
                </tbody>
            </table>
           <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共7条记录&nbsp;&nbsp; 1/2页</li>
				<a href="javascript:page_nav(document.forms[0],2);">下一页</a>
				<a href="javascript:page_nav(document.forms[0],2);">最后一页</a>&nbsp;&nbsp;
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
		</div> 
        </div>
       </div>
   </div>
   </div>

</body>
</html>