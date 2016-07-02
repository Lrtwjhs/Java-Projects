package com.blog.dto;

public class Link {

//	 ±àºÅ   	 id		    int      	PRIMARY KEY,
//	 Ãû³Æ	    name		VARCHAR (40) 	NOT NULL,
//	 ÍøÖ·	    url		    VARCHAR (100) 	NOT NULL,
//	 ÓÃ»§±àºÅ   	blogid		int     	NOT NULL 
//	
	private   int     id;
	private   String  name;
	private   String  url;
	private   int     blogid;
	
	public  Link(){
		
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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

	
	public Link(int blogid, int id, String name, String url) {
	super();
	this.blogid = blogid;
	this.id = id;
	this.name = name;
	this.url = url;
}
	
	
	
}
