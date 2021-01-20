package main;

public class Board {

	public static final String SYMBOL_O = "O";
	public static final String SYMBOL_X = "X";

	private static final String SYMBOL_NOT_SET = null;

	private String[][] field;

	public Board() {
		field = new String[3][3];
	}
	
	public String[][] getField() {
		return field;
	}

	public void setMark(String mark, int x, int y) throws InvalidPositionException {
		if (mark.equalsIgnoreCase(SYMBOL_X) || mark.equalsIgnoreCase(SYMBOL_O)) {

			if (x < 0 || x > 2 || y < 0 || y > 2) {
				throw new InvalidPositionException("Invalid position: " + x + ", " + y);
			}

			if (field[x][y] == SYMBOL_NOT_SET) {
				field[x][y] = mark;
			} else {
				throw new InvalidPositionException("This place is already used by the mark " + field[x][y]);
			}

		} else {
			throw new InvalidPositionException("Invalid mark!");
		}
	}

	public boolean hasWinner() {

		if (checkColumn() || checkRow() || checkDiagonale())
			return true;

		return false;
	}

	private boolean checkColumn() {
		for (int i = 0; i < 3; i++) {
			if (field[i][0] == (field[i][1]) && field[i][1] == (field[i][2])
					&& field[i][2] != (SYMBOL_NOT_SET))
				return true;
		}
		return false;
	}

	private boolean checkRow() {
		for (int i = 0; i < 3; i++) {
			if (field[0][i] == (field[1][i]) && field[1][i] == (field[2][i])
					&& field[2][i] != (SYMBOL_NOT_SET))
				return true;
		}
		return false;
	}

	private boolean checkDiagonale() {

		if (field[0][0] == (field[1][1]) && field[1][1] == (field[2][2])
				&& field[1][1] != (SYMBOL_NOT_SET))
			return true;

		if (field[0][2] == (field[1][1]) && field[1][1] == (field[2][0])
				&& field[1][1] != (SYMBOL_NOT_SET))
			return true;

		return false;
	}

}
