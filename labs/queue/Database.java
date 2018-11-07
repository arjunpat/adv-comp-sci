import java.util.PriorityQueue;
import java.util.Iterator;

public class Database {

	private PriorityQueue<Patient> patients;

	public Database() {
		patients = new PriorityQueue<Patient>();

		this.addPatient("Tanay", "Sonthalia", "cold", "low");
		this.addPatient("Arjun", "Patrawala", "flu", "medium");
		this.addPatient("Marley", "Magee", "dead", "high");

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
		
		Iterator<Patient> it = patients.iterator();

		while (it.hasNext()) {
			Patient p = it.next();

			if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName))  {

				int pri = 1;

				if (priority.equals("high")) {
					pri = 3;
				} else if (priority.equals("medium")) {
					pri = 2;
				}

				p.update(illness, pri);
			}
		}
	}

	public String getAllPatients() {
		Object[] p = patients.toArray();
		String data = "";

		for (int i = 0; i < p.length; i++) {
			data += ((Patient)p[i]).toString() + "\n";
		}

		return data;
	}

	public Patient getTopPatient() {
		return patients.peek();
	}

}
