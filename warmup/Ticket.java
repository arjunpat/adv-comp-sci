
public class Ticket implements Comparable<Ticket> {
	private String name, description, note;
	private int priority;

	public Ticket(String name, String description, String note, int priority) {
		this.name = name;
		this.description = description;
		this.note = note;
		this.priority = priority;
	}

	public String toString() {
		return "Name: " + name + " Description: " + description + " Note: " + note + " Priority: " + priority;
	}

	public int compareTo(Ticket t) {
		if (this.priority > t.getPriority()) {
			return -1;
		} else if (this.priority < t.getPriority()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public int getPriority() { 
		return this.priority;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
