package com.ajouroid.timetable;

import java.util.ArrayList;

public class BusInfo {
	private String bus_id;
	private String bus_number;
	String upFirstTime;
	String upLastTime;
	String downFirstTime;
	String downLastTime;
	String region;
	ArrayList<BusStopInfo> stopList;
	private String arrive_time;
	private int bus_type;
	
	public BusInfo(){}
	
	public BusInfo(String _id, String _number, String _region)
	{
		bus_id = _id;
		bus_number = _number;
		upFirstTime = "";
		upLastTime = "";
		downFirstTime = "";
		downLastTime = "";
		region = _region;
	}
	
	public BusInfo(String _id, String _number, String ufirst, String ulast, String dfirst, String dlast) {
		bus_id = _id;
		bus_number = _number;
		upFirstTime = ufirst;
		upLastTime = ulast;
		downFirstTime = dfirst;
		downLastTime = dlast;
		stopList = new ArrayList<BusStopInfo>();
	}
	
	public void setInfo(String _time, int _type) {
		arrive_time = _time;
		bus_type = _type;
	}

	public String getBus_id() {
		return bus_id;
	}

	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}

	public String getBus_number() {
		return bus_number;
	}

	public void setBus_number(String bus_number) {
		this.bus_number = bus_number;
	}

	public String getArrive_time() {
		return arrive_time;
	}

	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}

	public int getBus_type() {
		return bus_type;
	}

	public void setBus_type(int bus_type) {
		this.bus_type = bus_type;
	}


	public String getUpFirstTime() {
		return upFirstTime;
	}
	public void setUpFirstTime(String upFirstTime) {
		this.upFirstTime = upFirstTime;
	}
	public String getUpLastTime() {
		return upLastTime;
	}
	public void setUpLastTime(String upLastTime) {
		this.upLastTime = upLastTime;
	}
	public String getDownFirstTime() {
		return downFirstTime;
	}
	public void setDownFirstTime(String downFirstTime) {
		this.downFirstTime = downFirstTime;
	}
	public String getDownLastTime() {
		return downLastTime;
	}
	public void setDownLastTime(String downLastTime) {
		this.downLastTime = downLastTime;
	}
	public ArrayList<BusStopInfo> getStopList() {
		return stopList;
	}

	public void setStopList(ArrayList<BusStopInfo> stopList) {
		this.stopList = stopList;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}