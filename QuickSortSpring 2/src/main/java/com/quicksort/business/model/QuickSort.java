package com.quicksort.business.model;

import org.springframework.stereotype.Component;

@Component("com.quicksort.business.model.QuickSort")
public class QuickSort implements Sort{
	@Override
	public void sortNumArray(int[]numArray){
		quickSort(numArray,0,numArray.length-1);
	}
	
	/**
	 * 
	 * @param numArray　ソートする配列
	 * left, rightを包含的範囲を指定するfirst, lastに変更
	 */
    private void quickSort(int[]numArray, int first, int last) {
       
    	int curleft = first;		//左カーソルに配列の左端を代入
        int curright = last;	//右カーソルに配列の右端を代入
        int pivot = numArray[(curleft + curright) / 2];		//枢軸
        
        do {
            while (numArray[curleft] < pivot) {
                curleft++;	//(numArray[左カーソル] >= 枢軸)をみたす配列の要素が見つかるまで右方向へ走査する
            }
            
            while (numArray[curright] > pivot) {
                curright--;		//(numArray[右カーソル] <= 枢軸)を満たす配列の要素が見つかるまで左方向へ走査する
            }
            if (curleft <= curright) {	
                swap (numArray, curleft, curright);//枢軸の左にある要素と右にある要素を入れ替える。
                curleft++;//走査を続行する
                curright--;
            }
        } while (curleft <= curright);
        
        if (first < curright) {
            quickSort(numArray, first, curright);
        }
        
        if (curleft < last) {
            quickSort(numArray, curleft, last);
        }
    }
	
    private void swap (int[] array, int idx1, int idx2) {
    	//インデックスで指定された要素を入れ替える
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }
}
