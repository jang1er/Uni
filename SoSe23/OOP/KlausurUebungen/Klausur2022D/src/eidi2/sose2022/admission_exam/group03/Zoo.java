package eidi2.sose2022.admission_exam.group03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import eidi2.sose2022.admission_exam.group03.animal.AAnimal;
import eidi2.sose2022.admission_exam.group03.animal.CanFly;
import eidi2.sose2022.admission_exam.group03.animal.Raven;
import eidi2.sose2022.admission_exam.group03.animal.Tiger;

public class Zoo {
	HashMap<Trainer<AAnimal>, List<Enclosure<AAnimal>>> trainings = new HashMap<>();;
	
	public <T extends AAnimal> void addEnclosureForTrainer(Trainer<T> trainer, Enclosure<T> enclosureToAdd) {
		if(enclosureToAdd == null)throw new IllegalArgumentException();
		if(!trainings.containsKey(trainer)){
			trainings.put((Trainer<AAnimal>) trainer, new LinkedList<>());
		}

		trainings.get(trainer).add((Enclosure<AAnimal>) enclosureToAdd);
	}

	
	public <T extends AAnimal & CanFly> int countLegsOnGroundInAllEnclosures(Trainer<T> trainer) {
		List<Enclosure<AAnimal>> enclosures = trainings.get(trainer);
		List<Enclosure<AAnimal>> withRavens = enclosures.stream().filter(s -> s.enclosedAnimals.equals(Raven.class)).toList();
		if(withRavens == null)return 0;
		return withRavens.stream().mapToInt(s ->s.animals.stream().filter( $ -> $ instanceof Raven).map(r -> (Raven) r).filter($ -> !$.isAirborne()).mapToInt($ -> $.getLegCount()).sum()).sum();
	}
	
	public void gutAllTigers() {
		List<List<Enclosure<AAnimal>>> enclosures = new LinkedList<>(trainings.values());

		List<Enclosure<AAnimal>> tigerEnclosure = new LinkedList<>();
		for ( List<Enclosure<AAnimal>> x : enclosures){
			for( Enclosure<AAnimal> e : x){
				if(e.enclosedAnimals.equals(Tiger.class))tigerEnclosure.add(e);
			}
		}
		for ( Enclosure<AAnimal> x : tigerEnclosure){
			for ( AAnimal t : x.animals){
				t.setLegCount(0);
			}

		}
	}

	@Override
	public String toString() {
		return "Zoo [trainings=" + trainings + "]";
	}
}
