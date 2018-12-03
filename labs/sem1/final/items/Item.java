import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

package item;

public class Item {
	private int x, y, height, width;

	public Item() {

	}

	public abstract void draw(Graphics g);

	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

}