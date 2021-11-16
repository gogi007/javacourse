package edu.evacodekitchen.javabasics.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Account {

	private String owner;
	private String id;
	private List<Transaction> transactions;

	public Account(String owner, String id) {
		this.owner = owner;
		this.id = id;
		transactions = new ArrayList<>();
	}

	public int getBalance() {
		Integer sum = transactions.stream().mapToInt(x -> x.getMoney()).sum();
		return sum;
	}

	public void doTransaction(int amount, LocalDate date) {
		Integer sum = getBalance();
		if ((sum + amount) < 0) {
			throw new TooLowBalanceException();
		} else {
			transactions.add(new Transaction(amount, date));
		}
	}

	public List<Transaction> getTransactionsFor(LocalDate date) {
		List<Transaction> searchTransaction = transactions.stream()
				.filter(transaction -> date.equals(transaction.getDate())).collect(Collectors.toList());
		return searchTransaction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, owner);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(id, other.id) && Objects.equals(owner, other.owner);
	}

}
