package it.unibo.oop.lab.exception2;

@SuppressWarnings("serial")
public class NotEnoughFoundsException  extends IllegalStateException {
	
	@Override
	public String toString() {
		return "Not enought founds in the user's balance";
	}

}
