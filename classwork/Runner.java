public class Runner {
  public static void main(String[] args) {
    Manager manager = new Manager();
    System.out.println(manager);
    manager.work();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {}

    System.out.println(manager);
  }
}
