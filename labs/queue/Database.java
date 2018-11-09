import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Database {

	private PriorityQueue<Patient> patients;
	private Queue<Patient> billingQueue;
	private TreeSet<Patient> donePatients;

	public Database() {
		patients = new PriorityQueue<Patient>();
		billingQueue = new LinkedList<Patient>();
		donePatients = new TreeSet<Patient>();

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

	public void doneWithPatient(Patient p) {
		patients.remove(p);
		billingQueue.add(p);
	}

	public Patient getPatientToBill() {
		return billingQueue.peek();
	}

	public void removePatientFromBilling(Patient p) {
		billingQueue.remove(p);
		donePatients.add(p);
	}

	public String getCompletedPatients() {
		String data = "";

		Iterator<Patient> i = donePatients.iterator();
		while (i.hasNext()) {
			Patient p = i.next();
		}
	}

}
