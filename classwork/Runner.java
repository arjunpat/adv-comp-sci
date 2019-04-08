public class Runner {
  public static void main(String[] args) {
    MaxHeap<Integer> heap = new MaxHeap<Integer>();

    int num = 1;
    while (num < 9) {
      int num2 = (int)(Math.random() * 100 + 1);
      heap.add(num2);

      num++;
    }

    System.out.println(heap.toString());

    while (heap.size() > 0) {
      System.out.println(heap.poll());
    }
  }
}
