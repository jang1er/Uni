package de.uulm.sp.oop.Bookstore.Exceptions;

import de.uulm.sp.oop.Bookstore.Bookstore;
import de.uulm.sp.oop.Bookstore.Book;

public class BookNotInStoreException extends Exception{
    public  BookNotInStoreException(Bookstore store, Book book){
        super("The Book: " + book.getTitel() + " is not available in the store: " + store);
    }

}
