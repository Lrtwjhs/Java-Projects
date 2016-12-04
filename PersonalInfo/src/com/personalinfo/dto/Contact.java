package com.personalinfo.dto;

public class Contact {

	// 通讯录编号 C_id int NOT NULL PRIMARY KEY,
	// 所属人ID Uid int NOT NULL ,
	// 通讯人姓名 C_name varchar(20) NOT NULL,
	// 通讯人联系方式 C_tel varchar(20) NOT NULL,
	// 通讯人邮箱 C_emaiil varchar(25),
	// 通讯人职业 C_job varchar(15),
	// 通讯人城市 C_city varchar(20),
	// 通讯人备注 C_remark text,

	private int C_id;
	private String C_name;
	private String C_tel;
	private String C_email;
	private String C_job;
	private String C_city;
	private String C_remark;
	private int Uid;

	public Contact() {

	}

	public Contact(int C_id, String C_name, String C_tel, String C_email, String C_job, String C_city,
			String C_remark, int Uid) {
		super();
		this.C_id = C_id;
		this.C_name = C_name;
		this.C_tel = C_tel;
		this.C_email = C_email;
		this.C_job = C_job;
		this.C_city = C_city;
		this.C_remark = C_remark;
		this.Uid = Uid;
	}

	public int getC_id() {
		return C_id;
	}

	public void setC_id(int c_id) {
		this.C_id = c_id;
	}

	public int getUid() {
		return Uid;
	}

	public void setC_Uid(int Uid) {
		this.Uid = Uid;
	}

	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		this.C_name = c_name;
	}

	public String getC_tel() {
		return C_tel;
	}

	public void setC_tel(String c_tel) {
		this.C_tel = c_tel;
	}

	public String getC_email() {
		return C_email;
	}

	public void setC_email(String c_email) {
		this.C_email = c_email;
	}

	public String getC_job() {
		return C_job;
	}

	public void setC_job(String c_job) {
		this.C_job = c_job;
	}

	public String getC_city() {
		return C_city;
	}

	public void setC_city(String c_city) {
		this.C_city = c_city;
	}

	public String getC_remark() {
		return C_remark;
	}

	public void setC_remark(String c_remark) {
		this.C_remark = c_remark;
	}

}
