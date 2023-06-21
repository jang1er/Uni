package eidi2.sose2022.admission_exam.group01;

import eidi2.sose2022.admission_exam.storage.IStoreable;
import eidi2.sose2022.admission_exam.storage.Vault;

public class Bank {
	private final VaultingManager REGISTRY;
	
	public Bank(VaultingManager registry) {
		this.REGISTRY = registry;
	}
	
	public void addVault(Vault<IStoreable> vaultToAdd) {
		REGISTRY.addVaultForBank(this, vaultToAdd);
	}
	
	public void addStoreableToVault(long vaultID, IStoreable storeable) {
		REGISTRY.addStoreableToBankVault(vaultID, storeable);
	}
	
}
