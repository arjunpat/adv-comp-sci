import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ServerGameScreen extends View {

	private Game game;
	
	public ServerGameScreen(Game game) {
		this.game = game;

	}

	public void draw(Graphics g) {

	}

	public void changeOccured(Game game) {
		this.game = game;

		repaint();
	}
}