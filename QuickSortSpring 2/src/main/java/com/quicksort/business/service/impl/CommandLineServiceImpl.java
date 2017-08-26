package com.quicksort.business.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quicksort.business.domain.User;
import com.quicksort.business.repository.UserRepository;
import com.quicksort.business.service.CommandLineService;

@Component
public class CommandLineServiceImpl implements CommandLineService{
	
	@Autowired
	private UserRepository userRepository;

	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public void create() throws Exception {
		// TODO Auto-generated method stub
		while(true){	
			System.out.println("登録しますか？ yes or no");
			String answer = br.readLine();
			if(answer.equals("yes")){
				User user = new User();
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
			}else{
				break;
			}
		}
		
	}

	@Override
	public void delete() throws Exception{
		// TODO Auto-generated method stub
		
		while(true){
			System.out.println("登録データを削除しますか？ yes or no");
			String answer = br.readLine();
			if(answer.equals("yes")){
				System.out.println("削除するデータのIDを入力してください。");
				String idInput = br.readLine();
				Long id = Long.parseLong(idInput);
				userRepository.delete(id);
			}else{
				break;
			}
		
	}

}

}
