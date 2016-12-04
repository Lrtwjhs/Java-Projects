<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.personalinfo.dao.ContactDao,com.personalinfo.dto.Contact" %>
<%@ page language="java" import="com.personalinfo.dao.UserDao,com.personalinfo.dto.User" %>
<%

//取得用户ID
String   U_id = (String)session.getAttribute("U_id");
UserDao  dao1 = new UserDao();
User u = dao1.getLink(U_id);
int Uid =  u.getId();


//读取数据库
	String C_id = request.getParameter("C_id");
    ContactDao  dao = new ContactDao();
    Contact l = dao.getContacts(C_id);  
	String   C_name = l.getC_name();
	String   C_tel = l.getC_tel();
	String C_email = l.getC_email();
	String C_job = l.getC_job();
	String C_city = l.getC_city();
	String C_remark = l.getC_remark();

    

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>内容页面</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<form action="/PersonalInfo/contact?action=update" method="post">
		<table width="100%" cellpadding="0" class="Table1"
			bordercolor="#438EB9" border="1" cellspacing="0">
			<tr>
				<td height="25" align="right">姓名：   				     
				 <input type="hidden" id="C_id" name="C_id" value="<%=C_id %>" >
				 <input type="hidden" id="Uid" name="Uid" value="<%=Uid %>" >
				 
					</td>
				<td><input type="text" id="C_name" name="C_name"
					value="<%=C_name%>"></td>
			</tr>
			<tr>
				<td height="25" align="right">电话：</td>
				<td><input type="text" id="C_tel" name="C_tel" value="<%=C_tel%>"
					onkeyup="this.value=this.value.replace(/\D/g,'')"></td>
			</tr>
			<tr>
				<td height="25" align="right">Email：</td>
				<td><input type="text" id="C_email" name="C_email" value="<%=C_email%>"></td>
			</tr>
			<tr>
				<td height="25" align="right">职业：</td>
				<td><input type="text" id="C_job" name="C_job" value="<%=C_job%>"></td>
			</tr>
			<tr>
				<td height="25" align="right">所在城市：</td>
				<td><input type="text" id="C_city" name="C_city" value="<%=C_city%>"></td>
			</tr>
			<tr>
				<td height="25" align="right">备注：</td>
				<td><input type="text" id="C_remark" name="C_remark" value="<%=C_remark%>"></td>
			</tr>

			<tr>
				<td height="25" align="right">&nbsp;</td>
				<td><input type="submit" value="修改" name="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>
