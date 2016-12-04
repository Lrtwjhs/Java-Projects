<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java"
	import="com.personalinfo.dao.MemorandumDao,com.personalinfo.dto.Memorandum"%>

<%
	String list_con = "", part_msg = "", spage = "";

	spage = request.getParameter("pg"); //获取传递来的参数
	String total = "";
	String current = "";
	String totalpage = "";

	int up = 1, down = 1;
	int pgSize = 10; //每页显示的条数
	int cpage = 0; //当前显示的条数

	if (spage != null) {
		cpage = Integer.parseInt(spage);
	}
	MemorandumDao dao = new MemorandumDao();

	List list = dao.getList(cpage, pgSize);
	Iterator it = list.iterator();
	while (it.hasNext()) {
		Memorandum l = (Memorandum) it.next();
		list_con += "<tr align='center'  height='25'><td>" + l.getM_id() + "</td><td>" + l.getM_theme()
				+ "</td><td>" + l.getM_time() + "</td><td>" + l.getM_place() + "</td><td>" + l.getM_event()
				+ "</td><td>" + l.getM_status() + "</td><td>" + l.getUid()
				+ "</td><td><a href='M_update.jsp?M_id=" + l.getM_id()
				+ "'>修改</a> | <a href='/PersonalInfo/memorandum?action=delete&M_id=" + l.getM_id()
				+ "' >删除</a> </td></tr> \n";
		// System.out.println(list_con);
	}
	total = new Integer(dao.getTotal()).toString();
	current = new Integer(dao.getCPages()).toString();
	totalpage = new Integer(dao.getTPages()).toString();

	//分页运算
	up = dao.getCPages() - 1;
	down = dao.getCPages() + 1;

	if (up < 1) {
		up = 1;
	}

	if (down >= dao.getTPages()) {
		down = dao.getTPages();
	}

	part_msg = "共" + total + "条数据，分" + totalpage + "页，当前为第" + current + "页 <a href='C_list.jsp?pg=" + up
			+ "'> 上一页</a> <a href='C_list.jsp?pg=" + down + "'>下一页 </a>";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>内容页面</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<table width="100%" cellpadding="0" class="Table1"
		bordercolor="#438EB9" border="1" cellspacing="0">
		<tr align='center' height='30'>
			<th>ID</th>
			<th>主题</th>
			<th>活动时间</th>
			<th>地点</th>
			<th>事件</th>
			<th>状态</th>
			<th>用户ID</th>
			<th>管理操作</th>
		</tr>
		<%=list_con%>
	</table>
	<br />
	<%=part_msg%>


</body>
</html>
