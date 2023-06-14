package de.uulm.in.pm.api;

import static org.junit.jupiter.api.Assertions.*;

class WaggonTest {


    @org.junit.jupiter.api.Test
    void RunTimeExceptionTest(){
        RuntimeException re = assertThrows(RuntimeException.class, () -> {new Waggon(100,80,40, Waggon.Klasse.FIRST, true, null);} );
        assertEquals("Error: Free and reserved seats more than allSeats", re.getMessage());
    }
}