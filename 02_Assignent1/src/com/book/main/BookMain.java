package com.book.main;

import java.util.Scanner;

import com.book.pojo.Book;

public class BookMain {

	public static void main(String[] args) {
		Book book = new Book();
		Scanner sc = new Scanner(System.in);
		book.input(121, "Java", 1250);
		System.out.println(book);
		System.out.println("Enter number of copies you want");
		int n = sc.nextInt();
		if (n > 0) {
              System.out.println("Bill Amount is:"+book.purchase(n));
		} else {
			System.out.println("Enter Valid number");
		}
	}

}
