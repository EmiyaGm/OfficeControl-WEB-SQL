package com.cslg.OfficeControl.PO;

public class Order {	//指令类

	private int id;		//指令id
	private String name;	//设备名
	private String comd;	//红外命令
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComd() {
		return comd;
	}
	public void setComd(String comd) {
		this.comd = comd;
	}
	
	
	
}
