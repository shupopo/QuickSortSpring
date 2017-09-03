package com.quicksort.business.model;

import org.springframework.stereotype.Component;

@Component("com.quicksort.business.model.BubbleSort")
public class BubbleSort implements Sort {

	@Override
	public void sortNumArray(int[] numArray) {
		// TODO Auto-generated method stub
		bubbleSort(numArray);
	}

	private void bubbleSort(int[] numArray) {
		int tmp = 0; // 配列の要素を一時保管する変数
		for (int i = 0; i < numArray.length - 1; i++) {
			for (int j = 0; j < numArray.length - i - 1; j++) {
				if (numArray[j] > numArray[j + 1]) {
					tmp = numArray[j];
					numArray[j] = numArray[j + 1];
					numArray[j + 1] = tmp;
				}
			}
		}
	}

}
