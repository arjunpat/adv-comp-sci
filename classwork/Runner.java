public class Runner {
  public static void main(String[] args) {
    HashMap<Student, String> map = new HashMap<Student, String>();

    map.put(new Student("Jessica", 1234), "Calculus BC");
    map.put(new Student("Jessica", 1234), "AP Computer Science");
    map.put(new Student("Jessica", 1234), "Economics");

    map.put(new Student("Jose", 4321), "AP Computer Science");
    map.put(new Student("Jose", 4321), "Statistics");
    map.put(new Student("Jose", 4321), "Psychology");

    map.put(new Student("John", 1111), "Geometry");
    map.put(new Student("John", 1111), "App and Game Design");
    map.put(new Student("John", 1111), "Economics");

    System.out.println(map);

    map.remove(new Student("John", 1111));

    System.out.println(map);

    map.remove(new Student("Jessica", 1234), "Economics");

    System.out.println(map);
  }
}
