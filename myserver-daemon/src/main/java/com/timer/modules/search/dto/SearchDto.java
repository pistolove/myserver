package com.timer.modules.search.dto;

import javax.xml.crypto.Data;

import com.timer.dto.BaseDto;

public class SearchDto extends BaseDto{

	private String pname;

	private Double pprice;

	private Data time;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPprice() {
		return pprice;
	}

	public void setPprice(Double pprice) {
		this.pprice = pprice;
	}

	public Data getTime() {
		return time;
	}

	public void setTime(Data time) {
		this.time = time;
	}

}
