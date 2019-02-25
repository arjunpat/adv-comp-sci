import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CountryScreen extends View {

	private Database db;
	private Country country;
	private JButton closeButton, createImage;
	private JTextField url, caption, date;
	private Runner screenManager;
	private DLList<EachImage> images;

	public CountryScreen(Database db, Country country, Runner screenManager) {
		this.db = db;
		this.country = country;
		this.screenManager = screenManager;
		
		closeButton = new JButton("Close");
		closeButton.setBounds(0, 0, 0, 0);
		closeButton.addActionListener(e -> {
			screenManager.showHomeScreen();
		});
		add(closeButton);

		url = new JTextField();
		url.setText("URL");
		add(url);

		caption = new JTextField();
		caption.setText("Caption");
		add(caption);

		date = new JTextField();
		date.setText("Date");
		add(date);

		createImage = new JButton("Create image");
		add(createImage);

		images = db.getImageListByCountry(country);

		Thread loadImages = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < images.size(); i++) {
					EachImage im = images.get(i);
					im.loadImage();
					repaint();
				}
			}
		});

		loadImages.start();
	}

	public void draw(Graphics g) {
		this.draw(g, 0);
	}

	public void draw(Graphics g, int y) {
		if (y < 0)
			y = 0;

		g.setColor(new Color(255, 255, 255, (int)(255 * ((400 - y) / 400.0))));
		g.fillRect(0, y, 800, 800);

		closeButton.setBounds(680, y + 20, 100, 30);
		url.setBounds(20, y + 60, 200, 30);
		caption.setBounds(20, y + 100, 200, 30);
		date.setBounds(20, y + 140, 200, 30);
		createImage.setBounds(20, y + 180, 150, 30);

		drawTitle(g, Color.BLUE, country.toString(), 20, y + 30);

		int theX = 290;
		int theY = y + 50;
		for (int i = 0; i < images.size(); i++) {
			images.get(i).draw(g, theX, theY);
			theX += 220;

			if (theX > 600) {

				theX = 70;
				theY += 240;
			}
		}
	}
}