package com.taku.springboot;

import java.util.Date;
import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id
	private String Id;
	
	private String name;
	private String project;
	private Date date;
	
	public MyDataMongo(String name, String project) {
		super();
		this.name = name;
		this.project = project;
		this.date = new Date();
	}
	
	public String getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public String getProject() {
		return project;
	}
	public Date getDate() {
		return date;
	}
}
