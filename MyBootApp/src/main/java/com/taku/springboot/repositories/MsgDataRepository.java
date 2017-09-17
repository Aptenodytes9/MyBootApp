package com.taku.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taku.springboot.MsgData;

public interface MsgDataRepository extends JpaRepository<MsgData, Long> {
	
}
