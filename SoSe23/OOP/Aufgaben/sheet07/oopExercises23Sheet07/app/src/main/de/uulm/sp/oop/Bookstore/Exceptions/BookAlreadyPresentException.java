package de.uulm.sp.oop.Bookstore.Exceptions;

import de.uulm.sp.oop.Bookstore.Book;
import de.uulm.sp.oop.Bookstore.Bookstore;

public class BookAlreadyPresentException extends RuntimeException{
    public BookAlreadyPresentException(Book book, Bookstore store) {
        super("This Book: " + book.getTitel() + " is already present in store: " + store);
    }
}
