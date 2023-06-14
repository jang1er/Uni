package de.uulm.in.pm.api;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {
private static Train train1;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        train1 = new Train(412, Train.Antrieb.ELEKTRISCH,13500,250,
                new Waggon(50,24,3, Waggon.Klasse.FIRST,true,
                        new Waggon(100,12,64, Waggon.Klasse.SECOND, true,
                                new Waggon(100,32,11, Waggon.Klasse.SECOND, true,
                                        new Waggon(50,17,3, Waggon.Klasse.FIRST,true, null)))));

    }

    @org.junit.jupiter.api.Test
    void sumFreeSeats() {
        assertEquals(85,train1.sumFreeSeats());
    }
    @org.junit.jupiter.api.Test
    void LichtSchalter(){
        Waggon temp = train1.next;
        while (temp != null) {
            boolean licht = temp.Licht;
            temp.LichtSchalter();
            assertEquals(!licht, temp.Licht);
            temp = temp.next;
        }
    }
}