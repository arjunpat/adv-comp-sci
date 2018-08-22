import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

public abstract class TypeScreen {

	private Color green = new Color(79, 255, 146);
	private Color white = new Color(255, 255, 255);
	private Color purple = new Color(192, 179, 224);
	private Color lblue = new Color(176, 224, 230);
	private Color blue = new Color(0, 0, 255);
	private Color red = new Color(255, 0, 0);
	private Color black = new Color(0, 0, 0);
	private Color yellow = new Color(244, 236, 8);
	private Color dblue = new Color(30, 144, 255);
	private Color red1 = new Color(242, 106, 117);
	private Color yellow1 = new Color(249, 228, 89);

	public TypeScreen() {}

	public abstract void draw(Graphics g, Screen s);

	public abstract void keyPressed(KeyEvent e);
}
