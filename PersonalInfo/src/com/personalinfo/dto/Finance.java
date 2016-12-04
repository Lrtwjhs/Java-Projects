package com.personalinfo.dto;

public class Finance {

//	F_id	int(11) AI PK
//	F_time	datetime
//	F_ievent	varchar(20)
//	F_pevent	varchar(20)
//	F_income	decimal(9,2)
//	F_pay	decimal(9,2)
//	F_remamoney	decimal(18,2)
//	Uid	int(11)

	private   int     F_id;
	private   String  F_time;
	private   String  F_ievent;
	private String F_pevent;
	private String F_income;
	private String F_pay;
	private String F_remamoney;
	private   int     Uid;
	
    public Finance() {
	
	}
    public Finance(int     F_id,String  F_time,String  F_ievent,String F_pevent,String F_income,String F_remamoney,int     Uid, String F_pay) {
    	super();
    	this.F_id = F_id;
    	this.F_time = F_time;
    	this.F_ievent = F_ievent;
    	this.F_pevent = F_pevent;
    	this.F_income = F_income;
    	this.F_pay = F_pay;
    	this.F_remamoney = F_remamoney;
    	this.Uid = Uid;
	}

	public int getF_id() {
		return F_id;
	}

	public void setF_id(int f_id) {
		F_id = f_id;
	}

	public String getF_time() {
		return F_time;
	}

	public void setF_time(String f_time) {
		F_time = f_time;
	}

	public String getF_ievent() {
		return F_ievent;
	}

	public void setF_ievent(String f_ievent) {
		F_ievent = f_ievent;
	}

	public String getF_pevent() {
		return F_pevent;
	}

	public void setF_pevent(String f_pevent) {
		F_pevent = f_pevent;
	}

	public String getF_income() {
		return F_income;
	}

	public void setF_income(String f_income) {
		F_income = f_income;
	}

	public String getF_pay() {
		return F_pay;
	}

	public void setF_pay(String f_pay) {
		F_pay = f_pay;
	}

	public String getF_remamoney() {
		return F_remamoney;
	}

	public void setF_remamoney(String f_remamoney) {
		F_remamoney = f_remamoney;
	}

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}


    
}
