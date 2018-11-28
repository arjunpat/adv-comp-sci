import java.io.Serializable;

public class Game implements Serializable {

	private int[][] board; // 0 means empty, 1 means x, -1 means o
	private String turn; // server is x, client is o

	private int serverWins = 0;
	private int clientWins = 0;

	private boolean playingAI = false;
	
	public Game() {
		board = new int[3][3];
		resetBoard();
	}

	public boolean isMyTurn(String who) {
		return who.equals(turn);
	}

	public boolean makeTurn(int r, int c) {

		if (board[r][c] != 0)
			return false;

		if (turn.equals("server")) {
			board[r][c] = 1;
			turn = "client";
		} else if (turn.equals("client")) {
			board[r][c] = -1;
			turn = "server";
		}

		return true;

	}

	public int getBoardAt(int r, int c) {
		return board[r][c];
	}

	public boolean isBoardFull() {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if (board[r][c] == 0) {
					return false;
				}
			}
		}

		return true;
	}

	public String checkWin() {
		String winner = _checkWin();

		if (winner.equals("server")) {
			serverWins++;
			resetBoard();
		} else if (winner.equals("client")) {
			clientWins++;
			resetBoard();
		}

		return winner;
	}

	private String _checkWin() {

		if (board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
			if (board[0][0] == 1) return "server";
			if (board[0][0] == -1) return "client";
		}
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			if (board[0][0] == 1) return "server";
			if (board[0][0] == -1) return "client";
		}
		if (board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
			if (board[0][0] == 1) return "server";
			if (board[0][0] == -1) return "client";
		}
		if (board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
			if (board[0][1] == 1) return "server";
			if (board[0][1] == -1) return "client";
		}
		if (board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
			if (board[0][2] == 1) return "server";
			if (board[0][2] == -1) return "client";
		}
		if (board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
			if (board[1][0] == 1) return "server";
			if (board[1][0] == -1) return "client";
		}
		if (board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
			if (board[2][0] == 1) return "server";
			if (board[2][0] == -1) return "client";
		}
		if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
			if (board[2][0] == 1) return "server";
			if (board[2][0] == -1) return "client";
		}
		if (isBoardFull()) return "draw";

		return "none";
	}

	public void resetBoard() {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				board[r][c] = 0;
			}
		}

		turn = "server";
	}

	public int getServerWins() {
		return serverWins;
	}

	public int getClientWins() {
		return clientWins;
	}

	public boolean isPlayingAI() {
		return playingAI;
	}

	public void setPlayingAI(boolean val) {
		playingAI = val;
	}

}
