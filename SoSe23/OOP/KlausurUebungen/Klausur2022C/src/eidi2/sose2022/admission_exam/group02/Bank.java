package eidi2.sose2022.admission_exam.group02;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import eidi2.sose2022.admission_exam.exceptions.NoSuchVaultException;
import eidi2.sose2022.admission_exam.storage.IStoreable;
import eidi2.sose2022.admission_exam.storage.Vault;

public class Bank implements PropertyChangeListener {
	List<Vault<IStoreable>> knownVaults = new LinkedList<>();
	List<Vault<IStoreable>> foreignVaults = new LinkedList<>();
	PropertyChangeSupport support;
	
	public Bank() {
		support = new PropertyChangeSupport(this);
	}
	
	public void newBank(Bank bank) {
		support.addPropertyChangeListener(bank);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt == null)return;
		Object obj = evt.getSource();
		if( this != obj){
			Vault<IStoreable> vaultToAdd = (Vault<IStoreable>) evt.getNewValue();
			if(vaultToAdd == null) return;
			foreignVaults.add(vaultToAdd);

		}
	}
	
	public void addVault(Vault<IStoreable> vaultToAdd) {
		if(vaultToAdd == null)throw new IllegalArgumentException("vault is null");

		knownVaults.add(vaultToAdd);

		new PropertyChangeEvent(this,"", null, vaultToAdd);
	}
	
	/**
	 * Aggregates known and foreign vaults for easy access.
	 * @return A list containing all elements of both knownVaults and foreignVaults.
	 */
	private List<Vault<IStoreable>> getAllVaults() {
		var allVaults = new LinkedList<>(knownVaults);
		allVaults.addAll(foreignVaults);
		return allVaults;
	}
	
	/**
	 * Calculates the value of a vault given its ID
	 * @param vaultID
	 * @return The value of all contents of a vault, if the vault exists. Otherwise throws a NoSuchVaultException.
	 */
	public int getVaultValue(long vaultID) {
		var allVaults = getAllVaults();
		
		for(Vault<IStoreable> v: allVaults) {
			if(v.getID() == vaultID) {
				return v.getValue();
			}
		}
		
		throw new NoSuchVaultException("No vault with ID: " + vaultID + " exists!");
	}
	
	public boolean addStoreableToBankVault(long vaultID, IStoreable storeableToAdd) {
		if(storeableToAdd == null)return false;
		List<Vault<IStoreable>> allVaults = getAllVaults();
		Optional<Vault<IStoreable>> vault = allVaults.stream().filter(s -> s.getID() == vaultID).findFirst();

		if(vault.isEmpty())return false;
		return vault.get().addStoreableToVault(storeableToAdd);
	}
	
	public boolean removeValue(long vaultID, int valueToRemove) {
		Optional<Vault<IStoreable>> vault = knownVaults.stream().filter(s -> s.getID() == vaultID).findFirst();

		if(vault.isEmpty())return false;
		Vault<IStoreable> vaultReal = vault.get();
		int sum = vaultReal.getValue();
		return sum > vaultReal.removeValue(valueToRemove);

	}
}
