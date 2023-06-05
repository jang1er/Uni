package de.uulm.in.pm.api;

/** Things that can be eaten. */
public interface Ingestable {

  public void eat();

  public void eat(int food);

  public boolean isHungry();

  public boolean isDead();
}
