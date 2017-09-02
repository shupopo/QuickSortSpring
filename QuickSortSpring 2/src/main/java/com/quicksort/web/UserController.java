package com.quicksort.web;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quicksort.business.domain.User;
import com.quicksort.business.repository.UserRepository;
import com.quicksort.business.repository.Impl.UserDataDaoImpl;
import com.quicksort.business.service.SortService;





@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SortService sortService;
	
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
		sortService.editUser(select, user);
		return new ModelAndView("redirect:/");
	}

}
