<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.dao.SortDao,com.blog.dto.Sort" %>
<%@ page language="java" import="com.blog.dao.LinkDao,com.blog.dto.Link" %>

<%
     String   sort_con = "",link_con = "";
     
     SortDao  ds = new SortDao();
     LinkDao  dl = new LinkDao();
     //文章分类
     List     list =  ds.getIndexList();           
     Iterator  it = list.iterator();
     while(it.hasNext()){
      Sort  l = (Sort)it.next();
      sort_con +="<li><a href='main.jsp?cid="+l.getId()+"'>"+l.getName()+"</a> ("+l.getCount()+")</li>" ;
     }
     //友情链接
     List     list2 =  dl.getList();         
     Iterator  it2 = list2.iterator();
     while(it2.hasNext()){
      Link  l = (Link)it2.next();
      link_con +="<li><a href='"+l.getUrl()+"' target=\"_blank\">"+l.getName()+"</a></li>" ;
    }
%>

<div id="sidebar">
		<ul>
			<li>
				<h2>文章分类<br /></h2>
				<ul>
					<%=sort_con %>
				</ul>
			</li>
			<li>
				<h2>友情链接</h2>
				<ul>
					<%=link_con %>
				</ul>
			</li>
		</ul>
	</div>