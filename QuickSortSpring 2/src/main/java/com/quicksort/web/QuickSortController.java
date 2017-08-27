package com.quicksort.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quicksort.business.model.QuickSort;
import com.quicksort.business.service.SortService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quicksort.business.domain.User;
import com.quicksort.business.repository.UserRepository;
import com.quicksort.business.repository.Impl.UserDataDaoImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
public class QuickSortController {
	
	
	/**
	 * SortServiceImplをBean登録せずに＠Autowiredアノテーションをつけてもインスタンスは自動的に生成されない
	 * 
	 * インターフェースについてAutowiredでインスタンスを生成するとき実装クラスが複数ある場合の対処法は
	 * http://javatechnology.net/spring/qualifier/
	 * 
	 * 
	 */
	
	@Autowired
	private SortService sortService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	UserDataDaoImpl dao;
	
	@PostConstruct
	public void init(){
		dao = new UserDataDaoImpl(entityManager);
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		
		List<User> users = dao.getAll();
		
		mav.addObject("users", users);
		mav.addObject("msg","ソート前のデータです");
		mav.setViewName("index");
		return mav;
	}
	

	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
			ModelAndView mav) {		
		//List<User> result = dao.getSortedUser();
		
		List<User> userList = dao.getAll();
		List<User> result = sortService.createSortedUser(userList);
		
		mav.addObject("msg","ソート後のデータです。");
		mav.addObject("users", result);
		mav.setViewName("index");
		return mav;
	}
	

	
	@RequestMapping(value = "/user/new", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView mav) {
	    mav.setViewName("user/new");
	    return mav;
	}
	
	@RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public ModelAndView createTweet(User newUser, ModelAndView mav) {
        userRepository.saveAndFlush(newUser);
        mav.setViewName("user/create");
        return mav;
    }
	
	@RequestMapping(value = "user/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute User user, @PathVariable int id,ModelAndView mav) {
		mav.setViewName("user/edit");
		User user1 = userRepository.findById((long)id);
		mav.addObject("user",user1);
		return mav;
	}

	@RequestMapping(value = "user/edit", method = RequestMethod.POST)
	
	public ModelAndView update(@ModelAttribute User user, @RequestParam String select,@RequestParam long id,
			ModelAndView mav) {
		if(select.equals("UPDATE")){
			userRepository.saveAndFlush(user);
		}else{
			userRepository.delete(id);
		}
		
		return new ModelAndView("redirect:/");
	}
	
//	@RequestMapping(value = "user/delete/{id}", method = RequestMethod.GET)
//	public ModelAndView delete(@PathVariable int id,
//			ModelAndView mav) {
//		mav.setViewName("user/delete");
//	
//		User user = userRepository.findById((long)id);
//		mav.addObject("user",user);
//		return mav;
//	}
//
//	@RequestMapping(value = "user/delete", method = RequestMethod.POST)
//	public ModelAndView remove(@RequestParam long id, 
//			ModelAndView mav) {
//		userRepository.delete(id);
//		return new ModelAndView("redirect:/");
//	}
	
	
}