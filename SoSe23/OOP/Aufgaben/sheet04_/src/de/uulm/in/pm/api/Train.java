package de.uulm.in.pm.api;

public class Train {

    public final int baureihe;
    public final Antrieb Motor;
    public int ps;
    public int max_geschwindigkeit;
    public Waggon next;

    public Train(){
        this.baureihe = 412;
        this.Motor = Antrieb.ELEKTRISCH;
        this.ps = 2000;
        this.max_geschwindigkeit = 220;
        this.next = null;
    }

    public Train( int baureihe, Antrieb Motor,int ps, int max_geschwindigkeit, Waggon next){
        this.baureihe = baureihe;
        this.Motor = Motor;
        this.ps = ps;
        this.max_geschwindigkeit = max_geschwindigkeit;
        this.next = next;
    }

    public int sumFreeSeats(){
        int sum = 0;
        Waggon temp = next;
        while(temp != null){
            sum += temp.freeSeats;
            temp = temp.next;
        }
        return sum;
    }

    public void printTrain(){
        Waggon temp = next;
        System.out.println(this);
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public enum Antrieb{
        DIESEL,
        ELEKTRISCH
    }

    @Override
    public String toString(){
        return "Train[ Baureihe=" + baureihe + ", Antrieb=" + Motor + "(" + ps + "ps), Max. Geschw.=" + max_geschwindigkeit + "km/h ]";
    }
}
