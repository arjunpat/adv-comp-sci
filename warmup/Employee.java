
public class Employee implements Comparable<Employee>{
	private String name;
	private int id;

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

  public String getName() {
    return name;
  }
  
  public int getID() {
    return id;
  }

  public boolean equals(Object o) {
    Employee e = (Employee)o;
    if (e.getID() == id) {
      return true;
    }
    else {
      return false;
    }
  }

  public int hashCode() {
	  return id;
  }

  public String getCompareString() { return name + id; }

  public int compareTo(Employee em) {
	  if (em.hashCode() == id)
	  	return 0;
	  return getCompareString().compareTo(em.getCompareString());
  }

  public String toString() {
	  return "name: " + name + " id: " + id;
  }
}