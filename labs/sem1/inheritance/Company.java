public class Company extends Employee {
	private String companyName;

	public Company(String name, String jobTitle, String photoFile, String companyName) {
		super(name, jobTitle, photoFile);
		this.companyName = companyName;
	}

	public double getSalary() {
		return 120.0;
	}

	public String toString() {
		return super.toString() + "\n Company name: " + companyName;
	}

}