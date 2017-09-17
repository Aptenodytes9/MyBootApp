package com.taku.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.taku.springboot.MyDataMongo;

public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, Long>{
	public List<MyDataMongo> findByName(String str);
	public void deleteByName(String param);
}
