package eidi2.sose2022.admission_exam.group01;

import java.util.List;
import java.util.LinkedList;

import eidi2.sose2022.admission_exam.group01.util.Tuple;
import eidi2.sose2022.admission_exam.storage.IStoreable;
import eidi2.sose2022.admission_exam.storage.Vault;

public class VaultingManager {
	final List<Tuple<Bank, List<Vault<IStoreable>>>> banksAndVaults = new LinkedList<>();
	
	/**
	 * Searches for a bank and its associated vaults and returns both of them in the form of a tuple.
	 * @param bankToFind the bank for which a mapping tuple should be found
	 * @return Tuple containing the sought bank and a list of its associated Vaults or NULL if the bank does not exist in the mappings
	 */
	private Tuple<Bank, List<Vault<IStoreable>>> findBankTuple(Bank bankToFind) {
		return banksAndVaults.stream().filter(t -> t.first == bankToFind).findFirst().orElse(null);
	}
	
	public void addVaultForBank(Bank bank, Vault<IStoreable> vaultToAdd) {
		if( bank == null || vaultToAdd == null)throw new IllegalArgumentException("Bank or Vault is null");

		Tuple<Bank, List<Vault<IStoreable>>> bankForVault = findBankTuple(bank);
		if( bankForVault == null){
			// Bank not present -> create new Tuple
			List<Vault<IStoreable>> newVaultList = new LinkedList<>();
			newVaultList.add(vaultToAdd);
			banksAndVaults.add(new Tuple<>(bank, newVaultList));
		}else{
			// Bank is already present
			bankForVault.second.add(vaultToAdd);
		}
	}
	
	/**
	 * Searches for a vault with the passed ID.
	 * @param idToFind
	 * @return the vault with the passed ID or null if no such vault was found.
	 */
	Vault<IStoreable> findVaultWithID(long idToFind) {
		return banksAndVaults.stream().flatMap(t -> t.second.stream()).filter(v -> v.getID() == idToFind).findFirst().orElse(null);
	}
	
	public boolean addStoreableToBankVault(long vaultID, IStoreable storeableToAdd) {
		if(storeableToAdd == null)return false;

		Vault vaultToAddTo = findVaultWithID(vaultID);
		if(vaultToAddTo == null)return false;

		// Vault exists -> add Storable
		return vaultToAddTo.addStoreableToVault(storeableToAdd);
	}
}
