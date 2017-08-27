package com.quicksort.business.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.quicksort.business.domain.User;
import com.quicksort.business.repository.UserRepository;


@Component
public class UserSort{
	

	public List<User> userSort(List<User>userList){
		
			User[] user = userList.toArray(new User[userList.size()]);
			User tmp=null; //配列の要素を一時保管する変数
	        for( int i=0; i<user.length-1; i++ ) {
	           for( int j=0; j<user.length-i-1; j++ ) {
	              if( user[j].getScore() > user[j+1].getScore() ) {
	            	  	  tmp = user[j];
	                  user[j] = user[j+1];
	                  user[j+1] = tmp;
	              }
	           }
	        }
	        
	        List<User> sortedUser = Arrays.asList(user);
	        return sortedUser;
	        
	}
	

}