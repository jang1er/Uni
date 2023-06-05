package sheet04.test;

import sheet04.src.de.uulm.in.pm.api.AbstractBird;
import sheet04.src.de.uulm.in.pm.api.Eagle;

/** Main class. */
public class Main {

  /** Run tests. */
  public static void main(String[] args) {//
    // AbstractBird tweety = new AbstractBird(100,2);
    // Methoden müssen zuerst implementiert werden, da Abstrakte Klasse

    Eagle amos = new Eagle(100, "Amos");
    System.out.println(amos);
    Eagle amos2 = new Eagle(100 , "Amos");
    System.out.println(amos == amos2);
    // false
    System.out.println(amos.equals(amos2));
    // fals, keine eigene equals methode zum vergleich

  }
}
