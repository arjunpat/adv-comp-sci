public class Task implements Runnable {
  private boolean completed;

  public Task() {
    completed = false;
  }

  public synchronized void run() {
    System.out.println(Thread.currentThread().getName() + " starting");
    int max = (int)(Math.random() * 2 + 2);
    for (int i = 1; i<=max; i++) {
      System.out.println(Thread.currentThread().getName() + ": " + i);
      try {
        Thread.sleep(100);
      } catch (Exception e) {}
    }

    /*
    synchronized(this) {
      if (index<max) {
        index++;
      }
    }*/
    completed = true;
    System.out.println(Thread.currentThread().getName() + " completed");
  }

  public String toString() {
    return Thread.currentThread().getName() + ": Completed - " + completed;
  }
}
