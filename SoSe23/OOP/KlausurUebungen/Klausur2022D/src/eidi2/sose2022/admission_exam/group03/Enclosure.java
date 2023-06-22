package eidi2.sose2022.admission_exam.group03;

import java.util.LinkedList;
import java.util.List;

import eidi2.sose2022.admission_exam.group03.animal.AAnimal;

public class Enclosure<T extends AAnimal> {
	public Class<T> enclosedAnimals;
	List<T> animals = new LinkedList<>();
	final int maxSize = 100;

	public Enclosure(Class<T> enclosedAnimalType) {
		this.enclosedAnimals = enclosedAnimalType;
	}

	public boolean addAnimal(T animal) {
		animals.add(animal);
		return true;
	}

	@Override
	public String toString() {
		return "Enclosure [enclosedAnimals=" + enclosedAnimals + ", animals=" + animals + ", maxSize=" + maxSize + "]";
	}
}
