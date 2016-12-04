<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.personalinfo.dao.DiaryDao,com.personalinfo.dto.Diary" %>

<% 
  String   list_con = "",part_msg = "",spage = "";


  spage =request.getParameter("pg"); //获取传递来的参数
  String  total = "";
  String  current = "";
  String  totalpage = "";
  
  int      up=1,down=1;  
  int      pgSize = 10; //每页显示的条数
  int      cpage = 0;    //当前显示的条数
  
  if(spage!=null){
      cpage = Integer.parseInt(spage);				
   }
  DiaryDao  dao = new DiaryDao();
  
  List     list =  dao.getList(cpage,pgSize);           
  Iterator  it = list.iterator();
  while(it.hasNext()){
	  Diary  l = (Diary)it.next();
     list_con += "<tr align='center'  height='25'><td>"+l.getD_id()+"</td><td>"+l.getD_time()+"</td><td>"+l.getD_weather()+"</td><td>"
             +l.getD_week()+"</td><td>"+l.getD_event()+"</td><td>"+l.getUid()+"</td><td><a href='D_update.jsp?D_id="+l.getD_id()+"'>修改</a> | <a href='/PersonalInfo/diary?action=delete&D_id="+l.getD_id()+"' >删除</a> </td></tr> \n";
   // System.out.println(list_con);
  }
  total = new Integer(dao.getTotal()).toString();
  current = new Integer(dao.getCPages()).toString();
  totalpage = new Integer(dao.getTPages()).toString();
  
  //分页运算
  up = dao.getCPages()-1;
  down = dao.getCPages()+1;  
  
  if(up<1){
     up = 1;
  }
  
  if(down>=dao.getTPages()){
     down = dao.getTPages();
  }    

  part_msg = "共"+total+"条数据，分"+totalpage+"页，当前为第"+current+"页 <a href='D_list.jsp?pg="+up+"'> 上一页</a> <a href='D_list.jsp?pg="+down+"'>下一页 </a>";
  
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>内容页面</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
  </head>
  
<body>
  
     <table width="100%" cellpadding="0" class="Table1" bordercolor="#438EB9" border="1" cellspacing="0">
      <tr align='center'  height='30'>
      <th>ID</th>
      <th>时间</th>
      <th>天气</th>
      <th>星期</th>
      <th>内容</th>
      <th>用户ID</th>
       <th>管理操作</th></tr>
       <%=list_con %>
      </table>
      <br/>
      <%=part_msg %>
      
      
  </body>
</html>
