public class Runner {
  public static void main(String[] args) {

    Node[] nodes = new Node[] {
      new Node("cat"),
      new Node("dog"),
      new Node("bird"),
      new Node("bear"),
      new Node("pig")
    };

    for (int i = 1; i < nodes.length; i++) {
      nodes[i - 1].setNext(nodes[i]);
    }

    Node first = nodes[0];

    while (true) {
      System.out.println(first.get());
      if (first.next() != null) {
        first = first.next();
      } else {
        break;
      }
    }

  }
}
