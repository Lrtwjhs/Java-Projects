# JSPBLOG
A simple blog written and developed by Lrtwjhs.

## INTRODUCTION
- JSP + Severlet + javabean.
- Use Mysql server as the Database.
- Duoshuo as the comment system.
- Use HTML5 as the Markup Language.
- Using bootstrap framework.

## INSTALL
1. First, download the code,  build Tomcat and MySQL environment
2. Second, import the db\_blog.sql script into MySQL, modify password in /etc/com/blog/tools/db.properties with yours
3. Then, copy the Blog/WebRoot file into your webapps subdirectory of your tomcat installation (Mine is at /usr/local/tomcat/webapps), and rename the file to Blog
4. Restart Tomcat 
5. Go to http://localhost:8080/Blog/, You should see the index page, if not, you could hava something mistakes in the above steps
6. To administer the blog. Go to http://localhost:8080/Blog/admin/
7. The default username and password is admin/123456
8. Once you have added an author, You can to add a new article
9. Go back to the home page, you should see your blog added!
