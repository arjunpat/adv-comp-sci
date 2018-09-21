package resume;

import java.util.ArrayList;
import java.util.ListIterator;

public class Resume {

	private String name;
	private String email;
	private String address;
	private String objective;

	private ArrayList<School> schools;

	public Resume() {}

	public void init(String name, String email, String address, String objective) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.objective = objective;

		schools = new ArrayList<School>();
	}

	public void addSchool(String name, String degree, String year, String month) {

		School toAdd = new School(name, degree, year, month);
		ListIterator<School> it = schools.listIterator();

		while (it.hasNext()) {
			if (it.next().getGraduationDate().toString().compareTo(toAdd.getGraduationDate().toString()) > 0) {
				it.previous();
				break;
			}
		}
		it.add(toAdd);

	}

	public String schoolsToString() {
		ListIterator<School> it = schools.listIterator();
		String returnVal = "";

		while (it.hasNext()) {
			returnVal += it.next().toString() + "\n\n";
		}

		return returnVal;
	}

}