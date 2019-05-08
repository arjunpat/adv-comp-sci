import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Runner {
	private JFrame jFrame = new JFrame("Thing");

	public Runner() {
		showStartScreen();
	}

	private void updateScreen(View view) {
		jFrame.setContentPane(view);
		jFrame.revalidate();
		jFrame.pack();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}

	public void showStartScreen() {
		updateScreen(new StartScreen(this));
	}

	public void showGameScreen() {
		updateScreen(new GameScreen(this));
	}

	public void goToLoseScreen() {
		updateScreen(new LoseScreen(this));
	}

	public static void main(String[] args) {
		new Runner();
	}
}
