package videostore;

public abstract class Price {
	
	abstract int getPriceCode();
}

class ChildrensPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.CHILDRENS;
	}
}

class NewReleasePrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.NEWRELEASE;
	}
}

class RegularPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.REGULAR;
	}
}
