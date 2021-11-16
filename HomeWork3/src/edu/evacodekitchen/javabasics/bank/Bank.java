package edu.evacodekitchen.javabasics.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Bank {

	private List<Account> accounts;

	public Bank() {
		super();
		accounts = new ArrayList<>();
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public List<Account> getPremiumAccounts() {
		List<Account> searchPremiumAcc = accounts.stream().filter(account -> account.getBalance() > 12000)
				.collect(Collectors.toList());
		return searchPremiumAcc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounts);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(accounts, other.accounts);
	}

}
