package com.taku.springboot;

import java.io.Serializable;
import java.util.List;

public interface MsgDataDao extends Serializable{
	public List<MyData> getAll();
	public MsgData findById(Long id);
}
