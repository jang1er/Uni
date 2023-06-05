package de.uulm.in.pm.api;

/** Abstract class for birds. */
public abstract class AbstractBird extends AbstractAnimal implements Flyable {

  protected final int wings;
  private boolean inTheAir;

  /**
   * Bird with two legs.
   * 
   * @param food How fed is the bird
   * @param wings How many wings does it have
   */
  protected AbstractBird(int food, int wings) {
    super(food, 2);
    this.wings = wings;
    this.inTheAir = false;
  }

  @Override
  public boolean isFlying() {
    return inTheAir;
  }

  @Override
  public void land() {
    inTheAir = false;
  }

  @Override
  public void takeOff() {
    inTheAir = true;
  }
}
