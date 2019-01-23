/*

Create a Song List Manager using the DLList object you created.  The program will start with 5 songs of your choice with at least 2 songs having the same artists.  It will repeat indefinitely until the user quits and will have the following feature.

Add a song. It will add a song by time added when the program first starts, and will then keep the sort order selected by the user. You will not add and sort.  Instead, you will traverse the list to find a node with an element that is larger or greater alphabetically, and add it before that location.  You must use the add(int, E).
Display song List.  It will display the song list by time added when the program first starts, and will then keep the sort order selected by the user.  The song will list will be numbered and displayed in the following format starting at 1.
1. artist name - song name
2. artist name - song name
….
Delete song by artist and song name.  This will delete the first occurrence.
Delete song by number on the playlist.
Delete song by artist.  This will delete all occurrences.
Delete song by name.  This will delete all occurrences.
Sort by artist name.
Sort by song name.
Sort by time added.
Search by artist.  Display songs with only that artist. The order does not matter. The song list will be numbered and displayed in the following format starting at 1.
1. artist name - song name
2. artist name - song name
….
Quit

*/
import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    DLList<Song> list = new DLList<Song>();
    Scanner kb = new Scanner(System.in);

    list.add(new Song("Alejandro", "Lady Gaga"));
    list.add(new Song("Hello", "Adele"));
    list.add(new Song("Paparazzi", "Lady Gaga"));
    list.add(new Song("Party Rock Anthem", "LMFAO"));
    list.add(new Song("Sexy and I Know It", "LMFAO"));
    list.add(new Song("Welcome to my house", "HELLO"));
    list.add(new Song("Welcome to my house", "Marley"));


    int input = 0;

    while (input != 11) {
      System.out.println();
      System.out.println();
      System.out.println("1. Add a Song");
      System.out.println("2. Display Song List");
      System.out.println("3. Delete Song by Artist and Song Name");
      System.out.println("4. Delete Song by Number on Playlist");
      System.out.println("5. Delete Song by Artist");
      System.out.println("6. Delete Song by Name");
      System.out.println("7. Sort by Artist Name");
      System.out.println("8. Sort by Song Name");
      System.out.println("9. Sort by Time Added");
      System.out.println("10. Search by Artist");
      System.out.println("11. Quit");

      input = kb.nextInt();


      System.out.println();
      System.out.println();

      if (input == 1) {

        System.out.println("What is the song name?");
        String song = kb.next();

        System.out.println("What is the artist name?");
        String artist = kb.next();

        Song newSong = new Song(song, artist);

        list.add(newSong);
      } else if (input == 2) {

        for (int i = 0; i < list.size(); i++) {
          System.out.println((i + 1) + ". " + list.get(i).toString());
        }

      } else if (input == 3) {
        System.out.println("What is the song name?");
        String song = kb.next();

        System.out.println("What is the artist name?");
        String artist = kb.next();

        list.remove(new Song(song, artist));
      } else if (input == 4) {
        System.out.println("What song number?");
        int num = kb.nextInt();

        list.remove(num - 1);
      } else if (input == 5) {
        System.out.println("What is the artist name?");
        String artist = kb.next();

        for (int i = 0; i < list.size(); i++) {
          if (list.get(i).getArtist().equals(artist)) {
            list.remove(i);
            i--;
          }
        }

      } else if (input == 6) {
        System.out.println("What song name?");
        String name = kb.next();

        for (int i = 0; i < list.size(); i++) {
          if (list.get(i).getName().equals(name)) {
            list.remove(i);
            i--;
          }
        }

      } else if (input == 7) {

        for (int i = 0; i < list.size() - 1; i++) {
          for (int j = i + 1; j < list.size(); j++) {
            Song a = list.get(i);
            Song b = list.get(j);

            if (a.getArtist().compareTo(b.getArtist()) < 0) {
              list.set(j, a);
              list.set(i, b);
            }

          }
        }

      } else if (input == 8) {
        for (int i = 0; i < list.size() - 1; i++) {
          for (int j = i + 1; j < list.size(); j++) {
            Song one = list.get(i);
            Song two = list.get(j);

            if (one.getName().compareTo(two.getName()) > 0) {
              list.set(j, one);
              list.set(i, two);
            }
          }
        }
      } else if (input == 9) {
        for (int i = 0; i < list.size() - 1; i++) {
          for (int j = i + 1; j < list.size(); j++) {
            Song one = list.get(i);
            Song two = list.get(j);

            if (one.getCreated() > two.getCreated()) {
              list.set(j, one);
              list.set(i, two);
            }
          }
        }
      } else if (input == 10) {
        System.out.println("Type an artist name");
        String artist = kb.next();
        for (int i = 0; i < list.size(); i++) {
          if (list.get(i).getArtist().equals(artist)) {
            System.out.println((i + 1) + ". " + list.get(i).toString());
          }
        }
      }

    }

  }
}
