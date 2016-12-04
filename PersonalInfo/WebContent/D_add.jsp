<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.personalinfo.dao.DiaryDao,com.personalinfo.dto.Diary" %>

<%

String   U_id = (String)session.getAttribute("U_id");

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
   bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
</script>
  </head>
  
<body>
  
    <form  action="/PersonalInfo/diary" method="post">
       <table width="100%" cellpadding="0" class="Table1" bordercolor="#438EB9" border="1" cellspacing="0">
        <tr>
          <td height="25" align="right">时间：
          <input  type="hidden" id="action" name="action" value="add" >
          <input type="hidden" id="Uid" name="Uid" value="<%=U_id %>" >
          </td>
          <td><input type="date" id="D_time" name="D_time" value="<%=nowdate %>" ></td>
        </tr>
        <tr>
          <td height="25" align="right">天气：</td>
          <td><input type="text" id="D_weather" name="D_weather"></td>
        </tr>
        <tr>
          <td height="25" align="right">星期：</td>
          <td><input type="text" id="D_week" name="D_week" ></td>
        </tr>
                <tr>
          <td height="25" align="right">日记：</td>
                  <td> 
             <textarea    style="width:520px;height:155px"  name="D_event" id='D_event'></textarea> </td>
        </tr>

                
        <tr>
          <td height="25" align="right">&nbsp;</td>
          <td><input type="submit" value="提交" name="Submit"></td>
        </tr>
      </table>
      </form>
    
  </body>
</html>
