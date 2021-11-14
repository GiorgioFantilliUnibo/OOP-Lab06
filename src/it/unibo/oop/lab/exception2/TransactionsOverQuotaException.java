package it.unibo.oop.lab.exception2;

@SuppressWarnings("serial")
public class TransactionsOverQuotaException extends IllegalStateException {

	@Override
	public String toString() {
		return "Reached the maximum number of available transactions";
	}
	
}
