package com.quicksort.business.model;

import org.springframework.stereotype.Component;

@Component("com.quicksort.business.model.MergeSort")
public class MergeSort implements Sort{

	@Override
	public void sortNumArray(int[] numArray) {
		// TODO Auto-generated method stub
		
		mergeSort(numArray);
		
	}
	
	private void mergeSort(int[] numArray){
		if(numArray.length>1){
		      int m=numArray.length/2;
		      int n=numArray.length-m;
		      int[] firstArray=new int[m];
		      int[] lastArray=new int[n];
		      for(int i=0;i<m;i++) {
		    	  firstArray[i]=numArray[i];
		      }
		      for(int i=0;i<n;i++) {
		    	  lastArray[i]=numArray[m+i];
		      
		      }
		      mergeSort(firstArray);
		      mergeSort(lastArray);
		      merge(firstArray,lastArray,numArray);
		    }
		
	}



	private void merge(int[] a1,int[] a2,int[] a){
		int i=0,j=0;
		while(i<a1.length || j<a2.length){
			if(j>=a2.length || (i<a1.length && a1[i]<a2[j])){
				a[i+j]=a1[i];
				i++;
			}
			else{
				a[i+j]=a2[j];
				j++;
			}
		}
  }

}

