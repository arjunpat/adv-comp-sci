import java.util.*;

public class Schedule {

	private ArrayList<Pair<Integer, String>> mySchedule;

	public Schedule() {
		mySchedule = new ArrayList<Pair<Integer, String>>();
	}

	public void addClass(int period, String name) {

		for (int i = 0; i < mySchedule.size(); i++) {
			if (mySchedule.get(i).getKey() == period) {
				mySchedule.remove(i);
			}
		}

		mySchedule.add(new Pair<Integer, String>(period, name));

		for (int i = 0; i < mySchedule.size() - 1; i++) {
			for (int j = i + 1; j < mySchedule.size(); j++) {
				if ((mySchedule.get(j).getKey() < mySchedule.get(i).getKey())) {
					Pair<Integer, String> temp = mySchedule.get(i);
					Pair<Integer, String> temp2 = mySchedule.get(j);
					mySchedule.set(i, temp2);
					mySchedule.set(j, temp);
				}
			}
		}
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < mySchedule.size(); i++) {
			str += mySchedule.get(i).getKey() + ": " + mySchedule.get(i).getValue() + "\n";
		}

		return str;
	}

}