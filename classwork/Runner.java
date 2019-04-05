import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    MinHeap<Integer> heap = new MinHeap<Integer>();

    System.out.println("Part 1");

    int num = 1;
    while (num < 8) {
      int num2 = (int)(Math.random() * 100 + 1);
      heap.add(num2);
      num++;
    }

    System.out.println(heap.toString());
    System.out.println(heap.poll());
    System.out.println(heap.toString());

    System.out.println();
    System.out.println("Part 2");

    Scanner kb = new Scanner(System.in);
    MinHeap<Integer> heap2 = new MinHeap<Integer>();

    int num3 = 1;
    while (num3 < 8) {
      int num4 = (int)(Math.random() * 100 + 1);
      heap2.add(num4);
      num3++;
    }

    System.out.println(heap2.toString());

    System.out.println("What do you want to remove?");
    int num5 = kb.nextInt();

    heap2.remove(num5);

    System.out.println(heap2.toString());

    while (heap2.size() > 0) {
      System.out.println(heap2.poll());
    }

    System.out.println(heap2.toString());
  }
}
