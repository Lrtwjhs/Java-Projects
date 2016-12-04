package com.personalinfo.dto;

public class Diary {

//	日记 D_id	int(11) AI PK
//	日记时间 D_time	date
//	日记天气 D_weather	varchar(5)
//	日记星期 D_week	varchar(10)
//	日记内容 D_event	mediumtext
//	所属用户Ｕid	int(11) 
	
	private   int    D_id;
	private   String  D_time;
	private   String  D_weather;
	private   String  D_week;
	private String D_event;
	private   int     Uid;

	public Diary(int    D_id,String  D_time,String  D_weather,String  D_week,String D_event,int     Uid){
		super();
		this.D_id = D_id;
		this.D_time = D_time;
		this.D_weather = D_weather;
		this.D_week = D_week;
		this.D_event = D_event;
		this.Uid = Uid;

	}
	
	public Diary(){
		
	}

	public int getD_id() {
		return D_id;
	}

	public void setD_id(int d_id) {
		D_id = d_id;
	}

	public String getD_time() {
		return D_time;
	}

	public void setD_time(String d_time) {
		D_time = d_time;
	}

	public String getD_weather() {
		return D_weather;
	}

	public void setD_weather(String d_weather) {
		D_weather = d_weather;
	}

	public String getD_week() {
		return D_week;
	}

	public void setD_week(String d_week) {
		D_week = d_week;
	}

	public String getD_event() {
		return D_event;
	}

	public void setD_event(String d_event) {
		D_event = d_event;
	}

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}
	
	
	
}
