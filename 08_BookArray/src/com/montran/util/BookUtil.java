package com.montran.util;

import com.montran.pojo.Book;

public class BookUtil {
	private Book[] books;
	int count = 0, length;

	public BookUtil(int length) {
		books = new Book[length];
		this.length = length;
	}

	public boolean addNewBook(Book book) {
		if (count < length) {
			books[count++] = book;
			return true;
		}
		return false;
	}

	public boolean addAllBooks(Book[] bookArray, int n) {
		int i;
		for (i = 0; i < n; i++) {
			books[count++] = bookArray[i];
		}
		if (i == n) {
			return true;
		}
		return false;
	}

	public boolean updateBook(int bookId, String newName, double newPrice) {
		for (Book book : books) {

			if (book != null && book.getBookId() == bookId) {
				book.setName(newName);
				book.setPrice(newPrice);
				return true;
			}
		}
		return false;
	}

	public boolean deleteBook(int bookId) {
		for (Book book : books) {
			if (book != null && book.getBookId() == bookId) {
				book = null;
				return true;
			}
		}
		return false;
	}

	public Book getBookById(int bookId) {
		for (Book book : books) {
			if (book != null && book.getBookId() == bookId) {
				return book;
			}
		}
		return null;
	}

	public Book[] getAllBook() {
		return books;
	}
}
