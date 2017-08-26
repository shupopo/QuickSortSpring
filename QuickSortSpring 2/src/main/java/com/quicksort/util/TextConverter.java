package com.quicksort.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextConverter {
	
	/**
	 * 入力されたテキストを改行区切りで分けて配列に入れ、
	 * その配列をintに変換して返すメソッドであることを示すため
	 * convertTextからtoNumArrayに変更
	 * 
	 * @param text 改行区切りの入力
	 * @return 変換されたint配列
	 * @throws IOException 
	 */
	public static int[] toNumArray(String text) {
		
		String[] strArray = text.split("\n");
		int[] numArray = new int[strArray.length];
		for(int i=0;i<strArray.length;i++){
			strArray[i] = strArray[i].trim();
			try {
				numArray[i] = Integer.parseInt(strArray[i]);// throws NumberFormatException
		    } catch (NumberFormatException e) {
		        e.printStackTrace(); // 整数以外のとき、スタックトレースが出力される
		    }
			
		}
		
		
		
		return numArray;
		
	}

}
