package resume;

public class Job {

	private String title;
	private String company;
	private Date endDate;

	public Job(String title, String company, String year, String month) {
		this.title = title;
		this.company = company;
		this.endDate = new Date(year, month);
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public String toString() {
		return this.title + "\n" + this.company + "\n" + this.endDate.toString();
	}

}