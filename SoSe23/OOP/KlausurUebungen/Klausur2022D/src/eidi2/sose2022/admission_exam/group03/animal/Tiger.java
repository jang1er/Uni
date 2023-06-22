package eidi2.sose2022.admission_exam.group03.animal;

import eidi2.sose2022.admission_exam.group03.util.Sex;

public class Tiger extends AAnimal {

	public Tiger(int legCount, Sex sex) {
		super(legCount, sex);
	}

	@Override
	public String toString() {
		return "Tiger [legCount=" + legCount + ", sex=" + sex + "]";
	}

}
