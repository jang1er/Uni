package eidi2.sose2022.admission_exam.group03;

import eidi2.sose2022.admission_exam.group03.animal.AAnimal;

public class Trainer<T extends AAnimal> {
	public Class<T> trainedAnimal;
	
	public Trainer(Class<T> trainedAnimalType) {
		this.trainedAnimal = trainedAnimalType;
	}

	@Override
	public String toString() {
		return "Trainer [trainedAnimal=" + trainedAnimal + "]";
	}
}
