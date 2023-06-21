package eidi2.sose2022.admission_exam.group02;

import java.beans.PropertyChangeEvent;

import eidi2.sose2022.admission_exam.storage.IStoreable;
import eidi2.sose2022.admission_exam.storage.Vault;

public class Main {

	/**
	 * Docs: https://docs.oracle.com/javase/8/docs/api/overview-tree.html
	 */
	public static void main(String[] args) {
		// TODO: Use this to test your implementation
		testPropertyChange();
		testAddVault();
		testAddStoreableToBankVault();
		testRemoveVaule();
	}
	
	public static void testPropertyChange() {
		var bank = new Bank();
		var vault = new Vault<>(0);
		var pce = new PropertyChangeEvent(new Bank(), "knownVaults", null, vault);
		
		int sizeKnownVaultsPre = bank.knownVaults.size();
		int sizeForeignVaultsPre = bank.foreignVaults.size();
		
		bank.propertyChange(pce);
		
		System.out.println(sizeKnownVaultsPre == bank.knownVaults.size());
		System.out.println(sizeForeignVaultsPre + 1 == bank.foreignVaults.size());
	}
	
	public static void testAddVault() {
		var bank = new Bank();
		var vault = new Vault<>(0);
		
		int sizeKnownVaultsPre = bank.knownVaults.size();
		int sizeForeignVaultsPre = bank.foreignVaults.size();
		
		bank.addVault(vault);
		System.out.println(sizeKnownVaultsPre + 1 == bank.knownVaults.size());
		System.out.println(sizeForeignVaultsPre == bank.foreignVaults.size());
	}
	
	public static void testAddStoreableToBankVault() {
		var bank = new Bank();
		var vault = new Vault<>(0);
		bank.foreignVaults.add(vault);
		
		System.out.println(bank.addStoreableToBankVault(0, new Storeable(1)));
		System.out.println(1 == vault.getValue());
	}
	
	public static void testRemoveVaule() {
		var bank = new Bank();
		var vault = new Vault<>(0);
		vault.addStoreableToVault(new Storeable(1));
		bank.knownVaults.add(vault);
		
		System.out.println(bank.removeValue(0, 1));
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

