package com.taku.springboot;

import java.util.Date;
import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id
	private String id;

	private String name;
	private String project;
	private Date startTime;
	private Date finishTime;

	public MyDataMongo(String name, String project, Date startTime, Date finishTime) {
		super();
		this.name = name;
		this.project = project;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProject() {
		return project;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	@Override
	public String toString() {
		return "MyDataMongo [Id=" + id + ", name=" + name + ", project=" + project + ", startTime=" + startTime
				+ ", finishTime=" + finishTime + "]";
	}
}
