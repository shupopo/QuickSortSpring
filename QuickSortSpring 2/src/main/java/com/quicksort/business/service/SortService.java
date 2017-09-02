package com.quicksort.business.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.quicksort.business.domain.User;



public interface SortService {
	/**
	 * テキストを受け取りクイックソートしたのち整数の配列を返す。
	 * @param text
	 * @return
	 * 変換
	 * numArrayをコントローラーに返すのでメソッド名をinputからcreateNumArrayに変更
	 */
	int[] createSortedNumArray(int[]scores);
	
	List<User> createSortedUser(List<User> userList);
	
	void editUser(String select, User user);
	
	List<User> createSortedUserList();
	
	void registProfile() throws IOException;

	void editProfile() throws IOException;
	
	void displayUserList(List<User> list);



}
