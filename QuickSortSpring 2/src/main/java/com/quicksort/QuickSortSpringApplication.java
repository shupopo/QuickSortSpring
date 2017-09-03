package com.quicksort;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quicksort.commandline.CommandLineController;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @SpringBootApplicationの役割を調べておく
 * @author shuhei66
 *
 */
@SpringBootApplication
public class QuickSortSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickSortSpringApplication.class, args);
	}

	// @Override
	// public void run(String... arg0) throws Exception {
	// System.out.println("hello terminal");
	//
	//
	//
	//
	//
	//
	//
	// }

}
