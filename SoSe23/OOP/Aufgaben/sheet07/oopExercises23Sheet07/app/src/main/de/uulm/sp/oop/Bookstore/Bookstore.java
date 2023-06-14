package de.uulm.sp.oop.Bookstore;
import de.uulm.sp.oop.Bookstore.Exceptions.BookAlreadyPresentException;
import de.uulm.sp.oop.Bookstore.Exceptions.BookNotInStoreException;
;

import java.util.LinkedList;

public class Bookstore {
    private LinkedList<Book> inventory;

    public Bookstore() {
        inventory = new LinkedList<>();
    }

    public void addToAssortment(Book book){
        if(inventory.contains(book))throw new BookAlreadyPresentException(book, this);
        inventory.add(book);
    }

    public Book buyBook(Book book) throws BookNotInStoreException {
        if(!inventory.contains(book))throw new BookNotInStoreException(this, book);
        Book temp = inventory.get(inventory.indexOf(book));
        inventory.remove(book);
        return temp;
    }
}
