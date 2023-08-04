package com.bookapplication.bookapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookapplicationApplication.class, args);

		String ANSI_RESET = "\u001B[0m";
		String ANSI_GREEN = "\u001B[32m";
		System.out.println(ANSI_GREEN + "Wait for a second your Application is ready.............." + ANSI_RESET);

		try {
			Thread.sleep(1000);

		} catch (Exception e) {

		}

		System.out.println(
				"\n\n\t\t\t\t***********************Book Application | Library management system in spring boot***********************\t\t\t\t\t");
		System.out.println(
				"\t\t\t\t_____________________________________________________________________________________________________________________");
		System.out.println("\n\t\t\t\t\t\t\t\t Welcome to the iLibaray management system\t\t\t\t\t\n\n");
		System.out.println(ANSI_GREEN +
				" This is a console based book application written in java spring boot. It is very helpful for the college libaray to manage the books at"
				+ " a central palace where we easily fetched , add, delete and update the book by using some simple operation without malking much effort"
				+ ANSI_RESET);

	}

}
