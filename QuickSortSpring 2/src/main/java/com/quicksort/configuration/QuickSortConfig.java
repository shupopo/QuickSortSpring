package com.quicksort.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.quicksort.business.model.BubbleSort;
import com.quicksort.business.model.MergeSort;
import com.quicksort.business.model.QuickSort;
import com.quicksort.business.service.impl.SortServiceImpl;

@Configuration
public class QuickSortConfig {
	
	/**
	 * QuickSortControllerにあるSortServiceインターフェースには@Autowiredアノテーションが付与されているが、
	 * それだけではインスタンスが生成されないため
	 * 
	 * Field sortService in com.quicksort.
	 * QuickSortController required a bean of type 'com.quicksort.business.service.
	 * SortService' that could not be found.
	 * 
	 * のエラーが生じる
	 * 
	 * この設定クラスは、@Configurationがつくことでアプリ起動時にインスタンス化され
	 * 以下に記述されるBeanをアプリケーションに登録する。
	 * 
	 * @Beanがつけられたメソッドは、Beanとして登録するインスタンスを返す。
	 * 
	 * QuickSortControllerにある@AutowiredがついたSortServiceには
	 * それを継承するクラスのインスタンスが自動的にバインドされる。
	 * 詳しくは『Spring bootプログラミング入門』p340-
	 * 
	 * @return
	 */
	@Bean
	public SortServiceImpl sortService(){
		return new SortServiceImpl();
	}
	
	@Bean
	public QuickSort quickSort(){
		return new QuickSort();
	}
	
	@Bean
	public BubbleSort bubbleSort(){
		return new BubbleSort();
	}
	
	@Bean
	public MergeSort mergeSort(){
		return new MergeSort();
	}
	
}


