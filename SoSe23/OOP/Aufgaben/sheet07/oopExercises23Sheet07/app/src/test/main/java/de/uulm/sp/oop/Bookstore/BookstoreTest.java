package main.java.de.uulm.sp.oop.Bookstore;

import de.uulm.sp.oop.Bookstore.Book;
import de.uulm.sp.oop.Bookstore.Bookstore;
import de.uulm.sp.oop.Bookstore.Exceptions.BookAlreadyPresentException;
import de.uulm.sp.oop.Bookstore.Exceptions.BookNotInStoreException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookstoreTest {
    private Bookstore store;
    @BeforeEach
    void setUp() {
        store = new Bookstore();
        store.addToAssortment(new Book("Exmatrikulation ganz einfach", 355, new String[355]));
        store.addToAssortment(new Book("VHDL. Warum? Teil 1", 1000, new String[1000]));
        store.addToAssortment(new Book("How to: uninstall VHDL", 20, new String[20]));

    }

    @Test
    void addToAssortment() {
        assertThrows(BookAlreadyPresentException.class, () -> store.addToAssortment(new Book("Exmatrikulation ganz einfach", 355, new String[355])));
    }

    @Test
    void buyBook() {
        //assertEquals(new Book("How to: uninstall VHDL", 20, new String[20]), store.buyBook(new Book("How to: uninstall VHDL", 20, new String[20])));
        assertThrows(BookNotInStoreException.class, () -> store.buyBook(new Book("How to: uninstall Haskell", 33, new String[33])));
    }
}