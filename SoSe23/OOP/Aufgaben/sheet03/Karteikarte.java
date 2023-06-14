package sheet03;

class Karteikarte{

    private String vorderseite;
    private String rueckseite;

    @Override
    public String toString(){
        return "Vorderseite: " + vorderseite + "\nRückseite: " + rueckseite;
    }

    @Override
    public int hashCode() {
        return ( vorderseite.hashCode() + rueckseite.hashCode());
    }

    public boolean equals(Karteikarte obj) {
        return ( this.hashCode() == obj.hashCode());
    }

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
Die Funktion hashCode() gibt einen 4-stelligen Integerwert zurück, welcher die Speicherzelle des Objektes repräsentiert;
equals() vergleicht in der Standardimplementierung den Wert der Speicherzellen zweier Obkj́ekte.
Wenn eine der beiden Funktion selber definiert wird, sollte auch die andere angepasst werden.
toString() benutzt in der Standardimplementierung auch die Funktion hashCode(), wodurch nur der Speicherzellen-Ort angegeben wird.

Antwort zu b)
Sobald System.out.println() mit einem Objekt aufgerufen wird, wird implizit die .toString()-Methode aufgerufen
System.out.println(obj); => System.out.println(obj.toString());

Eine Antwort zu c) ist hier nicht noetig


Antwort zu d)


*/