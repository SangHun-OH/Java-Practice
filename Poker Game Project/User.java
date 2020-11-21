package pokerGame;

public class User {
	private String name;
	private Card[] deck;
	private int[] pairsNum = { 0, 0 };
	private int tripsNum;
	private int quadsNum;
	private int pair = 0; // ~ 2
	private int trips = 0; // ~ 1
	private int quads = 0; // ~ 1
	private int straight = 0; // ~ 1
	private int flush = 0; // ~ 1
	private int point = 0; // 1 ~ 10
	private int index = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card[] getDeck() {
		return deck;
	}

	public void setDeck(Card[] deck) {

		this.deck = deck;
	}

	public Card getCard(int index) {
		return deck[index];
	}

	public int getPair() {
		return pair;
	}

	public void setPair(int pair, int pairsNum) {
		this.pair = pair;
		if (index == 0) {
			this.pairsNum[index] = pairsNum;
			index++;
		} else {
			this.pairsNum[index] = pairsNum;
		}
	}

	public int getTrips() {
		return trips;
	}

	public void setTrips(int trips, int tripsNum) {
		this.trips = trips;
		if (tripsNum > this.tripsNum) {
			this.tripsNum = tripsNum;
		}
	}

	public int getStraight() {
		return straight;
	}

	public void setStraight(int straight) {
		this.straight = straight;
	}

	public int getFlush() {
		return flush;
	}

	public void setFlush(int flush) {
		this.flush = flush;
	}

	public int getQuads() {
		return quads;
	}

	public void setQuads(int quads, int quadsNum) {
		this.quads = quads;
		if (tripsNum > this.tripsNum) {
			this.quadsNum = quadsNum;
		}
	}

	public int getPairsNum(int index) {
		return pairsNum[index];
	}

	public int getTripsNum() {
		return tripsNum;
	}

	public int getQuadsNum() {
		return quadsNum;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
