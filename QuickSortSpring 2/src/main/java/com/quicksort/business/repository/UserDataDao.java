package com.quicksort.business.repository;

import java.io.Serializable;
import java.util.List;

public interface UserDataDao <T> extends Serializable {
	
	public List<T> getAll();
	
	public int[] getScore();
	
}
