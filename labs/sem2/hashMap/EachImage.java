import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.net.URL;
import javax.imageio.ImageIO;

public class EachImage {
	private String url, captionText, date;
	private Image image;

	public EachImage(String url, String captionText, String date) {
		this.url = url;
		this.captionText = captionText;
		this.date = date;
	}

	public void loadImage() {
		if (image == null) {
			try {
				image = ImageIO.read(new URL(url));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void draw(Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, x, y, 600, 400, null);

		g.setColor(Color.black);
		g.setFont(new Font("Tahoma", Font.PLAIN, 14));
		g.drawString(captionText + " — " + date, x, y + 415);
	}
}