import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
	  
	Scanner kb = new Scanner(System.in);
    
	HashMap<Employee, Integer> hash = new HashMap<Employee, Integer>();
	TreeMap<Employee, Integer> tree = new TreeMap<Employee, Integer>();

	hash.put(new Employee("John", 1234), 50000);
	hash.put(new Employee("Paula", 4321), 60000);
	hash.put(new Employee("Paula", 4321), 61000);
	hash.put(new Employee("Jose", 1111), 70000);
	hash.put(new Employee("John", 1234), 50000);
	hash.put(new Employee("John", 1232), 51000);
	hash.put(new Employee("Henry", 1234), 50000);
  
  tree.put(new Employee("Henry", 1234), 55000);
  tree.put(new Employee("Henry", 1221), 60000);
  tree.put(new Employee("Jennifer", 4321), 71000);
  tree.put(new Employee("Jose", 1111), 70000);
  tree.put(new Employee("John", 1234), 50000);
  tree.put(new Employee("John", 1234), 50000);
  tree.put(new Employee("Henry", 1234), 50000);

  Iterator<Employee> it1 = hash.keySet().iterator();
  while (it1.hasNext()) {
    Employee em1 = it1.next();
    System.out.println(em1.toString() + " Salary: " + tree.get(em1));
  }

	System.out.println("Tree map:");

  Iterator<Employee> it2 = tree.keySet().iterator();
  while (it2.hasNext()) {
	  Employee em2 = it2.next();
	  System.out.println(em2.toString() + " Salary: " + tree.get(em2));
  }
  
  System.out.println("Enter in an id");
  Employee em = new Employee("he", kb.nextInt());

  System.out.println(hash.get(em));
  System.out.println(tree.get(em));
  

  }
}