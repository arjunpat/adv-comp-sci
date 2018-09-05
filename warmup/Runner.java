import java.util.*;

public class Runner {
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		ArrayList<Language> langs = new ArrayList<Language>();
		langs.add(new French());
		langs.add(new Italian());
		langs.add(new Latin());
		langs.add(new Spanish());

		for (int i = 0; i < langs.size(); i++) {
			System.out.println(i + ". " + langs.get(i).getLanguage());
		}

		int choice = kb.nextInt();

		System.out.println(langs.get(choice).getLanguage());
		System.out.println(langs.get(choice).getAuthor());
		System.out.println(langs.get(choice).getHello());
		System.out.println(langs.get(choice).getBye());

	}
}