package it.unibo.oop.lab.exception2;

@SuppressWarnings("serial")
public class WrongAccountHolderException extends IllegalArgumentException {
	

	public WrongAccountHolderException() {
		super();
	}

	@Override
	public String toString() {
		return "Unauthorized account";
	}
	
}