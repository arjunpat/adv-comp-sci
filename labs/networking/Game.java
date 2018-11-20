import java.io.Serializable;

public class Game implements Serializable {

	int[][] board; // 0 means empty, 1 means x, -1 means o
	String turn = "server"; // server is x, client is o
	
	public Game() {
		board = new int[3][3];
		resetBoard();
	}

	public boolean isMyTurn(String who) {
		return who.equals(turn);
	}

	public void makeTurn(int r, int c) {

		if (board[r][c] != 0)
			return;

		if (turn == "server") {
			board[r][c] = 1;
			turn = "client";
		} else if (turn == "client") {
			board[r][c] = -1;
			turn = "server";
		}

	}

	public int[][] getBoard() {
		return board;
	}

	public boolean isBoardFull() {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if (board[r][c] ==0) {
					return false;
				}
			}
		}

		return true;
	}

	private void resetBoard() {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				board[r][c] = 0;
			}
		}
	}

}
