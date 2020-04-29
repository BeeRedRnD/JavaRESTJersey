package com.bilal.restapijersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	
	private Integer id;
	private String cname;
	private Integer cscore;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getCscore() {
		return cscore;
	}
	public void setCscore(Integer cscore) {
		this.cscore = cscore;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", cname=" + cname + ", cscore=" + cscore + "]";
	}
	
	
	

}
