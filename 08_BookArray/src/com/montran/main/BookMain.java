package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Book;
import com.montran.util.BookUtil;

public class BookMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int bookAddCount = 10;
		BookUtil bookUtil = new BookUtil(10);
		Book book = null;
		int bookId;
		String name;
		double price;
		String Continuechoice;
		int choice;
		boolean result;
		Book[] bookArray = new Book[10];
		do {

			if (bookUtil.getAllBook()[0] == null) {
				System.out.println("No Books Present");

			} else {
				showBookInTabular(bookUtil.getAllBook());
			}

			System.out.println("Menu");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("1. Add Single Book");
			System.out.println("2. Add Multiple Books");
			System.out.println("3. Update Existing Book");
			System.out.println("4. Delete Existing Book");
			System.out.println("5. Print Single Book Details");
			System.out.println("6. Exit");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:

				System.out.println("Enter BookId");
				bookId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Book Name");
				name = scanner.nextLine();
				System.out.println("Enter Book Price");
				price = scanner.nextDouble();
				book = new Book(bookId, name, price);
				result = bookUtil.addNewBook(book);
				if (result) {
					bookAddCount = bookAddCount - 1;
					System.out.println("Successfully inserted");
				} else {
					System.out.println("No more space available");
				}
				break;
			case 2:
				System.out.println("How many books you want to add [max=" + bookAddCount + "]");
				int n = scanner.nextInt();
				if (bookAddCount >= n) {
					bookAddCount = bookAddCount - n;
					for (int i = 0; i < n; i++) {
						int j = i + 1;
						System.out.println("Enter Book " + j + " id");
						bookId = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter Book " + j + " name");
						name = scanner.nextLine();
						System.out.println("Enter Book " + j + " price");
						price = scanner.nextDouble();
						book = new Book(bookId, name, price);
						bookArray[i] = book;
					}
					result = bookUtil.addAllBooks(bookArray, n);
					if (result) {
						System.out.println("Successfully inserted");
					} else {
						System.out.println("No more space available");
					}
				} else {
					System.out.println("Not allowed");
				}
				break;
			case 3:
				System.out.println("Enter Book id for update");
				bookId = scanner.nextInt();
				book = bookUtil.getBookById(bookId);
				if (book == null) {
					System.out.println("No Book Found ");
				} else {
					scanner.nextLine();
					System.out.println("Enter Book Name");
					name = scanner.nextLine();
					System.out.println("Enter Book Price");
					price = scanner.nextDouble();
					result = bookUtil.updateBook(bookId, name, price);
					if (result) {
						System.out.println("Successfully updated");
					} else {
						System.out.println("Failed to update");
					}
				}
				break;
			case 4:
				System.out.println("Enter Book id for delete");
				bookId = scanner.nextInt();
				result = bookUtil.deleteBook(bookId);
				if (result) {
					System.out.println("Successfully deleted");
				} else {
					System.out.println("No book Found");
				}
				break;
			case 5:
				System.out.println("Enter book id");
				bookId = scanner.nextInt();
               book= bookUtil.getBookById(bookId);
				if (book != null) {
					System.out.println(book);
				} else {
					System.out.println("No Book Found");
				}
				break;
			case 6:
				System.out.println("Print Thank you !!");
				System.exit(0);

			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue yes - no ?");
			Continuechoice = scanner.next();
		} while (Continuechoice.toLowerCase().equals("yes"));
		scanner.close();
	}

	private static void showBookInTabular(Book[] allBook) {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.printf("%10s %30s %20s", "Book Id", "Name", "Price");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");

		for (Book book : allBook) {
			if (book != null) {
				System.out.format("%10d %30s %20f", book.getBookId(), book.getName(), book.getPrice());
				System.out.println();
			}

		}
		System.out.println("-----------------------------------------------------------------------------");

	}

}
