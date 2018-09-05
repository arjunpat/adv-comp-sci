public class Teacher extends Government {
	private String schoolName;

	public Teacher(String name, String jobTitle, String photoFile, String cityName, String schoolName) {
		super(name, jobTitle, photoFile, cityName);
		this.schoolName = schoolName;
	}

	public String toString() {
		return super.toString() + " School name: " + schoolName;
	}
}