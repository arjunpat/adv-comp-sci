public class Company extends Employee {
	private String companyName;

	public Company(String name, String jobTitle, String photoFile, String companyName) {
		super(name, jobTitle, photoFile);
		this.companyName = companyName;
	}

	public String toString() {
		return super.toString() + " Company name: " + companyName;
	}

}