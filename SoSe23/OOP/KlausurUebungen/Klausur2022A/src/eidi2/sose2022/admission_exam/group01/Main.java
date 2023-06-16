package eidi2.sose2022.admission_exam.group01;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import eidi2.sose2022.admission_exam.group01.util.Tuple;
import eidi2.sose2022.admission_exam.storage.IStoreable;
import eidi2.sose2022.admission_exam.storage.Vault;

public class Main {

	/**
	 * Docs: https://docs.oracle.com/javase/8/docs/api/overview-tree.html
	 */
	public static void main(String[] args) {
		// Use these methods (and more) to test your implementation
		testFindBankTuple();
		testRemoveVaultValue();
		testremoveValueFromBankVault();
	}
	
	public static void testFindBankTuple() {
		var vm = new VaultingManager();
		var bank = new Bank(vm);
		Tuple<Bank, List<Vault<IStoreable>>> bankTuple = new Tuple<>(bank, new LinkedList<Vault<IStoreable>>());
		vm.banksAndVaults.add(bankTuple);
		
		System.out.println(bank.equals(vm.findBankTuple(bank).first));
	}
	
	public static void testRemoveVaultValue() {
		var vault = new Vault<>(0);
		vault.addStoreableToVault(new Storeable(10));
		vault.addStoreableToVault(new Storeable(20));
		
		System.out.println(20 == vault.removeValue(10));
	}
	
	public static void testremoveValueFromBankVault() {
		var vm = new VaultingManager();
		var bank = new Bank(vm);
		var list = new LinkedList<Vault<IStoreable>>();
		var vault = new TestVault<>(0);
		vault.contents.add(new Storeable(10));
		vault.contents.add(new Storeable(20));
		list.add(vault);
		list.add(new Vault<>(1));
		Tuple<Bank, List<Vault<IStoreable>>> bankTuple = new Tuple<>(bank, list);
		vm.banksAndVaults.add(bankTuple);
		
		System.out.println(vm.removeValueFromBankVault(bank, 0, 10));
	}
}

class TestVault<T extends IStoreable> extends Vault<T> {

	List<T> contents = new LinkedList<>();
	
	public TestVault(long id) {
		super(id);
	}
	
	public int removeValue(int value) {
		for (T t : contents) {
			if (t.value() == value) {
				contents.remove(t);
				return this.getValue();
			}
		}
		return this.getValue();
	}
	
	public int getValue() {
		return contents.stream().flatMapToInt(s -> IntStream.of(s.value())).sum();
	}
	
}

class Storeable implements IStoreable {
	int value;
	
	public Storeable(int value) {
		this.value=value;
	}

	@Override
	public int value() {
		return value;
	}
	
}
