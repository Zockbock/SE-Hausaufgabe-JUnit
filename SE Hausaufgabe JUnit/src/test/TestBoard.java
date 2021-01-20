package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Board;
import main.InvalidPositionException;

public class TestBoard {

	Board board = new Board();

	@Test
	public void testSetMark() {
		try {
			board.setMark(Board.SYMBOL_X, 0, 0);

			assertEquals("X", board.getField()[0][0].toString());
			
			board.setMark(Board.SYMBOL_O, 1, 1);

			assertEquals("O", board.getField()[1][1].toString());
			
			assertNull(board.getField()[2][2]);
			
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = InvalidPositionException.class)
	public void testException() throws InvalidPositionException {
		board.setMark(Board.SYMBOL_O, 4, -1);
		
		board.setMark("Y", 0, 0);
	}
	
	@Test
	public void testHasWinner() {
		
		
		assertFalse(board.hasWinner());
		
		try {
			
			board.setMark(Board.SYMBOL_X, 0, 0);
			board.setMark(Board.SYMBOL_O, 1, 1);
			board.setMark(Board.SYMBOL_X, 0, 1);
			board.setMark(Board.SYMBOL_O, 2, 1);
			board.setMark(Board.SYMBOL_X, 0, 2);
			
			
			assertTrue(board.hasWinner());
			
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
