package test;

import de.uulm.in.pm.api.Train;
import de.uulm.in.pm.api.Waggon;

public class TrainTest {

    public static void main( String[] args){
        Train train1 = new Train(412, Train.Antrieb.ELEKTRISCH,13500,250,
                new Waggon(50,24,3, Waggon.Klasse.FIRST,true,
                        new Waggon(100,12,64, Waggon.Klasse.SECOND, true,
                                new Waggon(100,32,11, Waggon.Klasse.SECOND, true,
                                        new Waggon(50,17,3, Waggon.Klasse.FIRST,true, null)))));

        System.out.println(train1);
        System.out.println(train1.sumFreeSeats());
        train1.printTrain();
    }
}
