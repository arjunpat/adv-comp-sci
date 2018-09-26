package resume;

import java.util.ArrayList;
import java.util.ListIterator;

public class Resume {

	private String name;
	private String email;
	private String address;
	private String objective;
	private String phone;

	private ArrayList<Education> schools;
	private ArrayList<Job> jobs;

	public Resume() {}

	public void init(String name, String email, String address, String objective, String phone) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.objective = objective;
		this.phone = phone;

		schools = new ArrayList<Education>();
		jobs = new ArrayList<Job>();
	}

	public void addEducation(String name, String degree, String year, String month) {

		Education toAdd = new Education(name, degree, year, month);
		ListIterator<Education> it = schools.listIterator();

		while (it.hasNext()) {
			if (it.next().getGraduationDate().toString().compareTo(toAdd.getGraduationDate().toString()) > 0) {
				it.previous();
				break;
			}
		}
		it.add(toAdd);

	}

	public void addJob(String title, String company, String year, String month, String yearStart, String monthStart, String description) {
		Job toAdd = new Job(title, company, year, month, yearStart, monthStart, description);
		ListIterator<Job> it = jobs.listIterator();

		while (it.hasNext()) {
			if (it.next().getEndDate().toString().compareTo(toAdd.getEndDate().toString()) > 0) {
				it.previous();
				break;
			}
		}
		it.add(toAdd);
	}

	public String educationToString() {
		ListIterator<Education> it = schools.listIterator();
		String returnVal = "";

		while (it.hasNext()) {
			returnVal += it.next().toString() + "\n\n";
		}

		return returnVal;
	}

	public String jobsToString() {
		ListIterator<Job> it = jobs.listIterator();
		String returnVal = "";

		while (it.hasNext()) {
			returnVal += it.next().toString() + "\n\n";
		}

		return returnVal;
	}

	public void removeSchool(int i) {
		schools.remove(i);
	}

	public void removeJob(int i) {
		jobs.remove(i);
	}

	public int getNumOfSchools() {
		return schools.size();
	}

	public int getNumOfJobs() {
		return jobs.size();
	}

	public String getName() {
		return name;
	}

	public String basicInfoToString() {
		return "Email: " + email + "\nAddress:" + address + "\nObjective: " + objective + "\nPhone: " + phone;
	}

}