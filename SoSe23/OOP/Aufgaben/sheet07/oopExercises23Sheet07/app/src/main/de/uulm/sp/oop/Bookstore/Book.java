package de.uulm.sp.oop.Bookstore;

public class Book {

    private final String Titel;
    private final int Seiten;
    private final String[] content;

    public Book(String Titel, int Seiten, String[] content){
        this.Titel = Titel;
        this.Seiten = Seiten;
        this.content = new String[this.Seiten];
    }

    public String getTitel() {
        return Titel;
    }

    public int getSeiten() {
        return Seiten;
    }

    public String[] getContent() {
        return content;
    }
}
