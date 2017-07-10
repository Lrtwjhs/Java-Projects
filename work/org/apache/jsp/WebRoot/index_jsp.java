package org.apache.jsp.WebRoot;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.blog.dao.ArticleDao;
import com.blog.dto.Article;
import java.util.*;
import java.util.*;
import com.blog.dao.SortDao;
import com.blog.dto.Sort;
import com.blog.dao.LinkDao;
import com.blog.dto.Link;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WebRoot/dh.jsp");
    _jspx_dependants.add("/WebRoot/left.jsp");
    _jspx_dependants.add("/WebRoot/bottom.jsp");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
  String      list_con = "";
  ArticleDao  dao = new ArticleDao();
  
  List     lista =  dao.getList(0,10);           
  Iterator  ita = lista.iterator();
  while(ita.hasNext()){
     Article  l = (Article)ita.next();
     list_con +=  "<h2 class=\"title\"><a href='show_art.jsp?id="+l.getId()+"'>"+l.getTitle()+"</a></h2>"
			   +" <p class=\"byline\"><small>日期:"+l.getPubtime()+" </small></p>"
		       +" <div class=\"entry\"> "
			   +"<blockquote><p>&#8220;"+l.getContent()+" &#8221;</p></blockquote></div>";				
  }
  

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>红色玫瑰</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"\" />\r\n");
      out.write("<meta name=\"description\" content=\"\" />\r\n");
      out.write("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"wrapper\">\r\n");
      out.write("<!-- start header -->\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\t<h1>红色玫瑰 </h1>\r\n");
      out.write("\t<p>Red Roses </p>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- end header -->\r\n");
      out.write("\r\n");
      out.write("<!-- start nav -->\r\n");
      out.write(" <ul id=\"nav\">\r\n");
      out.write("\t<li><a href=\"index.jsp\" >首页</a></li>\r\n");
      out.write("    <li><a href=\"list_article.jsp\" >文章</a></li>\r\n");
      out.write("    <li><a href=\"link.jsp\" >友情链接</a></li>\r\n");
      out.write("\t<li><a href=\"aboutus.jsp\" >站长介绍</a></li>\r\n");
      out.write("\t<li><a href=\"admin/\" >后台登陆</a></li>\r\n");
      out.write(" </ul>\r\n");
      out.write(" <!-- end nav -->  ");
      out.write("\r\n");
      out.write("<!-- start page -->\r\n");
      out.write("<div id=\"page\">\r\n");
      out.write("\t<!-- start content -->\r\n");
      out.write("\t<div id=\"content\">\r\n");
      out.write("\t\t<div class=\"post\">\r\n");
      out.write("\t\t\t<h1 class=\"title\">关于本站</h1>\r\n");
      out.write("\t\t\t<p class=\"byline\"><small>Posted on August 25th, 2007 by <a href=\"#\">admin</a> | <a href=\"#\">Edit</a></small></p>\r\n");
      out.write("\t\t\t<div class=\"entry\">\r\n");
      out.write("\t\t\t\t<p> \r\n");
      out.write("\t\t\t\t   博客的标题的得来还是很想了一下，在想的过程中，看自己想的也太多，所以何不简单一点呢？就叫简单生活好了。诚然我们在生活中过的也太复杂，太辛苦，所以在网络上简单一点也好，尽管可能被人骂，被人看不起。如果有人觉得我的博客不好，但愿也只有指教而不是漫骂。\r\n");
      out.write("                </p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<p class=\"meta\"><a href=\"#\" class=\"more\">最新文章列表</a> </p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"post\">\r\n");
      out.write("\t\t\t");
      out.print(list_con  );
      out.write("\r\n");
      out.write("\t\t\t<p class=\"meta\"><a href=\"#\" class=\"more\">最新文章列表</a> </p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- end content -->\r\n");
      out.write("\t<!-- start sidebar -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"sidebar\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<h2>文章分类<br /></h2>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t");
      out.print(sort_con );
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<h2>友情链接</h2>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t");
      out.print(link_con );
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>");
      out.write("\r\n");
      out.write("\t<!-- end sidebar -->\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- end page -->\r\n");
      out.write("\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("\t<p>&copy;2007 All Rights Reserved &nbsp;&bull;&nbsp; Design by <a href=\"#\">Free CSS Templates</a> &nbsp;&bull;&nbsp; Icons by <a href=\"#\">FAMFAMFAM</a>.</p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
