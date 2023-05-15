package sheet03;

class Karteikarte{

    private String vorderseite;
    private String rueckseite;


    //Konstruktor
    public Karteikarte(String vorderseite, String rueckseite){
        this.vorderseite = vorderseite;
        this.rueckseite = rueckseite;
    }


    public static void main(String[] args) {
        
        Karteikarte k1 = new Karteikarte("kompakte Menge",
                "Eine Menge heißt _kompakt_, wenn sie abgeschlossen und beschränkt ist\n Beispiel: [0,1]");

        Karteikarte k2 = new Karteikarte("kompakte Menge",
                "Eine Menge heißt _kompakt_, wenn sie abgeschlossen und beschränkt ist\n Beispiel: [0,1]");

        Karteikarte k3 = new Karteikarte("Eine Menge heißt _kompakt_, wenn sie abgeschlossen und beschränkt ist\n Beispiel: [0,1]", "kompakte Menge");

        Karteikarte k4 = new Karteikarte("Wilde Moehre",
                "Die Wilde Möhre ist ein Doldenblütler und ein Elternteil der Karotte.");

        System.out.println(k1);
        System.out.println(k1.equals(k2));
        System.out.println(k1.equals(k3));
        System.out.println(k1.equals(k4));
    }

    //TODO: c)
    //TODO: d)
}


/*
Antwort zu a)


Antwort zu b)


Eine Antwort zu c) ist hier nicht noetig


Antwort zu d)


*/