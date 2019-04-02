public class Runner {
  public static void main(String[] args) {
    int[] arr = {9, 18, 23, 20, 21, 25, 26, 22, 23};
    int[] arr2 = {90, 70, 80, 50, 60, 55, 44};
    printHeapByLevel(arr);

    int[] minHeap = {1, 2, 3, 4, 5, 6, 7};
    printHeapByLevel(minHeap);
    int[] minHeap2 = {8, 9, 10, 11, 12, 13, 14, 15};
    printHeapByLevel(minHeap2);
  }

  public static void printHeapByLevel(int[] arr) {
    int level = 0;
    for (int i = 0; i < arr.length; i++) {
      int l = (int)(Math.log(i + 1) / Math.log(2)) + 1;

      if (l != level) {
        level = l;
        System.out.print("\n" + level + ": " + arr[i] + ", ");
      } else {
        System.out.print(arr[i] + ", ");
      }

    }
    System.out.println();
  }

  public static void printHeapPreOrder(int[] arr, int index) {
    int left = index * 2 + 1;
    int right = index * 2 + 2;
    System.out.println(arr[index]);
  }

  public static void printHeapInOrder(int[] arr) {
    String str = "[";
    for (int i = 0; i < arr.length; i++) {
      str += arr[i];

      if (i != arr.length - 1) {
        str += ", ";
      }
    }

    System.out.println(str + "]");
  }
}
