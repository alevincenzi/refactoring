package videostore;

public class Main {

	public static void
	main(String[] args) {
	
		Customer customer = new Customer("Test customer");
		
		Movie movie1 = new Movie("Ghostbusters",  Movie.NEWRELEASE);
		Movie movie2 = new Movie("The godfather", Movie.REGULAR);
		Movie movie3 = new Movie("The Matrix",    Movie.REGULAR);
		Movie movie4 = new Movie("Despicable me", Movie.CHILDRENS);
		
		customer.addRental(new Rental(movie1, 3));
		customer.addRental(new Rental(movie1, 5));
		customer.addRental(new Rental(movie2, 2));
		customer.addRental(new Rental(movie2, 2));
		customer.addRental(new Rental(movie3, 10));
		customer.addRental(new Rental(movie4, 1));
		
		System.out.println(customer.statement());
		
/*
Rental Record for Test customer
	Ghostbusters	9.0
	Ghostbusters	15.0
	The godfather	2.0
	The godfather	2.0
	The Matrix	14.0
	Despicable me	1.5
Amount owned is 43.5
You earned 8 frequent renter points 
*/
	}

}
