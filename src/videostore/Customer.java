package videostore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();
	
	public
	Customer(String name){
		_name = name;
	}
	
	public String
	getName(){
		return _name;
	}
	
	public void
	addRental(Rental rental){
		_rentals.addElement(rental);
	}
	
	public String
	statement() {
		
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		Enumeration<Rental> rentals = _rentals.elements();
		
		String result = "Rental Record for " + getName() + "\n";
		
		while(rentals.hasMoreElements()) {
			
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			
			// determine amount for each line
			
			thisAmount = amountFor(each);
			
			// add frequent renter points
			
			frequentRenterPoints++;
			
			// add bonus for a two day new release rental
			
			if (   (each.getMovie().getPriceCode() == Movie.NEWRELEASE)
				&& each.getDaysRented() > 1)
				
				frequentRenterPoints++;
			
			// show figures for this rental
			
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			
			// add up to total amount
			
			totalAmount += thisAmount;
		}
		
		// add footer lines
		
		result += "Amount owned is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		
		return result;
	}
	
	private double
	amountFor(Rental each) {
		
		double thisAmount = 0;

		switch(each.getMovie().getPriceCode()) {
		
		case Movie.REGULAR :
			
			thisAmount += 2;
			if (each.getDaysRented() > 2)
				thisAmount += (each.getDaysRented() - 2) * 1.5;
			break;
			
		case Movie.NEWRELEASE:
			
			thisAmount += each.getDaysRented() * 3;
			break;
			
		case Movie.CHILDRENS:
			
			thisAmount += 1.5;
			if (each.getDaysRented() > 3)
				thisAmount += (each.getDaysRented() - 3) * 1.5;
			break;
		}
		
		return thisAmount;
	}

}
