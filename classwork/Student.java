import java.util.ArrayList;

public class Student {
  private int grade;
  private ArrayList<Integer> freeSem1 = new ArrayList<Integer>();
  private ArrayList<Integer> freeSem2 = new ArrayList<Integer>();

  public Student(int grade) {
    this.grade = grade;
  }

  public void addFreeSem1(int period) {
    if (!freeSem1.contains(period))
      freeSem1.add(period);
  }

  public void addFreeSem2(int period) {
    if (!freeSem2.contains(period))
      freeSem2.add(period);
  }

  public ArrayList<Integer> getFirstSem() {
    return freeSem1;
  }

  public ArrayList<Integer> getSecondSem() {
    return freeSem2;
  }

  public String toString() {
    return grade + " - 1:" + freeSem1.toString() + " 2: " + freeSem2.toString() + "\n";
  }

  public int getGrade() {
    return grade;
  }
}
