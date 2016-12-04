<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java"
	import="com.personalinfo.dao.DiaryDao,com.personalinfo.dto.Diary"%>
<%@ page language="java"
	import="com.personalinfo.dao.UserDao,com.personalinfo.dto.User"%>
<%
	//取得用户ID
	String U_id = (String) session.getAttribute("U_id");
	UserDao dao1 = new UserDao();
	User u = dao1.getLink(U_id);
	int Uid = u.getId();

	//读取数据库
	String D_id = request.getParameter("D_id");
	DiaryDao dao = new DiaryDao();
	Diary l = dao.getDiary(D_id);
	String D_time = l.getD_time();
	String D_weather = l.getD_weather();
	String D_week = l.getD_week();
	String D_event = l.getD_event();

	java.util.Calendar Datenow = Calendar.getInstance();
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
	String nowdate = formatter.format(Datenow.getTime());
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>内容页面</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/nicEdit.js"></script>

<script type="text/javascript">
	bkLib.onDomLoaded(function() {
		nicEditors.allTextAreas()
	});
</script>
</head>

<body>

	<form action="/PersonalInfo/diary?action=update" method="post">
		<table width="100%" cellpadding="0" class="Table1"
			bordercolor="#438EB9" border="1" cellspacing="0">
			<tr>
				<td height="25" align="right">时间： <input type="hidden"
					id="D_id" name="D_id" value="<%=D_id%>"> <input
					type="hidden" id="Uid" name="Uid" value="<%=Uid%>">
				</td>
				<td><input type="date" id="D_time" name="D_time"
					value="<%=D_time%>"></td>
			</tr>
			<tr>
				<td height="25" align="right">天气：</td>
				<td><input type="text" id="D_weather" name="D_weather"
					value="<%=D_weather%>"></td>
			</tr>
			<tr>
				<td height="25" align="right">星期：</td>
				<td><input type="text" id="D_week" name="D_week"
					value="<%=D_week%>"></td>
			</tr>
			<tr>
				<td height="25" align="right">日记：</td>
				<td><textarea style="width: 520px; height: 155px"
						name="D_event" id="D_event"><%=D_event%></textarea></td>
			</tr>


			<tr>
				<td height="25" align="right">&nbsp;</td>
				<td><input type="submit" value="修改" name="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>
