<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.personalinfo.dao.FinanceDao,com.personalinfo.dto.Finance" %>
<%@ page language="java" import="com.personalinfo.dao.UserDao,com.personalinfo.dto.User" %>
<%

// 取得用户ID
String   U_id = (String)session.getAttribute("U_id");
UserDao  dao1 = new UserDao();
User u = dao1.getLink(U_id);
int Uid =  u.getId();

//读取数据库
String F_id = request.getParameter("F_id");
FinanceDao dao = new FinanceDao();
Finance l = dao.getFinance(F_id);
String F_time = l.getF_time();
String F_ievent = l.getF_ievent();
String F_pevent = l.getF_pevent();
String F_income = l.getF_income();
String F_pay = l.getF_pay();
String F_remamoney = l.getF_remamoney();



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
   bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
</script>
  </head>
  
<body>
  
    <form  action="/PersonalInfo/finance?action=update" method="post">
       <table width="100%" cellpadding="0" class="Table1" bordercolor="#438EB9" border="1" cellspacing="0">
        <tr>
          <td height="25" align="right">时间：
                   <input type="hidden" id="F_id" name="F_id" value="<%=F_id %>" >
                   <input type="hidden" id="Uid" name="Uid" value="<%=Uid %>" >
          </td>
          <td><input type="date" id="F_time" name="F_time" value="<%=F_time%>" ></td>
        </tr>
        <tr>
          <td height="25" align="right">收入项目：</td>
          <td><input type="text" id="F_ievent" name="F_ievent" value="<%=F_ievent%>"></td>
        </tr>
                        <tr>
          <td height="25" align="right">收入金额：</td>
          <td><input type="text" id="F_income" name="F_income" value="<%=F_income%>" ></td>
        </tr>
        
        <tr>
          <td height="25" align="right">支出项目：</td>
          <td><input type="text" id="F_pevent" name="F_pevent" value="<%=F_pevent%>" ></td>
        </tr>

                        <tr>
          <td height="25" align="right">支出金额：</td>
          <td><input type="text" id="F_pay" name="F_pay"  value="<%=F_pay%>"></td>
        </tr>
                        <tr>
          <td height="25" align="right">剩余金额：</td>
          <td><input type="text" id="F_remamoney" name="F_remamoney" value="<%=F_remamoney%>" ></td>
        </tr>

                
        <tr>
          <td height="25" align="right">&nbsp;</td>
          <td><input type="submit" value="修改" name="Submit"></td>
        </tr>
      </table>
      </form>
    
  </body>
</html>
