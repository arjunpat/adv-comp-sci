import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.ArrayList;

public class Database {

	private PriorityQueue<Patient> patients;
	private Queue<Patient> billingQueue;
	private TreeSet<String> donePatients;
	private ArrayList<View> allTheViews;

	public Database() {
		patients = new PriorityQueue<Patient>();
		billingQueue = new LinkedList<Patient>();
		donePatients = new TreeSet<String>();
		allTheViews = new ArrayList<View>();

		this.addPatient("Tanay", "Sonthalia", "cold", "low");
		this.addPatient("Arjun", "Patrawala", "flu", "medium");
		this.addPatient("Marley", "Magee", "dead", "high");
		this.addPatient("Bob", "Ita", "overdose", "high");
		this.addPatient("Nick", "Cardigan", "PE", "medium");
		this.addPatient("Ben", "Frank", "pregnant", "high");
		this.addPatient("Lee", "Fauset", "runny nose", "low");
		this.addPatient("Tyler", "Ferri", "bordom", "low");
		this.addPatient("Ganghis", "Khan", "anger", "high");

	}


	public void addPatient(String firstName, String lastName, String illness, String priority) {
		int pri = 1;

		if (priority.equals("high")) {
			pri = 3;
		} else if (priority.equals("medium")) {
			pri = 2;
		}

		patients.add(new Patient(firstName, lastName, illness, pri));

		this.changesMade();
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

		this.changesMade();
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

		this.changesMade();
	}

	public Patient getPatientToBill() {
		return billingQueue.peek();
	}

	public void removePatientFromBilling(Patient p) {
		billingQueue.remove(p);
		donePatients.add(p.serialize());

		this.changesMade();
	}

	public String getCompletedPatients() {
		String data = "";

		Iterator<String> i = donePatients.iterator();
		while (i.hasNext()) {
			data += i.next() + "\n";
		}

		data += "\nPatients cared for: " + donePatients.size();

		return data;
	}

	public void addChangeListener(View v) {
		allTheViews.add(v);
	}

	public void changesMade() {
		for (int i = 0; i < allTheViews.size(); i++) {
			allTheViews.get(i).onChange();
		}
	}

}
