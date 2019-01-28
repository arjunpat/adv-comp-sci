public class Task implements Comparable<Task> {
  private String name;
  private int rank;

  public Task (String name, int rank) {
    this.name = name;
    this.rank = rank;
  }

  public int getRank() {
    return rank;
  }

  public int compareTo(Task t) {
    return t.getRank() - rank;
  }

  public String toString() {
    return name + " - " + rank;
  }
}
