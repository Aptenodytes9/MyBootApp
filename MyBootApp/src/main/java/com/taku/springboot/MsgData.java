package com.taku.springboot;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "msgdata")
public class MsgData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@NotNull
	private int id;
	
	@Column
	private String title;
	
	@Column(nullable = false)
	@NotNull
	private String message;
	
	@ManyToOne
	private MyData mydata;

	public MsgData() {
		super();
		mydata = new MyData();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MyData getMydata() {
		return mydata;
	}

	public void setMydata(MyData mydata) {
		this.mydata = mydata;
	}

}
