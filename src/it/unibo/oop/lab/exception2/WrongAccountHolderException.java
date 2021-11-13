package it.unibo.oop.lab.exception2;

@SuppressWarnings("serial")
public class WrongAccountHolderException extends IllegalArgumentException {
	
	private final String message;

	public WrongAccountHolderException(final String message) {
		super();
		this.message = message;
	}

}
