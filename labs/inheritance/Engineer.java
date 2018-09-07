public class Engineer extends Company {
	private String type;

	public Engineer(String name, String jobTitle, String photoFile, String companyName, String type) {
		super(name, jobTitle, photoFile, companyName);
		this.type = type;
	}

	public String toString() {
		return super.toString() + "\n Type: " + type;
	}


}