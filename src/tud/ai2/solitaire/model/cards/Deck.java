package tud.ai2.solitaire.model.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class tud.ai2.solitaire.model.cards.Deck
 * describes a deck object created for the game.
 * An object contains a list of cards, 13x4=52 elements.
 * Those 52 elements represent every possible card value from ace to king exists four times but
 * same values differ by their chosen suit.
 * Therefore no duplicates get created.
 * Decks can shuffle themselves
 *
 * @author (Felix Gail, Philipp Malkmus, Artjom Poljakow)
 * @version 1.0
 */

public class Deck {

    public int cutPoint = -1;
    private List<AbstractCard> cards;
    private static final Random rand = new Random();

    //TODO task 2a)
	/**
	 * Initialize the card
	 */
    public Deck() {
		cards = new ArrayList<AbstractCard>(52);
		for (CardValue value : CardValue.values()) {
			// for(int i = 0; i < 13; i ++) {
			for (Suit suit : Suit.values()) {
				// CardValue wert = new CardValue();
				Card tmpCard = new Card(suit, value);
				// System.out.println(tmpCard.getSuit());
				this.cards.add(tmpCard);
				// System.out.println(this.cards.size());
			}
		}
    }

    //TODO task 2c)

	/**
	 * @param iterations: Number of iteration
	 */
    public void riffle(int iterations) {
		int middle = cards.size() / 2;
		for (int iteration = 0; iteration < iterations; iteration++) {
			List<AbstractCard> left = new ArrayList<AbstractCard>();
			List<AbstractCard> right = new ArrayList<AbstractCard>();
			int bias = rand.nextInt(11) - 5; // bias is between -5 and 5
			cutPoint = middle + bias;
			// System.out.println(cutPoint);
			for (int i = 0; i < cards.size(); i++) {
				if (i < (middle + bias)) {
					left.add(cards.get(i));
				} else {
					right.add(cards.get(i));
				}
			}
			List<AbstractCard> copy_l = left;
			List<AbstractCard> copy_r = right;
			this.cards = riffleMerge(copy_l, copy_r);
		}
    }

    //TODO task 2b)
	/**
	 * @param left:  list of card
	 * @param right: list of card
	 * @return res: list of card, but merge with 'left' and 'right'
	 */
    public static List<AbstractCard> riffleMerge(List<AbstractCard> left, List<AbstractCard> right) {
		int num_l = left.size(); // number of cards in left
		int num_r = right.size(); // number of cards in right
		int l_idx = 0; // index for left
		int r_idx = 0; // index for right
		List<AbstractCard> res = new ArrayList<AbstractCard>();
		for (int i = 0; i < (num_l + num_r); i++) {
			if (l_idx >= num_l || r_idx >= num_r)
				break;
			if (rand.nextDouble() >= 0.5) {
				res.add(left.get(l_idx++)); // random number >= 0.5: add the card of left into res
			} else {
				res.add(right.get(r_idx++));
			}
		}

		// add the rest cards
		while (l_idx < num_l) {
			res.add(left.get(l_idx++));
		}
		while (r_idx < num_r) {
			res.add(right.get(r_idx++));
		}
		return res;
    }

    public List<AbstractCard> getCards() {
        return cards;
    }

    //TODO task 6
    public void loadCardImages(String path) {
		for (AbstractCard card : cards) {
			try {
				card.setFrontImage(path);
			} catch (Exception ResourceNotFoundException) {
				// TODO: handle exception
				String errorString = "The path: " + path + "/" + card.getSuit().string().toLowerCase() + "/"
						+ card.getValue().string().toLowerCase() + ".png is wrong, please check again";
				System.out.println(errorString);
			}
		}

    }
}
