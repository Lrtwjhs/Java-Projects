package com.blog.tools;

import java.util.Iterator;
import java.util.List;

import com.blog.dao.LinkDao;
import com.blog.dto.Link;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        DBcon  dba =new DBcon();
//        
//        if(dba.getConnection()!=null){
//       	System.out.println("Success");
//        }
		  
		  String list_con = "";
		  LinkDao dao = new LinkDao();
		  List    list = dao.getList(2, 5);
		  Iterator  it = list.iterator();
		  while(it.hasNext()){
		     Link  l = (Link)it.next();
		     list_con += l.getId()+"---"+l.getBlogid()+"---"+l.getName()+"---"+l.getUrl()+"\n";		    
		  }
		  System.out.print(list_con);
		  System.out.print(dao.getCPages()+"---"+dao.getTotal()+"---"+dao.getTPages());		   
	}
}
