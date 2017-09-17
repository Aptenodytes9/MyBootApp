package com.taku.springboot;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.taku.springboot.repositories.MsgDataRepository;

@Controller
public class MsgDataController {
	
	@Autowired
	MsgDataRepository repository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	MsgDataDaoImpl dao;
	
	@RequestMapping(value="/msg", method= RequestMethod.GET)
	public ModelAndView msg(ModelAndView mav){
		return mav;
	}
	
	
	public ModelAndView msgForm(@Valid @ModelAttribute MsgData msgdata, Errors result, ModelAndView mav){
		return null;
		
	}
	
}
