public class Manager {
  private int[] numberList;
  private int index;

  public Manager() {
    numberList = new int[5];
    for (int i = 0; i < numberList.length; i++) {
      numberList[i] = (int)((Math.random() * 10) + 1);
    }

    index = 0;
  }

  public synchronized void doubleIt() {
    System.out.println(Thread.currentThread().getName() + " starting");
    numberList[index] = numberList[index] * 2;

    System.out.println(Thread.currentThread().getName() + " completed; index: " + index);
    index++;
  }

  public String toString() {
    String str = "";
    for (int i = 0; i < numberList.length; i++) {
      str += numberList[i] + "\n";
    }

    return str;
  }
}
