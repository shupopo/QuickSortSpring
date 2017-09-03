package com.quicksort.business.repository.Impl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.quicksort.business.domain.User;
import com.quicksort.business.repository.UserDataDao;

@Repository
public class UserDataDaoImpl implements UserDataDao<User> {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	
	public UserDataDaoImpl(){
		super();
	}
	public UserDataDaoImpl(EntityManager manager){
		entityManager = manager;
	}
	
	@Override
	public List<User> getAll() {
		Query query = entityManager.createNativeQuery("select * from quicksort", User.class);
		List<User> list = query.getResultList();
		entityManager.close();
		return list;
	}
	//Spring bootプログラミング入門ではHSQLDBのためentityが必要ないが、MySQLを使う場合は引数にentityのクラスを指定しなければならない。
	//http://qiita.com/tag1216/items/55742fdb442e5617f727
	
	@Override
	public int[] getScore() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("select distinct score from quicksort order by score asc");
		List<Integer> list = query.getResultList();
		int[] scoreArray = toArr(list);
		entityManager.close();
		return scoreArray;		
	}
	//引数にエンティティのクラスを指定するとエンティティしか取ってこれなくなる
	
	//http://qiita.com/kics/items/a1f002a303298061febf
	private static int[] toArr(List<Integer> list){
        // List<Integer> -> int[]
        int l = list.size();
        int[] arr = new int[l];
        Iterator<Integer> iter = list.iterator();
        for (int i=0;i<l;i++) arr[i] = iter.next();
        return arr;
    }
}
