package resume;

public class Job {

	private String title;
	private String company;
	private Date endDate;
	private Date startDate;
	private String description;

	public Job(String title, String company, String year, String month, String yearStart, String monthStart, String description) {
		this.title = title;
		this.company = company;
		this.endDate = new Date(year, month);
		this.startDate = new Date(yearStart, monthStart);
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public String toString() {
		return this.title + "\n" + this.company + "\n" + this.startDate.toString() + " - " + this.endDate.toString() + "\n" + description;
	}

}