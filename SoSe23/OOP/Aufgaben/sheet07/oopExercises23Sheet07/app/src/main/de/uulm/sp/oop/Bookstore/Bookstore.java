package de.uulm.sp.oop.Bookstore;
import de.uulm.sp.oop.Bookstore.Exceptions.BookAlreadyPresentException;
import de.uulm.sp.oop.Bookstore.Exceptions.BookNotInStoreException;
;

import java.util.HashMap;
import java.util.LinkedList;

public class Bookstore {
    private HashMap<String, Book> inventory;

    public Bookstore() {
        inventory = new HashMap<>();
    }

    public void addToAssortment(Book book){
        if(inventory.containsKey(book.getTitel()))throw new BookAlreadyPresentException(book, this);
        inventory.put(book.getTitel(),book);
    }

    public Book buyBook(Book book) throws BookNotInStoreException {
        if(!inventory.containsKey(book.getTitel()))throw new BookNotInStoreException(this, book);
        Book temp = inventory.get(book.getTitel());
        inventory.remove(book);
        return temp;
    }
}
