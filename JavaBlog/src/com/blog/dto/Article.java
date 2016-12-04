package com.blog.dto;

public class Article {

//	 编号                    id 		    int    	PRIMARY KEY,
//	 标题	    title 		VARCHAR (20) 	NOT NULL ,
//	内容     	    content		TEXT(2000) 	NULL,
//	发布日期   	pubtime		DATETIME	NOT NULL,
//	用户编号  	blogid		int     	NOT NULL 
//	类别    	    sortid 		int    	NULL 
	
	private   int     id;
	private   String  title;
	private   String  content;
	private   String  pubtime;
	private   int     blogid;
	private   int     sortid;	
	private   String  sort;
	
	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	public Article(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public int getSortid() {
		return sortid;
	}
	public void setSortid(int sortid) {
		this.sortid = sortid;
	}
	
	
	
}
