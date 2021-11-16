package edu.evacodekitchen.javabasics.bank;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

	private Integer money;
	private LocalDate date;

	public Transaction(Integer money, LocalDate date) {
		super();
		this.money = money;
		this.date = date;
	}

	public int getMoney() {
		return money;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, money);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(date, other.date) && Objects.equals(money, other.money);
	}

}
