public class Banker extends Company {
	private String type;

	public Banker(String name, String jobTitle, String photoFile, String companyName, String type) {
		super(name, jobTitle, photoFile, companyName);
		this.type = type;
	}

	public String toString() {
		return super.toString() + " Type: " + type;
	}


}