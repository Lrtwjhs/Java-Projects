<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java"
	import="com.personalinfo.dao.MemorandumDao,com.personalinfo.dto.Memorandum"%>
<%@ page language="java"
	import="com.personalinfo.dao.UserDao,com.personalinfo.dto.User"%>
<%
	//取得用户ID
	String U_id = (String) session.getAttribute("U_id");
	UserDao dao1 = new UserDao();
	User u = dao1.getLink(U_id);
	int Uid = u.getId();

	//读取数据库
	String M_id = request.getParameter("M_id");
	MemorandumDao dao = new MemorandumDao();
	Memorandum l = dao.getMemorandum(M_id);
	String M_theme = l.getM_theme();
	String M_time = l.getM_time();
	String M_place = l.getM_place();
	String M_event = l.getM_event();
	String M_status = l.getM_status();

	java.util.Calendar Datenow = Calendar.getInstance();
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String nowdate = formatter.format(Datenow.getTime());
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>内容页面</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	bkLib.onDomLoaded(function() {
		nicEditors.allTextAreas()
	});
</script>

</head>

<body>

	<form action="/PersonalInfo/memorandum?action=update" method="post">
		<table width="100%" cellpadding="0" class="Table1"
			bordercolor="#438EB9" border="1" cellspacing="0">
			<tr>

				<td height="25" align="right">主题： <input type="hidden"
					id="M_id" name="M_id" value="<%=M_id%>"> <input
					type="hidden" id="Uid" name="Uid" value="<%=Uid%>">

				</td>
				<td><input type="text" id="M_theme" name="M_theme"
					value="<%=M_theme%>"></td>
			</tr>
			<tr>
				<td height="25" align="right">活动时间：</td>
				<td><input type="date" id="M_time" name="M_time"
					value="<%=M_time%>"></td>
			</tr>
			<tr>
				<td height="25" align="right">地点：</td>
				<td><input type="text" id="M_place" name="M_place"
					value="<%=M_place%>"></td>
			</tr>

			<tr>
				<td height="25" align="right">事件：</td>
				<td><input type="text" id="M_event" name="M_event"
					value="<%=M_event%>"></td>
			</tr>
			<tr>
				<td height="25" align="right">状态：</td>
				<td><input type="text" id="M_status" name="M_status"
					value="<%=M_status%>"></td>
			</tr>


			<tr>
				<td height="25" align="right">&nbsp;</td>
				<td><input type="submit" value="修改" name="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>
