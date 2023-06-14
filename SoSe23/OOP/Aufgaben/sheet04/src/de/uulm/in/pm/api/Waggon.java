package de.uulm.in.pm.api;

public class Waggon {

    // Class-Variables
    public int freeSeats, reservedSeats, allSeats;
    public final Klasse waggonClass;
    public final boolean isDoppelstock;
    public final Status Toilette;
    public boolean Licht;
    public Waggon next;


    public Waggon(){
        this.allSeats = 100;
        this.freeSeats = allSeats;
        this.reservedSeats = 0;
        this.waggonClass = Klasse.SECOND;
        this.isDoppelstock = false;
        if( 0.3 < (Math.random()*100)){
            this.Toilette = Status.DEFECT;
        }else { this.Toilette = Status.FREE;}
        if( (Math.random()*100)<50){ Licht = true;}else { Licht = false;}
        this.next = null;
    }

    public Waggon(int allSeats, int freeSeats, int reservedSeats, Klasse waggonClass, boolean isDoppelstock, Waggon next){
        this.allSeats = allSeats;
        this.freeSeats = freeSeats;
        this.reservedSeats = reservedSeats;
        this.waggonClass = waggonClass;
        this.isDoppelstock = isDoppelstock;
        this.next = next;
        if( 0.3 < (Math.random()*100)){
            this.Toilette = Status.DEFECT;
        }else { this.Toilette = Status.FREE;}
        if( (Math.random()*100)<50){ Licht = true;}else { Licht = false;}
        if ( allSeats < freeSeats + reservedSeats){
            throw new RuntimeException("Error: Free and reserved seats more than allSeats");
        }
    }

    public void LichtSchalter(){
        this.Licht = !Licht;
    }

    @Override
    public String toString(){
        return "Waggon[ Seats="+ allSeats +"/"+ freeSeats +"/"+reservedSeats+", Klasse=" + waggonClass+", Doppeldecker="+ isDoppelstock+", Licht=" + Licht+" ]";
    }

    public enum Klasse {
        FIRST,
        SECOND
    }
    public enum Status {
        FREE,
        USED,
        DEFECT
    }
}
