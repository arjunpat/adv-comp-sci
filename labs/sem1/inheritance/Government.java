public class Government extends Employee {
	private String cityName;

	public Government(String name, String jobTitle, String photoFile, String cityName) {
		super(name, jobTitle, photoFile);
		this.cityName = cityName;
	}

	public double getSalary() {
		return 100.00;
	}

	public String toString() {
		return super.toString() + "\n City name: " + cityName;
	}

}