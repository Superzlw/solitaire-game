package tud.ai2.solitaire.model.cards;

public class CardStack extends AbstractCardStack {
    private static int MAX_STACK = 13;
	private AbstractCard[] card_stack = new AbstractCard[MAX_STACK];
	int N = 0;

	@Override
	public void push(AbstractCard cc) {
		// TODO Auto-generated method stub
		if (N == 13)
			return;
		card_stack[N++] = cc;
	}

	@Override
	public AbstractCard pop() {
		// TODO Auto-generated method stub
		if (N == 0)
			return null;
		return card_stack[--N];
	}

	@Override
	public AbstractCard peek() {
		// TODO Auto-generated method stub
		return card_stack[N - 1];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (N == 0);
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return (N == 13);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return N;
	}

}
