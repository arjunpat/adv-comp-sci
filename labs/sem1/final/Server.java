import javax.swing.*;
import java.util.*;
import game.Game;

public class Server {

	private Game game;
	private JFrame jFrame;
	private ServerGameScreen serverGameScreen;

	public Server() {
		jFrame = new JFrame("Server / Player 1");

		serverGameScreen = new ServerGameScreen();
		showGameScreen();
	}

	public void poll() throws Exception {

		serverGameScreen.changeOccured(game);
	}

	private showGameScreen() {
		updateScreen(serverGameScreen);
	}

	private void updateScreen(View view) {
		jFrame.setContentPane(view);
		jFrame.pack();
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jFrame.setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server();

		server.poll();
	}
}