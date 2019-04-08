public class Task implements Comparable<Task> {
  private String task;
  private int priority;

  public Task(String task, int priority) {
    this.task = task;
    this.priority = priority;
  }

  public int compareTo(Task t) {
    return priority - t.getPriority();
  }

  public int getPriority() {
    return priority;
  }

  public String toString() {
    return priority + ": " + task;
  }
}
