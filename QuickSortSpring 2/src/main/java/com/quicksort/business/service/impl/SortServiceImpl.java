package com.quicksort.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.quicksort.business.domain.User;
import com.quicksort.business.model.Sort;
import com.quicksort.business.model.UserSort;
import com.quicksort.business.repository.UserRepository;
import com.quicksort.business.service.SortService;
import com.quicksort.util.TextConverter;

@Service
public class SortServiceImpl implements SortService {
	
	 /**
	  * inputメソッドでソートを使うためにニューする
	  * このクラスでしか使わないので、private
	  * 
	  */
	@Qualifier("com.quicksort.business.model.BubbleSort")
	@Autowired
	private Sort sort;
	
	@Autowired
	private UserSort userSort;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public int[] createSortedNumArray(int[] numArray) {

		sort.sortNumArray(numArray);
		return numArray;
	}

	@Override
	public List<User> createSortedUser(List<User> userList) {

		List<User> sortedUserList = userSort.userSort(userList);
		return sortedUserList;

	}

	@Override
	public void editUser(String select, User user) {

		if(select.equals("UPDATE")){
			userRepository.saveAndFlush(user);
		}else{
			userRepository.delete(user.getId());
		}
			
	}

}
