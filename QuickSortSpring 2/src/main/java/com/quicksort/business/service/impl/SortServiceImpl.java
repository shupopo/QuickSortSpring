package com.quicksort.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.quicksort.business.domain.User;
import com.quicksort.business.model.Sort;
import com.quicksort.business.model.UserSort;
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

	@Override
	public int[] createSortedNumArray(int[] numArray) {
		

		//int[] numArray = TextConverter.toNumArray(text);
		sort.sortNumArray(numArray);
		return numArray;
	}

	@Override
	public List<User> createSortedUser(List<User> userList) {
		// TODO Auto-generated method stub
		
		List<User> sortedUserList = userSort.userSort(userList);
		return sortedUserList;
	}

}
