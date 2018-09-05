import java.awt.*;

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

	public void drawPhoto(Graphics g, int x, int y) {

		Image pic = Toolkit.getDefaultToolkit().getImage("images/" + photoFile + ".png");
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(picture, x, y, null);
	}

	public String getName() { return name; }
	public String getJobTitle() { return jobTitle; }

	public String toString() {
		return "Name: " + name + " Job title: " + jobTitle + " Salary: " + this.getSalary();
	}

}