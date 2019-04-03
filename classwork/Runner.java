public class Runner {
  public static void main(String[] args) {
    MinHeap<Integer> heap = new MinHeap<Integer>();

    int num = 1;
    while (num < 8) {
      int num2 = (int)(Math.random() * 100 + 1);
      heap.add(num2);
      num++;
    }

    System.out.println(heap.toString());
  }
}
