<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.personalinfo.dao.FinanceDao,com.personalinfo.dto.Finance" %>

<%

String   U_id = (String)session.getAttribute("U_id");


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
  
    <form  action="/PersonalInfo/finance" method="post">
       <table width="100%" cellpadding="0" class="Table1" bordercolor="#438EB9" border="1" cellspacing="0">
        <tr>
          <td height="25" align="right">时间：
          <input  type="hidden" id="action" name="action" value="add" >
          <input type="hidden" id="Uid" name="Uid" value="<%=U_id %>" >
          </td>
          <td><input type="date" id="F_time" name="F_time" value="<%=nowdate %>" ></td>
        </tr>
        <tr>
          <td height="25" align="right">收入项目：</td>
          <td><input type="text" id="F_ievent" name="F_ievent"></td>
        </tr>
                        <tr>
          <td height="25" align="right">收入金额：</td>
          <td><input type="text" id="F_income" name="F_income" onkeyup="this.value=this.value.replace(/\D/g,'')"  ></td>
        </tr>
        <tr>
          <td height="25" align="right">支出项目：</td>
          <td><input type="text" id="F_pevent" name="F_pevent" ></td>
        </tr>

                        <tr>
          <td height="25" align="right">支出金额：</td>
          <td><input type="text" id="F_pay" name="F_pay" onkeyup="this.value=this.value.replace(/\D/g,'')"  ></td>
        </tr>
                        <tr>
          <td height="25" align="right">剩余金额：</td>
          <td><input type="text" id="F_remamoney" name="F_remamoney" onkeyup="this.value=this.value.replace(/\D/g,'')"  ></td>
        </tr>

                
        <tr>
          <td height="25" align="right">&nbsp;</td>
          <td><input type="submit" value="提交" name="Submit"></td>
        </tr>
      </table>
      </form>
    
  </body>
</html>
