import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Student {

	private String name;
	private String imageFile;

	public Student(String name, String imageFile) {
		this.name = name;
		this.imageFile = imageFile;
	}

	public void drawStudent(Graphics g, int x, int y, int width, int height) {
		try {
			BufferedImage pic = ImageIO.read(new File("images/" + imageFile + ".png"));
			g.drawImage(pic.getScaledInstance(width, height, Image.SCALE_DEFAULT), x, y, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "Name: " + name;
	}


}