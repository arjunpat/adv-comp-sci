import java.util.PriorityQueue;

public class Database {

	private PriorityQueue<Patient> patients;

	public Database() {
		patients = new PriorityQueue<Patient>();

		this.addPatient("Tanay", "Sonthalia", "cold", "high");
		this.addPatient("Arjun", "Patrawala", "flu", "low");
		this.addPatient("Marley", "Magee", "dead", "medium");

	}


	public void addPatient(String firstName, String lastName, String illness, String priority) {
		int pri = 1;

		if (priority.equals("high")) {
			pri = 3;
		} else if (priority.equals("medium")) {
			pri = 2;
		}

		patients.add(new Patient(firstName, lastName, illness, pri));
	}

	public void updatePatient(String firstName, String lastName, String illness, String priority) {
		
	}

	public String getAllPatients() {
		Object[] p = patients.toArray();
		String data = "";

		for (int i = 0; i < p.length; i++) {
			data += ((Patient)p[i]).toString() + "\n";
		}

		return data;
	}

}
