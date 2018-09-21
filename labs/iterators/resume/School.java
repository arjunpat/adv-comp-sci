package resume;

public class School {

	private String name;
	private String degree;
	private Date graduationDate;

	public School(String name, String degree, String year, String month) {
		this.name = name;
		this.degree = degree;
		graduationDate = new Date(year, month);
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public String toString() {
		return this.name + "\n" + this.degree + "\n" + this.graduationDate.toString();
	}

}