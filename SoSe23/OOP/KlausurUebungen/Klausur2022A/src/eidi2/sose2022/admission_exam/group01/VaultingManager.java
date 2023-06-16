package eidi2.sose2022.admission_exam.group01;

import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

import eidi2.sose2022.admission_exam.group01.util.Tuple;
import eidi2.sose2022.admission_exam.storage.IStoreable;
import eidi2.sose2022.admission_exam.storage.Vault;

public class VaultingManager {
	final List<Tuple<Bank, List<Vault<IStoreable>>>> banksAndVaults = new LinkedList<>();

	public Tuple<Bank, List<Vault<IStoreable>>> findBankTuple(Bank bankToFind){
		Optional<Tuple<Bank, List<Vault<IStoreable>>>> foundbank = banksAndVaults.stream().filter(s -> s.first.equals(bankToFind)).findFirst();
		return foundbank.orElse(null);
	}

	/**
	 * adds a Vault to the list of vaults associated with a bank
	 * @param bank for which to add the vault
	 * @param vaultToAdd
	 */
	public void addVaultForBank(Bank bank, Vault<IStoreable> vaultToAdd) {
		if(bank == null || vaultToAdd == null) {
			throw new IllegalArgumentException("Neither Bank nor vaultToAdd can be null!");
		}
			
		var bankTuple = findBankTuple(bank);
		
		if(bankTuple == null) {
			bankTuple = new Tuple<>(bank, new LinkedList<Vault<IStoreable>>());
			banksAndVaults.add(bankTuple);
		}
		bankTuple.second.add(vaultToAdd);
	}
	
	public boolean removeValueFromBankVault(Bank bankToFind, long vaultID, int valueToRemove) {
		int sum = 0;
		//Optional<Tuple<Bank, List<Vault<IStoreable>>>> toRemove = (banksAndVaults.stream().filter(s -> s.first.equals(bankToFind)).findFirst());

		Tuple<Bank, List<Vault<IStoreable>>> toRemove = findBankTuple(bankToFind);
		Optional<Vault<IStoreable>> vaultWithValue = toRemove.second.stream().filter(s -> s.getID() == vaultID).findFirst();
		if(vaultWithValue.isPresent())sum = vaultWithValue.get().getValue();
		return vaultWithValue.isPresent() && sum != vaultWithValue.get().removeValue(valueToRemove);
	}


	
}
