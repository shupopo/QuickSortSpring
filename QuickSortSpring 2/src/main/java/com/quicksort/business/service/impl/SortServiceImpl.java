package com.quicksort.business.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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

	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    private Scanner scanner = new Scanner(System.in);
    
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
		int[] scoreArray = dao.getScore();
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

	@Override
	public void displayUserList(List<User> list) {
		// TODO Auto-generated method stub
		List<User> userList = list;
		System.out.println("ID"+" : "+"名前"+" : "+"スコア"+" : "+"性別");
		for(int i=0;i<userList.size();i++){
			User user = userList.get(i);
			System.out.println(user.getId()+" : "+user.getName()+" : "+user.getScore()+" : "+user.getSex());
		}
	}

	@Override
	public void registProfile() throws IOException {
		User user = new User();
		changeProfile(user);		
	}

	@Override
	public void editProfile() throws IOException {
		System.out.println("編集したいユーザのIDを入力してください。");
        Long id = (long) scanner.nextInt();
        User user = userRepository.findById(id);
		System.out.println("[0]プロフィール削除 [1]プロフィール更新");
		int select = scanner.nextInt();
		if(select == 0){
			userRepository.delete(user.getId());
		}else{
			System.out.println("編集前のプロフィールは以下の通りです。");
			System.out.println("ID"+" : "+"名前"+" : "+"スコア"+" : "+"性別");
			System.out.println(user.getId()+" : "+user.getName()+" : "+user.getScore()+" : "+user.getSex());
			changeProfile(user);
		}
	}
	 private void changeProfile(User user) throws IOException{
		 System.out.println("名前を登録してください。");
			String name = br.readLine();
			user.setName(name);
			
			System.out.println("スコアを登録してください。");
			String scoreInput = br.readLine();
			int score = Integer.parseInt(scoreInput);
			user.setScore(score);
			
			System.out.println("性別を登録してください。");
			String sex = br.readLine();
			user.setSex(sex);

			userRepository.saveAndFlush(user);	
	}




}
