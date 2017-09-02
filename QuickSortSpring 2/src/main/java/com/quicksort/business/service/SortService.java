package com.quicksort.business.service;

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
	
	void editUser(String select, User user,long id);
	
	

}
