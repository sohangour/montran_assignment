package com.book.pojo;

public class Book {
	private int bookNo;
	private String bookTitle;
	private double price;

	private double totalCost(int n) {
		return price * n;
	}

	public void input(int bookNo, String bookTitle, double price) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.price = price;
	}

	public double purchase(int n) {
		return totalCost(n);
	}

	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", price=" + price + "]";
	}

}
