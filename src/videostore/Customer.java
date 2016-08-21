package videostore;

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
}
