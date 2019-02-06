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

	public static String checkWin(DLList<Card> values) {
		DLList<Integer> sortedByNum = new DLList<Integer>();
		DLList<Integer> sortedBySuit = new DLList<Integer>();

		for (int i = 0; i < values.size(); i++) {
			sortedByNum.add(values.get(i).getCard());
			sortedBySuit.add(values.get(i).getSuit());
		}

		for (int i = 0; i < sortedByNum.size(); i++) {
			for (int j = i + 1; j < sortedByNum.size(); j++) {
				int a = sortedByNum.get(i);
				int b = sortedByNum.get(j);

				if (a > b) {
					sortedByNum.set(i, b);
					sortedByNum.set(j, a);
				}
			}
		}

		for (int i = 0; i < sortedBySuit.size(); i++) {
			for (int j = i + 1; j < sortedBySuit.size(); j++) {
				int a = sortedBySuit.get(i);
				int b = sortedBySuit.get(j);

				if (a > b) {
					sortedBySuit.set(i, b);
					sortedBySuit.set(j, a);
				}
			}
		}

		/*System.out.println(sortedByNum);
		System.out.println(sortedBySuit);*/

		// check royal flush and straight flush
		if (sortedBySuit.get(0).equals(sortedBySuit.get(4))) {

			if (sortedByNum.get(0).equals(10) && sortedByNum.get(4).equals(14)) {
				return "royal_flush";
			}

			// check straight flush
			if (isStraight(sortedByNum))
				return "straight_flush";
		}

		// check four of a kind
		if (numberOfRepeatsForFirstIndex(sortedByNum) == 4 || numberOfRepeatsForLastIndex(sortedByNum) == 4) {
			return "four_of_a_kind";
		}

		// check full house
		if (
			(numberOfRepeatsForFirstIndex(sortedByNum) == 3 && numberOfRepeatsForLastIndex(sortedByNum) == 2)
			|| (numberOfRepeatsForFirstIndex(sortedByNum) == 2 && numberOfRepeatsForLastIndex(sortedByNum) == 3)
		) {
			return "full_house";
		}

		// check flush
		if (sortedBySuit.get(0) == sortedBySuit.get(4)) {
			return "flush";
		}


		// check straight
		if (isStraight(sortedByNum)) {
			return "straight";
		}

		if (highestNumberOfRepeats(sortedByNum) >= 3) {
			return "3_of_a_kind";
		}

		int amt = 0;
		for (int i = 2; i < 15; i++) {
			if (numOfOccurences(sortedByNum, i) >= 2) {
				amt++;
			}
		}

		if (amt == 2)
			return "2_pairs";

		
		for (int i = 11; i < 15; i++) {
			if (numOfOccurences(sortedByNum, i) == 2)
				return "pair";
		}

		return "none";
	}

	public static boolean isStraight(DLList<Integer> sortedByNum) {
		for (int i = 1; i < 5; i++) {
			if (sortedByNum.get(i) - 1 != sortedByNum.get(i - 1)) {
				return false;
			}
		}

		return true;
	}

	public static int numberOfRepeatsForFirstIndex(DLList<Integer> list) {
		int valueOfFirstCard = list.get(0);
		int counter = 1;

		for (int i = 1; i < 5; i++) {
			if (list.get(i).equals(valueOfFirstCard)) {
				counter++;
			}
		}

		return counter;
	}

	public static int numberOfRepeatsForLastIndex(DLList<Integer> list) {
		int valueOfLastCard = list.get(4);
		int counter = 1;

		for (int i = 0; i < 4; i++) {
			if (list.get(i).equals(valueOfLastCard)) {
				counter++;
			}
		}

		return counter;
	}

	public static int highestNumberOfRepeats(DLList<Integer> list) {
		DLList<Integer> amounts = new DLList<Integer>();

		for (int i = 0; i < list.size(); i++) {
			int value = list.get(i);
			int counter = 0;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).equals(value)) {
					counter++;
				}
			}
			amounts.add(counter);
		}


		int currentMax = amounts.get(0);
		for (int i = 0; i < amounts.size(); i++) {
			if (currentMax < amounts.get(i)) {
				currentMax = amounts.get(i);
			}
		}

		return currentMax;
	}

	public static int numOfOccurences(DLList<Integer> list, int val) {
		int amt = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(val)) {
				amt++;
			}
		}

		return amt;
	}

}