public class Student {
  String name;
  int id;

  public Student(String a, int b) {
    name = a;
    id = b;
  }

  public int hashCode() {
    return id;
  }

  public int getID() {
    return id;
  }

  public String toString() {
    return name + " #" + id;
  }

  public boolean equals(Object o) {
    Student s = (Student)o;

    if (s.getID() == id) {
      return true;
    }

    return false;
  }
}
