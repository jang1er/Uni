package eidi2.sose2022.admission_exam.group01;

import java.util.LinkedList;
import java.util.List;

import eidi2.sose2022.admission_exam.group01.util.Tuple;
import eidi2.sose2022.admission_exam.storage.IStoreable;
import eidi2.sose2022.admission_exam.storage.Vault;

public class Main {
	/**
	 * Docs: https://docs.oracle.com/javase/8/docs/api/overview-tree.html
	 */
	public static void main(String[] args) {
		// TODO: Use this to test your implementation
		testAddStorableToVault();
		testAddVaultForBank();
		testAddStoreableForBank();
	}
	
	public static void testAddStorableToVault() {
		var vault = new Vault<>(0);
		
		System.out.println(vault.addStoreableToVault(new Storeable(1)));
	}
	
	public static void testAddVaultForBank() {
		var vm = new VaultingManager();
		var initialLength = vm.banksAndVaults.size();
		
		vm.addVaultForBank(new Bank(vm), new Vault<>(0));
		System.out.println((initialLength+1 == vm.banksAndVaults.size()));
	}
	
	public static void testAddStoreableForBank() {
		var vm = new VaultingManager();
		var bank = new Bank(vm);
		var list = new LinkedList<Vault<IStoreable>>();
		var vault = new Vault<>(0);
		list.add(vault);
		Tuple<Bank, List<Vault<IStoreable>>> bankTuple = new Tuple<>(bank, list);
		vm.banksAndVaults.add(bankTuple);
		
		System.out.println(vm.addStoreableToBankVault(0, new Storeable(1)));
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