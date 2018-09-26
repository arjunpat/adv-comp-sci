import java.util.ArrayList;
import java.util.Scanner;
import java.util.ListIterator;
import java.io.FileNotFoundException;
import java.io.File;

public class Database {

	private ArrayList<Student> students;
	private int passes = 0;

	public Database(String fileName) {
		students = new ArrayList<Student>();

		try {
			Scanner in = new Scanner(new File(fileName));

			while (in.hasNextLine()) {

				String line = in.nextLine();
				String[] name = line.split("\\s+");

				ListIterator<Student> it = students.listIterator();
				Student stu = new Student(name[0], name[1], (int)((Math.random() * 4) + 14));


				while (it.hasNext()) {
					if (it.next().toString().compareTo(stu.toString()) > 0) {
						it.previous();
						break;
					}
				}

				it.add(stu);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public int binarySearch(String lastName) {
		return this._binarySearch(lastName, 0, students.size());
	}

	private int _binarySearch(String lastName, int startPos, int endPos) {

		if (startPos <= endPos) {
			this.passes++;
			int mid = (startPos + endPos) / 2;

			if (students.get(mid).getLastName().equals(lastName)) {
				return mid + 1; // not index
			} else if (students.get(mid).getLastName().compareTo(lastName) > 0) {
				endPos = mid - 1;

			} else if (students.get(mid).getLastName().compareTo(lastName) < 0) {
				startPos = mid + 1;

			}

			return this._binarySearch(lastName, startPos, endPos);

		}

		return -1;

	}


	public int sequentialSearch(String lastName) {
		for (int i = 0; i < students.size(); i++) {
			passes++;

			if (students.get(i).getLastName().equals(lastName))
				return i + 1;
		}

		return -1;
	}

	public int getPasses() {
		int num = this.passes;
		this.passes = 0;
		return num;
	}

	public Student getStudent(int i) {
		return students.get(i - 1);
	}

	public void scramble() {
		int index;
		Student temp;

		for (int i = 0; i < students.size(); i++) {

			index = (int)(Math.random() * students.size());
			temp = students.get(index);
			students.set(index, students.get(i));
			students.set(i, temp);

		}
	}

	public String toString() {
		String returnVal = "";

		for (int i = 0; i < students.size(); i++) {
			returnVal += (i + 1) + ". " + students.get(i).toString() + "\n";
		}

		return returnVal.substring(0, returnVal.length() - 1);
	}


}