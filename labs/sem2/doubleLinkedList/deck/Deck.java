package deck;

public class Deck {

	private DLList<Card> cards;

	public Deck() {
		loadDeck();
	}

	public void loadDeck() {

		cards = new DLList<Card>();

		for (int i = 1; i < 5; i++) {
			for (int j = 2; j < 15; j++) {
				cards.add(new Card(i, j));
			}
		}

		shuffle();
	}

	public void shuffle() {
		for (int i = 0; i < cards.size(); i++) {
			int j = (int)(Math.random() * cards.size());

			Card a = cards.get(i);
			Card b = cards.get(j);

			cards.set(i, b);
			cards.set(j, a);
		}
	}

	public Card drawCard() {
		Card first = cards.get(0);
		cards.remove(0);

		return first;
	}

}