package videostore;

public class Movie {

	public static final int CHILDRENS  = 2;
	public static final int REGULAR    = 0;
	public static final int NEWRELEASE = 1;
	
	private String _title;
	private Price  _price;

	public
	Movie(String title, int priceCode){
		_title    = title;
		setPriceCode(priceCode);
	}

	public String
	getTitle() {
		return _title;
	}

	public int
	getPriceCode() {
		return _price.getPriceCode();
	}

	public void
	setPriceCode(int priceCode) {
		switch (priceCode) {
		case REGULAR:
			_price = new RegularPrice();
			break;
		case CHILDRENS:
			_price = new ChildrensPrice();
			break;
		case NEWRELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public double
	getCharge(int daysRented) {

		double result = 0;

		switch(getPriceCode()) {
		
		case Movie.REGULAR :
			
			result += 2;
			if (daysRented > 2)
				result += (daysRented - 2) * 1.5;
			break;
			
		case Movie.NEWRELEASE:
			
			result += daysRented * 3;
			break;
			
		case Movie.CHILDRENS:
			
			result += 1.5;
			if (daysRented > 3)
				result += (daysRented - 3) * 1.5;
			break;
		}
		
		return result;
	}

	public int getFrequentRenterPoints(int daysRented) {
		if ((getPriceCode() == Movie.NEWRELEASE) && daysRented > 1)
			return 2;
		else
			return 1;
	}
}
