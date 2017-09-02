package com.quicksort.business.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.quicksort.business.domain.User;
import com.quicksort.business.model.Sort;
import com.quicksort.business.model.UserSort;
import com.quicksort.business.repository.UserRepository;
import com.quicksort.business.repository.Impl.UserDataDaoImpl;
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
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	UserDataDaoImpl dao;
	
	@PostConstruct
	public void init(){
		dao = new UserDataDaoImpl(entityManager);
	}

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

	@Override
	public List<User> createSortedUserList() {
//		int[] arrayToSort = dao.getScore();
		List<User> users = dao.getAll();
		int recordSize = users.size();
		User[] user = new User[recordSize];
		List<Integer>scoreList = new ArrayList<Integer>();
		for(int i=0;i<recordSize;i++){
			user[i] = users.get(i);
			scoreList.add(user[i].getScore());
		}
		List<Integer> scoreListNoDuplication = new ArrayList<Integer>(new HashSet<>(scoreList));
		int[] scoreArray = toArr(scoreListNoDuplication);
		sort.sortNumArray(scoreArray);
		List<User> result = new ArrayList<User>();
		for(int i = 0;i<scoreArray.length;i++){
			List<User> sortedUser = userRepository.findByScore(scoreArray[i]);
			result.addAll(sortedUser);
		}
		return result;
	}
	
	private static int[] toArr(List<Integer> list){
        // List<Integer> -> int[]
        int l = list.size();
        int[] arr = new int[l];
        Iterator<Integer> iter = list.iterator();
        for (int i=0;i<l;i++) arr[i] = iter.next();
        return arr;
    }

}
