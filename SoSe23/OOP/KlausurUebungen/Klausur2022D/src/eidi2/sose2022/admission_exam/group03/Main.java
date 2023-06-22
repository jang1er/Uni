package eidi2.sose2022.admission_exam.group03;

import eidi2.sose2022.admission_exam.group03.animal.AAnimal;
import eidi2.sose2022.admission_exam.group03.animal.Raven;
import eidi2.sose2022.admission_exam.group03.animal.Tiger;
import eidi2.sose2022.admission_exam.group03.util.Sex;

public class Main {

	public static void main(String[] args) {
		var tigerEnc = new Enclosure<>(Tiger.class);
		var ravenEnc = new Enclosure<>(Raven.class);
		var greg = new Trainer<>(Tiger.class);
		var amelie = new Trainer<>(Raven.class);
		var zoo = new Zoo();
		
		var t1 = new Tiger(4, Sex.MALE);
		var t2 = new Tiger(4, Sex.FEMALE);
		var r1 = new Raven(2, Sex.OTHER);
		var r2 = new Raven(2, Sex.OTHER);
		
		tigerEnc.addAnimal(t1);
		tigerEnc.addAnimal(t2);
		ravenEnc.addAnimal(r1);
		ravenEnc.addAnimal(r2);
		
		zoo.addEnclosureForTrainer(greg, tigerEnc);
		zoo.addEnclosureForTrainer(amelie, ravenEnc);
		
		System.out.println("raven legs ammelie:");
		System.out.println(zoo.countLegsOnGroundInAllEnclosures(amelie));
		r1.takeOff();
		System.out.println("raven legs ammelie after takeoff:");
		System.out.println(zoo.countLegsOnGroundInAllEnclosures(amelie));
		
		System.out.println("legs zoo:");
		System.out.println(countLegsOf(zoo, AAnimal.class));
		System.out.println(countLegsOf(zoo, Raven.class));
		System.out.println(countLegsOf(zoo, Tiger.class));
		zoo.gutAllTigers();
		System.out.println("gutted");
		System.out.println(countLegsOf(zoo, AAnimal.class));
		System.out.println(countLegsOf(zoo, Raven.class));
		System.out.println(countLegsOf(zoo, Tiger.class));
		
	}
	
	private static <T extends AAnimal> int countLegsOf(Zoo zoo, Class<T> clazz) {
		var legCount = 0;
		return zoo.trainings.values().stream().flatMap($ -> $.stream()).flatMap($ -> $.animals.stream()).filter($ -> clazz.isAssignableFrom($.getClass())).mapToInt($ -> $.getLegCount()).sum();
	}
}
