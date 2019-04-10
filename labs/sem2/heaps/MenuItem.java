import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.net.URL;
import javax.imageio.ImageIO;

public class MenuItem {
	private String name;
	private double price;
	private Image image;

	public MenuItem(String name, double price, String link) {
		this.name = name;
		this.price = price;

		try {
			image = ImageIO.read(new URL(link));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Image getImage() {
		return image;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return name + " - $" + price;
	}
}