package resume;

public class Education {

	private String name;
	private String degree;
	private Date graduationDate;

	public Education(String name, String degree, String year, String month) {
		this.name = name;
		this.degree = degree;
		this.graduationDate = new Date(year, month);
	}

	public Date getGraduationDate() {
		return this.graduationDate;
	}

	public String toString() {
		return this.name + "\n" + this.degree + "\n" + this.graduationDate.toString();
	}

}