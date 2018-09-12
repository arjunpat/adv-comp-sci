import javax.swing.*;
import java.util.*;

public class ScreenManager {

	private ArrayList<Pair<Student, Schedule>> students = new ArrayList<Pair<Student, Schedule>>();
	private JFrame jFrame;

	public ScreenManager(JFrame jFrame) {
		this.jFrame = jFrame;

		Schedule arjunp = new Schedule();
		arjunp.addClass(1, "Chemistry Honors");
		arjunp.addClass(2, "Spanish 3 Honors");
		arjunp.addClass(3, "AP Calc BC");

		Schedule marleym = new Schedule();
		marleym.addClass(4, "AP Comp");
		marleym.addClass(5, "WHAP");
		marleym.addClass(6, "Advanced Comp Sci");

		Schedule tanays = new Schedule();
		tanays.addClass(1, "Multivariable Calc");
		tanays.addClass(2, "AP Psych");
		tanays.addClass(3, "Advanced Comp Sci");

		students.add(new Pair<Student, Schedule>(new Student("Tanay Sonthalia", "ts"), tanays));
		students.add(new Pair<Student, Schedule>(new Student("Marley Magee", "mm"), arjunp));
		students.add(new Pair<Student, Schedule>(new Student("Arjun Patrawala", "ap"), marleym));

		this.showAllStudents();
	}

	private void updateScreen(View view) {
		jFrame.setContentPane(view);
		jFrame.pack();
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jFrame.setVisible(true);
	}

	public void showAllStudents() {
		this.updateScreen(new ShowStudentsView(this, students));
	}

	

}