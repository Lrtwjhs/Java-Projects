package com.personalinfo.dto;

public class Memorandum {

	// M_id int(11) AI PK
	// M_theme varchar(50)
	// M_time datetime
	// M_place varchar(25)
	// M_event tinytext
	// M_status varchar(20)
	// Uid int(11)

	private int M_id;
	private String M_theme;
	private String M_time;
	private String M_place;
	private String M_event;
	private String M_status;
	private int Uid;

	public Memorandum() {

	}
	
	public Memorandum(String M_theme, String M_time,String M_place,String M_event,String M_status,int Uid) {
    	super();

    	this.M_theme = M_theme;
    	this.M_time = M_time;
    	this.M_place = M_place;
    	this.M_event = M_event;
    	this.M_status = M_status;
    	this.Uid = Uid;
    	
	}
	

	public int getM_id() {
		return M_id;
	}

	public void setM_id(int m_id) {
		M_id = m_id;
	}

	public String getM_theme() {
		return M_theme;
	}

	public void setM_theme(String m_theme) {
		M_theme = m_theme;
	}

	public String getM_time() {
		return M_time;
	}

	public void setM_time(String m_time) {
		M_time = m_time;
	}

	public String getM_place() {
		return M_place;
	}

	public void setM_place(String m_place) {
		M_place = m_place;
	}

	public String getM_event() {
		return M_event;
	}

	public void setM_event(String m_event) {
		M_event = m_event;
	}

	public String getM_status() {
		return M_status;
	}

	public void setM_status(String m_status) {
		M_status = m_status;
	}

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}

}
