public class Booking {

	int cost;
	Customer costumer;
	Movie movie;


	public Booking(Customer costumer, Movie movie) {
		this.costumer = costumer;
		this.movie = movie;
	}

	public int getCost(int standard, int oap, int student, int child, boolean isWed) {

		standard = standard;
		oap = oap;
		student = student;
		child = child;
		isWed = isWed;

		if (!isWed) {
			int cost = standard * 8 + oap * 6 + student * 6 + child * 4;
			return cost;
		} else {
			int cost = standard * 6 + oap * 4 + student * 4 + child * 2;
			return cost;
		}

	}

}