package pokerGame;

public class Card {
	private String shape;
	private int rank;

	public Card(String shape, int rank) {
		this.shape = shape;
		this.rank = rank;
	}

	public String getShape() {
		return shape;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
}
