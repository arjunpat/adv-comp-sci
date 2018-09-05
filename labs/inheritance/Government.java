public class Government extends Employee {
	private String cityName;

	public Government(String name, String jobTitle, String photoFile, String cityName) {
		super(name, jobTitle, photoFile);
		this.cityName = cityName;
	}

	public String toString() {
		return super.toString() + " City name: " + cityName;
	}

}