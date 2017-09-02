package com.quicksort.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quicksort.business.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
		
	public User findById(Long id);
	
	public List<User> findByScore(int score);

	public User findByScoreLike(int i);
	
	@Query(value="select distinct score from quicksort",nativeQuery = true)
    public int[] getScores();
//
//	@Query("select * from quicksort order by score")
//	public List<User> sortByScore();



	
}
