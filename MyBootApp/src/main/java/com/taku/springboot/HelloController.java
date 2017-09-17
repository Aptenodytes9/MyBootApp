package com.taku.springboot;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.taku.springboot.repositories.MyDataMongoRepository;
import com.taku.springboot.repositories.MyDataRepository;

@Controller
public class HelloController {
	
	@Autowired
	MyDataMongoRepository repository;
	//MyDataRepository repository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	MyDataDaoImpl dao;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index (ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("title", "Find Page");
		mav.addObject("msg", "This is MyDataMongo sample contents...");
		Iterable<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView form(
			@RequestParam("name") String name,
			@RequestParam("project") String project,
			ModelAndView mav) {
		MyDataMongo mydata = new MyDataMongo(name, project);
		repository.save(mydata);
		return new ModelAndView("redirect:/");
	}
	
	/*@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit (@ModelAttribute MyData mydata, @PathVariable int id, ModelAndView mav) {
		mav.setViewName("edit");
		mav.addObject("title", "edit mydata...");
		MyData data = repository.findById((long)id);
		mav.addObject("formModel", data);
		return mav;
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView update(@ModelAttribute MyData mydata,ModelAndView mav){
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}*/ 
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView remove (@RequestParam("delete") String param, ModelAndView mav){
		mav.setViewName("index");
		if(param != null && !"".equals(param)){
			repository.deleteByName(param);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ModelAndView find(ModelAndView mav){
		mav.setViewName("index");
		mav.addObject("title", "Find Page");
		mav.addObject("msg", "MyData sample");
		mav.addObject("value", "");
		Iterable<MyDataMongo> list = repository.findAll();
		//Iterable<MyData> list = repository.findAllOrderByName();
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping(value="/find", method=RequestMethod.POST)
	public ModelAndView search(ModelAndView mav, @RequestParam("find") String param){
		mav.setViewName("index");
		if(param == null || "".equals(param)){
			mav = new ModelAndView("redirect:/find");
		} else {
			mav.addObject("title", "Find result");
			mav.addObject("msg", "[" + param + "]の検索結果");
			mav.addObject("value", param);
			List<MyDataMongo> result = repository.findByName(param);
			mav.addObject("datalist", result);
		}
		return mav;
	}
	
	/*@RequestMapping(value="/find", method=RequestMethod.GET)
	public ModelAndView find(ModelAndView mav){
		mav.setViewName("find");
		mav.addObject("title", "Find Page");
		mav.addObject("msg", "MyData sample");
		mav.addObject("value", "");
		Iterable<MyData> list = dao.getAll();
		//Iterable<MyData> list = repository.findAllOrderByName();
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping(value="/find", method=RequestMethod.POST)
	public ModelAndView search(ModelAndView mav, HttpServletRequest request){
		mav.setViewName("find");
		String param = request.getParameter("fstr");
		if(param == null || "".equals(param)){
			mav = new ModelAndView("redirect:/find");
		} else {
			mav.addObject("title", "Find result");
			mav.addObject("msg", "[" + param + "]の検索結果");
			mav.addObject("value", param);
			List<MyData> result = dao.find(param);
			mav.addObject("datalist", result);
		}
		return mav;
	}*/
	
	@PostConstruct
	public void init() {
		dao = new MyDataDaoImpl(entityManager);
		MyData d1 = new MyData();
		d1.setName("toru");
		d1.setAge(15);
		d1.setMail("toru@www.com");
		d1.setMemo("09012345678");
		MyData d2 = new MyData();
		d2.setName("kaoru");
		d2.setAge(25);
		d2.setMail("kaoru@mov.com");
		d2.setMemo("09012345678");
		MyData d3 = new MyData();
		d3.setName("sachiko");
		d3.setAge(47);
		d3.setMail("66@www.com");
		d3.setMemo("09012345678");
		MyData d4 = new MyData();
		d4.setName("sample man");
		d4.setAge(99);
		d4.setMail("sample@www.com");
		d4.setMemo("01205556666");
/*		repository.saveAndFlush(d1);
		repository.saveAndFlush(d2);
		repository.saveAndFlush(d3);
		repository.saveAndFlush(d4);*/
	}
	
	@RequestMapping("/other")
	public String other() {
		return "redirect:/";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "forward:/";
	}
}
