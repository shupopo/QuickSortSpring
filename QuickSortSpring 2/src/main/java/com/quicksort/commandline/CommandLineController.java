package com.quicksort.commandline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.quicksort.business.domain.User;
import com.quicksort.business.repository.UserRepository;
import com.quicksort.business.service.CommandLineService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;



@Component
public class CommandLineController implements CommandLineRunner{
	
	@Autowired
	private CommandLineService service;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		service.create();
		service.delete();
		
		}
			    
		
		    
		
	}


	
	
	
	

