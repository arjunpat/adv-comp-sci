public class Word {
  private String word;

  public Word(String word) {
    this.word = word;
  }

  public String toString() {
    return word;
  }

  public int hashCode() {
    char[] arr = word.toCharArray();

    return vowels() * arr.length;
  }

  private int vowels() {
    return word.length() - word.replaceAll("a|e|i|o|u", "").length();
  }

  public boolean equals(Object o) {
    Word w = (Word)o;
    if (w.toString().equals(word)) {
      return true;
    }
    return false;
  }
}
