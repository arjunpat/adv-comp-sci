public class PoliceOfficer extends Government {
	private String rank;

	public PoliceOfficer(String name, String jobTitle, String photoFile, String cityName, String rank) {
		super(name, jobTitle, photoFile, cityName);
		this.rank = rank;
	}

	public String toString() {
		return super.toString() + " Rank: " + rank;
	}
}