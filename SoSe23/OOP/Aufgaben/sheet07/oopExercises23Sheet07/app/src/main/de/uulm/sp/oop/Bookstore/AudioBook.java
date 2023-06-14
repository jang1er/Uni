package de.uulm.sp.oop.Bookstore;

public class AudioBook extends Book {

    private double listenDuration;
    private String readerName;


    public AudioBook(String Titel, int Seiten, String[] content, double listenDuration, String readerName) {
        super(Titel, Seiten, content);
        this.listenDuration = listenDuration;
        this.readerName = readerName;
    }

    public double getListenDuration() {
        return listenDuration;
    }

    public String getReaderName() {
        return readerName;
    }


}
