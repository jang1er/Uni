package main.java.de.uulm.sp.oop.exercises.e06.util;

/**
 * A Class that encompasses two values of generic types. Immutable as long as F and S are immutable.
 * 
 * @author stefan
 *
 * @param <F> The type of the first encompassed value.
 * @param <S> The type of the second encompassed value.
 */
public final class Pair<F extends Comparable<F>, S extends Comparable<S>>
    implements Comparable<Pair<F, S>> {

  private final F first;
  private final S second;

  /**
   * Generates hashCode of Pair based on hashCode implementations of F and S
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((first == null) ? 0 : first.hashCode());
    result = prime * result + ((second == null) ? 0 : second.hashCode());
    return result;
  }

  /**
   * Checks if a passed object is equal to this one.
   * 
   * @param obj Object to check equality to.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pair<?, ?> other = (Pair<?, ?>) obj;
    if (first == null) {
      if (other.first != null)
        return false;
    } else if (!first.equals(other.first))
      return false;
    if (second == null) {
      if (other.second != null)
        return false;
    } else if (!second.equals(other.second))
      return false;
    return true;
  }

  /**
   * @return String representation of pair.
   */
  @Override
  public String toString() {
    return "(" + first.toString() + "," + second.toString() + ")";
  }

  /**
   * Generates a pair.
   * 
   * @param first Value of first field.
   * @param second Value of second field.
   */
  public Pair(F first, S second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Returns the first field. WARNING: If F is not a primitive this will return a reference to the
   * contained first field.
   * 
   * @return Value of first field.
   */
  public F getFirst() {
    return first;
  }

  /**
   * Returns the second field. WARNING: If S is not a primitive this will return a reference to the
   * contained second field.
   * 
   * @return Value of second field.
   */
  public S getSecond() {
    return second;
  }

  /**
   * Compare passed pair. The first field is weighted heavier than the second field.
   * 
   * @param pairToCompare The pair which to which comparison should be done.
   */
  @Override
  public int compareTo(Pair<F, S> pairToCompare) {
    F firstToCompare = pairToCompare.first;
    S secondToCompare = pairToCompare.getSecond();

    int firstCompared = first.compareTo(firstToCompare);
    int secondCompared = second.compareTo(secondToCompare);

    return (firstCompared != 0) ? firstCompared : secondCompared;
  }

}
