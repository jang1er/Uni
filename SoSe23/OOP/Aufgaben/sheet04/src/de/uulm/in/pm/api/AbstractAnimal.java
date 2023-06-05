package de.uulm.in.pm.api;

/** Abstract class for animals. */
public abstract class AbstractAnimal implements Ingestable, Moveable {

  protected static final int HUNGER_LIMIT = 10;

  protected final int legs;
  private int food;

  protected AbstractAnimal(int food, int legs) {
    this.food = food;
    this.legs = legs;
  }

  @Override
  public void eat() {
    this.food = this.food + 1;
  }

  @Override
  public void eat(int food) {
    for (int i = food; i > 0; i--) {
      eat();
    }
  }

  @Override
  public boolean isHungry() {
    return food <= HUNGER_LIMIT;
  }

  @Override
  public boolean isDead() {
    return food <= 0;
  }

  protected void burnFood() {
    this.food = this.food - 1;
  }

  protected void burnFood(int food) {
    for (int i = food; i > 0; i--) {
      burnFood();
    }
  }
}
