import java.util.LinkedList;
import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    HashTable<Word> words = new HashTable<Word>();

    while (true) {
      String input = sc.nextLine();

      if (input.equals("end")) {
        System.out.println(words.contains(new Word("car")));
        System.out.println(words.contains(new Word("goat")));
        System.out.println(words);

        words.remove(new Word("jump"));
        words.remove(new Word("goat"));
        System.out.println(words);
        break;
      }

      Word word = new Word(input);

      words.add(word);
    }
  }
}
