package main;

@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {

	public InvalidPositionException(String errorMessage) {
		super(errorMessage);
	}

}
