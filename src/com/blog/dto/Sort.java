package com.blog.dto;

public class Sort {

//	±àºÅ  	    id		    int      	 
//	Ãû³Æ	        name		VARCHAR (40) 	
//	ÓÃ»§±àºÅ    	blogid		int     	

	private   int     id;
	private   String  name;
	private   int  blogid;
	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}
	private   String count;
	
	public Sort(){
		
	}
	
	public Sort(int blogid, int id, String name) {
		super();
		this.blogid = blogid;
		this.id = id;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the blogid
	 */
	public int getBlogid() {
		return blogid;
	}
	/**
	 * @param blogid the blogid to set
	 */
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	
	
}
