package com.blog.dto;

public class Feedback {

//	 编号	    id 		    int    
//	 昵称	        uname		VARCHAR (20) 	
//	 IP          IP		    VARCHAR (30) 
//	 内容            	content		TEXT(2000) 	
//	 发布日期	    pubtime		DATETIME 	
//	 文章编号    	articleid	int    
	
	private   int     id;
	private   String  uname;
	private   String  content;
	private   String  pubtime;
	private   int     articleid;	
	private   String  ip;
	public    Feedback(){
		
	}
	
	public Feedback(int articleid, String content, int id, String ip,
			String pubtime, String uname) {
		super();
		this.articleid = articleid;
		this.content = content;
		this.id = id;
		this.ip = ip;
		this.pubtime = pubtime;
		this.uname = uname;
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
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the pubtime
	 */
	public String getPubtime() {
		return pubtime;
	}
	/**
	 * @param pubtime the pubtime to set
	 */
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	/**
	 * @return the articleid
	 */
	public int getArticleid() {
		return articleid;
	}
	/**
	 * @param articleid the articleid to set
	 */
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
