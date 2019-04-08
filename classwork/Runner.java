import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    MinHeap<Task> heap = new MinHeap<Task>();

    Scanner kb = new Scanner(System.in);

    int num = 1;
    while (num < 6) {
      System.out.println("Enter a task");
      String task = kb.next();

      System.out.println("Enter a priority");
      int priority = kb.nextInt();

      heap.add(new Task(task, priority));

      num++;
    }

    while (heap.size() > 0) {
      System.out.println(heap.poll());
    }
  }
}
