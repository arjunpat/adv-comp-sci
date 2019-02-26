import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CountryScreen extends View {

	private Database db;
	private Country country;
	private Runner screenManager;
	private DLList<EachImage> images;
	private int currentImage = -1;
	private int opacity = 255;
	private JButton nextImage, previousImage;

	public CountryScreen(Database db, Country country, Runner screenManager) {
		this.db = db;
		this.country = country;
		this.screenManager = screenManager;
		
		JButton closeButton = new JButton("Close");
		closeButton.setBounds(680, 20, 100, 30);
		closeButton.addActionListener(e -> {
			screenManager.showHomeScreen();
		});
		add(closeButton);

		JTextField url = new JTextField();
		url.setBounds(20, 60, 200, 30);
		url.setText("URL");
		add(url);

		JTextField caption = new JTextField();
		caption.setText("Caption");
		caption.setBounds(20, 100, 200, 30);
		add(caption);

		JTextField date = new JTextField();
		date.setText("Date");
		date.setBounds(20, 140, 200, 30);
		add(date);

		JButton createImage = new JButton("Create image");
		createImage.setBounds(20, 180, 150, 30);
		createImage.addActionListener(e -> {
			db.addImage(country, new EachImage(url.getText(), caption.getText(), date.getText()));
			url.setText("URL");
			caption.setText("Caption");
			date.setText("Date");

			repaint();
			loadImages();
		});
		add(createImage);

		nextImage = new JButton("->");
		nextImage.setBounds(700, 300, 50, 400);
		nextImage.addActionListener(e -> {
			currentImage++;
			repaint();
		});
		add(nextImage);

		previousImage = new JButton("<-");
		previousImage.setBounds(50, 300, 50, 400);
		previousImage.addActionListener(e -> {
			currentImage--;
			repaint();
		});
		add(previousImage);

		loadImages();
		
	}

	public void loadImages() {
		images = db.getImageListByCountry(country);

		if (images.size() > 0) {
			currentImage = 0;
		}

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
		int totalImages = images.size();
		g.setColor(new Color(255, 255, 255, opacity));
		g.fillRect(0, 0, 800, 800);

		drawTitle(g, Color.BLUE, country.toString(), 20, 30);

		if (currentImage > -1) {
			g.setFont(new Font("Tahoma", Font.PLAIN, 18));
			g.setColor(Color.BLACK);
			g.drawString("Image " + (currentImage + 1) + "/" + totalImages, 620, 290);
			EachImage img = images.get(currentImage);
			img.draw(g, 100, 300);
		}

		nextImage.setEnabled(currentImage + 1 != images.size());
		previousImage.setEnabled(currentImage > 0);
	}

	public void setOpacity(int opacity) {
		this.opacity = opacity;
	}

	public boolean isOptimizedDrawingEnabled() {
		return false;
	}
}