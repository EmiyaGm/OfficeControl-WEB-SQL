package com.cslg.OfficeControl.PO;

public class Gather {		//采集类
	
	private int id;
	private String name;	//设备名
	private float inTemp;	//进风口温度
	private float outTemp;	//出风口温度
	private float temp;		//温度
	private int humans;		//人员情况
	private	float humidity; //湿度
	private float light;	//光度
	private int userId;		//用户id
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
	public float getInTemp() {
		return inTemp;
	}
	public void setInTemp(float inTemp) {
		this.inTemp = inTemp;
	}
	public float getOutTemp() {
		return outTemp;
	}
	public void setOutTemp(float outTemp) {
		this.outTemp = outTemp;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public int getHumans() {
		return humans;
	}
	public void setHumans(int humans) {
		this.humans = humans;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getLight() {
		return light;
	}
	public void setLight(float light) {
		this.light = light;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
