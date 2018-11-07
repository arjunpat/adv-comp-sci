public class Patient implements Comparable<Patient> {
	private String firstName, lastName, illness, doctorsNotes;
	private double billingAmount;
	private int priority;
	private double created;



	public Patient(String firstName, String lastName, String illness, int priority) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.illness = illness;

		// 1 -> low, 2 -> medium, 3 -> high
		this.priority = priority;

		this.created = System.currentTimeMillis();
	}

	public int compareTo(Patient p) {
		int pri = p.getPriority();

		if (pri == this.priority) {

			if (p.getCreated() > this.created) {
				return 1;
			}

			return -1;

		} else if (pri < this.priority) {
			return 1;
		}
		return -1;
	}

	public String toString() {
		String[] pri = {"low", "medium", "high"};

		return firstName + " " + lastName + " - " + illness + " - " + pri[this.priority - 1];
	}

	public int getPriority() { return this.priority; }
	public double getCreated() { return this.created; }
}
