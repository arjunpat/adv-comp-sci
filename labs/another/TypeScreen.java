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

	protected Color green = new Color(79, 255, 146);
	protected Color white = new Color(255, 255, 255);
	protected Color purple = new Color(192, 179, 224);
	protected Color lblue = new Color(176, 224, 230);
	protected Color blue = new Color(0, 0, 255);
	protected Color red = new Color(255, 0, 0);
	protected Color black = new Color(0, 0, 0);
	protected Color yellow = new Color(244, 236, 8);
	protected Color dblue = new Color(30, 144, 255);
	protected Color red1 = new Color(242, 106, 117);
	protected Color yellow1 = new Color(249, 228, 89);

	public TypeScreen() {}

	public abstract void draw(Graphics g, Screen s);

	public abstract void keyPressed(KeyEvent e);
}
