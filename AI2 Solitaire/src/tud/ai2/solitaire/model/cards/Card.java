package tud.ai2.solitaire.model.cards;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import tud.ai2.solitaire.exceptions.ResourceNotFoundException;

public class Card extends AbstractCard {
	private Suit suit;
	private CardValue value;
	BufferedImage FrontImage;
	boolean aufgedeckt = false;

	public Card(Suit suit, CardValue value) {
		this.suit = suit;
		this.value = value;

		// TODO Auto-generated constructor stub
	}

	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof AbstractCard) {
			Card o = (Card) obj;
			if (o.value == this.value && o.suit == this.suit)
				return true;
		}
		return false;
	}

	@Override
	public Suit getSuit() {
		// TODO Auto-generated method stub
		return this.suit;
	}

	@Override
	public CardValue getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public boolean flip() {
		// TODO Auto-generated method stub
		this.aufgedeckt = !this.aufgedeckt;
		return this.aufgedeckt;
	}

	@Override
	public boolean isRevealed() {
		// TODO Auto-generated method stub
		return this.aufgedeckt;
	}

	@Override
	public void setRevealed(boolean revealed) {
		// TODO Auto-generated method stub
		this.aufgedeckt = true;
	}

	@Override
	public void setFrontImage(String basePath) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		String path = basePath + "/" + this.suit.string().toLowerCase() + "/" + this.value.string().toLowerCase()
				+ ".png";
		// System.out.println("Path is::::: " + path);
		try {
			// URL url = new URL(path);
			File strFile = new File(path);
			URL url = strFile.toURL();
			FrontImage = ImageIO.read(url);
		} catch (Exception IOException) {
			// TODO: handle exception
			// String errorString = "The path: " + path + "is wrong, please check again";
			throw new ResourceNotFoundException(IOException);
		}

	}

	@Override
	public BufferedImage getFrontImage() {
		// TODO Auto-generated method stub
		return this.FrontImage;
	}

}
