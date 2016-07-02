#JSPBLOG
Written and developed by Lrtwjhs.

##INTRODUCTION
- There isn't much documentation, and this application isn't
- fully developed yet. I'm releasing this code because I couldn't find a Blog
written in JSP anywhere. So, I wrote one myself. 
- This application was written on Linux (Suse 8.0) using Netbeans 3.3.2.
- It was tested on Jakarta Tomcat 3 and 4.
- It uses MySQL server as the database. You can use other databases, but I'm not
sure whether or not they will work. (Further version will have tests other JSP platforms and databases with PostgreSQL and MS Access, etc).

##INSTALL
1. First, import the portal.sql script into Mysql
2. Second, copy the blog.war file into your webapps subdirectory of your tomcat installation (Mine is at /usr/local/tomcat/webapps)
3. Restart Tomcat 
4. Go to http://localhost:8080/blog/,You should see a Title, a footer and a rather empty page..You need to add an author and actual content
5. To administer the blog. Go to http://yourserver:8080/blog/admin/
6. The default username and password is admin/admin
7. CHANGE THESE VALUES IN THE FILE INDEX2.JSP IN THE ADMIN DIRECTORY!!!!!!
8. Once you have added an author, go to the Add News Link 
9. Go back to the home page, you should see your blog added!

##TODO
- Add a "better" administration page with better security
- Add an edit option to edit blogs that have been added(The existing edit option is VERY buggy
- Add a delete option to delete blogs
- Add more database tables with other options


This code is released under the GPL
