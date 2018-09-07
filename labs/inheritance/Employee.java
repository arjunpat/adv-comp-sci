import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Employee {
	private String name;
	private String jobTitle;
	private String photoFile;

	public Employee(String name, String jobTitle, String photoFile) {
		this.name = name;
		this.jobTitle = jobTitle;
		this.photoFile = photoFile;
	}

	public abstract double getSalary();

	public void drawPhoto(Graphics g, int x, int y, int width, int height) {

		try {
            BufferedImage pic = ImageIO.read(new File("images/" + photoFile + ".png"));
			g.drawImage(pic.getScaledInstance(width, height, Image.SCALE_DEFAULT), x, y, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public String getName() { return name; }
	public String getJobTitle() { return jobTitle; }

	public String toString() {
		return /*"Name: " + name + " Job title: " + jobTitle + */" Salary: $" + this.getSalary();
	}

}