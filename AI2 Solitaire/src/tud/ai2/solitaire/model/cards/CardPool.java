package tud.ai2.solitaire.model.cards;

import java.awt.Container;
import java.util.Collection;

public class CardPool extends AbstractCardPool {

    /**
     * Initializes a tud.ai2.solitaire.model.cards.CardPool instance on its creation.
     * Initializes the parent class, adds the provided cards to the pool.
     *
     * @param cards     a list of cards that will be added to the draw pool
     * @param container a container to draw on
     */
    public CardPool(Collection<AbstractCard> cards, Container container) {
        super(cards, container);
        for (AbstractCard card : cards) {
            getDrawStack().push(card);
        }
        prepare();
    }

	@Override
	public AbstractCard drawStackClicked() {
		// TODO Auto-generated method stub
		if (!getDrawStack().isEmpty()) {
			AbstractCard drawed_card = getDrawStack().pop();
			getWasteStack().push(drawed_card);
			return drawed_card;
		} else {
			return null;
		}
	}

	@Override
	public void redeal() {
		// TODO Auto-generated method stub
		while (!getWasteStack().isEmpty()) {
			getDrawStack().push(getWasteStack().pop());
		}
	}

	@Override
	public void removeFromWaste(AbstractCard card) {
		// TODO Auto-generated method stub
		if (card == getWasteStack().peek() && card != null) {
			getWasteStack().pop();
		}
	}

}
