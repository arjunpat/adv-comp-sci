public class Song {
  private String name;
  private String artist;
  private int created;
  private static int order = 0;

  public Song(String name, String artist) {
    this.name = name;
    this.artist = artist;
    this.created = order;
    order++;
  }

  public boolean equals(Object o) {
    Song s = (Song) o;
    return name.equals(s.getName()) && artist.equals(s.getArtist());
  }

  public String getName() {
    return name;
  }

  public String getArtist() {
    return artist;
  }

  public int getCreated() {
    return created;
  }

  public String toString() {
    return artist + " - " + name;
  }
}
