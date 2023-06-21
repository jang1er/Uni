package eidi2.sose2022.admission_exam.storage;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Vault<T extends IStoreable> {
	private final long ID;
	List<T> contents = new LinkedList<>();
	
	public Vault(long id) {
		this.ID = id;
	}
	
	public long getID() {
		return ID;
	}
	
	/**
	 * Calculates the sum of all values contained within the vault and returns it.
	 * @return The sum of all contained values.
	 */
	public int getValue() {
		return contents.stream().flatMapToInt(s -> IntStream.of(s.value())).sum();
	}
	
	/**
	 * Adds a Storeable to the Vault if the storeables value is larger than 0
	 * @param value a non-null Storeable
	 * @return if adding the storeable succeeded
	 */
	public boolean addStoreableToVault(T value) {
		if (value == null || value.value() <= 0) {
			return false;
		}
		contents.add(value);
		return true;
	}
	
	/**
	 * Removes an Element with the given value form the vault
	 * @param value
	 * @return
	 */
	public int removeValue(int value) {
		for (T t : contents) {
			if (t.value() == value) {
				contents.remove(t);
				return this.getValue();
			}
		}
		return this.getValue();
	}
	
}
